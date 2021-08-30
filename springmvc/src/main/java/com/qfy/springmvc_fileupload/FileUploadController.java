package com.qfy.springmvc_fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    /*
    单文件上传
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "headerimg") MultipartFile file, Model model){
        System.out.println("文件名："+file.getName());
        System.out.println("文件大小："+file.getSize());
        System.out.println("文件的原始名："+file.getOriginalFilename());
        //文件保存
        try {
            file.transferTo(new File("D:\\"+file.getOriginalFilename()));
            model.addAttribute("msg","文件上传成功");
        } catch (Exception e) {
            model.addAttribute("msg","文件上传失败，失败原因："+e.getMessage());
        }

        return "forward:/index.jsp";
    }
    */




    //多文件上传
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "headerimg") MultipartFile[] file, Model model){
        for (MultipartFile multipartFile : file) {
            if(!multipartFile.isEmpty()){
                try {
                    multipartFile.transferTo(new File("D:\\"+multipartFile.getOriginalFilename()));
                    model.addAttribute("msg","文件上传成功");
                } catch (Exception e) {
                    model.addAttribute("msg","文件上传失败，失败原因："+e.getMessage());
                }
            }
        }
        return "forward:/index.jsp";
    }
}
