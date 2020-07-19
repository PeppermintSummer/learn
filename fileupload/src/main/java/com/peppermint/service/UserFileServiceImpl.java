package com.peppermint.service;

import com.peppermint.dao.UserFileDAO;
import com.peppermint.entity.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Service
@Transactional
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    private UserFileDAO userFileDAO;

    @Override
    public List<UserFile> findByUserId(Integer id) {
        return userFileDAO.findByUserId(id);
    }

    @Override
    public void save(UserFile userFile) {
        //处理是否是图片
        String isImg = userFile.getType().startsWith("image") ? "是":"否";
        userFile.setIsImg(isImg);
        userFile.setDowncounts(0);
        userFile.setUploadTime(new Date());
        userFileDAO.save(userFile);
    }

    @Override
    public UserFile findById(Integer id) {
        return userFileDAO.findById(id);
    }

    @Override
    public void update(UserFile userFile) {
        userFileDAO.update(userFile);
    }

    @Override
    public void delete(Integer id) {
        userFileDAO.delete(id);
    }
}
