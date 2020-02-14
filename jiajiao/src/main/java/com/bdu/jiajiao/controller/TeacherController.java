package com.bdu.jiajiao.controller;

import com.bdu.jiajiao.dto.BaseInfoDTO;
import com.bdu.jiajiao.dto.PasswordDTO;
import com.bdu.jiajiao.dto.TeaPublicOrderDTO;
import com.bdu.jiajiao.mapper.CommentMapper;
import com.bdu.jiajiao.mapper.TeacherMapper;
import com.bdu.jiajiao.pojo.Comment;
import com.bdu.jiajiao.pojo.Teacher;
import com.bdu.jiajiao.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author 123
 * @create 2019/11/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CommentMapper commentMapper;


    /**
     * 密码
     */
    @RequestMapping("/toChangePwd")
    public String toChangePwd(Model model){
        model.addAttribute("type","teacher");
        return "changePassword";
    }

    /**
     * 修改密码
     */
    @RequestMapping("changePWD")
    public String changePassword(PasswordDTO passwordDTO, Model model, HttpServletRequest request, RedirectAttributes modelMap) {
        model.addAttribute("type","teacher");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        if (teacher.getPassword().equals(passwordDTO.getOldPassword())){
            teacher.setPassword(passwordDTO.getNewPassword());
            teacherService.updateTeacher(teacher);
            modelMap.addFlashAttribute("msg_success","修改成功");
        }else{
            modelMap.addFlashAttribute("msg_fail","原密码错误");
        }
        return "redirect:/teacher/toChangePwd";
    }

        /**
         * 查看个人信息
         */
    @RequestMapping("/toMyDesc")
    public String toMyDesc(Model model, HttpServletRequest request){
        model.addAttribute("type","teacher");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("teacher",teacher);
        return "teaMyDesc";
    }

    /**
     * 修改个人信息
     */
    @RequestMapping("/updateTeacher")
    public String updateTeacher(BaseInfoDTO baseInfoDTO,Model model, HttpServletRequest request){
        model.addAttribute("type","teacher");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        BeanUtils.copyProperties(baseInfoDTO,teacher);
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher/toMyDesc";
    }



    /**
     * 查看我的家教订单
     */
    @RequestMapping("/toMyOrders")
    public String toMyOrders(Model model){
        model.addAttribute("type","teacher");
        return "myOrders";
    }

    /**
     * 查看家教信息（publicOrder）
     */
    @RequestMapping("/toPublicOrder")
    public String toPublicOrder(Model model,HttpServletRequest request) {
        model.addAttribute("type","teacher");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        Teacher teacher1 = teacherService.findById(teacher.getId());
        model.addAttribute("teacher",teacher1);
        return "teaPublicOrder";
    }

    /**
     * 发布/修改家教信息
     */
    @RequestMapping("/pubInfo")
    public String pubInfo(TeaPublicOrderDTO teaPublicOrderDTO, Model model, HttpServletRequest request){
        model.addAttribute("type","teacher");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("teacher",teacher);
        if (teacher.getItem() != null){
            BeanUtils.copyProperties(teaPublicOrderDTO,teacher);
            teacherService.updateTeacher(teacher);
        }else {
            BeanUtils.copyProperties(teaPublicOrderDTO,teacher);
            teacherService.addTeacher(teacher);
        }
        return "redirect:/teacher/toPublicOrder";
    }

    /**
     * 个人主页
     */
    @RequestMapping("/toSetting")
    public String toSetting(Model model){
        model.addAttribute("type","teacher");
        return "main";
    }
    /**
     * 教师详情页的展示
     */
    @RequestMapping("/toDetail/{id}")
    public String toDetail(Model model,@PathVariable(name = "id") int id){
        model.addAttribute("type","teacher");
        Teacher teacher = teacherMapper.queryTeacherById(id);
        List<Comment> comments = commentMapper.queryCommentByParentId(id);
        int counts = commentMapper.countComment(id);
        model.addAttribute("teacher",teacher);
        model.addAttribute("comments",comments);
        model.addAttribute("count",counts);
        return "teacherDetail";
    }

    /**
     * 登录
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, Model model){
        model.addAttribute("title","家教老师");
        model.addAttribute("type","teacher");
        return "login";
    }

    @RequestMapping("login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        RedirectAttributes modelMap,
                        Model model){
        Teacher teacher = teacherService.login(username, password);
        if (teacher == null){
            modelMap.addFlashAttribute("msg","用户名或密码错误");
            return "redirect:/teacher/toLogin";
        }else {
            String token = UUID.randomUUID().toString();
            teacher.setToken(token);
            teacherService.updateTeacher(teacher);
            Cookie cookie = new Cookie("token-teacher",token);
            response.addCookie(cookie);
            request.getSession().setAttribute("teacher",teacher);
            modelMap.addFlashAttribute("type","teacher");
            return "redirect:/showIndex";
        }

    }

    /**
     * 注册
     */
    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        model.addAttribute("title","家教老师");
        model.addAttribute("type","teacher");
        return "register";
    }

    @RequestMapping("register")
    public String Register(Teacher teacher, RedirectAttributes modelMap,HttpSession session){
        if (teacherMapper.queryTeacherByName(teacher.getUsername()) != null){
            modelMap.addFlashAttribute("msg1","用户名已存在，注册失败");
            System.out.println(teacher.getUsername());
            return "redirect:/teacher/toRegister";
        }
        int result = teacherMapper.addTeacher(teacher);
        if(result!= 1){
            modelMap.addFlashAttribute("msg","未知错误，请联系管理员");
            return "redirect:/teacher/toRegister";
        }

        modelMap.addAttribute("type","teacher");
        modelMap.addFlashAttribute("msg2","注册成功，请登录");
        return "redirect:/teacher/toLogin";
    }


    //@RequestMapping("toUpload")
    //    public String toUpload(Model model){
    //        model.addAttribute("type","teacher");
    //        return "teacherUpload";
    //    }
    //
    //@RequestMapping("teacherUpload")
    //public String upLoad(Teacher teacher, @RequestBody int id,RedirectAttributes modelMap){
    //    Teacher teacher1 = teacherMapper.queryTeacherById(id);
    //    teacher1.setCreateTime(new Date());
    //    int idNumber = new Random().nextInt(999999);
    //    teacher1.setIdNumber(idNumber+"");
    //    BeanUtils.copyProperties(teacher,teacher1);
    //    teacherMapper.addTeacher(teacher1);
    //    modelMap.addFlashAttribute("msg2","注册成功，请登录");
    //    return "redirect:/teacher/toLogin";
    //}

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("teacher");
        Cookie cookie = new Cookie("token-teacher", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @RequestMapping("/teacher")
    public String showTeachers(Model model){
        List<Teacher> teacherList = teacherMapper.queryAllTeacher();
        List<Teacher> teachers = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            if (teacher.getTitle()==null){

            }else{
                teachers.add(teacher);
            }
        }
        model.addAttribute("teachers",teachers);
        model.addAttribute("type","teacher");
        return "teacher";
    }


   /** @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, RedirectAttributes modelMap){

        Teacher teacher = teacherService.login(username, password);
        if(teacher == null){
            modelMap.addFlashAttribute("msg","用户名或密码错误");
            modelMap.addFlashAttribute("msg_type","danger");
            modelMap.addFlashAttribute("title","家教老师");
            modelMap.addFlashAttribute("type","teacher");
            return "redirect:/teacher/toLogin";
        }
        if(teacher.getStatus() < 0 ){
            session.setAttribute("user",teacher);
            return "redirect:/teacher/toUpload";
        }
        session.setAttribute("user",teacher);
        session.setAttribute("type","teacher");
        return "redirect:/teacher/toMain";
    }*/
}
