package com.bdu.jiajiao.service;

import com.bdu.jiajiao.pojo.Student;

/**
 * @author 123
 * @create 2019/11/24
 * @since 1.0.0
 */
public interface StudentService {

    Student findByToken(String token);

    Student findById(int id);

    Student login(String username, String password);

    Student queryStudentByName(String username);

    int addStudent(Student student);

    int updateStudent(Student student);
}
