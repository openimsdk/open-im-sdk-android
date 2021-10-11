package io.openim.android.sdk.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.Message;

/**
 * Open-IM message service interface
 * <p/>
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public interface MessageService {
    /**
     * Send message
     *
     * @param base           callback
     * @param message        message data
     * @param recvUid        receiver uid
     * @param recvGid        receiver group id
     * @param onlineUserOnly whether send to online user only
     */
    void sendMessage(Message message, String recvUid, String recvGid, boolean onlineUserOnly, OnMsgSendCallback base);

    /**
     * Recall message
     *
     * @param message  sent message to recall
     * @param callback callback
     */
    void recallMessage(@NonNull Message message, OnBase<String> callback);

    /**
     * Get history messages.
     *
     * @param userID   user id
     * @param groupID  group id
     * @param startMsg 从startMsg {@link Message}开始拉取消息
     *                 startMsg：如第一次拉取20条记录 startMsg=null && count=20 得到 list；
     *                 下一次拉取消息记录参数：startMsg=list.get(0) && count =20；以此内推，startMsg始终为list的第一条。
     * @param count    一次拉取count条
     * @param base     callback List&lt;{@link Message}&gt;
     */
    void getHistoryMessageList(String userID, String groupID, Message startMsg, int count, OnBase<List<Message>> base);

    /**
     * Add message listener
     * <p/>
     * Called on that:
     * <br/>
     * <ul>message recalled: onRecvMessageRevoked</ul>
     * <ul>message was read: onRecvC2CReadReceipt</ul>
     * <ul>new message received: onRecvNewMessage</ul>
     */
    void addAdvancedMsgListener(@NonNull OnAdvanceMsgListener listener);

    /**
     * Remove message listener if added
     *
     * @param listener listener to remove
     */
    void removeAdvancedMsgListener(@Nullable OnAdvanceMsgListener listener);
}
