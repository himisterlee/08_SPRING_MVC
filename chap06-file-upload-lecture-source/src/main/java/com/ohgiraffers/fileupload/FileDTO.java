package com.ohgiraffers.fileupload;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {

    private String originFileName;
    private String saveName;
    private String filePath;
    private String fileDescription;
}
