package cn.cest.os.sso.Controller;

import cn.cest.os.sso.Service.SsoService;
import cn.cest.os.sso.Util.Result;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SsoController {

    private final SsoService ssoService;

    public SsoController(SsoService ssoService) {
        this.ssoService = ssoService;
    }

    /**
     * 判断是否登录
     * @return 是否登录标志
     */
    @GetMapping("/ifLogin")
    public Result<Boolean> tokenIfValid(){
        //判断是否登录（判断请求头中的token）
        boolean flag = StpUtil.isLogin();
        if(flag){
            return Result.ok(true,"已登录，token有效");
        }
        return Result.fail(false,"未登录，token无效");
    }

    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @return 用户uid
     */
    @PostMapping("/login")
    public Result<Integer> login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        //获取uid
        Integer uid = ssoService.getUidBuUserNameAndPwd(username,password);
        //登录
        StpUtil.login(uid);
        return Result.ok(uid,"登录成功");
    }
    @GetMapping("/session")
    public Result<SaSession> getToken(@RequestParam("username") String username,
                                        @RequestParam("password") String password){
        //获取uid
        Integer uid = ssoService.getUidBuUserNameAndPwd(username,password);
        //获取session
        SaSession sessionByLoginId = StpUtil.getSessionByLoginId(uid);
        return Result.ok(sessionByLoginId,"获取session成功");
    }
    @GetMapping("/permissions")
    public Result<List<String>> getPermissionList(@RequestParam("uid") Integer uid){
        //获取权限列表
        List<String> permissionList = ssoService.getPermissionListByUid(uid);
        return Result.ok(permissionList,"获取权限列表成功");
    }


    /**
     * 退出登录
     * @return 成功标志
     */
    @PostMapping("/logout")
    public Result<Boolean> logout(){
        try {
            StpUtil.logout();
            return Result.ok(true,"退出成功");
        } catch (Exception e) {
            //todo 记录日志
            return Result.fail(false,"退出失败");
        }
    }


}
