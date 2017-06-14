package com.aidijing.service.impl;

import com.aidijing.entity.Role;
import com.aidijing.entity.UserRole;
import com.aidijing.mapper.RoleMapper;
import com.aidijing.service.IRoleService;
import com.aidijing.service.IUserRoleService;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl< RoleMapper, Role > implements IRoleService {

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public List< Role > getByUserId ( Long userId ) {
        final List< UserRole > userRoles = userRoleService.selectList( new Condition().eq( "user_id", userId ) );
        final List< Long > roleIds = userRoles.parallelStream()
                                              .map( UserRole::getRoleId ) // userRole -> userRole.getRoleId()
                                              .collect( Collectors.toList() );
        return this.selectBatchIds( roleIds );
    }
}
