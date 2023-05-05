package com.wangkun.controller;

import com.wangkun.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("common")
public class CommonController {

    @Value("${fileBasePath}")
    private String fileBasePath;

    @PostMapping("upload")
    public ResponseVo<String> upload(MultipartFile file) {
        // 原始文件名，创建文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileName = UUID.randomUUID() + suffix;

        // 创建一个目录对象
        File dir = new File(fileBasePath);
        if (!dir.exists()) {
            System.out.println("fileBasePath" + fileBasePath);
            dir.mkdirs();
        }

        // 将上传的文件放入指定位置
        try {
            file.transferTo(new File(fileBasePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseVo.success("上传成功");
    }

    @GetMapping("download")
    public void download(String name, HttpServletResponse response) {
        try {
            // 输入流，通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(fileBasePath + name));

            // 输出流，通过输出流将文件写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }

            outputStream.close();
            fileInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}











