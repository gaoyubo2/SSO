package cn.cest.os.sso.Service.impl;

import cn.cest.os.sso.mapper.desktop.AppMapper;
import cn.cest.os.sso.pojo.RoleApp;
import cn.cest.os.sso.mapper.manage.RoleAppMapper;
import cn.cest.os.sso.Service.RoleAppService;
import cn.cest.os.sso.pojo.dto.RoleAppIdDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoyubo
 * @since 2024-03-15
 */
@Service
public class RoleAppServiceImpl extends ServiceImpl<RoleAppMapper, RoleApp> implements RoleAppService {

    @Autowired
    private AppMapper appMapper;
    /**
     * 添加角色应用权限
     *
     * @param roleAppIdDTO 角色信息、权限ID列表
     * @return 添加标志
     */
    @Override
    public Boolean addRoleApp(RoleAppIdDTO roleAppIdDTO) {
        List<Integer> appIdList = roleAppIdDTO.getAppIdList();
        for(Integer appId: appIdList){
            //根据id查询

        }
        //todo 添加权限
        return true;

    }

}
