package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> getAllCourses();
    List<Course> getAllCourseId();
    Course getCourseByCourseId(String courseId);
    Teacher getTeacherById(String teacherId);
    List<Course> viewCourseByCourseName(String coursename);
    List<Course> viewCourseByTeacherName(String teacherName);
    void addCourse(Course course);
    void deleteCourse(String courseId);
    void updateCourse(Course course);
    Major getMajorByMajorId(String majorId);
}
