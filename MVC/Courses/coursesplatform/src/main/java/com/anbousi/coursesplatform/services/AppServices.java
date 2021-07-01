package com.anbousi.coursesplatform.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.anbousi.coursesplatform.models.Course;
import com.anbousi.coursesplatform.models.User;
import com.anbousi.coursesplatform.models.UserCourse;
import com.anbousi.coursesplatform.repositores.CourseRepository;
import com.anbousi.coursesplatform.repositores.UserCourseRepository;
import com.anbousi.coursesplatform.repositores.UserRepository;

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
    
 // find Course by Id-------------------------------------------
	public Course findCourseById(Long courseId) {
		Optional<Course> c = courseRepository.findById(courseId);
		
    	if(c.isPresent()) {
            return c.get();
    	} else {
    	    return null;
    	}
    }
	
//  ---------------------------------------------------------------------
	
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


//	Get All Courses
	public List<Course> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

// Create a Course
	public void createCourse(Course course) {
		courseRepository.save(course);		
	}

	
// User Join Course
	public void userJoinCourse(Long userId, Long courseId) {
		UserCourse uc = new UserCourse();
		User u = findUserById(userId);
		Course c = findCourseById(courseId);
		uc.setUser(u);
		uc.setCourse(c);
		userCourseRepository.save(uc);
	}


//	Update Course
	public void updateCourse(Course course, Long courseId) {
		
		Course c = findCourseById(courseId);
		System.out.println(c.getName());
		System.out.println(c.getId());
		c.setId(courseId);
		c.setName(course.getName());
		c.setInstructor(course.getInstructor());
		c.setCapacity(course.getCapacity());
		courseRepository.save(c);
	}


	public void deleteCourse(Long courseId) {
		Course c = findCourseById(courseId);
		courseRepository.delete(c);
		
	}




	

}
