package com.yitiankeji.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yitiankeji.entity.Manager;
import com.yitiankeji.entity.ManagerRole;
import com.yitiankeji.mapper.ManagerMapper;
import com.yitiankeji.mapper.ManagerRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
 */
@Service
@Transactional
public class ManagerService extends ServiceImpl<ManagerMapper, Manager> {

    @Autowired
    private ManagerRoleMapper managerRoleMapper;

    public void saveRoles(Integer managerId, List<Integer> roleIds) {
        // 删除管理员具有的角色
        managerRoleMapper.deleteByManagerId(managerId);
        // 为管理员添加新角色
        managerRoleMapper.saveRoles(managerId, roleIds);
    }
}
