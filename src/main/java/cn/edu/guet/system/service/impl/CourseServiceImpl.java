package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.mapper.CourseMapper;
import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courseList=courseMapper.getAllCourses();
        return courseList;
    }

    @Override
    public List<Course> getAllCourseId() {
        List<Course> allCourse=courseMapper.getAllCourseId();
        List allCourseId=new ArrayList();
        for(int i=0;i<allCourse.size();i++){
            allCourseId.add(allCourse.get(i).getCourseId());
        }
        return allCourseId;
    }

    @Override
    public Course getCourseByCourseId(String courseId) {
        Course course=courseMapper.getCourseByCourseId(courseId);
        return course;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        Teacher teacher=courseMapper.getTeacherById(teacherId);
        return teacher;
    }

    @Override
    public List<Course> viewCourseByCourseName(String coursename) {
        List<Course> cCourses=courseMapper.viewCourseByCourseName(coursename);
        return cCourses;
    }

    @Override
    public List<Course> viewCourseByTeacherName(String teacherName) {
        List<Course> tCourses=courseMapper.viewCourseByTeacherName(teacherName);
        return tCourses;
    }

    @Override
    public void addCourse(Course course) throws Exception {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourse(String courseId) throws Exception{
        courseMapper.deleteCourse(courseId);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

    @Override
    public Major getMajorByMajorId(String majorId) {
        Major major=courseMapper.getMajorByMajorId(majorId);
        return major;
    }


}
