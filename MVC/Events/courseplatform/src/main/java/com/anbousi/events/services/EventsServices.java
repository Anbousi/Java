package com.anbousi.events.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.anbousi.events.models.Event;
import com.anbousi.events.models.State;
import com.anbousi.events.models.User;
import com.anbousi.events.models.UserEvent;
import com.anbousi.events.repositories.EventRepository;
import com.anbousi.events.repositories.MessageRepository;
import com.anbousi.events.repositories.StateRepository;
import com.anbousi.events.repositories.UserEventRepository;
import com.anbousi.events.repositories.UserRepository;

@Service
public class EventsServices {
	
	private final UserRepository userRepository;
	private final EventRepository eventRepository;
	private final StateRepository stateRepository;
	private final MessageRepository messageRepository;
	private final UserEventRepository userEventRepository;
	
	
	public EventsServices(UserRepository userRepository, EventRepository eventRepository,
			StateRepository stateRepository, MessageRepository messageRepository,
			UserEventRepository userEventRepository) {
		
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
		this.stateRepository = stateRepository;
		this.messageRepository = messageRepository;
		this.userEventRepository = userEventRepository;
	}
	
    // register user and hash their password ------------------------------
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
//    ---------------------------------------------------------------------
    
    // find user by email-------------------------------------------
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
//    --------------------------------------------------------------
    
    // find user by id----------------------------------------------
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
//    --------------------------------------------------------------
    
 // find Event by id----------------------------------------------
	private Event findEventById(Long eventId) {
    	Optional<Event> e = eventRepository.findById(eventId);
    	
    	if(e.isPresent()) {
            return e.get();
    	} else {
    	    return null;
    	}
	}
// authenticate user-----------------------------------------------------
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
//-----------------------------------------------------------------------
    
//    Add a State -----------------------------------
	public void addState(State state) {
		stateRepository.save(state);
	}
//	-------------------------------------------------
	
//  Get All States -----------------------------------
	public List<State> getAllStates() {
		List <State> states = stateRepository.findAll();
		return states;
	}
//	-------------------------------------------------
	
//  Get All Events -----------------------------------
	public List<Event> findAllEvents() {
		List<Event> events = eventRepository.findAll();
		return events;
	}
//	-------------------------------------------------

//	Create Event---------------------------------------
	public Event createEvent(Long userId, Event event) {
		if(findUserById(userId) != null) {
		User u = findUserById(userId);
		event.setUser(u);
		eventRepository.save(event);
		System.out.println("Saved");
		return event;
		}
		return null;
	}
//	---------------------------------------------------

//	Add a User to an Event
	public void userEvent(Long eventId, Long userId) {
		UserEvent ue = new UserEvent();
		User u = findUserById(userId);
		Event e = findEventById(eventId);
		ue.setUser(u);
		ue.setEvent(e);
		userEventRepository.save(ue);
		}
// Cancel Event
	public void userEventCancel(Long eventId, Long userId) {
		UserEvent ue = userEventRepository.findByEventId(eventId);
		userEventRepository.delete(ue);
	}

//	Get All User Event
	public List<UserEvent> getAllUserEvent() {
		List<UserEvent> ue = (List<UserEvent>) userEventRepository.findAll();
		return ue;
	}



	
	
	
	
	
	

}
