package com.kabir.kabirbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "ville")
public class Ville implements Serializable {

    @Id
    private String id;
    private String lib;
    private Pays pays;
}
