package com.anbousi.coursesplatform.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.coursesplatform.models.UserCourse;

@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, Long> {

}
