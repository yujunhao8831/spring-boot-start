package com.aidijing.service;

import com.aidijing.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
public interface IUserService extends IService< User > {


    PageInfo listPage ( PageRowBounds pageRowBounds );

    List< User > list ();

    User get ( Long id );

    User update ( User user );

    User save ( User user );

    boolean delete ( Long id );

    /**
     * 异步更新
     *
     * @return
     */
    ListenableFuture< Boolean > asyncUpdate ();
}
