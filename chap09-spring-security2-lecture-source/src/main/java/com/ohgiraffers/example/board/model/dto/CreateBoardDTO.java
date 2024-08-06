package com.ohgiraffers.example.board.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateBoardDTO {

    private String title;
    private String content;
}
