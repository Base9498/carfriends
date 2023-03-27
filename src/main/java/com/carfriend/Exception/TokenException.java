package com.carfriend.Exception;

import lombok.Data;

@Data
public class TokenException extends Exception{
    private String message;
}
