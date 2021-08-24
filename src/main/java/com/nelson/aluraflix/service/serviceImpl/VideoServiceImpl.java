package com.nelson.aluraflix.service.serviceImpl;

import com.nelson.aluraflix.Enum.CategoryEnum;
import com.nelson.aluraflix.DTO.VideoDTO;
import com.nelson.aluraflix.entity.Category;
import com.nelson.aluraflix.entity.Video;
import com.nelson.aluraflix.repository.VideoRepository;
import com.nelson.aluraflix.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<VideoDTO> findAll() {

        List<Video> videos = this.videoRepository.findAll();

        return videos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public VideoDTO findVideoById(Integer id) {

        Video video = this.videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Video não encontrado"));

        return convertToDTO(video);
    }

    @Override
    public VideoDTO saveVideo(VideoDTO videoDTO) {

        Video video = convertToEntity(videoDTO);

        Video videoSaved = this.videoRepository.save(video);

        return convertToDTO(videoSaved);
    }

    @Override
    public VideoDTO updateVideo(VideoDTO videoDTO) {

        Video video = this.videoRepository.findById(videoDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Video não encontrado para atualização"));

        video.setTitle(videoDTO.getTitle());
        video.setDescription(videoDTO.getDescription());
        video.setUrl(videoDTO.getUrl());

        Video videoUpdated = this.videoRepository.save(video);

        return convertToDTO(videoUpdated);
    }

    @Override
    public void deleteVideoById(Integer id) {

        this.videoRepository.deleteById(id);

    }

    public VideoDTO convertToDTO(Video video) {

        return this.modelMapper.map(video, VideoDTO.class);
    }

    public Video convertToEntity(VideoDTO videoDTO) {

        // Se o video não vir com categoria, será categoria default 'Livre'
        if (videoDTO.getCategory().getId() == null) {

            Category category = new Category();

            category.setId(CategoryEnum.FREE.getValue());
            videoDTO.setCategory(category);
        }

        return this.modelMapper.map(videoDTO, Video.class);
    }
}
