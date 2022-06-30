package io.openim.android.sdk.manager;

import java.util.Comparator;
import java.util.List;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.listener._ConversationListener;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.NotDisturbInfo;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;


/**
 * 会话管理器
 */
public class ConversationManager {
    /**
     * 设置会话监听器
     * 如果会话改变，会触发onConversationChanged方法回调
     * 如果新增会话，会触发onNewConversation回调
     * 如果未读消息数改变，会触发onTotalUnreadMessageCountChanged回调
     * <p>
     * 启动app时主动拉取一次会话记录，后续会话改变可以根据监听器回调再刷新数据
     */
    public void setOnConversationListener(OnConversationListener listener) {
        Open_im_sdk.setConversationListener(new _ConversationListener(listener));
    }

    /**
     * 获取会话记录
     *
     * @param base callback List<{@link ConversationInfo}>
     */
    public void getAllConversationList(OnBase<List<ConversationInfo>> base) {
        Open_im_sdk.getAllConversationList(BaseImpl.arrayBase(base, ConversationInfo.class), ParamsUtil.buildOperationID());
    }

    /**
     * 获取会话记录
     *
     * @param base   callback List<{@link ConversationInfo}>
     * @param offset 偏移量，每次开始的index值
     * @param count  数量，每次获取的数量总数
     */
    public void getConversationListSplit(OnBase<List<ConversationInfo>> base, long offset, long count) {
        Open_im_sdk.getConversationListSplit(BaseImpl.arrayBase(base, ConversationInfo.class), ParamsUtil.buildOperationID(), offset, count);
    }

    /**
     * 获取单个会话
     *
     * @param sourceId:    聊值：UserId；聊值：GroupId
     * @param sessionType: 单聊：1；群聊：2
     * @param base         callback {@link ConversationInfo}
     */
    public void getOneConversation(OnBase<ConversationInfo> base, String sourceId, long sessionType) {
        Open_im_sdk.getOneConversation(BaseImpl.objectBase(base, ConversationInfo.class), ParamsUtil.buildOperationID(), sessionType, sourceId);
    }

    /**
     * 根据会话id获取多个会话
     *
     * @param conversationIDs 会话ID 集合
     * @param base            callback List<{@link ConversationInfo}>
     */
    public void getMultipleConversation(OnBase<List<ConversationInfo>> base, List<String> conversationIDs) {
        Open_im_sdk.getMultipleConversation(BaseImpl.arrayBase(base, ConversationInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(conversationIDs));
    }

    /**
     * 删除草稿
     *
     * @param conversationID 会话ID
     * @param base           callback String
     */

    public void deleteConversation(OnBase<String> base, String conversationID) {
        Open_im_sdk.deleteConversation(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID);
    }

    /**
     * 设置草稿
     *
     * @param conversationID 会话ID
     * @param draftText      草稿
     * @param base           callback String
     **/
    public void setConversationDraft(OnBase<String> base, String conversationID, String draftText) {
        Open_im_sdk.setConversationDraft(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID, draftText);
    }

    /**
     * 置顶会话
     *
     * @param conversationID 会话ID
     * @param isPinned       true 置顶； false 取消置顶
     * @param base           callback String
     **/
    public void pinConversation(OnBase<String> base, String conversationID, boolean isPinned) {
        Open_im_sdk.pinConversation(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID, isPinned);
    }

    /**
     * 标记群组会话已读
     *
     * @param groupID 群组ID
     * @param base    callback String
     */
    public void markGroupMessageHasRead(OnBase<String> base, String groupID) {
        Open_im_sdk.markGroupMessageHasRead(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), groupID);
    }

    /**
     * 得到消息未读总数
     *
     * @param base String
     */
    public void getTotalUnreadMsgCount(OnBase<String> base) {
        Open_im_sdk.getTotalUnreadMsgCount(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }


    /**
     * 获取会话id；
     * 在从群列表进入聊天窗口后退群，这时候需要根据此方法获取会话id删除会话。
     *
     * @param sourceId:    聊值：UserId；聊值：GroupId
     * @param sessionType: 单聊：1；群聊：2
     */
    public String getConversationIDBySessionType(String sourceId, long sessionType) {
        return Open_im_sdk.getConversationIDBySessionType(sourceId, sessionType);
    }

    /**
     * 设置会话免打扰状态
     *
     * @param status 1:屏蔽消息; 2:接收消息但不提示; 0:正常
     */
    public void setConversationRecvMessageOpt(OnBase<String> base, List<String> conversationIDs, long status) {
        Open_im_sdk.setConversationRecvMessageOpt(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(conversationIDs), status);
    }

    /**
     * 获取会话免打扰状态
     * 1: Do not receive messages, 2: Do not notify when messages are received; 0: Normal
     * [{"conversationId":"single_13922222222","result":0}]
     */
    public void getConversationRecvMessageOpt(OnBase<List<NotDisturbInfo>> base, List<String> conversationIDs) {
        Open_im_sdk.getConversationRecvMessageOpt(BaseImpl.arrayBase(base, NotDisturbInfo.class), ParamsUtil.buildOperationID(), JsonUtil.toString(conversationIDs));
    }

    /***
     * 设置私聊
     * @param conversionID 会话ID
     * @param isPrivate true开启
     * */
    public void setOneConversationPrivateChat(OnBase<String> base, String conversionID, boolean isPrivate) {
        Open_im_sdk.setOneConversationPrivateChat(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversionID, isPrivate);
    }

    /***
     * 从本地和服务器删除会话跟历史消息
     * @param conversionID 会话ID
     * */
    public void deleteConversationFromLocalAndSvr(OnBase<String> base, String conversionID) {
        Open_im_sdk.deleteConversationFromLocalAndSvr(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversionID);
    }

    /***
     * 从本地删除所有会话
     * */
    public void deleteAllConversationFromLocal(OnBase<String> base) {
        Open_im_sdk.deleteAllConversationFromLocal(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }

    /**
     * 清除@消息标志位
     *
     * @param conversationID 会话ID
     */
    public void resetConversationGroupAtType(OnBase<String> base, String conversationID) {
        Open_im_sdk.resetConversationGroupAtType(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID);
    }

    /**
     * 查询at所有人标识
     */
    public String getAtAllTag() {
        return Open_im_sdk.getAtAllTag();
    }

    /**
     * 全局免打扰
     *
     * @param status 状态 1:屏蔽消息; 2:接收消息但不提示; 0:正常
     */
    public void setGlobalRecvMessageOpt(OnBase<String> base, long status) {
        Open_im_sdk.setGlobalRecvMessageOpt(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), status);
    }


    /**
     * 会话排序比较器
     */
    public Comparator<ConversationInfo> simpleComparator() {
        return (a, b) -> {
            if ((a.isPinned() && b.isPinned()) ||
                (!a.isPinned() && !b.isPinned())) {
                long aCompare = Math.max(a.getDraftTextTime(), a.getLatestMsgSendTime());
                long bCompare = Math.max(b.getDraftTextTime(), b.getLatestMsgSendTime());
                return Long.compare(bCompare, aCompare);
            } else if (a.isPinned() && !b.isPinned()) {
                return -1;
            } else {
                return 1;
            }
        };
    }

}
