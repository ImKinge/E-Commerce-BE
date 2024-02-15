package com.ecommerce.dto;

public class ResponseDto <T> {

    private T response;

    private Boolean success;

    public ResponseDto () {

    }

    public ResponseDto(T response, Boolean success) {
        this.response = response;
        this.success = success;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
