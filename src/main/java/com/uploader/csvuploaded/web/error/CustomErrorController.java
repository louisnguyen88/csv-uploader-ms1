package com.uploader.csvuploaded.web.error;


import com.uploader.csvuploaded.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * handle all exception and respond http error
 */
@ControllerAdvice
class CustomErrorController {
    private static final Logger log = LoggerFactory.getLogger(CustomErrorController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorJson> handleConflict(Exception ex, HttpServletRequest request) {

        HttpStatus httpStatus;

        if (ex instanceof BusinessException) {

            // logging exception message
            log.warn("Problem processing request: " + request.getRequestURI());
            log.warn("Problem description: " + ex.getMessage());

            httpStatus = HttpStatus.BAD_REQUEST; // 400
            ErrorJson error = new ErrorJson(((BusinessException) ex).getErrorCode(), ex.getMessage(), request.getRequestURI());
            return new ResponseEntity<>(error, httpStatus);

        } else { // 500 response code

            // logging exception message and a stacktrace
            log.warn("Problem processing request: " + request.getRequestURI(), ex);

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

            ErrorJson error = new ErrorJson(
                    "N/A",
                    ex.getClass().getName() + ":" + ex.getMessage(),
                    request.getRequestURI());
            return new ResponseEntity<>(error, httpStatus);
        }
    }
}
