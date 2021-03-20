package com.fanyi.controller;

import com.fanyi.pojo.Book;
import com.fanyi.service.BookService;
import com.fanyi.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

//视图解析器无法解析jsp,html页面,返回结果直接写入 HTTP response body 中
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list(){
        return bookService.list();
    }

    /*
        修改或者添加图书:
        @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
    */
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate(book);
        return book;
    }

    /*
        删除图书（根据ID）
     */
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    /*
        根据编号将图书分类
        @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中
     */
    @GetMapping("api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid){
        if ( 0!= cid){
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }

    /*
        模糊查询，根据作者名或者书名查询图书
     */
    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

    /*
        上传图书封面图片:
        对接收到的文件重命名，但保留原始的格式
     */
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);//创建文件夹
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            //文件夹不存在就创建
            f.getParentFile().mkdirs();
        try {
            //将图片保存到D盘下
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
