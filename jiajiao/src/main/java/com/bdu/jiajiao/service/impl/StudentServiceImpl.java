package com.bdu.jiajiao.service.impl;

import com.bdu.jiajiao.mapper.StudentMapper;
import com.bdu.jiajiao.pojo.Student;
import com.bdu.jiajiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 123
 * @create 2019/11/24
 * @since 1.0.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findByToken(String token) {
        return studentMapper.findByToken(token);
    }

    @Override
    public Student findById(int id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public Student login(String username,String password) {
        Student student1 = studentMapper.login(username, password);
        return student1;
    }

    @Override
    public Student queryStudentByName(String username) {
        return studentMapper.queryStudentByUsername(username);
    }

    @Override
    public int addStudent(Student student) {
        student.setCreateTime(new Date());
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {

        return studentMapper.updateStudent(student);
    }
}
