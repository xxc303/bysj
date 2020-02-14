package com.bdu.jiajiao.mapper;

import com.bdu.jiajiao.pojo.Admin;

/**
 * @author 123
 * @version 1.0
 * @date 2020 2020/1/13 15:35
 */
public interface AdminMapper {

    Admin login(String username, String password);

    int updateAdmin(Admin admin);

    void changePassword(String password);
}
