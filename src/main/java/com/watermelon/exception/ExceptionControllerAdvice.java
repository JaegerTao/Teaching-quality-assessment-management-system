package com.watermelon.exception;


import com.watermelon.utils.EnumCode;
import com.watermelon.utils.ResultUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public ResultUtil exceptionHandler(MethodArgumentNotValidException e) {
        Map<String,String> collect = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return ResultUtil.error(EnumCode.BAD_REQUEST ,collect);
    }
    @ExceptionHandler
    public ResultUtil exceptionHandler(DataIntegrityViolationException e) {
        return ResultUtil.error(EnumCode.BAD_REQUEST,"违反数据库完整性");
    }

}
