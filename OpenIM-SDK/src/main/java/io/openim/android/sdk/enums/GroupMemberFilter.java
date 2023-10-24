package io.openim.android.sdk.enums;

public enum GroupMemberFilter {
    All(0),
    Owner(1),
    Admin(2),
    Nomal(3),
    AdminAndNomal(4),
    AdminAndOwner(5);

    public final int value;

    GroupMemberFilter(int v) {
        this.value = v;
    }
}
