package com.watermelon.exception;

import com.watermelon.utils.ResultUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException{
    ResultUtil resultUtil;
}
