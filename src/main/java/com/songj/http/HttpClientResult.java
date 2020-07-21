package com.songj.http;

import java.io.Serializable;

/**
 * @ClassName: HttpClientResult
 * @Description: 封装httpClient响应结果
 * @Author: Scott S
 * @Date: 2019/6/27 10:01
 * @Version: 1.0
 **/
public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HttpClientResult(int code) {
        this.code = code;
        this.content = "";
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }
}