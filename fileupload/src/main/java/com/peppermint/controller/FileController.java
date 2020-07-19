package com.peppermint.controller;

import com.peppermint.entity.User;
import com.peppermint.entity.UserFile;
import com.peppermint.service.UserFileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private UserFileService userFileService;

    @GetMapping("delete")
    public String delete(Integer id) throws FileNotFoundException {
        //根据查询信息
        UserFile userFile = userFileService.findById(id);
        //删除文件
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();
        File file = new File(realPath, userFile.getNewFileName());
        if (file.exists()){
            file.delete();
        }
        //删除数据库中的记录
        userFileService.delete(id);
        return "redirect:/file/showAll";
    }

    @GetMapping("download")
    public void download(Integer id,
                         HttpServletResponse response) throws IOException {
        //获取文件的信息
        UserFile userFile = userFileService.findById(id);
        //更新下载次数
        userFile.setDowncounts(userFile.getDowncounts()+1);
        userFileService.update(userFile);

        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();
        //获取文件输入流
        FileInputStream is = new FileInputStream(new File(realPath, userFile.getNewFileName()));
        //attachment附件下载,inline在线打开
        response.setHeader("content-disposition", "attachment;fileName="+ URLEncoder.encode(userFile.getOldFileName(), "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }

    @PostMapping("upload")
    public String upload(MultipartFile aaa,HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        String oldFileName = aaa.getOriginalFilename();
        //获取文件名后缀
        String extension ="."+ FilenameUtils.getExtension(aaa.getOriginalFilename());
        //生成新的文件名称
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ UUID.randomUUID().toString().replace("-", "")+extension;
        //文件大小
        long size = aaa.getSize();
        //文件类型
        String type = aaa.getContentType();
        //上传
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirPath = realPath +"/" + dateFormat;
        File dateDir = new File(dateDirPath);
        if(!dateDir.exists()){
            dateDir.mkdirs();
        }
        aaa.transferTo(new File(dateDir,newFileName));
        //文件信息放入数据库
        UserFile userFile = new UserFile();
        userFile.setOldFileName(oldFileName).setNewFileName(newFileName)
                .setExt(extension)
                .setSize(String.valueOf(size))
                .setType(type)
                .setPath("/files/"+dateFormat)
                .setUserId(user.getId());
        userFileService.save(userFile);
        return "redirect:/file/showAll";
    }

    @GetMapping("showAll")
    public String findAll(HttpSession session,
                          Model model){
        User user = (User) session.getAttribute("user");
        List<UserFile> userFiles = userFileService.findByUserId(user.getId());
        model.addAttribute("files", userFiles);
        return "showAll";
    }
}
