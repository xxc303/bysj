package com.bdu.jiajiao.controller;

import com.bdu.jiajiao.pojo.Student;
import com.bdu.jiajiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author 123
 * @create 2019/11/21
 * @since 1.0.0
 */
@Controller
public class IndexController {

    @Autowired
    private StudentService studentService;

    /**
     * 登录页
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 首页
     */
    @GetMapping("/showIndex")
    public String showIndex(HttpServletRequest request, Model model) {
        //Cookie[] cookies = request.getCookies();
        //if (cookies != null && cookies.length != 0){
        //    for (Cookie cookie : cookies) {
        //        if (cookie.getName().equals("token")){
        //            String token = cookie.getValue();
        //            Student student = studentService.findByToken(token);
        //            if (student != null){
        //                request.getSession().setAttribute("student",student);
        //            }
        //            break;
        //        }
        //    }
        //}
        Object student = request.getSession().getAttribute("student");
        Object teacher = request.getSession().getAttribute("teacher");
        Object admin = request.getSession().getAttribute("admin");
        if (student != null){
            model.addAttribute("type","student");
        }else if (teacher != null){
            model.addAttribute("type","teacher");
        }else if (admin != null){
            model.addAttribute("type","admin");
        }
        return "showIndex";
    }

    /**
     * 退出登录
     */
    //@RequestMapping("/logout")
    //public String logout(HttpServletRequest request,
    //                     HttpServletResponse response){
    //    request.getSession().removeAttribute("student");
    //    Cookie cookie1 = new Cookie("token-student", null);
    //    Cookie cookie2 = new Cookie("token-teacher", null);
    //
    //    cookie1.setMaxAge(0);
    //    cookie2.setMaxAge(0);
    //    response.addCookie(cookie1);
    //    response.addCookie(cookie2);
    //    return "redirect:/";
    //}

}
