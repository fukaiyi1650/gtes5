package com.yitiankeji.service;

import com.yitiankeji.entity.RoleMenu;
import com.yitiankeji.mapper.RoleMenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
 */
@Service
@Transactional
public class RoleMenuService extends ServiceImpl<RoleMenuMapper, RoleMenu> {

}
