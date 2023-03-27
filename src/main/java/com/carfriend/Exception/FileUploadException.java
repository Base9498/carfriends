package com.carfriend.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadException extends IOException{
    //异常信息
    private String message;

}
