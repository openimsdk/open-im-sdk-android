package io.openim.android.sdk.enums;

public enum JoinSource {
    Invitation(2), Search(3), QrCode(4);

    public final int value;

    JoinSource(int v) {
        this.value = v;
    }
}
