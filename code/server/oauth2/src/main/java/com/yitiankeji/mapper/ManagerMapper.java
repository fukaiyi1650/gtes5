package com.yitiankeji.mapper;

import com.yitiankeji.entity.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author art
 * @since 2020-04-08
 */
@Repository
public interface ManagerMapper extends BaseMapper<Manager> {

    Manager findByAccount(String account);
}
