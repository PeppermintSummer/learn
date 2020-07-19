package com.peppermint.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Administrator
 */
@Controller
public class IndexController {
//    public static final Logger logger= LoggerFactory.getLogger(IndexController.class);
//
//    @GetMapping("/upload")
//    public String upload(){
//        return "upload";
//    }
//
//    @PostMapping("/upload")
//    @ResponseBody
//    public String upload(@RequestParam("file") MultipartFile file){
//        if (file.isEmpty()){
//            return "上传失败！";
//        }
//        String filename = file.getOriginalFilename();
//        String filepath = "E:\\guyu\\";
//        File dest = new File(filepath+filename);
//        try {
//            file.transferTo(dest);
//            logger.info("上传成功");
//            return "上传成功！";
//        } catch (IOException e) {
//            logger.info("上传失败！");
//            e.printStackTrace();
//        }
//        return "上传失败！";
//    }

    @GetMapping("index")
    public String toLogin(){
        return "login";
    }
}
