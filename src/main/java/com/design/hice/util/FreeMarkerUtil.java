package com.design.hice.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @Description
 * @Author ckj
 * @Date 2022/7/29 11:07 AM
 **/
@Component
public class FreeMarkerUtil {
    @Value("${static.path}")
    private String staticPath;
    private static String templatePath;
    static{
        try {
            templatePath = ResourceUtils.getURL("classpath:").getPath() + "/templates";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void createHtml(String templateType, String templateFileName, String targetPath, String targetFileName, Map<String, Object> map) throws IOException, TemplateException {
        Configuration config = new Configuration();
        //指定默认编码格式
        config.setDefaultEncoding("UTF-8");
        //设置模版文件的路径
        config.setDirectoryForTemplateLoading(new File(staticPath + "/templates/" + templateType));
        //获得模版包
        Template template = config.getTemplate(templateFileName);

        //从参数文件中获取指定输出路径
        String path = staticPath +"/"+ targetPath;
        //生成的静态页存放路径如果不存在就创建
        File file = null;
        file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //定义输出流，注意必须指定编码
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path + "/" + targetFileName)), UTF_8));
        //生成模版
        template.process(map, writer);
    }

}
