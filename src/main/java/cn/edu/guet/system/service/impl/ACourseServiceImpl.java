package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.mapper.ACourseMapper;
import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.IACourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ACourseServiceImpl implements IACourseService {
    @Autowired
    ACourseMapper ACourseMapper;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courseList= ACourseMapper.getAllCourses();
        return courseList;
    }

    @Override
    public List<Course> getAllCourseId() {
        List<Course> allCourse= ACourseMapper.getAllCourseId();
        List allCourseId=new ArrayList();
        for(int i=0;i<allCourse.size();i++){
            allCourseId.add(allCourse.get(i).getCourseId());
        }
        return allCourseId;
    }

    @Override
    public Course getCourseByCourseId(String courseId) {
        Course course= ACourseMapper.getCourseByCourseId(courseId);
        return course;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {
        Teacher teacher= ACourseMapper.getTeacherById(teacherId);
        return teacher;
    }

    @Override
    public List<Course> viewCourseByCourseName(String coursename) {
        List<Course> cCourses= ACourseMapper.viewCourseByCourseName(coursename);
        return cCourses;
    }

    @Override
    public List<Course> viewCourseByTeacherName(String teacherName) {
        List<Course> tCourses= ACourseMapper.viewCourseByTeacherName(teacherName);
        return tCourses;
    }

    @Override
    public void addCourse(Course course) throws Exception {
        ACourseMapper.addCourse(course);
    }

    @Override
    public void deleteCourse(String courseId) throws Exception{
        ACourseMapper.deleteCourse(courseId);
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        ACourseMapper.updateCourse(course);
    }

    @Override
    public Major getMajorByMajorId(String majorId) {
        Major major= ACourseMapper.getMajorByMajorId(majorId);
        return major;
    }


}
