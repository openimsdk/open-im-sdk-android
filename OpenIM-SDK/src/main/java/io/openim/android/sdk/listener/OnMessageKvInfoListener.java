package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.MessageKv;

public interface OnMessageKvInfoListener {
    default void onMessageKvInfoChanged(List<MessageKv> list){}
}
