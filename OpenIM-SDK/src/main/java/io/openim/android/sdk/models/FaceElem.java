package io.openim.android.sdk.models;

/**
 * 表情
 */
public class FaceElem {
    /**
     * app内嵌表情包，根据index 匹配显示表情图
     * */
    private int index;
    /**
     * 其他表情，如url表情，直接加载url即可
     * */
    private String data;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
