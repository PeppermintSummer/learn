package com.peppermint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peppermint.entity.User;
import com.peppermint.mapper.UserMapper;
import com.peppermint.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
}
