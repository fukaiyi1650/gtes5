package com.yitiankeji.service;

import com.yitiankeji.entity.Menu;
import com.yitiankeji.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
 */
@Service
@Transactional
public class MenuService extends ServiceImpl<MenuMapper, Menu> {

}
