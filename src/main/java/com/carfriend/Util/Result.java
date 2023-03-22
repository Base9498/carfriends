package com.carfriend.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /***
     * 响应码
     */
    private int code;
    /***
     * 结果数据
     */
    private Object data;
    /***
     * 响应信息
     */
    private String message;

    /***
     * 无响应信息
     * @param code 响应码
     * @param data 响应数据
     */
    public Result(int code,Object data){
        this.code=code;
        this.data=data;
    }

    /***
     * 无响应数据
     * @param code 响应码
     * @param message 响应信息
     */
    public Result(int code,String message){
        this.code=code;
        this.message=message;
    }
}
