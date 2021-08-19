//package com.nelson.aluraflix.mapper;
//
//import com.nelson.aluraflix.model.Video;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ConvertVideo {
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public VideoDTO convertToDTO(Video video) {
//
//        return modelMapper.map(video, VideoDTO.class);
//    }
//
//    public Video convertToEntity(VideoDTO videoDTO) {
//
//        return modelMapper.map(videoDTO, Video.class);
//    }
//}
