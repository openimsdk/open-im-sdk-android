package io.openim.android.sdk.manager;

import java.util.List;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;
import open_im_sdk.Open_im_sdk;


/**
 * 会话管理器
 */
public class ConversationManager {
    /**
     * 标记单聊会话为已读
     *
     * @param userID 单聊对象ID
     * @param base   callback String
     */
    public void markSingleMessageHasRead(OnBase<String> base, String userID) {
        Open_im_sdk.markSingleMessageHasRead(BaseImpl.stringBase(base), userID);
    }

    /**
     * 标记群组会话已读
     *
     * @param groupID 群组ID
     * @param base    callback String
     */
    public void markGroupMessageHasRead(OnBase<String> base, String groupID) {
        Open_im_sdk.markGroupMessageHasRead(BaseImpl.stringBase(base), groupID);
    }

    /**
     * 得到消息未读总数
     *
     * @param base String
     */
    public void getTotalUnreadMsgCount(OnBase<String> base) {
        Open_im_sdk.getTotalUnreadMsgCount(BaseImpl.stringBase(base));
    }

    /**
     * 置顶会话
     *
     * @param conversationID 会话ID
     * @param isPinned       true 置顶； false 取消置顶
     * @param base           callback String
     **/
    public void pinConversation(OnBase<String> base, String conversationID, boolean isPinned) {
        Open_im_sdk.pinConversation(conversationID, isPinned, BaseImpl.stringBase(base));
    }

    /**
     * 设置草稿
     *
     * @param conversationID 会话ID
     * @param draft          草稿
     * @param base           callback String
     **/
    public void setConversationDraft(OnBase<String> base, String conversationID, String draft) {
        Open_im_sdk.setConversationDraft(conversationID, draft, BaseImpl.stringBase(base));
    }

    /**
     * 删除草稿
     *
     * @param conversationID 会话ID
     * @param base           callback String
     */

    public void deleteConversation(OnBase<String> base, String conversationID) {
        Open_im_sdk.deleteConversation(conversationID, BaseImpl.stringBase(base));
    }

    /**
     * 根据会话id获取多个会话
     *
     * @param conversationIDs 会话ID 集合
     * @param base            callback List<{@link ConversationInfo}>
     */
    public void getMultipleConversation(OnBase<List<ConversationInfo>> base, List<String> conversationIDs) {
        Open_im_sdk.getMultipleConversation(JsonUtil.toString(conversationIDs), BaseImpl.arrayBase(base, ConversationInfo.class));
    }

    /**
     * 获取单个会话
     *
     * @param sourceId:    聊值：UserId；聊值：GroupId
     * @param sessionType: 单聊：1；群聊：2
     * @param base         callback {@link ConversationInfo}
     */
    public void getOneConversation(OnBase<ConversationInfo> base, String sourceId, long sessionType) {
        Open_im_sdk.getOneConversation(sourceId, sessionType, BaseImpl.objectBase(base, ConversationInfo.class));
    }

    /**
     * 获取会话记录
     *
     * @param base callback List<{@link ConversationInfo}>
     */
    public void getAllConversationList(OnBase<List<ConversationInfo>> base) {
        Open_im_sdk.getAllConversationList(BaseImpl.arrayBase(base, ConversationInfo.class));
    }

    /**
     * 设置会话监听器
     * 如果会话改变，会触发onConversationChanged方法回调
     * 如果新增会话，会触发onNewConversation回调
     * 如果未读消息数改变，会触发onTotalUnreadMessageCountChanged回调
     * <p>
     * 启动app时主动拉取一次会话记录，后续会话改变可以根据监听器回调再刷新数据
     */
    public void setOnConversationListener(OnConversationListener listener) {
        Open_im_sdk.setConversationListener(new open_im_sdk.OnConversationListener() {
            @Override
            public void onConversationChanged(String s) {
                if (null != listener) {
                    List<ConversationInfo> list = JsonUtil.toArray(s, ConversationInfo.class);
                    CommonUtil.runMainThread(() -> listener.onConversationChanged(list));
                }
            }

            @Override
            public void onNewConversation(String s) {
                if (null != listener) {
                    List<ConversationInfo> list = JsonUtil.toArray(s, ConversationInfo.class);
                    CommonUtil.runMainThread(() -> listener.onNewConversation(list));

                }
            }

            @Override
            public void onSyncServerFailed() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onSyncServerFailed);
                }
            }

            @Override
            public void onSyncServerFinish() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onSyncServerFinish);
                }
            }

            @Override
            public void onSyncServerStart() {
                if (null != listener) {
                    CommonUtil.runMainThread(listener::onSyncServerStart);
                }
            }

            @Override
            public void onTotalUnreadMessageCountChanged(int i) {
                if (null != listener) {
                    CommonUtil.runMainThread(() -> listener.onTotalUnreadMessageCountChanged(i));
                }
            }
        });
    }
}
