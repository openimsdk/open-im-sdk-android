package io.openim.android.sdk.enums;

public enum ViewType {

    History(0), Search(1);

    private final int value;

    private ViewType(int v) {
        this.value = v;
    }
    public int getValue() {
        return value;
    }
}
