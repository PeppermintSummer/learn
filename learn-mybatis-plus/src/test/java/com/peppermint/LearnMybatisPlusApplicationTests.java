package com.peppermint;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peppermint.mapper.AdminMapper;
import com.peppermint.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class LearnMybatisPlusApplicationTests {
    //继承了BaseMapper，所有的方法都来自父类
    @Autowired
    private AdminMapper adminMapper;

    @Test
    void contextLoads() {
        //查询全部用户,参数是一个wrapper，条件构造器，这里我们先不用
        List<Admin> admins = adminMapper.selectList(null);
        //forEach函数式接口
        admins.forEach(System.out::println);

        //批量查询
        List<Admin> adminList = adminMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        adminList.forEach(System.out::println);

        //条件查询
        HashMap<String, Object> map = new HashMap<>();
        //自定义要查询的条件
        map.put("name", "哈皮狗");
        adminMapper.selectByMap(map);


    }

    @Test
    public void testInsert(){
        Admin admin = new Admin();
        admin.setName("阿红");
        admin.setAge(18);
        admin.setEmail("1238@qq.com");

        int result = adminMapper.insert(admin);
        System.out.println(result); //受影响的行数
        System.out.println(admin);
    }

    @Test
    public void testUpdate(){
        Admin admin = new Admin();
        admin.setId(6L);
        admin.setAge(3);
        admin.setEmail("666@qq.com");
        adminMapper.updateById(admin);
    }

    //物理删除
    @Test
    public void deleteById(){
        adminMapper.deleteById(1L);
        adminMapper.deleteBatchIds(Arrays.asList(1L,2L));
    }

    //逻辑删除，在数据库中并没有被删除，而是通过一个一个变量让他失效
    //delete=0/1 管理员可以查看被删除的数据，防止数据的丢失，类似于回收站
    //配置文件config，properties
    //查询的时候会自动去查询拼接deleted=0的用户信息

    @Test
    public void testOptimisticLocker(){
        //线程1
        //查询用户信息
        Admin admin1 = adminMapper.selectById(1L);
        //修改用户信息
        admin1.setName("哈皮狗");
        admin1.setEmail("99988899@qq.com");

        //模拟另外一个线程进行插队操作
        Admin admin2 = adminMapper.selectById(1L);
        admin2.setName("田园犬");
        admin2.setEmail("77755@qq.com");
        adminMapper.updateById(admin2);

        //自旋锁来多次尝试提交！
        adminMapper.updateById(admin1);//如果没有乐观锁就会覆盖插队线程的值！
    }

    //测试分页
    @Test
    public void testPagination(){
        Page<Admin> page = new Page<>(1,5);//当前页面,页面大小
        adminMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

}
