package gr.opensourceuom.presentation.advice;

import gr.opensourceuom.presentation.course.CourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalRestAdvice {

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> courseNotFoundHandler(CourseNotFoundException e) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("error", "Course Not Found");
        errorMap.put("code", String.valueOf(HttpStatus.NOT_FOUND));

        return errorMap;
    }

}
