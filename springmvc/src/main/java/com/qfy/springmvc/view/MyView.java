package com.qfy.springmvc.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 自定义视图
 * @author QFY
 * @Description
 * @create 2021-07-16 16:26
 */
public class MyView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("之前保存的数据"+map);
        httpServletResponse.setContentType("text/html");
        List<String> vn= (List<String>) map.get("video");
        httpServletResponse.getWriter().write("<h1>芜湖马上起飞</h1>");
        for (String s : vn) {
            httpServletResponse.getWriter().write("<a>点击查看"+s+".avi</a><br/>");
        }
    }
}
