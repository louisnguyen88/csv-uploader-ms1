package com.uploader.csvuploaded.web;

import com.uploader.csvuploaded.exception.BusinessException;
import com.uploader.csvuploaded.service.AmazonS3ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller web layer to make api call
 */
@RestController
@RequestMapping("v1.0/files")
public class UploaderController {

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

    /**
     * Upload file API to receive file from client and process it
     * @param file
     * @return
     */
    @PostMapping
    public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        if (file == null || !file.getOriginalFilename().toLowerCase().endsWith(".csv")) {
            throw new BusinessException("Required .csv file in request");
        }
        this.amazonS3ClientService.uploadFileToS3Bucket(file, true);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

        return response;
    }

}
