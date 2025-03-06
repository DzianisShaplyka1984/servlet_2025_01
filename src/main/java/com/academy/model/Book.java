package com.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private Integer year;
}
