package com.peppermint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * @author Administrator
 */
@Controller
public class TestController {
//    @GetMapping("/uploadfile")
//    public String uploadFile() {
//        return "upload";
//    }
//
//    @RequestMapping(value = "/upload",method = RequestMethod.POST)
//    public String upload(MultipartFile file)throws  IOException{
//        long startTime=System.currentTimeMillis();
//        System.out.println("file:"+file.getOriginalFilename());
//        try {
//            File fileDirectory = new File("E:\\guyu\\"+System.currentTimeMillis());
//            if (fileDirectory.exists()){
//
//            } else {
//                fileDirectory.mkdirs();
//            }
//            OutputStream os = new FileOutputStream("E:\\guyu\\"+System.currentTimeMillis()+file.getOriginalFilename());
//            InputStream is=file.getInputStream();
//
//            int temp;
//            //一个一个字节的读取并写入
//            while((temp=is.read())!=(-1))
//            {
//                os.write(temp);
//            }
//            os.flush();
//            os.close();
//            is.close();
//        }  catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        long  endTime=System.currentTimeMillis();
//        System.out.println("方法的运行时间："+String.valueOf(endTime-startTime)+"ms");
//        return "success";
//    }
}
