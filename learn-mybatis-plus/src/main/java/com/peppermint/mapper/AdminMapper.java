package com.peppermint.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peppermint.pojo.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */

//在对应的mapper上面实现一个基本的接口BaseMapper
@Repository //代表持久层
public interface AdminMapper extends BaseMapper<Admin> {
    //所有的crud操作已经完成
    //不要再像以前那样配置一大堆文件了

}
