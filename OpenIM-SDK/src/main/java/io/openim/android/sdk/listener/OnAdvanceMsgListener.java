package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.ReadReceiptInfo;
import io.openim.android.sdk.models.Message;

/**
 * 消息监听
 */
public interface OnAdvanceMsgListener {
    /**
     * 收到新消息
     * 需要添加到列表，然后刷新界面
     */
    void onRecvNewMessage(Message msg);

    /**
     * 对方已阅读消息回执
     * 需更新界面已读状态
     */
    void onRecvC2CReadReceipt(List<ReadReceiptInfo> list);

    /**
     * 对方撤回了消息
     * 需要将消息类型更改为MessageType.REVOKE，然后刷新界面
     */
    void onRecvMessageRevoked(String msgId);
}
