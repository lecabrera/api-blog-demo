package com.bandesal.blog.application.controller;

import com.bandesal.blog.application.repository.IBlogService;
import com.bandesal.blog.infraestructure.dbo.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    Logger logger;
    @Autowired
    IBlogService iBlogService;
    public BlogController(){
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        return iBlogService.getAllBlogs()
                .map(blogs -> new ResponseEntity<>(blogs, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/get/{title}")
    public ResponseEntity<Blog> getBlogByTitle(@PathVariable("title") String title){
        return iBlogService.getBlogByTitle(title).map(blog ->
                new ResponseEntity<>(blog, HttpStatus.FOUND)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Blog> saveNewBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(iBlogService.createNewBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity deteleBlog(@PathVariable("id") int bloggerId){
        if(iBlogService.deleteBlog(bloggerId))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



}
