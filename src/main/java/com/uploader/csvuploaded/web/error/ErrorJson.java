package com.uploader.csvuploaded.web.error;

/**
 * Error json class will be respond error code and message
 */
class ErrorJson {

    String uri;
    String code;
    String message;

    public ErrorJson() {}

    public ErrorJson(String code, String message, String uri) {
        this.code = code;
        this.message = message;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
