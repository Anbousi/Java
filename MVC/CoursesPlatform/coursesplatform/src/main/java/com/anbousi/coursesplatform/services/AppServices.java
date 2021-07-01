package com.anbousi.coursesplatform.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.anbousi.coursesplatform.models.User;
import com.anbousi.coursesplatform.repositories.CourseRepository;
import com.anbousi.coursesplatform.repositories.UserCourseRepository;
import com.anbousi.coursesplatform.repositories.UserRepository;

@Service
public class AppServices {
	
	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final UserCourseRepository userCourseRepository;
	public AppServices(UserRepository userRepository, CourseRepository courseRepository,
			UserCourseRepository userCourseRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
		this.userCourseRepository = userCourseRepository;
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


	
	
	
	

}
