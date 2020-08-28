package cn.edu.guet.system.controller;

import cn.edu.guet.system.model.Menu;
import cn.edu.guet.system.service.ILoginService;
import cn.edu.guet.system.service.IMenuService;
import cn.edu.guet.system.util.JwtUtils;
import cn.edu.guet.system.util.Result;
import cn.edu.guet.system.util.UserDto;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class LoginController {

    @Autowired
    ILoginService loginService;
    @Autowired
    IMenuService menuService;
    @Autowired
    JwtUtils jwtUtils;

    Result result=new Result();
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Object login(@RequestBody UserDto userDto, HttpSession httpSession, HttpServletResponse response){
        String username=userDto.getUsername();
        String password=userDto.getPassword();
        System.out.println("登陆控制器"+username);
        System.out.println("控制器"+password);

        Object user=loginService.login(username,password);
        Assert.notNull(user,"用户不存在");
        String jwt = jwtUtils.generateToken(username);
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization");
        List<Menu> menuList=menuService.getMenuById(username);
        return result.succ(200,"登陆成功",menuList);
    }
}

