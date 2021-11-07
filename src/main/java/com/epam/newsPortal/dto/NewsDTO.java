package com.epam.newsPortal.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
public class NewsDTO {

    public NewsDTO() {
    }

    @NonNull
    private Long id;
    @NonNull
    private String title;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @NonNull
    private String brief;
    @NonNull
    private String content;
}
