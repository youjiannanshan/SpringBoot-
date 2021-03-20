package com.fanyi.mapper;

import com.fanyi.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    List<Category> findAll();

    Category findById(int id);
}
