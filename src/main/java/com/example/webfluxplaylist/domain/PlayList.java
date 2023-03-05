package com.example.webfluxplaylist.domain;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Genero is mandatory.")
    private String genero;
    @NotNull(message = "Banda is mandatory.")
    private String banda;
    @NotNull(message = "Musica is mandatory.")
    private String musica;
}
