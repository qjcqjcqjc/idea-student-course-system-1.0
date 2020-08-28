package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    Teacher getTeacherById(String id);
    List<Teacher> getAllTeacher();
    List<Student> getAllStudent();
    List<Student> getAllStudentId();
    List<Student> viewStudentBySchoolName(String schoolName);
    List<Major> getAllMajor();
    List<Clazz> getAllClazz();
    List<School> getAllSchool();
    List<Teacher> getAllTeacherId();
    List<Clazz> getAllClazzId();
    List<Major> getAllMajorId();
    List<School> getAllSchoolId();
    Student getStudentById(String id);
    Clazz getClazzById(String id);
    School getSchoolById(String id);

    void deleteStudent(String id);
    void deleteTeacher(String id);

    void addTeacher(Teacher tea) throws Exception;
    void addStudent(Student stu) throws Exception;
}
