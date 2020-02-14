package com.bdu.jiajiao.dto;

import com.bdu.jiajiao.pojo.Student;
import com.bdu.jiajiao.pojo.Teacher;

/**
 * @author 123
 * @create 2019/11/24
 * @since 1.0.0
 */
public class UserDTO {

    private String token;
    private Student student;
    private Teacher teacher;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "token='" + token + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
