package com.wbzhou.controller;


import com.wbzhou.model.User;
import com.wbzhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import com.wbzhou.util.util;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@Controller
@RequestMapping(value = "/api/register")
public class UserController {

    @Autowired
    private UserService userService;


    public User getUserById(String username) {
        return userService.getUserById(username);
    }

    @ResponseBody
    @RequestMapping(value = "/isUserNameValid")
    public Map isUserNameValid(String username) {
        util.TestLogger("/isUserNameValid："+username);
        User u = getUserById(username);
        String data;
        int code;
        if(u!=null){
            code = 1;
            data = "手机号已注册";
        } else {
            code = 0;
            data = "成功";
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("data", data);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/reg")
    public Map insert(User user) {
        String phone = user.getPhone();
        User u = getUserById(phone);
        String data;
        int code;
        if(u!=null){
            code = 1;
            data = "手机号已注册";
        } else {
            code = 0;
            data = user.getPhone();
            userService.addUser(user);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("data", data);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/captcha.png", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        //获取随机字符串
        String random = util.random();
        //输出图片
        request.getSession().setAttribute("res", util.num);
        util.outputImage(random, response.getOutputStream());
        //存入结果
    }

    @ResponseBody
    @RequestMapping(value = "/isAuthcodeValid")
    public String authcodeValid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cap = request.getParameter("authcode");
        if(request.getSession().getAttribute("res") == null){
            return "fail";
        } else {
            Integer res = (Integer) request.getSession().getAttribute("res");
            if(Integer.parseInt(cap)==res)
            {
                // 填写正确，注册成功
                request.getSession().removeAttribute("res");
                System.out.println("注册成功");
                return "success";

            } else {
                return "fail";
            }
        }
    }

}
