package com.aidijing.service;

import com.aidijing.domian.JwtUser;
import com.aidijing.entity.Role;
import com.aidijing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        User user = userService.findByUsername( username );
        if ( user == null ) {
            throw new UsernameNotFoundException( String.format( "该'%s'用户名不存在.", username ) );
        } else {
            return new JwtUser(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    mapToGrantedAuthorities( user.getId() ),
                    user.isEnabled(),
                    user.getLastPasswordResetDate()
            );
        }
    }

    private List< GrantedAuthority > mapToGrantedAuthorities ( Long userId ) {
        List< Role > roles = roleService.getByUserId( userId );
        return roles.parallelStream()
                    .map( role -> new SimpleGrantedAuthority( role.getRoleNameCode() ) )
                    .collect( Collectors.toList() );
    }
}










