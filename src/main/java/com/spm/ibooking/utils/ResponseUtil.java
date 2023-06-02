package com.spm.ibooking.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * response 统一接口
 *
 */
public class ResponseUtil {
    final static String CODE = "code";
    final static String DATA = "data";
    final static String MESSAGE = "message";

    /**
     * response { code + msg }
     * 
     * @param code
     * @param message
     * @return
     */
    public static String response(Integer code, String msg) {
        Map<Object, Object> map = new HashMap<>();
        map.put(CODE, code);
        map.put(MESSAGE, msg);
        return JsonUtil.toJson(map);
    }

    /**
     * response { code + msg }
     * @param responseStatus
     * @return
     */
    public static String response(ResponseStatus responseStatus) {
        Map<Object, Object> map = new HashMap<>();
        map.put(CODE, responseStatus.getCode());
        map.put(MESSAGE, responseStatus.getMsg());
        return JsonUtil.toJson(map);
    }

    /**
     * response { code + msg + data}
     *
     * @param code
     * @param data
     * @param message
     * @return
     */
    public static String responseWithData(String code, String msg, Object data) {
        Map<Object, Object> map = new HashMap<>();
        map.put(CODE, code);
        map.put(MESSAGE, msg);
        map.put(DATA, data);
        return JsonUtil.toJson(map);
    }

    /**
     * response { code + msg + data}
     * 
     * @param responseStatus
     * @param data
     * @return
     */
    public static String responseWithData(ResponseStatus responseStatus, Object data) {
        Map<Object, Object> map = new HashMap<>();
        map.put(CODE, responseStatus.getCode());
        map.put(MESSAGE, responseStatus.getMsg());
        map.put(DATA, data);
        return JsonUtil.toJson(map);
    }
}
