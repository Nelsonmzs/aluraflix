package com.nelson.aluraflix.service;

import com.nelson.aluraflix.mapper.VideoDTO;

import java.util.List;

public interface VideoService {

    List<VideoDTO> findAll();

    VideoDTO findVideoById(Integer id);

    VideoDTO saveVideo(VideoDTO videoDTO);

    VideoDTO updateVideo(VideoDTO videoDTO);

    void deleteVideoById(Integer id);
}
