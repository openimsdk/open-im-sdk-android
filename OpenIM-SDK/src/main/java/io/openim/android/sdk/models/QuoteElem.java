package io.openim.android.sdk.models;

public class QuoteElem {
    /**
     * 回复内容
     */
    private String text;
    /**
     * 被回复的消息
     */
    private Message quoteMessage;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message getQuoteMessage() {
        return quoteMessage;
    }

    public void setQuoteMessage(Message quoteMessage) {
        this.quoteMessage = quoteMessage;
    }
}
