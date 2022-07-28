package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.models.Image;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.Video;
import com.sabrysolutions.voyager.backend.repositories.ImageRepository;
import com.sabrysolutions.voyager.backend.repositories.LanguageRepository;
import com.sabrysolutions.voyager.backend.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MediaService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private VideoRepository videoRepository;


    public List<Image> findImageByProfileId(Long id){
       return imageRepository.findByProfileId(id);

    }

    public List<Video> findVideoByProfileId(Long id){
        return videoRepository.findByProfileId(id);

    }

    public void saveImage(Image image){
        imageRepository.save(image);
    }

    public void saveVideo(Video video){
        videoRepository.save(video);
    }

}
