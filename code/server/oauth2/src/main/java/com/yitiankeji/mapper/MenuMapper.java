package com.yitiankeji.mapper;

import com.yitiankeji.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author art
 * @since 2020-04-08
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    public List<Menu> findByRoleId(Integer roleId);
}
