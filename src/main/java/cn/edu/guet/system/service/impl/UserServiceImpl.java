package cn.edu.guet.system.service.impl;


import cn.edu.guet.system.mapper.UserMapper;
import cn.edu.guet.system.model.*;
import cn.edu.guet.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Teacher getTeacherById(String id) {
        Teacher tea=userMapper.getTeacherById(id);
        return tea;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teacherList=userMapper.getAllTeacher();
        return teacherList;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList=userMapper.getAllStudent();
        return studentList;
    }

    @Override
    public List<Student> getAllStudentId() {
        List<Student> allStudent=userMapper.getAllStudentId();
        List allStudentId=new ArrayList();
        for(int i=0;i<allStudent.size();i++){
            allStudentId.add(allStudent.get(i).getStudentId());
        }
        return allStudentId;
    }

    @Override
    public List<Student> viewStudentBySchoolName(String schoolName) {
        List<Student> students=userMapper.viewStudentBySchoolName(schoolName);
        return students;
    }

    @Override
    public List<Major> getAllMajor() {
        List<Major> allMajor=userMapper.getAllMajor();
        return allMajor;
    }

    @Override
    public List<Clazz> getAllClazz() {
        List<Clazz> allClazz=userMapper.getAllClazz();
        return allClazz;
    }

    @Override
    public List<School> getAllSchool() {
        List<School> allSchool=userMapper.getAllSchool();
        return allSchool;
    }

    @Override
    public List<Teacher> getAllTeacherId() {
        List<Teacher> allTeacher=userMapper.getAllTeacherId();
        List allTeacherId=new ArrayList();
        for(int i=0;i<allTeacher.size();i++){
            allTeacherId.add(allTeacher.get(i).getTeacherId());
        }
        return allTeacherId;
    }

    @Override
    public List<Clazz> getAllClazzId() {
        List<Clazz> allClazz=userMapper.getAllClazzId();
        List allClazzId=new ArrayList();
        for(int i=0;i<allClazz.size();i++){
            allClazzId.add(allClazz.get(i).getClassId());
        }
        return allClazzId;
    }

    @Override
    public List<Major> getAllMajorId() {
        List<Major> allMajor=userMapper.getAllMajorId();
        List allMajorId=new ArrayList();
        for(int i=0;i<allMajor.size();i++){
            allMajorId.add(allMajor.get(i).getMajorId());
        }
        return allMajorId;
    }

    @Override
    public List<School> getAllSchoolId() {
        List<School> allSchool=userMapper.getAllSchoolId();
        List allSchoolId=new ArrayList();
        for(int i=0;i<allSchool.size();i++){
            allSchoolId.add(allSchool.get(i).getSchoolId());
        }
        return allSchoolId;
    }


    @Override
    public Student getStudentById(String id) {
        Student stu=userMapper.getStudentById(id);
        return stu;
    }

    @Override
    public Clazz getClazzById(String id) {
        Clazz clazz=userMapper.getClazzById(id);
        return clazz;
    }

    @Override
    public School getSchoolById(String id) {
        School school=userMapper.getSchoolById(id);
        return school;
    }

    @Override
    public void deleteStudent(String id) {
        userMapper.deleteStudent(id);
    }

    @Override
    public void deleteTeacher(String id) {
        userMapper.deleteTeacher(id);
    }

    @Override
    public void addTeacher(Teacher tea) throws Exception {
        userMapper.addTeacher(tea);
    }

    @Override
    public void addStudent(Student stu) throws Exception {
        userMapper.addStudent(stu);
    }
}
