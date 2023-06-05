package com.example.musicserve;

import com.example.musicserve.domain.Admin;
import com.example.musicserve.domain.Singer;
import com.example.musicserve.service.AdminService;
import com.example.musicserve.service.SingerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MusicServeApplicationTests {
    @Autowired
    private AdminService adminService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMP(){
        List<Admin> list = adminService.list();
        for (Admin admin : list) {
            System.out.println(admin);
        }
    }
    @Autowired
    private SingerService singerService;
    @Test
    public void testMP2(){
        List<Singer> list = singerService.list();
        for (var admin : list) {
            System.out.println(admin);
        }
    }

}
