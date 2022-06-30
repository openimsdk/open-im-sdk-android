package io.openim.android.sdk.enums;

/**
 * 进群验证方式
 */
public class GroupVerification {
    /**
     * 申请需要同意 邀请直接进
     */
    static final int APPLY_NEED_VERIFICATION_INVITE_DIRECTLY = 0;

    /**
     * 所有人进群需要验证，除了群主管理员邀
     */
    static final int ALL_NEED_VERIFICATION = 1;

    /**
     * 直接进群
     */
    static final int DIRECTLY = 2;
}
