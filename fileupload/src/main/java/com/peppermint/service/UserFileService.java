package com.peppermint.service;

import com.peppermint.entity.UserFile;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserFileService {
    List<UserFile> findByUserId(Integer id);

    void save(UserFile userFile);

    UserFile findById(Integer id);

    void update(UserFile userFile);

    void delete(Integer id);
}
