package com.bandesal.blog.application.repository;

import com.bandesal.blog.infraestructure.dbo.Blog;
import com.bandesal.blog.infraestructure.dbo.Reader;

import java.util.List;
import java.util.Optional;

public interface IReaderService {
    public Optional<Reader> getReaderById(int idReader);
    public Reader saveReader(Reader reader);
    public Boolean deleteReader (int idReader);
    public List<Reader> getAll();

}
