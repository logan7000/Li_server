package org.li.springboot_examples.exception;

import cn.hutool.core.exceptions.ValidateException;

import lombok.extern.slf4j.Slf4j;
import org.li.springboot_examples.dto.APIResultTO;
import org.li.springboot_examples.entity.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.io.Serializable;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param exception
     * @return
     */
    @ExceptionHandler(ValidateException.class)
    public APIResultTO handleValidatorException(ValidateException exception) {
        log.info("参数校验异常：", exception.getMessage(), exception);
        APIResultTO<Serializable> serializableAPIResultTO = APIResultTO.buildFailed(ErrorCodeEnum.ERROR_PARAM);
        return serializableAPIResultTO;
    }
}
