package com.aidijing.service;

import com.aidijing.entity.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
public interface IRoleService extends IService<Role> {
    List<Role> getByUserId ( Long userId );
}
