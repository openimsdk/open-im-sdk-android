package io.openim.android.sdk.enums;

public enum ApplyHandleResult {
    Unprocessed(-1),
    Agree(0),
    Reject(1);
    public final  int value;
    ApplyHandleResult(int v) {
        this.value=v;
    }
}
