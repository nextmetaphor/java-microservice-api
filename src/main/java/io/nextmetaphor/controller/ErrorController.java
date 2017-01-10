package io.nextmetaphor.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public void handleConflict(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        // Hide the message for any @ResponseStatus annotations - Tomcat shows it otherwise
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            response.setStatus(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class).value().value());
        }
    }
}
