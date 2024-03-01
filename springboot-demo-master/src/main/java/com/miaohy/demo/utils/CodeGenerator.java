package com.miaohy.demo.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    //Username
    private static String author = "MIAOHY";

    public static void main(String[] args) {
        //Change the cost of the database address better not move behind the question mark
        String url = "jdbc:mysql://localhost:3380/demo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
        //Database user name and password
        String name = "root";
        String password = "root";
        //The name of the table to be generated
        String tableName = "user";
        generate( url,name,password,tableName);
    }

    private static void generate(String url,String name,String password, String... tableNamesInclude){
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);//作者名称
        gc.setOpen(false);
        //gc.setSwagger2(true);
        gc.setFileOverride(false);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);

        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
//        gc.setEntityName("%sDO");

        gc.setDateType(DateType.ONLY_DATE); //
        mpg.setGlobalConfig(gc);


        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(name);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);


        PackageConfig pc = new PackageConfig();
        pc.setParent("com.miaohy.demo");
        //pc.setModuleName(moduleName); //自定义模块名
        mpg.setPackageInfo(pc);


        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableNamesInclude);
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
