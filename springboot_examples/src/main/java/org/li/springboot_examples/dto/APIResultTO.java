package org.li.springboot_examples.dto;

import lombok.Data;
import org.li.springboot_examples.entity.ErrorCodeEnum;

import java.io.Serializable;

/**
 * 全局API响应数据传输对象
 *
 * @param <T>
 */
@Data
public class APIResultTO<T extends Serializable> extends BaseTO {
    private static final long serialVersionUID = 4781359221619148785L;


    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 辅助提示信息
     */
    private String message;

    /**
     * 构建成功
     *
     * @param data
     * @param <K>
     * @return
     */
    public static <K extends Serializable> APIResultTO<K> buildSuccess(K data) {
        APIResultTO<K> result = new APIResultTO<>();
        result.setCode(0);
        result.setData(data);
        result.setMessage("");
        return result;
    }

    /**
     * 构建失败
     *
     * @param data
     * @param <K>
     * @return
     */
    public static <K extends Serializable> APIResultTO<K> buildFailed(K data, String message) {
        APIResultTO<K> result = new APIResultTO<>();
        result.setCode(-1);
        result.setData(data);
        result.setMessage("");
        return result;
    }

    public static <K extends Serializable> APIResultTO<K> buildFailed(ErrorCodeEnum errorCodeEnum) {
        APIResultTO<K> result = new APIResultTO<>();
        result.setCode(errorCodeEnum.getCode());
        result.setMessage(errorCodeEnum.getMessage());
        return result;
    }

    public static <K extends Serializable> APIResultTO<K> buildFailed(ErrorCodeEnum errorCodeEnum, String message) {
        APIResultTO<K> result = new APIResultTO<>();
        result.setCode(errorCodeEnum.getCode());
        result.setMessage(message);
        return result;
    }


}
