package com.gxkj.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GxCommentGenerator extends DefaultCommentGenerator {

    private Properties properties;

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.properties = new Properties();
        this.properties.putAll(properties);
    }


    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        compilationUnit.addFileCommentLine("/**");
        compilationUnit.addFileCommentLine(" * ");

        String copyright = " * Copyright From 2020, All rights reserved.";
        compilationUnit.addFileCommentLine(copyright);

        compilationUnit.addFileCommentLine(" * ");
        compilationUnit.addFileCommentLine(" * " + compilationUnit.getType().getShortNameWithoutTypeArguments() + ".java");
        compilationUnit.addFileCommentLine(" * ");
        compilationUnit.addFileCommentLine(" */");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        //实体类javadoc
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * <p>");
        String remarks = introspectedTable.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" * " + remarks);
        }
        topLevelClass.addJavaDocLine(" * 表: " + introspectedTable.getFullyQualifiedTable() + "的 model 类");
        topLevelClass.addJavaDocLine(" * ");
        topLevelClass.addJavaDocLine(" * @author \t" + getAuth());
        topLevelClass.addJavaDocLine(" * @date \t" + getDateString());
        topLevelClass.addJavaDocLine(" */");

        //实体类添加 序列化
        FullyQualifiedJavaType serializable = new FullyQualifiedJavaType("java.io.Serializable");
        topLevelClass.addImportedType(serializable);
        topLevelClass.addSuperInterface(serializable);
        Field serialVersionUID = new Field();
        serialVersionUID.setVisibility(JavaVisibility.PRIVATE);
        serialVersionUID.setStatic(true);
        serialVersionUID.setFinal(true);
        serialVersionUID.setName("serialVersionUID");
        serialVersionUID.setType(new FullyQualifiedJavaType("long"));
        serialVersionUID.setInitializationString("1L");
        serialVersionUID.addJavaDocLine(" /**  类的 seri version id */");
        topLevelClass.addField(serialVersionUID);
    }


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuffer sb = new StringBuffer();
        sb.append("/** 字段：");
        sb.append(introspectedColumn.getActualColumnName());

        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            sb.append("，");
            sb.append(remarks);
        }
        sb.append(" */");
        field.addJavaDocLine(sb.toString());
    }

    private String getAuth() {
        String author = "$author$";
        if (this.properties.containsKey("author")) {
            author = this.properties.getProperty("author");
        }
        return author;
    }
}
