//package io.openim.android.sdk.listener;
//
//import androidx.annotation.NonNull;
//
//import io.openim.android.sdk.models.FriendApplicationInfo;
//import io.openim.android.sdk.models.GroupApplicationInfo;
//import io.openim.android.sdk.models.Message;
//import io.openim.android.sdk.utils.CommonUtil;
//import io.openim.android.sdk.utils.JsonUtil;
//
//public class _ListenerForService extends BaseListener<OnListenerForService> implements open_im_sdk_callback.OnListenerForService {
//
//    public _ListenerForService(@NonNull OnListenerForService listener) {
//        super(listener);
//    }
//
//    @Override
//    public void onFriendApplicationAccepted(String s) {
//        FriendApplicationInfo u = JsonUtil.toObj(s, FriendApplicationInfo.class);
//        post(() -> listener.onFriendApplicationAccepted(u));
//    }
//
//    @Override
//    public void onFriendApplicationAdded(String s) {
//        FriendApplicationInfo u = JsonUtil.toObj(s, FriendApplicationInfo.class);
//        post(() -> listener.onFriendApplicationAdded(u));
//    }
//
//    @Override
//    public void onGroupApplicationAccepted(String s) {
//        GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
//        post(() -> listener.onGroupApplicationAccepted(u));
//    }
//
//    @Override
//    public void onGroupApplicationAdded(String s) {
//        GroupApplicationInfo u = JsonUtil.toObj(s, GroupApplicationInfo.class);
//        post(() -> listener.onGroupApplicationAdded(u));
//    }
//
//    @Override
//    public void onRecvNewMessage(String s) {
//        Message msg = JsonUtil.toObj(s, Message.class);
//        post(() -> listener.onRecvNewMessage(msg));
//    }
//}
