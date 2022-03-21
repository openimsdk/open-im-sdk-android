package io.openim.android.sdk.listener;

import java.util.List;

import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.ReadReceiptInfo;
import io.openim.android.sdk.utils.JsonUtil;


final public class _AdvanceMsgListener implements open_im_sdk_callback.OnAdvancedMsgListener {
    private final OnAdvanceMsgListener listener;

    public _AdvanceMsgListener(OnAdvanceMsgListener listener) {
        this.listener = listener;
    }

    @Override
    public void onRecvC2CReadReceipt(String s) {
        if (listener != null) {
            List<ReadReceiptInfo> list = JsonUtil.toArray(s, ReadReceiptInfo.class);
            listener.onRecvC2CReadReceipt(list);
        }
    }

    @Override
    public void onRecvGroupReadReceipt(String s) {
        if (listener != null) {
            List<ReadReceiptInfo> list = JsonUtil.toArray(s, ReadReceiptInfo.class);
            listener.onRecvGroupMessageReadReceipt(list);
        }
    }

    @Override
    public void onRecvMessageRevoked(String s) {
        if (listener != null) {
            listener.onRecvMessageRevoked(s);
        }
    }

    @Override
    public void onRecvNewMessage(String s) {
        Message msg = JsonUtil.toObj(s, Message.class);
        listener.onRecvNewMessage(msg);
    }
}
