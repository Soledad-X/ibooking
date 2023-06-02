package com.spm.ibooking.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义响应码
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {
    
    /**
     * SUCCESS
     */
    SUCCESS(1000, "Operation successful"),


    /**
     * FAILED
     */
    FAILED(2000, "operation failed"),
    ENTITY_NOT_FOUND(2001, "The specified entity ID does not exist."),
    DUPLICATE_NAME(2002, "The name field must be unique. Another record with the same name already exists."),
    /**
     * ERROR
     */
    ERROR(3000, "Error");


    private Integer code;
    private String msg;
}
