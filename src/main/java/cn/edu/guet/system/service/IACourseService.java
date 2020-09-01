package cn.edu.guet.system.service;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Teacher;

import java.util.List;

public interface IACourseService {
    List<Course> getAllCourse();
    List<Course> getAllCourseId();
    Course getCourseByCourseId(String courseId);
    Teacher getTeacherById(String teacherId);
    List<Course> viewCourseByCourseName(String coursename);
    List<Course> viewCourseByTeacherName(String teacherName);
    void addCourse(Course course) throws Exception;
    void deleteCourse(String courseId) throws Exception;
    void updateCourse(Course course) throws Exception;
    Major getMajorByMajorId(String majorId);
}
