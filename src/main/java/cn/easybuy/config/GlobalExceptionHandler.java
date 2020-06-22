package cn.easybuy.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常类
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(LuoYangException.class)
    @ResponseBody
    public String zdyerror(LuoYangException e){
        return e.getMessage();
    }
}
