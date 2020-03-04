/**
 * 
 * Copyright From 2020, All rights reserved.
 * 
 * SysRoleAuthority.java
 * 
 */
package com.gxkj.portal.dal.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 表: sys_role_authority的 model 类
 * 
 * @author 	whichstar
 * @date 	2020年03月04日
 */
@Data
public class SysRoleAuthority implements Serializable {
     /**  类的 seri version id */
    private static final long serialVersionUID = 1L;

    /** 字段：id，编号 */
    private Long id;

    /** 字段：role_id，角色id */
    private Long roleId;

    /** 字段：auth_id，权限id */
    private Long authId;

    /** 字段：state，有效1，无效0 */
    private Integer state;

    /** 字段：update_time，修改时间 */
    private Date updateTime;

    /** 字段：create_time，创建时间 */
    private Date createTime;
}