package com.lcwd.todo.todomanager.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    //Handling single file
    @PostMapping("/single")
    public String uploadSingle(@RequestParam("image") MultipartFile file){
        logger.info("file content type : {}" , file.getContentType());
        logger.info("file name : {}" , file.getName());
        logger.info("Original file name : {}" , file.getOriginalFilename());
        logger.info("file size : {}" , file.getSize());

        //how to write file in serve

//        InputStream inputStream = file.getInputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream("data.png");
//        byte data[] = new byte[inputStream.available()];
//        fileOutputStream.write(inputStream);

        return "file test";
    }

    //Handling multiple file
    @PostMapping("/multiple")
    public String uploadMulti(@RequestParam MultipartFile[] files){
        Arrays.stream(files).forEach(file ->{
            logger.info("file content type : {}" , file.getContentType());
            logger.info("file name : {}" , file.getName());
            logger.info("Original file name : {}" , file.getOriginalFilename());
            logger.info("file size : {}" , file.getSize());
            System.out.println("+++++++++++++++++++++++");
        });
        return "Handling multiple file";
    }

    //Serving file in response
    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response){
       try{
           InputStream fileInputStream = new FileInputStream("images/download.png");
           response.setContentType(MediaType.IMAGE_PNG_VALUE);
           StreamUtils.copy(fileInputStream , response.getOutputStream());

       }catch (Exception e){
           e.printStackTrace();
       }


    }
}
