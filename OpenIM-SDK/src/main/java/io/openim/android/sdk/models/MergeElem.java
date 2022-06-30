package io.openim.android.sdk.models;

import java.util.List;

public class MergeElem {
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private List<String> abstractList;
    /**
     * 具体选择合并的消息列表
     */
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
