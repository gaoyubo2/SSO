package cn.cest.os.sso.Controller;


import cn.cest.os.sso.Service.RoleService;
import cn.cest.os.sso.Util.Result;
import cn.cest.os.sso.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoyubo
 * @since 2024-03-15
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public Result<Integer> addRole(@RequestBody Role role){
        boolean flag = roleService.save(role);
        if(flag){
            return Result.ok(role.getTbid(),"添加角色成功");
        }
        return Result.fail("添加角色失败");
    }
    @GetMapping
    public Result<List<Role>>
    //test1 1543

}

