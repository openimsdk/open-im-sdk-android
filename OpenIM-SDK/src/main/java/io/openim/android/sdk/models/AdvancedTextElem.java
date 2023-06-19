package io.openim.android.sdk.models;

import java.util.List;

public class AdvancedTextElem {
    private String text;
    private List<MessageEntity> messageEntityList;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MessageEntity> getMessageEntityList() {
        return messageEntityList;
    }

    public void setMessageEntityList(List<MessageEntity> messageEntityList) {
        this.messageEntityList = messageEntityList;
    }
}
