package com.aidijing.service.impl;

import com.aidijing.entity.User;
import com.aidijing.mapper.UserMapper;
import com.aidijing.service.IUserService;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.springframework.cache.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户服务实现类
 * <p>
 * 这里 {@code @CacheConfig 的 cacheNames = "userService.user"},表示该类下面所有方法在使用Spring Cache注解后
 * 默认的cacheNames,如果不指定则使用@CacheConfig所指定的cacheNames,如果指定了,则使用指定的.
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
@CacheConfig( cacheNames = "userService.user.namespace" )
@Service( "userService" )
public class UserServiceImpl extends ServiceImpl< UserMapper, User > implements IUserService {

    /**
     * 用户分页在缓存中存储名称key的前缀
     */
    private static final String CACHE_USER_LIST_PAGE_NAME_PREFIX = "userService.user.list.namespace";


    /**
     * SpEL表达式 : T(完整的类名),因为key只能是String类型,下面的key使用SpEL表达式进行了转换
     * 这里
     *
     * @param pageRowBounds
     * @return
     */
    @Cacheable( value = CACHE_USER_LIST_PAGE_NAME_PREFIX, key = "#pageRowBounds.offset + '.' + #pageRowBounds.getLimit()" )
    @Override
    public PageInfo listPage ( PageRowBounds pageRowBounds ) {

        PageHelper.startPage( pageRowBounds.getOffset(), pageRowBounds.getLimit() );
        return new PageInfo( super.selectList( null ) );
    }

    @Cacheable( value = CACHE_USER_LIST_PAGE_NAME_PREFIX, key = "#root.methodName" )
    @Override
    public List< User > list () {
        return super.selectList( null );
    }

    @Cacheable( key = "T(java.lang.String).valueOf(#id)" )
    @Override
    public User get ( Long id ) {
        return super.selectById( id );
    }


    @Caching(
            evict = {
                    @CacheEvict( value = CACHE_USER_LIST_PAGE_NAME_PREFIX, allEntries = true )
            },
            put = {
                    @CachePut( key = "T(java.lang.String).valueOf(#user.id)", condition = "#result != null" )
            }
    )
    @Override
    public User update ( User user ) {
        if ( ! super.updateById( user ) ) {
            return null;
        }
        return super.selectById( user.getId() );
    }


    @Caching(
            evict = {
                    @CacheEvict( value = CACHE_USER_LIST_PAGE_NAME_PREFIX, allEntries = true )
            },
            put = {
                    @CachePut( key = "T(java.lang.String).valueOf(#user.id)", condition = "#result != null" )
            }
    )
    @Override
    public User save ( User user ) {
        if ( ! super.insert( user ) ) {
            return null;
        }
        return user;
    }

    @Caching( evict = {
            @CacheEvict( value = CACHE_USER_LIST_PAGE_NAME_PREFIX, allEntries = true ) ,
            @CacheEvict( key = "T(java.lang.String).valueOf(#id)" )

    } )
    @Override
    public boolean delete ( Long id ) {
        return super.deleteById( id );
    }

    @Async
    @Override
    public ListenableFuture< Boolean > asyncUpdate () {
        return new AsyncResult( this.sleepUpdate( 3 ) );
    }

    private Boolean sleepUpdate ( int second ) {
        try {
            TimeUnit.SECONDS.sleep( second );
        } catch ( InterruptedException e ) {
        }
        final List< User > users = super.selectList( null );
        users.forEach( user -> user.setUpdateTime( Calendar.getInstance().getTime() ) );
        return super.updateBatchById( users );
    }

    @Override
    public User findByUsername ( String username ) {
        return this.selectOne( new Condition().eq( "username", username ) );
    }

}
