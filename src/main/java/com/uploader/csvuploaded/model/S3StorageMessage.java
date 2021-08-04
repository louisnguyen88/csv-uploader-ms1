package com.uploader.csvuploaded.model;

public class S3StorageMessage {

    private String id;
    private String bucketName;
    private String fileName;

    public S3StorageMessage() {
    }

    public S3StorageMessage(String id, String bucketName, String fileName) {
        this.id = id;
        this.bucketName = bucketName;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Override
    public String toString() {
        return "UploadingMessage{" +
                "id='" + id + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", csvFileName='" + fileName + '\'' +
                '}';
    }
}
