package org.li.springboot_examples.controller;

import cn.hutool.core.exceptions.ValidateException;
import org.li.springboot_examples.dto.APIResultTO;
import org.li.springboot_examples.entity.ErrorCodeEnum;
import org.li.springboot_examples.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 校验控制器
 */
@RestController
@RequestMapping("/validate")
public class ValidateController {
    /**
     * validate by myself
     *
     * @return
     */
    @RequestMapping("/user")
    public APIResultTO<HashMap<String, String>> validate(@RequestBody User user) {
        if(user == null) return APIResultTO.buildFailed(ErrorCodeEnum.EMPTY_PARAM);
        if(isId(user.getId()) == false) return APIResultTO.buildFailed("ID不存在或者小于0");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "1");
        return APIResultTO.buildSuccess(hashMap);
    }

    /**
     * 利用全局的exception 捕获来处理异常
     * @param user
     * @return
     */
    @RequestMapping("/user2")
    public APIResultTO<HashMap<String, String>> validate2(@RequestBody User user) throws ValidateException {
        if(user == null) return APIResultTO.buildFailed(ErrorCodeEnum.EMPTY_PARAM);
        isIdByException(user.getId());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "1");
        return APIResultTO.buildSuccess(hashMap);
    }

    /**
     * 不是id
     *
     * @param id
     * @return
     */
    static boolean isId(int id) {
        if (id == 0) {
            return false;
        }
        if (id < 0) {
            return false;
        }
        return true;
    }

    /**
     * 是否是id 抛出exception来处理
     * @param id
     * @return
     */
    static void isIdByException(int id) throws ValidateException {
        if (id == 0) {
            throw new ValidateException("id不存在");
        }
        if (id < 0) {
            throw new ValidateException("id不能为负数");
        }
    }
}
