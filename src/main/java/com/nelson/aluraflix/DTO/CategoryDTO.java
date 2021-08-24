package com.nelson.aluraflix.DTO;

import com.nelson.aluraflix.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String color;

    private List<Video> videos;
}
