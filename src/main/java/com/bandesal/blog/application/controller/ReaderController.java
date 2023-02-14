package com.bandesal.blog.application.controller;

import com.bandesal.blog.application.repository.IReaderService;
import com.bandesal.blog.infraestructure.dbo.Reader;
import com.bandesal.blog.infraestructure.repository.IReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    Logger logger;
    @Autowired
    IReaderService iReaderService;

    public ReaderController(){
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @GetMapping("/get-all-readers")
    public ResponseEntity<List<Reader>> getAllReader(){
        return new ResponseEntity<>(iReaderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable("id") int id){
            logger.info("Response from service: " + id);
            return iReaderService.getReaderById(id)
                     .map(reader ->
                       new ResponseEntity<>(reader, HttpStatus.OK)
                     )
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/save")
    public ResponseEntity<Reader> saveReader(@RequestBody Reader reader){
        return new ResponseEntity<Reader>(iReaderService.saveReader(reader), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deteleReader(@PathVariable("id") int readerId){
        if(iReaderService.deleteReader(readerId))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
}
