package com.fanyi.service;

import com.fanyi.mapper.BookMapper;
import com.fanyi.pojo.Book;
import com.fanyi.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        return bookMapper.findAll();
    }

    public void addOrUpdate(Book book){
        bookMapper.addOrUpdate(book);
    }

    public void deleteById(int id){
        bookMapper.deleteById(id);
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookMapper.findAllByCategory(category);
    }

    public List<Book> Search(String keywords){
        return bookMapper.findAllByTitleLikeOrAuthorLike('%'+keywords+'%');
    }


}
