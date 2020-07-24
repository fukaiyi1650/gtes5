package com.yitiankeji.service;

import com.yitiankeji.entity.Manager;
import com.yitiankeji.mapper.ManagerMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author yitiankeji
 */
@Service
@Transactional
public class ManagerService extends ServiceImpl<ManagerMapper, Manager> {

}
