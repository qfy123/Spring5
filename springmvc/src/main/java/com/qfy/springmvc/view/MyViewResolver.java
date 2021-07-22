package com.qfy.springmvc.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author QFY
 * @Description
 * @create 2021-07-16 16:21
 */
public class MyViewResolver implements ViewResolver, Ordered {
    private Integer order=0;
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        //根据视图名返回视图对象
        if(s.startsWith("wuhu:")){
            return new MyView();
        }else {

            return null;
        }
    }

    @Override
    public int getOrder() {
        return order;
    }
    public void setOrder(Integer order){
        this.order=order;
    }
}
