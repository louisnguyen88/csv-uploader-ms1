package com.uploader.csvuploaded.service;

import com.uploader.csvuploaded.model.S3StorageMessage;
import com.uploader.csvuploaded.service.impl.AmazonSqsClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

import static org.mockito.Mockito.*;

public class AmazonSqsClientServiceTest {
    private QueueMessagingTemplate queueMessagingTemplate;

    private AmazonSqsClientService amazonSqsClientService;

    @Before
    public void setUp() {
        queueMessagingTemplate = mock(QueueMessagingTemplate.class);
        amazonSqsClientService = new AmazonSqsClientServiceImpl(queueMessagingTemplate);
    }

    @Test
    public void shouldCallQueueMessagingTemplateToSendToUploadQueueWhenSendMessageToSqs() {
        amazonSqsClientService.sendMessageToSqs("bucket-name", "message");
        String queue = "ms-uploader";
        verify(queueMessagingTemplate, times(1)).convertAndSend(eq(queue), any(S3StorageMessage.class));
    }
}
