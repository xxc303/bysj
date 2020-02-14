package com.bdu.jiajiao.service;

import com.bdu.jiajiao.pojo.Admin;
import com.bdu.jiajiao.pojo.Teacher;

/**
 * @author 123
 * @version 1.0
 * @date 2020 2020/1/13 15:48
 */
public interface AdminService {
    Admin login(String username, String password);

    int updateAdmin(Admin admin);
}
