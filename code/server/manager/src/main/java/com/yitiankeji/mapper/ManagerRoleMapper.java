package com.yitiankeji.mapper;

import com.yitiankeji.entity.ManagerRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 管理员角色 Mapper 接口
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
 */
@Repository
public interface ManagerRoleMapper extends BaseMapper<ManagerRole> {

    void deleteByManagerId(Integer managerId);

    void saveRoles(@Param("managerId") Integer managerId, @Param("roleIds") List<Integer> roleIds);
}
