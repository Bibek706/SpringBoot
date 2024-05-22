package com.cglia.demo.service;

import java.util.List;

import com.cglia.demo.entity.Course;

public interface CourseService {
  public List<Course> getCourses();
  public Course getCource(long courseId);
  public Course addCourse(Course course);
  public Course delete(Integer id);
  public Course updateCourse(Course course);
}
