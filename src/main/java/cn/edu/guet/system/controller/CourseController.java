package cn.edu.guet.system.controller;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.ICourseService;
import cn.edu.guet.system.service.IUserService;
import cn.edu.guet.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    ICourseService courseService;
    Result result=new Result();
    @Autowired
    IUserService userService;
    //��ȡȫ���γ�
    @RequestMapping(value = "/getAllCourse",method = RequestMethod.GET)
    public Result getAllCourse(){
        List<Course> allCourse=courseService.getAllCourse();
        if(allCourse==null){
            return result.fail("��ѯ�γ�ʧ��");
        }else{
            return result.succ(200,"��ѯ�γ̳ɹ�",allCourse);
        }
    }

    //ͨ����ʦ�������ҿγ�
    @RequestMapping(value = "/viewCourseByTeacherName",method = RequestMethod.GET)
    public Result viewCourseByTeacherName(String teacherName){
        System.out.println(teacherName);
        List<Course> teacherCourses=courseService.viewCourseByTeacherName(teacherName);
        System.out.println(teacherCourses);
        if (teacherCourses == null) {
            return result.fail("�����ڸ���ʦ");
        }
        else{
                return result.succ(200, "��ѯ�γ̳ɹ�", teacherCourses);
        }
    }

    //ͨ���γ����Ʋ��ҿγ�
    @RequestMapping(value = "/viewCourseByCourseName",method = RequestMethod.GET)
    public Result viewCourseByCourseName(String courseName){
        System.out.println(courseName);
        List<Course> viewCourses=courseService.viewCourseByCourseName(courseName);
        System.out.println(viewCourses);
        if (viewCourses == null) {
            return result.fail("�����ڸÿγ�");
        }
        else{
            return result.succ(200, "��ѯ�γ̳ɹ�", viewCourses);
        }
    }

    //��ӿγ�
    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public Result addCourse(String courseId,String courseName,String teacherId,String majorId) {
        Course addCourse = new Course();
        List allCourseId=courseService.getAllCourseId();
        List allTeacherId=userService.getAllTeacherId();
        List allMajorId=userService.getAllMajorId();
        try {
            Major major=courseService.getMajorByMajorId(majorId);
            Teacher teacher=courseService.getTeacherById(teacherId);
            addCourse.setCourseId(courseId);
            addCourse.setCourseName(courseName);
            addCourse.setTeacher(teacher);
            addCourse.setMajor(major);
            courseService.addCourse(addCourse);
            return result.succ(200, "��ӿγ̳ɹ�", null);
        }catch (Exception e){
            e.printStackTrace();
            if (allCourseId.contains(courseId)){
                return result.fail("�ÿγ��Ѵ���");
            }else if (!allTeacherId.contains(teacherId)){
                return result.fail("����ʦ������");
            }else if (!allMajorId.contains(majorId)){
                return result.fail("��רҵ������");
            }
        }
        return null;
    }

    //ɾ���γ�
    @RequestMapping(value = "/deleteCourse",method = RequestMethod.GET)
    public Result deleteCourse(String courseId){
        System.out.println(courseId);
        try {
            courseService.deleteCourse(courseId);
            return result.succ(200,"ɾ���γ̳ɹ�",null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("�γ�ID�����ڻ�����Ӽ�¼");
        }
    }

    //���¿γ�
    @RequestMapping(value = "/updateCourse",method = RequestMethod.POST)
    public Result updateCourse(String courseId,String courseName,String teacherId,String majorId){
        Course updateCourse=courseService.getCourseByCourseId(courseId);
        Teacher teacher=courseService.getTeacherById(teacherId);
        Major major=courseService.getMajorByMajorId(majorId);
        updateCourse.setCourseName(courseName);
        updateCourse.setTeacher(teacher);
        updateCourse.setMajor(major);
        courseService.updateCourse(updateCourse);
        if(updateCourse==null){
            return result.fail("���¿γ�ʧ��");
        }else{
            return result.succ(200,"���¿γ̳ɹ�",null);
        }
    }
}
