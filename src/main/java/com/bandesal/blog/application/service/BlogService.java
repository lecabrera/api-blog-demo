package com.bandesal.blog.application.service;

import com.bandesal.blog.application.repository.IBlogService;
import com.bandesal.blog.infraestructure.dbo.Blog;
import com.bandesal.blog.infraestructure.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public Optional<Blog> getBlogByTitle(String title) {
        return iBlogRepository.findBlogByTitle(title);
    }

    public Optional<Blog> getBlogById(int idBlog){
        return iBlogRepository.findById(idBlog);
    }

    @Override
    public Blog createNewBlog(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public Boolean deleteBlog(int blogId) {
        return getBlogById(blogId).map(blog -> {
            iBlogRepository.deleteById(blogId);
            return true;
        }).orElse(false);
    }
    @Override
    public Optional<List<Blog>> getAllBlogs() {
        return Optional.of(iBlogRepository.findAll());
    }


}
