package io.openim.android.sdk.enums;

/**
 * 消息类型
 */
public class MessageType {
    /**
     * 文本
     */
    public static final int TEXT = 101;
    /**
     * 图片
     */
    public static final int PICTURE = 102;
    /**
     * 声音
     */
    public static final int VOICE = 103;
    /**
     * 视频
     */
    public static final int VIDEO = 104;
    /**
     * 文件
     */
    public static final int FILE = 105;
    /**
     * _@消息
     */
    public static final int AT_TEXT = 106;
    /**
     * 合并
     */
    public static final int MERGER = 107;
    /**
     * 名片
     */
    public static final int CARD = 108;
    /**
     * 位置
     */
    public static final int LOCATION = 109;
    /**
     * 自定义类型
     */
    public static final int CUSTOM = 110;
    /**
     * 撤回
     */
    public static final int REVOKE = 111;
    /**
     * 已读
     */
    public static final int HAS_READ_RECEIPT = 112;
    /**
     * 正在输入
     */
    public static final int TYPING = 113;
    /**
     * 引用
     */
    public static final int QUOTE = 114;
    ///
    public static final int ACCEPT_FRIEND = 201;
    public static final int ADD_FRIEND = 202;
    public static final int REFUSE_FRIEND_APPLICATION = 203;
    public static final int SET_SELF_INFO = 204;
    public static final int REVOKE_MESSAGE = 205;
    public static final int C2C_MESSAGE_AS_READ = 206;
    public static final int KICK_ONLINE = 303;

    ///
    public static final int TRANSFER_GROUP_OWNER = 501;
    public static final int CREATE_GROUP = 502;

    // static const create_group = 503;
    public static final int JOIN_GROUP = 504;
    public static final int QUIT_GROUP = 505;
    public static final int SET_GROUP_INFO = 506;
    public static final int ACCEPT_GROUP_APPLICATION = 507;
    public static final int REFUSE_GROUP_APPLICATION = 508;
    public static final int KICK_GROUP_MEMBER = 509;
    public static final int INVITED_USER_TO_GROUP = 510;
}
