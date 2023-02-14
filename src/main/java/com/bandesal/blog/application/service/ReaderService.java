package com.bandesal.blog.application.service;

import com.bandesal.blog.application.repository.IReaderService;
import com.bandesal.blog.infraestructure.dbo.Blog;
import com.bandesal.blog.infraestructure.dbo.Reader;
import com.bandesal.blog.infraestructure.repository.IReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService implements IReaderService {
    private Logger logger;
    @Autowired
    private IReaderRepository iReaderRepository;

    public ReaderService(){
      //  this.iReaderRepository = iReaderRepository;
        //this.iReaderRepository = iReaderRepository;
        this.logger = LoggerFactory.getLogger(getClass());
    }
    @Override
    public Optional<Reader> getReaderById(int idReader) {
            return iReaderRepository.finfByIdReader(idReader);
    }

    @Override
    public Reader saveReader(Reader reader){
        return  iReaderRepository.save(reader);
    }

    @Override
    public Boolean deleteReader(int idReader) {
        return getReaderById(idReader).map(reader -> {
            iReaderRepository.delete(reader);
            return true;
        }).orElse( false
        );
    }

    @Override
    public List<Reader> getAll() {
        return iReaderRepository.findAll();
    }


}
