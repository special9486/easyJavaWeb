package com.example.servingwebcontent.commons.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
public class EasyMap {
    private Map<String, Object> map = new HashMap<>();

    public static EasyMap createInstance() {
        return new EasyMap();
    }

    public void put(final String key, final Object value) {
        map.put(key, value);
    }

    public void putAll(final Map<String, Object> data) {
        map.putAll(data);
    }

    public Object get(final String key) {
        return map.get(key);
    }

    public String getString(final String key) {
        final Object value = get(key);
        return value == null ? null : value.toString();
    }

    public Integer getInteger(final String key) {
        final String value = getString(key);
        return value == null ? null : Integer.parseInt(value);
    }

    public Long getLong(final String key) {
        final String value = getString(key);
        return value == null ? null : Long.parseLong(value);
    }

    @SuppressWarnings("unchecked")
    public EasyMap getEasyMap(final String key) {
        final Object value = get(key);
        if (value instanceof EasyMap) {
            return (EasyMap)value;
        } else if (value instanceof Map) {
            final EasyMap easyMap = EasyMap.createInstance();
            easyMap.putAll((Map<String, Object>)value);
            return easyMap;
        } else {
            return null;
        }
    }

    public Map<String, Object> toMap() {
        return map;
    }

}
