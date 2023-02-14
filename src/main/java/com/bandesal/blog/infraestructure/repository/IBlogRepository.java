package com.bandesal.blog.infraestructure.repository;

import com.bandesal.blog.infraestructure.dbo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blogs  where title = :title", nativeQuery = true)
    public Optional<Blog> findBlogByTitle(@Param("title") String title);

}
