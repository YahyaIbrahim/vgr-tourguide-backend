package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.exceptions.SuccessPhoto;
import com.sabrysolutions.voyager.backend.exceptions.SuccessString;
import com.sabrysolutions.voyager.backend.models.Image;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.ProfileImage;
import com.sabrysolutions.voyager.backend.models.Video;
import com.sabrysolutions.voyager.backend.repositories.ImageRepository;
import com.sabrysolutions.voyager.backend.services.MediaService;
import com.sabrysolutions.voyager.backend.services.ProfileService;
import com.sabrysolutions.voyager.backend.storage.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Api(value = "Media APIs", tags = {"Media Management"},
		description = "Media operations")
public class MediaController {
/*
	@Value("${server.path}")
	private String serverPath;
*/
	@Autowired
	private HttpServletRequest httpServletRequest;



	@Autowired
	ProfileService profileService;

	@Autowired
	MediaService mediaService;

	private final StorageService storageService;


	@Autowired
	public MediaController(StorageService storageService) {
		this.storageService = storageService;

	}



	@ApiOperation(value = "Loads Media image")
	@GetMapping(path = "/{email}/media/images",produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessList loadMediaImage(@PathVariable String email) {
		try {
			Profile profile = profileService.loadByEmail(email);
			List<Image> touristPhotos = mediaService.findImageByProfileId(profile.getId());
			return new SuccessList(200, true, touristPhotos, null);
		}catch (NullPointerException d) {
			return new SuccessList(400, true, null, "There's no Images");
		}

	}

	@ApiOperation(value = "Loads Media")
	@GetMapping(path = "/{email}/media/videos",produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessList loadMediaVideo(@PathVariable String email) {
		try {
			Profile profile = profileService.loadByEmail(email);
			List<Video> touristVideos = mediaService.findVideoByProfileId(profile.getId());
			return new SuccessList(200, true, touristVideos, null);
		}catch (NullPointerException d) {
			return new SuccessList(400, true, null, "There's no Videos");
		}

	}


	@PostMapping(value = "/{email}/uploadPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public SuccessList handleFileUpload(@RequestPart("file") MultipartFile file,
								  @PathVariable String email) {
		Profile profile = profileService.loadByEmail(email);
		String serverPath = "http://"+httpServletRequest.getServerName() + "/media/";
		Image image=new Image();
		image.setProfile(profile);
		image.setUpdateTime(new Date());
		image.setUrlLink(serverPath+file.getOriginalFilename());
		if (image.getUrlLink().equals("")) {
			return new SuccessList(400, true, null, "uploading the file is failed !");
		} else {
			mediaService.saveImage(image);
			storageService.store(file);
			return new SuccessList(200, true, null, null);

		}
	}
	@PostMapping(value = "{email}/uploadVideo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public SuccessList handleVideoUpload(@RequestPart("file") MultipartFile file
										,@PathVariable String email) {

		Profile profile = profileService.loadByEmail(email);
		String serverPath = "http://"+httpServletRequest.getServerName() + "/media/";
		Video video=new Video();
		video.setProfile(profile);
		video.setUpdateTime(new Date());
		video.setUrlLink(serverPath+file.getOriginalFilename());
		if (video.getUrlLink().equals("")) {
			return new SuccessList(400, true, null, "uploading the file is failed !");
		} else {
			mediaService.saveVideo(video);
			storageService.store(file);
			return new SuccessList(200, true, null, null);

		}
	}

	@PostMapping(value = "/{email}/editProfilePhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public SuccessList updateProfilePhoto(@RequestPart("file") MultipartFile file
									,@PathVariable String email) {


		Profile profile = profileService.loadByEmail(email);
		String serverPath = "http://"+httpServletRequest.getServerName() + "/media/";
		ProfileImage image=new ProfileImage();
		image.setProfile(profile);
		image.setUpdateTime(new Date());
		image.setPath(serverPath+file.getOriginalFilename());
		image.setProfile(profile);

		if (image.getPath().equals("")) {
			return new SuccessList(400, true, null, "uploading the file is failed !");

		}else{
			profileService.saveImage(image);
			storageService.store(file);
			profile.setProfileImage(image);
			profileService.save(profile);
			return new SuccessList(200, true, null, null);
		}
	}


	@ApiOperation(value = "Loads Media")
	@GetMapping(path = "/{email}/media/profileImage",produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessPhoto loadProfilePhoto(@PathVariable String email) {
		try {
			Profile profile = profileService.loadByEmail(email);
			ProfileImage profileImage = profileService.loadProfileImage(profile);
			return new SuccessPhoto(200,  true,profileImage, null);
		}catch (NullPointerException d) {
			return new SuccessPhoto(400,  false,null, "There's no Profile Image");
		}

	}


}