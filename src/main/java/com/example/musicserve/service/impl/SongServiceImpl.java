package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicserve.common.constant.AppHttpCodeEnum;
import com.example.musicserve.common.constant.Constants;
import com.example.musicserve.common.req.AddSongDto;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Song;
import com.example.musicserve.service.SongService;
import com.example.musicserve.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song>
    implements SongService{
    @Autowired
    private SongMapper songMapper;
    @Override
    public ResponseResult allSong() {
        List<Song> songs = songMapper.selectList(null);
        return ResponseResult.okResult(songs);
    }

    @Override
    public ResponseResult addSong(AddSongDto songDto) {
        String pic="/img/songPic/tubiao.jpg";
        MultipartFile mpFile = songDto.getMpFile();
        String filePath= Constants.SONG_PATH;
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }
        String filename = mpFile.getOriginalFilename();
        File dest = new File(filePath + System.getProperty("file.separator") + filename);
        String storeUrlPath="/song/"+filename;
        try {
            //保存到本地
            mpFile.transferTo(dest);
//            将歌曲信息存入数据库
            Song song = new Song();
            song.setSingerId(songDto.getSingerId());
            song.setName(songDto.getName());
            song.setIntroduction(songDto.getIntroduction());
            song.setPic(pic);
            song.setLyric(songDto.getLyric());
            song.setUrl(storeUrlPath);
            int insert = songMapper.insert(song);
            if(insert>0){
                return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(),"上传成功",storeUrlPath);
            }
            else{
                return ResponseResult.errorResult(AppHttpCodeEnum.UPLOAD_FAILED);
            }
        } catch (IOException e) {
            return ResponseResult.errorResult(AppHttpCodeEnum.UPLOAD_FAILED);
        }
    }

    @Override
    public ResponseResult getDetail(Integer id) {
        Song song = songMapper.selectById(id);
        return ResponseResult.okResult(song);
    }
}




