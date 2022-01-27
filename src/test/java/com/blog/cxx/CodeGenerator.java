//package com.blog.cxx;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import com.baomidou.mybatisplus.generator.fill.Column;
//import org.junit.jupiter.api.Test;
//
//import java.util.Collections;
//
//
//public class CodeGenerator {
//    @Test
//    public void test(){
//        System.out.println("cxx");
//    }
//
//    @Test
//    public void simpleGenerator() {
//        /* 需要更改的配置信息 */
//
//        // 数据库名称
//        String databaseName = "cxx_blog";
//        // 数据库用户名
//        String USERNAME = "root";
//        // 数据库密码
//         String PASSWORD = "";
//        // 项目根路径
//        String projectRootPath = System.getProperty("user.dir");
//        // 父包名
//        String parentPackageName = "com.blog.cxx.service";
//
//        // 包路径
//        String packagePath = projectRootPath + "/src/main/java";
//
//        // 开始执行代码生成
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/" + databaseName + "?serverTimezone=GMT%2B8", USERNAME, PASSWORD)
//                // 1. 全局配置
//                .globalConfig(builder -> builder
//                    // 作者名称
//                    .author("Cxx")
//                    // 开启覆盖已生成的文件
//                    .fileOverride()
//                    // 禁止打开输出目录。注释掉则生成完毕后，自动打开生成的文件目录。
//                    .disableOpenDir()
//                    // 指定输出目录
//                    .outputDir(packagePath)
//                    // 开启swagger2
//                    .enableSwagger()
//                    // 指定时间策略。
//                    .dateType(DateType.ONLY_DATE)
//                    // 注释时间策略。
//                    .commentDate("yyyy-MM-dd")
//                    )
//
//                // 2. 包配置
//                .packageConfig((scanner, builder) -> builder
//                        // 设置父包名
//                        .parent(parentPackageName)
//                        // 设置实体类包名
//                        .entity("entity")
//                        // 设置service类包名
//                        .service("service")
//                        // 设置controller类包名
//                        .controller("controller")
//                        // 设置mapper类包名
//                        .mapper("mapper")
//                        // 设置mapperXml生成路径
//                        //.pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectRootPath + "\\src\\main\\resources\\mapper"))
//                )
//
//                // 3. 策略配置
//                .strategyConfig((scanner, builder) -> builder
//                        // 为空则生成全部的表名
//                        .addInclude(Collections.emptyList())
//
//                        // Service实体类策略配置
//                        .serviceBuilder()
//                        // 格式化类名
//                        .formatServiceFileName("%sService")
//                        // 格式化类名
//                        .formatServiceImplFileName("%sServiceImpl")
//
//                        // Entity实体类策略配置
//                        .entityBuilder()
//                        // 开启lombok注解
//                        .enableLombok()
//                        // 开启链式模型
//                        .enableChainModel()
//                        // 主键策略：自增
////                        .idType(IdType.AUTO)
//                        // 会在实体类的属性前，添加[@TableField("nickname")]
//                        .enableTableFieldAnnotation()
//                        // 会在实体类的该字段上追加注解[@TableField(value = "create_time", fill = FieldFill.INSERT)]
//                        .addTableFills(new Column("create_time", FieldFill.INSERT))
//                        // 会在实体类的该字段上追加注解[@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)]
//                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
//
//                        // Mapper策略配置
//                        .mapperBuilder()
//                        // 格式化类名
//                        .formatMapperFileName("%sMapper")
//                        // 开启 @Mapper 注解。
//                        // 会在mapper接口上添加注解[@Mapper]
//                        .enableMapperAnnotation()
//                        // 启用 BaseResultMap 生成。
//                        // 会在mapper.xml文件生成[通用查询映射结果]配置。
//                        .enableBaseResultMap()
//                        // 启用 BaseColumnList。
//                        // 会在mapper.xml文件生成[通用查询结果列 ]配置
//                        .enableBaseColumnList()
//
//                        // Controller策略配置
//                        .controllerBuilder()
//                        // 会在控制类中加[@RestController]注解。
//                        .enableRestStyle()
//                        // 格式化类名
//                        .formatFileName("%sController")
//                        // 开启驼峰转连字符
//                        .enableHyphenStyle()
//                        .build()
//                )
//
//                // 4. 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
//                //.templateEngine(new BeetlTemplateEngine())
//                .templateEngine(new FreemarkerTemplateEngine())
//
//                // 5. 执行
//                .execute();
//    }
//}
