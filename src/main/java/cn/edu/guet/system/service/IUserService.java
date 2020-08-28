package cn.edu.guet.system.service;

import cn.edu.guet.system.model.*;

import java.util.List;

public interface IUserService {

    List<Teacher> getAllTeacher();
    List<Student> getAllStudent();
    List<Student> getAllStudentId();
    List<Teacher> getAllTeacherId();
    List<Clazz> getAllClazzId();
    List<Major> getAllMajorId();
    List<School> getAllSchoolId();
    void deleteStudent(String id);
    void deleteTeacher(String id);
    void addTeacher(Teacher teacher) throws Exception;
    void addStudent(Student student) throws Exception;


    Teacher getTeacherById(String id);
    List<Student> viewStudentBySchoolName(String schoolName);
    List<Major> getAllMajor();
    List<Clazz> getAllClazz();
    List<School> getAllSchool();
    Student getStudentById(String id);
    Clazz getClazzById(String id);
    School getSchoolById(String id);


}
