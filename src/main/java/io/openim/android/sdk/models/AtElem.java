package io.openim.android.sdk.models;

import java.util.List;

public class AtElem {
    private String text;
    private List<String> atUserList;
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
