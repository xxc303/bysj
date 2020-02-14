package com.bdu.jiajiao.Interceptor;

import com.bdu.jiajiao.pojo.Student;
import com.bdu.jiajiao.pojo.Teacher;
import com.bdu.jiajiao.service.StudentService;
import com.bdu.jiajiao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 123
 * @create 2019/11/25
 * @since 1.0.0
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (("token-student").equals(cookie.getName())) {
                    String tokenStu = cookie.getValue();
                    Student student = studentService.findByToken(tokenStu);
                    if (student != null) {
                        //request.getSession().setAttribute("student", student);
                    }else if (("token-teacher").equals(cookie.getName())){
                        String tokenTeacher = cookie.getValue();
                        Teacher teacher = teacherService.findByToken(tokenTeacher);
                        if (teacher != null){
                            //request.getSession().setAttribute("teacher", teacher);
                        }
                    }
                    break;
                }
            }
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
