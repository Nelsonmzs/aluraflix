package com.nelson.aluraflix.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nelson.aluraflix.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @JsonIgnoreProperties({"title", "color","videos"})
    private Category category;

    @NotNull
    private String url;

}
