package com.yitiankeji.service;

import com.yitiankeji.entity.Role;
import com.yitiankeji.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author yitiankeji
 */
@Service
@Transactional
public class RoleService extends ServiceImpl<RoleMapper, Role> {

}
