package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.C2CReadReceiptInfo;
import io.openim.android.sdk.models.GroupMessageReceipt;
import io.openim.android.sdk.models.KeyValue;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.RevokedInfo;

/**
 * 消息监听
 */
public interface OnAdvanceMsgListener {
    /**
     * 收到新消息
     * 需要添加到列表，然后刷新界面
     */
   default void onRecvNewMessage(Message msg){}

    /**
     * 对方已阅读消息回执
     * 需更新界面已读状态
     */
    default void onRecvC2CReadReceipt(List<C2CReadReceiptInfo> list){}

    /**
     * 群成员已阅读消息回执
     * 需更新界面已读状态
     */
    default void onRecvGroupMessageReadReceipt(GroupMessageReceipt groupMessageReceipt){}

    /**
     * 对方撤回了消息
     * 单聊撤回，群聊测回以及群组管理员撤回其他人消息
     * 新版本只会通过此回调回传被撤回的详细信息，不会触发onRecvNewMessage回调
     */
    default void onRecvMessageRevokedV2(RevokedInfo info){}

    default void onRecvMessageExtensionsChanged(String msgID, List<KeyValue> list){}

    default void onRecvMessageExtensionsDeleted(String msgID, List<String> list){}

    default void onRecvMessageExtensionsAdded(String msgID, List<KeyValue> list){}

    /**
     *  消息被删除
     * @param message
     */
    default void onMsgDeleted(Message message){}

    default void onRecvOfflineNewMessage(List<Message> msg){}
}
