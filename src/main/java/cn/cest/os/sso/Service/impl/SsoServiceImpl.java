package cn.cest.os.sso.Service.impl;

import cn.cest.os.sso.Service.SsoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SsoServiceImpl implements SsoService {

    /**
     * 根据用户名密码获取UID
     *
     * @param username 用户名
     * @param password 密码
     * @return uid
     */
    @Override
    public Integer getUidBuUserNameAndPwd(String username, String password) {
        //TODO 获取uid
        return 1;
    }

    /**
     * 根据用户id获取权限列表
     *
     * @param uid 用户id
     * @return 权限列表
     */
    @Override
    public List<String> getPermissionListByUid(Integer uid) {
        List<String> permissionList = new ArrayList<>();
        permissionList.add("serviceA");
        permissionList.add("serviceB");
        //todo 获取用户权限列表
        return permissionList;

    }
}
