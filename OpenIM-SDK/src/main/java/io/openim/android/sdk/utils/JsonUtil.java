package io.openim.android.sdk.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static final Gson gson = new Gson();

    /**
     * 将object对象转成json字符串
     */
    public static String toString(Object object) {
        String gsonString = "";
        try {
            if (null != object) {
                gsonString = gson.toJson(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gsonString;
    }


    /**
     * 将gsonString转成泛型bean
     */
    public static <T> T toObj(String gsonString, Class<T> cls) {
        T t = null;
        try {
            if (null != gsonString) {
                t = gson.fromJson(gsonString, cls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


    /**
     * 转成list
     * 泛型在编译期类型被擦除导致报错
     * @param gsonString
     * @param cls
     * @return
     */
//    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
//        List<T> list = null;
//        if (gson != null) {
//            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
//            }.getType());
//        }
//        return list;
//    }

    /**
     * 转成list
     * 解决泛型在编译期类型被擦除导致报错
     */
    public static <T> List<T> toArray(String json, Class<T> cls) {
        List<T> list = null;
        try {
            if (null != json) {
                list = new ArrayList<T>();
                JsonArray array = JsonParser.parseString(json).getAsJsonArray();
                for (final JsonElement elem : array) {
                    list.add(gson.fromJson(elem, cls));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 转成list中有map的
     */
    public static <T> List<Map<String, T>> toListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (null != gsonString) {
            list = gson.fromJson(gsonString,
                new TypeToken<List<Map<String, T>>>() {
                }.getType());
        }
        return list;
    }


    /**
     * 转成map的
     */
    public static <T> Map<String, T> toMaps(String gsonString) {
        Map<String, T> map = null;
        if (null != gsonString) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
