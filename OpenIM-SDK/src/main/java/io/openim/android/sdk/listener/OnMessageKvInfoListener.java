package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.MessageKv;

public interface OnMessageKvInfoListener {
    void onMessageKvInfoChanged(List<MessageKv> list);
}
