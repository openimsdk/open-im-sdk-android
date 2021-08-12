package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.HaveReadInfo;
import io.openim.android.sdk.models.Message;

public interface OnAdvanceMsgListener {
    void onRecvNewMessage(Message msg);

    void onRecvC2CReadReceipt(List<HaveReadInfo> list);

    void onRecvMessageRevoked(String msgId);
}
