package com.example.demo.dto;

public class ApiResponse {
    private int status;
    private String message;
    private Object data;
    private PageMeta meta;

   
    

   


    public ApiResponse() {
    }


    public ApiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public PageMeta getMeta() {
        return this.meta;
    }

    public void setMeta(PageMeta meta) {
        this.meta = meta;
    }

    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
