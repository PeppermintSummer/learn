package com.peppermint.dao;

import com.peppermint.entity.UserFile;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserFileDAO {

    //根据登录用户id查询文件列表
    List<UserFile> findByUserId(Integer id);

    //保存记录
    void save(UserFile userFile);

    //根据文件ID获取文件的信息
    UserFile findById(Integer id);

    void update(UserFile userFile);

    void delete(Integer id);
}
