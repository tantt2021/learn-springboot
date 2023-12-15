package com.learnspringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learnspringboot.entity.Book;
import com.learnspringboot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/addBook")
    public String addBook(Book book){
        System.out.println(book.toString());
        int i = bookMapper.insert(book);
        if(i> 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    /*
    * Get方式根据name查书
    * */
    @GetMapping("/findBook/{name}")
    public String findBook(@PathVariable String name){
        QueryWrapper<Book>  queryWrapper = new QueryWrapper<Book>();
        queryWrapper.like("name",name);
        List<Book> books = bookMapper.selectList(queryWrapper);
        books.forEach(System.out::println);
        return books.toString();
    }

    /*
    * Post方式根据name查书
    * */
    @PostMapping("/findBookByName")
    public List<Book> findBookByName(Book book){
        System.out.println("收到的请求参数："+book);
        QueryWrapper<Book>  queryWrapper = new QueryWrapper<Book>();
        queryWrapper.like("name",book.getName());
        List<Book> books = bookMapper.selectList(queryWrapper);
        System.out.println("查询结果："+books);
        return books;
    }

    /*
    * Post改数据
    * */
    @PostMapping("/updateBook")
    public String updateBook(Book book){
        System.out.println("修改的入参："+book);
        int i = bookMapper.updateById(book);
        if(i > 0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /*
    * Post删除数据
    * */
    @PostMapping("/deleteBook")
    public String deleteBook(String id){
        System.out.println("id:"+id);
        int i = bookMapper.deleteById(id);
        if(i > 0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

}
