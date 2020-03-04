/**
 * 
 * Copyright From 2020, All rights reserved.
 * 
 * SysRoleAuthorityMapper.java
 * 
 */
package com.gxkj.portal.dal.mapper;

import com.gxkj.portal.dal.entity.SysRoleAuthority;

/**
 * <p>
 * 表: sys_role_authority的 mapper 类
 * 
 * @author 	whichstar
 */
public interface SysRoleAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleAuthority record);

    int insertSelective(SysRoleAuthority record);

    SysRoleAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleAuthority record);

    int updateByPrimaryKey(SysRoleAuthority record);
}