package com.anbousi.coursesplatform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.coursesplatform.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
