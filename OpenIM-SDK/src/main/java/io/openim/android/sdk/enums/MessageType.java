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
    /**
     * 自定义表情包
     */
    public static final int CUSTOM_FACE = 115;
    /**
     * 群消息已读回执
     */
    public static final int GROUP_HAS_READ_RECEIPT = 116;
    /**
     * 富文本消息
     */
    public static final int ADVANCED_TEXT = 117;

    /**
     * 2.3.0版本的消息撤回类型，兼容单人撤回，群撤回，新增群主管理员撤回成员信息
     */
//    public static final int ADVANCED_REVOKE = 118;

    public static final int CUSTOM_MSG_NOT_TRIGGER_CONVERSATION = 119;

    public static final int CUSTOM_MSG_ONLINE_ONLY = 120;

    public static final int NTF_BEGIN = 1000;

    public static final int FRIEND_NTF_BEGIN = 1200;
    public static final int FRIEND_APPLICATION_APPROVED_NTF = 1201;
    public static final int FRIEND_APPLICATION_REJECTED_NTF = 1202;
    public static final int FRIEND_APPLICATION_NTF = 1203;
    public static final int FRIEND_ADDED_NTF = 1204;
    public static final int FRIEND_DELETED_NTF = 1205;
    public static final int FRIEND_REMARK_SET_NTF = 1206;
    public static final int BLACK_ADDED_NTF = 1207;
    public static final int BLACK_DELETED_NTF = 1208;
    public static final int FRIEND_NTF_END = 1299;

    public static final int CONVERSATION_CHANGE_NTF = 1300;

    public static final int USER_NTF_BEGIN = 1301;
    public static final int USERINFO_UPDATED_NTF = 1303;
    public static final int USER_NTF_END = 1399;

    public static final int OA_NTF = 1400;

    public static final int GROUP_NTF_BEGIN = 1500;
    public static final int GROUP_CREATED_NTF = 1501;
    public static final int GROUP_INFO_SET_NTF = 1502;
    public static final int JOIN_GROUP_APPLICATION_NTF = 1503;
    public static final int MEMBER_QUIT_NTF = 1504;
    public static final int GROUP_APPLICATION_ACCEPTED_NTF = 1505;
    public static final int GROUP_APPLICATION_REJECTED_NTF = 1506;
    public static final int GROUP_OWNER_TRANSFERRED_NTF = 1507;
    public static final int MEMBER_KICKED_NTF = 1508;
    public static final int MEMBER_INVITED_NTF = 1509;
    public static final int MEMBER_ENTER_NTF = 1510;
    public static final int GROUP_DISBAND_NTF = 1511;
    public static final int GROUP_NTF_END = 1599;

    public static final int GROUP_MEMBER_MUTED_NTF = 1512;
    public static final int GROUP_MEMBER_CANCEL_MUTED_NTF = 1513;
    public static final int GROUP_MUTED_NTF = 1514;
    public static final int GROUP_CANCEL_MUTED_NTF = 1515;
    public static final int GROUP_NOTICE_CHANGED_NTF = 1516;
    public static final int GROUP_MEMBER_INFO_CHANGED_NTF = 1519;
    public static final int GROUP_NAME_CHANGED_NTF = 1520;

    public static final int SIGNALING_NTF_BEGIN = 1600;
    public static final int SIGNALING_NTF = 1601;
    public static final int SIGNALING_NTF_END = 1699;

    public static final int BURN_AFTER_READING_NTF = 1701;

    public static final int NTF_END = 2000;

    /**
     * 3.0版本的消息撤回类型，兼容单人撤回，群撤回，新增群主管理员撤回成员信息
     */
    public static final int REVOKE_MESSAGE_NTF = 2101;
}
