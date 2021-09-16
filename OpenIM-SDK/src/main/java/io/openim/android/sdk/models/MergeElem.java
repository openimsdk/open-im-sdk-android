package io.openim.android.sdk.models;

import java.util.List;

public class MergeElem {
    private String title;
    private List<String> abstractList;
    private List<Message> multiMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAbstractList() {
        return abstractList;
    }

    public void setAbstractList(List<String> abstractList) {
        this.abstractList = abstractList;
    }

    public List<Message> getMultiMessage() {
        return multiMessage;
    }

    public void setMultiMessage(List<Message> multiMessage) {
        this.multiMessage = multiMessage;
    }
}
