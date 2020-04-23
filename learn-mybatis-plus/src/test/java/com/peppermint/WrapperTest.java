package com.peppermint;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peppermint.mapper.AdminMapper;
import com.peppermint.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WrapperTest {
    //十分重要：Wrapper，我们写一些复杂的sql就可以使用它来代替
    @Autowired
    private AdminMapper adminMapper;

    @Test
    void contextLoads(){
        //查询name不为空的用户，并且邮箱不为空，年龄大于18
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 18);
        wrapper.between("age", 20, 30);
        //左和右 e%e  %e%
        wrapper.like("name", "e");
        //子查询 where (------)
        wrapper.inSql("id", "select id from admin where id<3");
        adminMapper.selectList(wrapper).forEach(System.out::println); //可以选择和学过的map对比一下

    }

}
