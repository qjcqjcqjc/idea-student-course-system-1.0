package cn.edu.guet.system.controller;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.service.IStudentService;
import cn.edu.guet.system.util.GetUsername;
import cn.edu.guet.system.util.JwtUtils;
import cn.edu.guet.system.util.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class StudentController {

    @Autowired
    IStudentService studentService;
    @Autowired
    GetUsername getUsername;

    @RequestMapping("ChooseCourse")
    public Result ChooseCourse(String majorid, HttpServletRequest request){
        String studentid = getUsername.getUsername(request);
        System.out.println("获取到用户id"+studentid);
        System.out.println("获取到专业"+majorid);
        List<Course> courseList=studentService.getCourse(majorid,studentid);
        System.out.println(courseList);
        return Result.succ(courseList);
    }

    @RequestMapping("ChooseMajor")
    public Result ChooseMajor(){
        List<Major> majorList=studentService.getMajor();
        return Result.succ(majorList);
    }

    @RequestMapping("CourseSelection")
    public Result CourseSelection(String courseid, HttpSession httpSession){
        String studentid= (String) httpSession.getAttribute("username");
        studentid = "1700720133";
        studentService.courseSelection(courseid,studentid);
        return Result.succ("选课成功");
    }
}
