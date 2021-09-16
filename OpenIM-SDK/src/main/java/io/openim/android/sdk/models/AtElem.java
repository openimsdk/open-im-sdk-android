package io.openim.android.sdk.models;

import java.util.List;

public class AtElem {
    /**
     * at 消息内容
     */
    private String text;
    /**
     * 被@的用户id集合
     */
    private List<String> atUserList;
    /**
     * 自己是否被@了
     */
    private boolean isAtSelf;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAtUserList() {
        return atUserList;
    }

    public void setAtUserList(List<String> atUserList) {
        this.atUserList = atUserList;
    }

    public boolean isAtSelf() {
        return isAtSelf;
    }

    public void setAtSelf(boolean atSelf) {
        isAtSelf = atSelf;
    }
}
