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
    //获取某个学生信息
    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    public Result getStudentById(String id){
        if (id == null) {
            return result.fail("请输入id");
        }
        Student stu=userService.getStudentById(id);
        if (stu == null) {
            return result.fail("无该学生");
        }
        return result.succ(stu);
    }

    //通过学院名查找学生
    @RequestMapping(value = "/viewStudentBySchoolName", method = RequestMethod.GET)
    public Result viewStudentBySchoolName(String schoolName){
        List<Student> students=userService.viewStudentBySchoolName(schoolName);
        if (students == null) {
            return result.fail("没有学生");
        }
        return result.succ(students);
    }

    //获取全部学生信息
    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public Result getAllStudent(){
        List<Student> studentList=userService.getAllStudent();
        if (studentList == null) {
            return result.fail("没有学生");
        }
        return result.succ(studentList);
    }

    //获取某个老师信息
    @RequestMapping(value = "/getTeacherById", method = RequestMethod.GET)
    public Result getTeacherById(String id){
        if (id == null) {
            return result.fail("请输入id");
        }
        Teacher tea=userService.getTeacherById(id);
        if (tea == null) {
            return result.fail("无该老师");
        }
        return result.succ(tea);
    }

    //获取全部老师信息
    @RequestMapping(value = "/getAllTeacher", method = RequestMethod.GET)
    public Result getAllTeacher(){
        List<Teacher> teacherList=userService.getAllTeacher();
        if (teacherList == null) {
            return result.fail("没有老师");
        }
        return result.succ(teacherList);
    }

    //添加学生
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
            return result.succ(200,"添加学生成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            if(allStudentId.contains(studentId)){
                return result.fail("该学生已存在");
            }else if(!allClazzId.contains(classId)){
                return result.fail("该班级不存在");
            }

        }
            return  null;
    }

    //删除学生
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public Result deleteStudent(String id){
        userService.deleteStudent(id);
        return result.succ(200,"删除成功",null);
    }

    //添加老师
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
            return result.succ(200, "添加老师成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            if(allTeacherId.contains(teacherId)){
                return result.fail("老师已存在");
            }else if(!allSchoolId.contains(schoolId)){
                return  result.fail("该专业不存在");
            }

        }
        return null;
    }

    //删除老师
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
    public Result deleteTeacher(String teacherId){
        if(teacherId==null){
            return result.fail("删除老师失败");
        }else{
            userService.deleteTeacher(teacherId);
            return result.succ(200,"删除老师成功",null);
        }
    }


}
