package com.anbousi.coursesplatform.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anbousi.coursesplatform.models.Course;
import com.anbousi.coursesplatform.models.User;
import com.anbousi.coursesplatform.services.AppServices;
import com.anbousi.coursesplatform.valodator.UserValidator;
@Controller
public class CourseControllers {
	private final AppServices appServices;
	private final UserValidator userValidator;
	public CourseControllers(AppServices appServices, UserValidator userValidator) {
		this.appServices = appServices;
		this.userValidator = userValidator;
	}
	
// Show All Courses, Welcome Page
	@RequestMapping("/courses")
	public String Courses( Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "home.jsp";
		}
		
		User u = appServices.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user" , u);
		List<Course> courses = appServices.getAllCourses();
		model.addAttribute("courses" , courses);
		return "courses.jsp";
	}
	
	
// Add a Course,Page
	@RequestMapping("/courses/new")
	public String addCourse( @ModelAttribute("course") Course course, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "home.jsp";
		}
		
		return "addCourse.jsp";
	}
	
// Create a Course,Form
	@RequestMapping(value="/courses/new" ,  method=RequestMethod.POST)
	public String createCourse(@Valid @ModelAttribute("course") Course course,BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "home.jsp";
		}
		
		if(result.hasErrors()) {
	         return "addCourse.jsp";
	     }
		
		appServices.createCourse(course);
		
		return "redirect:/courses";
	}

//	Join a Course
	@RequestMapping(value="/courses/add/{id}")
	public String joinCourse(HttpSession session, @PathVariable("id") Long courseId) {
		
		Long userId = (Long) session.getAttribute("userId");
		appServices.userJoinCourse(userId,courseId);
		
		return "redirect:/courses";
		
	}
	
//	Show a Course
	@RequestMapping(value="/courses/{id}")
	public String showTheCourse(HttpSession session, @PathVariable("id") Long courseId, Model model) {
		
		Long userId = (Long) session.getAttribute("userId");
		Course course = appServices.findCourseById(courseId);
		model.addAttribute("course" , course);
		
		return "showCourse.jsp";
		
	}
	
//	Edit a Course
	@RequestMapping(value="/courses/{id}/edit")
	public String editTheCourse(HttpSession session, @PathVariable("id") Long courseId, Model model , @ModelAttribute("course") Course course) {
		Course c = appServices.findCourseById(courseId);
		model.addAttribute("course" , c);
		return "editCourse.jsp";
		
	}
	
	
// Edit a Course,Form
	@RequestMapping(value="/courses/{id}/edit" ,  method=RequestMethod.POST)
	public String editTheCourse(@Valid @ModelAttribute("course") Course course,BindingResult result,@PathVariable("id") Long courseId, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "home.jsp";
		}
		
		if(result.hasErrors()) {
	         return "editCourse.jsp";
	     }
		
		appServices.updateCourse(course,courseId);
		
		return "redirect:/courses";
	}
	
// Delete a Course,Form
	@RequestMapping(value="/courses/{id}/delete")
	public String deleteCourse(@PathVariable("id") Long courseId) {
	
		appServices.deleteCourse(courseId);
		
		return "redirect:/courses";
	}

	

}
