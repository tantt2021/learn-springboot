package com.learnspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learnspringboot.entity.Book;
import org.apache.ibatis.annotations.Mapper;


//Mapper来自于mybatis-plus
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
