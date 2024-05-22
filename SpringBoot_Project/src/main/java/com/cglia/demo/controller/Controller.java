package com.cglia.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.demo.entity.Course;
import com.cglia.demo.service.CourseService;

@RestController
@RequestMapping
public class Controller {
	@Autowired
	private CourseService courseService;
//	
//	@GetMapping("/home")
//   public String home() {
//	return "This is a home page";   
//   }
	
	// Get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
		
	}
	@GetMapping("/show/{courseId}")
	public Course getCourse(@PathVariable long courseId) {
		return this.courseService.getCource(courseId);
	}
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	 @DeleteMapping("/delete/{id}")
	    public Course deleteBook(@PathVariable Integer id) {
	        return this.courseService.delete(id);
	    }
	 @PutMapping("/update")
	 public Course updateCourse(@RequestBody Course course) { 
		 return this.courseService.updateCourse(course);
	 }
}
