package com.yitiankeji.response;

import lombok.Data;

@Data
public final class ResponseData {

    private boolean error;
    private int code = -1;
    private String message;
    private Object data;

    public static ResponseData success() {
        return new ResponseData();
    }

    public static ResponseData success(String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData success(String message) {
        return success(message, null);
    }

    public static ResponseData success(Object data) {
        return success(null, data);
    }


    public static ResponseData error(int code, String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setError(true);
        responseData.setCode(code);
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData error(int code, String message) {
        return error(code, message, null);
    }

    public static ResponseData error(int code, Object data) {
        return error(code, null, data);
    }
}
