package com.fanyi.mapper;

import com.fanyi.pojo.Book;
import com.fanyi.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keywords);

    List<Book> findAll();
    int addOrUpdate(Book book);
    int deleteById(int id);

}
