package com.peppermint;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //全局配置,一定要是generator包下的
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"src/main/java");
        gc.setAuthor("peppermint");
        gc.setOpen(false);//打开windows的资源管理器
        gc.setFileOverride(true);//是否覆盖原来的
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl("")
                .setDriverName("")
                .setUsername("root")
                .setPassword("")
                .setDbType(DbType.MYSQL);
        mpg.setDataSource(dataSource);


        PackageConfig packageInfo = new PackageConfig();
        packageInfo.setModuleName("peppermint")
                .setEntity("entity")
                .setMapper("mapper")
                .setController("controller")
                .setService("service");
        mpg.setPackageInfo(packageInfo);

        //重点：策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user","admin") //设置要映射的表名
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setLogicDeleteFieldName("deleted")
                .setRestControllerStyle(true);
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(gmtCreate);
        tableFillList.add(gmtModified);
        strategy
                .setTableFillList(tableFillList);
        mpg.setStrategy(strategy);

        mpg.execute(); //执行
    }
}
