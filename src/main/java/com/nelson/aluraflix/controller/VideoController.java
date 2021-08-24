package com.nelson.aluraflix.controller;

import com.nelson.aluraflix.DTO.VideoDTO;
import com.nelson.aluraflix.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/videos")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping
    public ResponseEntity<List<VideoDTO>> findAllVideos() {

        return ResponseEntity.ok(videoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> findVideoById(@PathVariable Integer id) {

        return ResponseEntity.ok(videoService.findVideoById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public VideoDTO createVideo(@RequestBody @Valid VideoDTO videoDTO) {

        return videoService.saveVideo(videoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoDTO> updateVideo(@PathVariable String id, @RequestBody @Valid VideoDTO videoDTO) {

        videoService.updateVideo(videoDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVideo(@PathVariable Integer id) {

        videoService.deleteVideoById(id);
    }
}
