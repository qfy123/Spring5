package com.qfy.springmvc_locale;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析返回locale
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale l=null;
        //如果带了locale参数，就用参数指定的区域信息；如果没带就用请求头默认的
        String locale = httpServletRequest.getParameter("locale");
        if (locale!=null&&!"".equals(locale)){
            l=new Locale(locale.split("_")[0],locale.split("_")[1]);
        }else {
            l=httpServletRequest.getLocale();
        }
        return l;
    }
    //修改locale
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
        throw new UnsupportedOperationException("Cannot change HTTP accept header - use a different locale resolution strategy");

    }
}
