package com.languages.languages.domain;

import lombok.Data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
@Data
public class Language {

    @Id
    private String id;
    private String name;
    private String longDescription;
    private String imagePath;
    private List<String> used;

}
