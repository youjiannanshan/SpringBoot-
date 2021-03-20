package com.fanyi.service;

import com.fanyi.mapper.CategoryMapper;
import com.fanyi.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> list(){
        return categoryMapper.findAll();
    }

    public Category get(int id){
        return categoryMapper.findById(id);
    }
}
