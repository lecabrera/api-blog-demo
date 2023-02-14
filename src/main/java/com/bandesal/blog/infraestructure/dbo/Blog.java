package com.bandesal.blog.infraestructure.dbo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blogs")
@Getter @Setter
public class Blog {
    @Id
    @GeneratedValue(generator = "blog_sequence")
    @GenericGenerator(
        name = "blog_sequence",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "blog_sequence"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
    )
    @Column(name = "id")
    private Integer idBlog;
    private String title;
    private String description;

}
