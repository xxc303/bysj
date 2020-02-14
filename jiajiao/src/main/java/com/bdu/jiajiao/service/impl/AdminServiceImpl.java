package com.bdu.jiajiao.service.impl;

import com.bdu.jiajiao.mapper.AdminMapper;
import com.bdu.jiajiao.pojo.Admin;
import com.bdu.jiajiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 123
 * @create 2020/1/13
 * @since 1.0.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.login(username, password);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }
}
