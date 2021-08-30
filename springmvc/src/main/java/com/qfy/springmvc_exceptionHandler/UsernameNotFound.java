package com.qfy.springmvc_exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "拒绝访问",value = HttpStatus.NOT_ACCEPTABLE)
public class UsernameNotFound extends RuntimeException{
    private static final long serialVersionUID=1L;
}
