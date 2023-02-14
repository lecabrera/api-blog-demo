package com.bandesal.blog.infraestructure.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
public class BlogsReaderPK implements Serializable {
    @Column(name = "id_r")
    private Integer idReader;
    @Column(name = "id_b")
    private Integer idBlog;

}
