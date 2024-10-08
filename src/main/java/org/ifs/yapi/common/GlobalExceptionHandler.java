package org.ifs.yapi.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public YResult exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return YResult.error(500, e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public YResult exceptionHandler(AccessDeniedException e) {
        return YResult.error(403, e.getMessage());
    }
}
