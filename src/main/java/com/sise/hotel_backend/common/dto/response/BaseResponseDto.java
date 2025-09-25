package com.sise.hotel_backend.common.dto.response;

import java.util.List;

import lombok.Getter;

@Getter
public class BaseResponseDto {
    private final boolean success;
    private final String message;
    private final Object data;
    private final List<String> errors;

    private BaseResponseDto(boolean success, String message, Object data, List<String> errors) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    public static BaseResponseDto success(Object data) {
        return success(data, "Ok");
    }

    public static BaseResponseDto success(Object data, String message) {
        return new BaseResponseDto(true, message, data, null);
    }

    public static BaseResponseDto error(String message) {
        return error(message, null);
    }

    public static BaseResponseDto error(String message, List<String> errors) {
        return new BaseResponseDto(false, message, null, errors);
    }
}
