package com.goal.controller;

import com.goal.entity.Book;
import com.goal.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 查找出所有的图书信息并分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    /**
     * 更新操作
     * @param book
     * @return
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        if (book != null){
            bookRepository.saveAndFlush(book);
            return "success";
        }
            return "error";
    }

    /**
     * 添加操作
     * @param book
     * @return
     */
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        if (book != null){
            bookRepository.saveAndFlush(book);
            return "success";
        }
        return "error";
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        if (id != null){
            bookRepository.deleteById(id);
            return "success";
        }
        return "error";
    }


}
