package com.uploader.csvuploaded.service.impl;

import com.uploader.csvuploaded.model.S3StorageMessage;
import com.uploader.csvuploaded.service.AmazonSqsClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * This class will be send message to SQS by QueueMessagingTemplate
 */
@Service
public class AmazonSqsClientServiceImpl implements AmazonSqsClientService {


    public static final String QUEUE = "ms-uploader";
    private static final Logger log = LoggerFactory.getLogger(AmazonSqsClientServiceImpl.class);

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public AmazonSqsClientServiceImpl(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @Override
    /**
     * Send message to SQS to communicate with File Transformer
     */
    public void sendMessageToSqs(String bucketName, String csvPath) {
        S3StorageMessage s3StorageMessage = new S3StorageMessage(UUID.randomUUID().toString(), bucketName, csvPath);
        log.info("Sending the message {} to the Amazon sqs {}.", s3StorageMessage, QUEUE);
        queueMessagingTemplate.convertAndSend(QUEUE, s3StorageMessage);
        log.info("Message {} sent successfully to the Amazon sqs {}.", s3StorageMessage, QUEUE);
    }
}
