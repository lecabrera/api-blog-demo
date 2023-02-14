package com.bandesal.blog.application.repository;

import com.bandesal.blog.infraestructure.dbo.Blog;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IBlogService
{
    public Optional<Blog> getBlogByTitle(String title);
    public Blog createNewBlog(Blog blog);
     public Boolean deleteBlog(int blogId);
     public Optional<List<Blog>> getAllBlogs();

}
