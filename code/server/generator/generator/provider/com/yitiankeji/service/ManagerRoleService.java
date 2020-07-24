package com.yitiankeji.service;

import com.yitiankeji.entity.ManagerRole;
import com.yitiankeji.mapper.ManagerRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 管理员角色 服务实现类
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
 */
@Service
@Transactional
public class ManagerRoleService extends ServiceImpl<ManagerRoleMapper, ManagerRole> {

}
