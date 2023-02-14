package com.bandesal.blog.infraestructure.repository;

import com.bandesal.blog.infraestructure.dbo.Blog;
import com.bandesal.blog.infraestructure.dbo.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IReaderRepository extends JpaRepository<Reader, Integer> {

    @Query(value = "select * from readers  where id = :idReader", nativeQuery = true)
    public Optional<Reader> finfByIdReader(@Param("idReader") int idReader);




}
