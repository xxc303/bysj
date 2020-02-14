package com.bdu.jiajiao.controller;

import com.bdu.jiajiao.pojo.Admin;
import com.bdu.jiajiao.pojo.Teacher;
import com.bdu.jiajiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author 123
 * @create 2019/11/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/toSetting")
    public String toSetting(Model model) {
        model.addAttribute("type", "admin");
        return "main";
    }

    /**
     * 登录
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, Model model) {
        model.addAttribute("title", "管理员");
        model.addAttribute("type", "admin");
        return "login";
    }

    @RequestMapping("login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        RedirectAttributes modelMap,
                        Model model) {
        Admin admin = adminService.login(username, password);
        if (admin == null) {
            modelMap.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/teacher/toLogin";
        } else {
            String token = UUID.randomUUID().toString();
            admin.setToken(token);
            adminService.updateAdmin(admin);
            Cookie cookie = new Cookie("token-admin", token);
            response.addCookie(cookie);
            request.getSession().setAttribute("admin", admin);
            modelMap.addFlashAttribute("type","admin");
            return "redirect:/showIndex";
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("admin");
        Cookie cookie = new Cookie("token-admin", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
