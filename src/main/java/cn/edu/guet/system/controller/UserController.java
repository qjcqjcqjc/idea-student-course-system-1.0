package cn.edu.guet.system.controller;

import cn.edu.guet.system.model.Clazz;
import cn.edu.guet.system.model.School;
import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.IUserService;
import cn.edu.guet.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService userService;
    Result result=new Result();
    //��ȡĳ��ѧ����Ϣ
    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    public Result getStudentById(String id){
        if (id == null) {
            return result.fail("������id");
        }
        Student stu=userService.getStudentById(id);
        if (stu == null) {
            return result.fail("�޸�ѧ��");
        }
        return result.succ(stu);
    }

    //ͨ��ѧԺ������ѧ��
    @RequestMapping(value = "/viewStudentBySchoolName", method = RequestMethod.GET)
    public Result viewStudentBySchoolName(String schoolName){
        List<Student> students=userService.viewStudentBySchoolName(schoolName);
        if (students == null) {
            return result.fail("û��ѧ��");
        }
        return result.succ(students);
    }

    //��ȡȫ��ѧ����Ϣ
    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public Result getAllStudent(){
        List<Student> studentList=userService.getAllStudent();
        if (studentList == null) {
            return result.fail("û��ѧ��");
        }
        return result.succ(studentList);
    }

    //��ȡĳ����ʦ��Ϣ
    @RequestMapping(value = "/getTeacherById", method = RequestMethod.GET)
    public Result getTeacherById(String id){
        if (id == null) {
            return result.fail("������id");
        }
        Teacher tea=userService.getTeacherById(id);
        if (tea == null) {
            return result.fail("�޸���ʦ");
        }
        return result.succ(tea);
    }

    //��ȡȫ����ʦ��Ϣ
    @RequestMapping(value = "/getAllTeacher", method = RequestMethod.GET)
    public Result getAllTeacher(){
        List<Teacher> teacherList=userService.getAllTeacher();
        if (teacherList == null) {
            return result.fail("û����ʦ");
        }
        return result.succ(teacherList);
    }

    //���ѧ��
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Result addStudent(String classId, String studentId, String studentName){
        System.out.println("1111111"+classId);
        Clazz clazz=userService.getClazzById(classId);
        Student stu=new Student();
        stu.setStudentName(studentName);
        stu.setStudentId(studentId);
        stu.setClazz(clazz);
        List<Student> allStudentId=userService.getAllStudentId();
        List<Clazz> allClazzId=userService.getAllClazzId();
        try {
            userService.addStudent(stu);
            return result.succ(200,"���ѧ���ɹ�",null);
        } catch (Exception e) {
            e.printStackTrace();
            if(allStudentId.contains(studentId)){
                return result.fail("��ѧ���Ѵ���");
            }else if(!allClazzId.contains(classId)){
                return result.fail("�ð༶������");
            }

        }
            return  null;
    }

    //ɾ��ѧ��
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public Result deleteStudent(String id){
        userService.deleteStudent(id);
        return result.succ(200,"ɾ���ɹ�",null);
    }

    //�����ʦ
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public Result addTeacher(String teacherId, String teacherName, String schoolId){
        Teacher teacher=new Teacher();
        School school=userService.getSchoolById(schoolId);
        teacher.setTeacherId(teacherId);
        teacher.setTeacherName(teacherName);
        teacher.setSchool(school);
        List<Teacher> allTeacherId=userService.getAllTeacherId();
        List<School> allSchoolId=userService.getAllSchoolId();
        try {
            userService.addTeacher(teacher);
            return result.succ(200, "�����ʦ�ɹ�", null);
        } catch (Exception e) {
            e.printStackTrace();
            if(allTeacherId.contains(teacherId)){
                return result.fail("��ʦ�Ѵ���");
            }else if(!allSchoolId.contains(schoolId)){
                return  result.fail("��רҵ������");
            }

        }
        return null;
    }

    //ɾ����ʦ
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
    public Result deleteTeacher(String teacherId){
        if(teacherId==null){
            return result.fail("ɾ����ʦʧ��");
        }else{
            userService.deleteTeacher(teacherId);
            return result.succ(200,"ɾ����ʦ�ɹ�",null);
        }
    }


}
