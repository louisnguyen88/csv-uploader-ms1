package com.uploader.csvuploaded.service;

public interface AmazonSqsClientService {
    void sendMessageToSqs(String awsS3AudioBucket, String message);
}
