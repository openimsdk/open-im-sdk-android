package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.utils.CommonUtil;
import open_im_sdk_callback.Base;

final public class BaseImpl {

    public static Base stringBase(OnBase<String> base) {
        return new StringBase(base);
    }

    public static <T> Base arrayBase(OnBase<List<T>> base, Class<T> clazz) {
        return new ArrayBase<T>(base, clazz);
    }

    public static <T> Base objectBase(OnBase<T> base, Class<T> clazz) {
        return new ObjectBase<>(base, clazz);
    }

    private static class ArrayBase<T> implements Base {
        OnBase<List<T>> base;
        Class<T> clazz;

        public ArrayBase(OnBase<List<T>> base, Class<T> clazz) {
            this.base = base;
            this.clazz = clazz;
        }

        @Override
        public void onError(int l, String s) {
            CommonUtil.returnError(base, l, s);

        }

        @Override
        public void onSuccess(String s) {
            CommonUtil.returnList(base, clazz, s);
        }
    }

    private static class ObjectBase<T> implements  Base {
        OnBase<T> base;
        Class<T> clazz;

        public ObjectBase(OnBase<T> base, Class<T> clazz) {
            this.base = base;
            this.clazz = clazz;
        }

        @Override
        public void onError(int l, String s) {
            CommonUtil.returnError(base, l, s);

        }

        @Override
        public void onSuccess(String s) {
            CommonUtil.returnObject(base, clazz, s);
        }
    }

    private static class StringBase implements  Base {
        OnBase<String> base;


        public StringBase(OnBase<String> base) {
            this.base = base;
        }

        @Override
        public void onError(int l, String s) {
            CommonUtil.returnError(base, l, s);

        }

        @Override
        public void onSuccess(String s) {
            CommonUtil.returnSuccess(base, s);
        }
    }
}
