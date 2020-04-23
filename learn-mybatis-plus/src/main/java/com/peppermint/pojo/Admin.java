package com.peppermint.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    //对应数据库中的主键(UUID,自增ID，雪花算法，redis，zookeeper)
//    @TableId(type = IdType.ID_WORKER) //全局默认的一个方案
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version //代表这是乐观锁的注解
    private Integer version;

    @TableLogic //逻辑删除
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
