package io.openim.android.sdk.manager;

import android.util.ArrayMap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.listener._ConversationListener;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.ConversationReq;
import io.openim.android.sdk.models.NotDisturbInfo;
import io.openim.android.sdk.models.UserInfo;
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
    public void getOneConversation(OnBase<ConversationInfo> base, String sourceId, int sessionType) {
        Open_im_sdk.getOneConversation(BaseImpl.objectBase(base, ConversationInfo.class), ParamsUtil.buildOperationID(), sessionType, sourceId);
    }

    /**
     * 根据会话id获取多个会话
     *
     * @param conversationIDs 会话ID 集合
     * @param base            callback List<{@link ConversationInfo}>
     */
    public void getMultipleConversation(OnBase<List<ConversationInfo>> base, List<String> conversationIDs) {
        Open_im_sdk.getMultipleConversation(BaseImpl.arrayBase(base, ConversationInfo.class), ParamsUtil.buildOperationID(),
            JsonUtil.toString(conversationIDs));
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

    public void hideConversation(OnBase<String> base, String conversationID) {
        Open_im_sdk.hideConversation(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID);
    }


    /**
     * 标记群组会话已读
     *
     * @param groupID 群组ID
     * @param base    callback String
     */
    public void markGroupMessageHasRead(OnBase<String> base, String groupID) {
        Open_im_sdk.markConversationMessageAsRead(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), groupID);
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
    public String getConversationIDBySessionType(String sourceId, int sessionType) {
        return Open_im_sdk.getConversationIDBySessionType(ParamsUtil.buildOperationID(), sourceId, sessionType);
    }

    /**
     * 改变当前输入状态，输入结束时，需要将focus值为false
     * @param base 回调函数，回调值为String
     * @param conversationId 会话Id
     * @param hasFocus 用户是否在输入
     */
    public void changeInputStates(OnBase<String> base, String conversationId, boolean hasFocus) {
        Open_im_sdk.changeInputStates(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationId, hasFocus);
    }

    /**
     * 获取用户输入状态
     * @param base 回调函数，回调值为String
     * @param conversationID 会话Id
     * @param userId 用户Id
     */
    public void getInputStates(OnBase<String> base, String conversationID, String userId) {
        Open_im_sdk.getInputStates(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID, userId);
    }

    /**
     * 设置会话信息
     * @param base 回调信息
     * @param conversationID 会话id
     * @param conversationReq 请求信息
     */
    public void setConversation(OnBase<String> base, String conversationID, ConversationReq conversationReq) {
        Open_im_sdk.setConversation(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversationID, JsonUtil.toStringWithoutNull(conversationReq));
    }

    /***
     * 从本地和服务器删除会话跟历史消息
     * @param conversionID 会话ID
     * */
    public void deleteConversationFromLocalAndSvr(OnBase<String> base, String conversionID) {
        Open_im_sdk.clearConversationAndDeleteAllMsg(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversionID);
    }

    public void deleteConversationAndDeleteAllMsg(OnBase<String> base, String conversionID) {
        Open_im_sdk.deleteConversationAndDeleteAllMsg(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), conversionID);
    }

    /**
     * 查询at所有人标识
     */
    public String getAtAllTag() {
        return Open_im_sdk.getAtAllTag(ParamsUtil.buildOperationID());
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
