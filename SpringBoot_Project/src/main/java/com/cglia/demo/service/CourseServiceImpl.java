package com.cglia.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cglia.demo.entity.Course;
@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;
	
	public CourseServiceImpl(){
		 list=new ArrayList<>();
		 list.add(new Course(1,"Java core cour","This course contain basic of java"))	;
			list.add(new Course(2,"Spring boot course","Creating rest api using spring boot"));
	}
		@Override
		public List<Course> getCourses() {
			return list;
		}
		@Override
		public Course getCource(long courseId) {
			Course c=null;
			for(Course course:list) {
				if(course.getId()==courseId) {
					c=course;
					break;
				}
			}
			return c;
		}
		@Override
		public Course addCourse(Course course) {
			list.add(course);
			return course;
		}
		@Override
		public Course delete(Integer id) {
			Course a=null;
			for(Course course:list) {
				if(course.getId()==id) {
					list.remove(course);
					break;
				}
			}
			return a;
		}
		@Override
		public Course updateCourse(Course course) {
			
			list.forEach(e -> {
				if (e.getId() == course.getId()) {
					e.setTitle(course.getTitle());
					e.setDescription(course.getDescription());
				}
			});
			return course;

			}
		}

