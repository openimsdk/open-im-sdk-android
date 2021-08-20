package io.openim.android.sdk.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil {
    /*static Gson gson = new Gson();

     *//**
     * 将object对象转成json字符串
     *
     * @param object
     * @return
     *//*
    public static String toString(Object object) {
        try {
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    *//**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param cls
     * @return
     *//*
    public static <T> T toObj(String gsonString, Class<T> cls) {
        try {
            return gson.fromJson(gsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    *//**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     *
     * @param gsonString
     * @param cls
     * @return
     *//*
    public static <T> List<T> toList(String gsonString, Class<T> cls) {
        try {
            return gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    *//**
     * 转成list
     * 解决泛型问题
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     *//*
    public static <T> List<T> toArray(String json, Class<T> cls) {
        try {
            List<T> list = new ArrayList<T>();
            JsonArray array = JsonParser.parseString(json).getAsJsonArray();
            for (final JsonElement elem : array) {
                list.add(gson.fromJson(elem, cls));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    *//**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     *//*
    public static <T> List<Map<String, T>> toListMap(String gsonString) {
        try {
            return gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    */

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     *//*
    public static <T> Map<String, T> toMap(String gsonString) {
        try {
            return gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
    public static String toString(Object o) {
        return JSONObject.toJSONString(o);
    }

    public static <T> T toObj(String text, Class<T> clazz) {
        try {
            return JSONObject.parseObject(text, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toArray(String text, Class<T> clazz) {
        try {
            return JSONObject.parseArray(text, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
