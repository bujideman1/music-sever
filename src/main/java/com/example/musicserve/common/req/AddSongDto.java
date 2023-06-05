package com.example.musicserve.common.req;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class AddSongDto {
    private Integer singerId;
    private String name;
    private String introduction;
    private String lyric;
    private MultipartFile mpFile;
}
