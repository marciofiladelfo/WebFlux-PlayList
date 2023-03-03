package com.example.webfluxplaylist.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PlayList {

    @Id
    private String id;
    private String genero;
    private String banda;
    private String musica;
}
