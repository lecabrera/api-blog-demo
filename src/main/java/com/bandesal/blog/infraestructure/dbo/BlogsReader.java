package com.bandesal.blog.infraestructure.dbo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blogs_readers")
@Getter @Setter
public class BlogsReader {
    @EmbeddedId
    private BlogsReaderPK id;

    @ManyToOne
    @JsonIgnoreProperties("readers")
    @MapsId("idBlog")
    @JoinColumn(name = "id_b", insertable = false, updatable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "id_r", insertable = false, updatable = false)
    private Reader reader;

}
