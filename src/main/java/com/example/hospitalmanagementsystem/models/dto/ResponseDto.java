package com.example.hospitalmanagementsystem.models.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseDto<T> {
    String message;
    String key;
   HttpStatus httpStatus;
   T data;

    public ResponseDto(String message, String key, HttpStatus httpStatus, T data) {
        this.message = message;
        this.key = key;
        this.httpStatus = httpStatus;
        this.data = data;

    }
public static ResponseDto<Void> success(){
        return new ResponseDto("Successfully","success",HttpStatus.OK,null);

}
public static <T>ResponseDto success(T data){
        return new ResponseDto("Successfully","success",HttpStatus.OK,data);
}

}
