package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.MessageKv;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;

final public class _MessageKvInfoListener implements open_im_sdk_callback.OnMessageKvInfoListener {
    private final OnMessageKvInfoListener listener;

    public _MessageKvInfoListener(OnMessageKvInfoListener listener) {
        this.listener = listener;
    }

    @Override
    public void onMessageKvInfoChanged(String s) {
        if (listener != null) {
            List<MessageKv> list = JsonUtil.toArray(s, MessageKv.class);
            CommonUtil.runMainThread(() -> listener.onMessageKvInfoChanged(list));
        }
    }
}
