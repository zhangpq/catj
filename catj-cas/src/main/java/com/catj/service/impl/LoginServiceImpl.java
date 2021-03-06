package com.catj.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.catj.common.CatJAuth;
import com.catj.common.CatJResult;
import com.catj.constant.ModuleEnum;
import com.catj.constant.SystemConstant;
import com.catj.model.User;
import com.catj.service.LoginService;
import com.catj.service.RedisService;
import com.catj.service.UserService;
import com.catj.util.DataUtils;
import com.catj.util.LogContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/6.
 */
@RestController
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


    /**
     * 去登录
     *
     * @param userPhone
     * @param password
     * @return
     */
    @Override
    public CatJResult goLogin(String userPhone, String password) {
        LogContextUtil.setUuidContext(ModuleEnum.CAS_MODULE.getDesc(), "去登陆");
        try {
            if (DataUtils.isEmpty(userPhone) || DataUtils.isEmpty(password)) return CatJResult.paramError();
            User user = userService.findLoginUser(userPhone, password);
            if (user == null) return CatJResult.FAIL("登录失败,用户名或密码错误", null);
            //加入redis缓存
            String authToken = addUserToCache(user);
            return CatJResult.OK("登录成功", CatJAuth.createAuth(authToken));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("去登陆异常,userPhone：".concat(userPhone), e);
            return CatJResult.FAIL("服务异常", "500");
        } finally {
            LogContextUtil.clear();
        }
    }

    /**
     * 退出登录
     *
     * @param authToken
     * @return
     */
    @Override
    public CatJResult logout(String authToken) {
        LogContextUtil.setUuidContext(ModuleEnum.CAS_MODULE.getDesc(), "退出登陆");
        try {
            if (DataUtils.isEmpty(authToken)) return CatJResult.paramError();
            //删除redis缓存
            if (redisService.exists(authToken)) {
                redisService.remove(authToken);
            }
            return CatJResult.OK("退出成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("退出登陆异常", e);
            return CatJResult.FAIL("服务异常", "500");
        } finally {
            LogContextUtil.clear();
        }
    }


    /**
     * 将登录用户添加到REIDS缓存
     *
     * @param user
     * @return
     */
    private String addUserToCache(User user) {
        String authToken = IdUtil.simpleUUID();
        redisService.setExpireValue(authToken, JSONUtil.toJsonStr(user), SystemConstant.LOGIN_TOKEN_EXPRED_TIME);
        return authToken;
    }
}
