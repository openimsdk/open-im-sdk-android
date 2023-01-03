package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.KeyValue;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.ReadReceiptInfo;
import io.openim.android.sdk.models.RevokedInfo;
import io.openim.android.sdk.utils.CommonUtil;
import io.openim.android.sdk.utils.JsonUtil;


final public class _AdvanceMsgListener implements open_im_sdk_callback.OnAdvancedMsgListener {
    private final OnAdvanceMsgListener listener;

    public _AdvanceMsgListener(OnAdvanceMsgListener listener) {
        this.listener = listener;
    }

    @Override
    public void onNewRecvMessageRevoked(String s) {
        if (listener != null) {
            RevokedInfo info = JsonUtil.toObj(s, RevokedInfo.class);
            CommonUtil.runMainThread(() -> listener.onRecvMessageRevokedV2(info));
        }
    }

    @Override
    public void onRecvC2CReadReceipt(String s) {
        if (listener != null) {
            List<ReadReceiptInfo> list = JsonUtil.toArray(s, ReadReceiptInfo.class);
            CommonUtil.runMainThread(() -> listener.onRecvC2CReadReceipt(list));
        }
    }

    @Override
    public void onRecvGroupReadReceipt(String s) {
        if (listener != null) {
            List<ReadReceiptInfo> list = JsonUtil.toArray(s, ReadReceiptInfo.class);
            CommonUtil.runMainThread(() -> listener.onRecvGroupMessageReadReceipt(list));
        }
    }

    @Override
    public void onRecvMessageExtensionsChanged(String s, String s1) {
        if (listener != null) {
            List<KeyValue> list = JsonUtil.toArray(s, KeyValue.class);
            CommonUtil.runMainThread(() -> listener.onRecvMessageExtensionsChanged(s, list));
        }
    }

    @Override
    public void onRecvMessageExtensionsDeleted(String s, String s1) {
        if (listener != null) {
            List<String> list = JsonUtil.toArray(s, String.class);
            CommonUtil.runMainThread(() -> listener.onRecvMessageExtensionsDeleted(s, list));
        }
    }

    @Override
    public void onRecvMessageRevoked(String s) {
        if (listener != null) {
            CommonUtil.runMainThread(() -> listener.onRecvMessageRevoked(s));
        }
    }

    @Override
    public void onRecvNewMessage(String s) {
        Message msg = JsonUtil.toObj(s, Message.class);
        CommonUtil.runMainThread(() -> listener.onRecvNewMessage(msg));
    }
}
