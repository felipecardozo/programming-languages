package com.languages.languages.domain;

import lombok.Data;

import java.util.List;

@Data
public class Language {

    private String id;
    private String name;
    private String longDescription;
    private String imagePath;
    private List<String> used;

}
