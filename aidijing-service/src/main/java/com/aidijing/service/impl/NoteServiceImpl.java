package com.aidijing.service.impl;

import com.aidijing.entity.Note;
import com.aidijing.mapper.NoteMapper;
import com.aidijing.service.INoteService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 笔记 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {
	
}
