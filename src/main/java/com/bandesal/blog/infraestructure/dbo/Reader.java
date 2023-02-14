package com.bandesal.blog.infraestructure.dbo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "readers")
@Getter @Setter
public class Reader {
    @Id
    @GeneratedValue(generator = "reader_sequence")
    @GenericGenerator(
        name = "reader_sequence",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "reader_sequence"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
    )
    @Column(name = "id")
    private Integer idReader;
    @Column(name = "name")
    private String name;


}

