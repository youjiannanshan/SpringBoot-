package com.fanyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int id;
    private Category category;

    String cover;
    String title;
    String author;
    String date;
    String press;
    String abs;
}
