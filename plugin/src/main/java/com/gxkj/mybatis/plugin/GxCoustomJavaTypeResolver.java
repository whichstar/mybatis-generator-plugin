package com.gxkj.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.util.HashMap;
import java.util.Map;

public class GxCoustomJavaTypeResolver extends JavaTypeResolverDefaultImpl {
    protected Map<String, Integer> typeExtMap;

    public GxCoustomJavaTypeResolver() {
        this.typeExtMap = new HashMap<>();
        initTypeSet();
    }


    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        for (String jdbcType : this.typeExtMap.keySet()) {

            String value = this.properties.getProperty(jdbcType);

            if (hasText(value)) {
                this.typeMap.put(this.typeExtMap.get(jdbcType), new JavaTypeResolverDefaultImpl.JdbcTypeInformation(jdbcType.substring(jdbcType.indexOf(".") + 1), new FullyQualifiedJavaType(value)));
            }
        }
        return super.calculateJavaType(introspectedColumn);
    }

    private void initTypeSet() {
        this.typeExtMap.put("jdbcType.ARRAY", Integer.valueOf(2003));
        this.typeExtMap.put("jdbcType.BIGINT", Integer.valueOf(-5));
        this.typeExtMap.put("jdbcType.BINARY", Integer.valueOf(-2));
        this.typeExtMap.put("jdbcType.BIT", Integer.valueOf(-7));
        this.typeExtMap.put("jdbcType.BLOB", Integer.valueOf(2004));
        this.typeExtMap.put("jdbcType.BOOLEAN", Integer.valueOf(16));
        this.typeExtMap.put("jdbcType.CHAR", Integer.valueOf(1));
        this.typeExtMap.put("jdbcType.CLOB", Integer.valueOf(2005));
        this.typeExtMap.put("jdbcType.DATALINK", Integer.valueOf(70));
        this.typeExtMap.put("jdbcType.DATE", Integer.valueOf(91));
        this.typeExtMap.put("jdbcType.DECIMAL", Integer.valueOf(3));
        this.typeExtMap.put("jdbcType.DISTINCT", Integer.valueOf(2001));
        this.typeExtMap.put("jdbcType.DOUBLE", Integer.valueOf(8));
        this.typeExtMap.put("jdbcType.FLOAT", Integer.valueOf(6));
        this.typeExtMap.put("jdbcType.INTEGER", Integer.valueOf(4));
        this.typeExtMap.put("jdbcType.JAVA_OBJECT", Integer.valueOf(2000));
        this.typeExtMap.put("jdbcType.LONGNVARCHAR", Integer.valueOf(-16));
        this.typeExtMap.put("jdbcType.LONGVARBINARY", Integer.valueOf(-4));
        this.typeExtMap.put("jdbcType.LONGVARCHAR", Integer.valueOf(-1));
        this.typeExtMap.put("jdbcType.NCHAR", Integer.valueOf(-15));
        this.typeExtMap.put("jdbcType.NCLOB", Integer.valueOf(2011));
        this.typeExtMap.put("jdbcType.NVARCHAR", Integer.valueOf(-9));
        this.typeExtMap.put("jdbcType.NULL", Integer.valueOf(0));
        this.typeExtMap.put("jdbcType.NUMERIC", Integer.valueOf(2));
        this.typeExtMap.put("jdbcType.OTHER", Integer.valueOf(1111));
        this.typeExtMap.put("jdbcType.REAL", Integer.valueOf(7));
        this.typeExtMap.put("jdbcType.REF", Integer.valueOf(2006));
        this.typeExtMap.put("jdbcType.SMALLINT", Integer.valueOf(5));
        this.typeExtMap.put("jdbcType.STRUCT", Integer.valueOf(2002));
        this.typeExtMap.put("jdbcType.TIME", Integer.valueOf(92));
        this.typeExtMap.put("jdbcType.TIMESTAMP", Integer.valueOf(93));
        this.typeExtMap.put("jdbcType.TINYINT", Integer.valueOf(-6));
        this.typeExtMap.put("jdbcType.VARBINARY", Integer.valueOf(-3));
        this.typeExtMap.put("jdbcType.VARCHAR", Integer.valueOf(12));
    }


    public static boolean hasText(String text) {
        if (text != null && text.trim().length() > 0) return true;
        return false;
    }
}
