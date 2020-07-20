package com.yitiankeji.mapper;

import com.yitiankeji.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author art
 * @since 2020-04-08
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    public List<Role> findByManagerId(Integer managerId);
}
