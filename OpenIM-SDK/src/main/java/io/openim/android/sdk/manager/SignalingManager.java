package io.openim.android.sdk.manager;

import android.util.ArrayMap;

import java.util.List;
import java.util.Map;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnSignalingListener;
import io.openim.android.sdk.listener._SignalingListener;
import io.openim.android.sdk.models.MeetingInfoList;
import io.openim.android.sdk.models.RoomCallingInfo;
import io.openim.android.sdk.models.SignalingCertificate;
import io.openim.android.sdk.models.SignalingInfo;
import io.openim.android.sdk.utils.JsonUtil;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

public class SignalingManager {

    /**
     * 设置信令监听
     */
    public void setSignalingListener(OnSignalingListener listener) {
        Open_im_sdk.setSignalingListener(new _SignalingListener(listener));
    }

    /**
     * 邀请个人加入音视频
     */
    public void signalingInvite(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingInvite(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 邀请群里某些人加入音视频
     */
    public void signalingInviteInGroup(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingInviteInGroup(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 同意某人音视频邀请
     */
    public void signalingAccept(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingAccept(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 拒绝某人音视频邀请
     */
    public void signalingReject(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingReject(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 邀请者取消音视频通话
     */
    public void signalingCancel(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingCancel(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }

    /**
     * 挂断
     */
    public void signalingHungUp(OnBase<SignalingCertificate> base, SignalingInfo info) {
        Open_im_sdk.signalingHungUp(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(info));
    }


    /**
     * 获取房间通话信息
     */
    public void signalingGetRoomByGroupID(OnBase<RoomCallingInfo> base, String groupID) {
        Open_im_sdk.signalingGetRoomByGroupID(BaseImpl.objectBase(base, RoomCallingInfo.class), ParamsUtil.buildOperationID(), groupID);
    }

    /**
     * 获取进入房间需要的token，url等数据
     */
    public void signalingGetTokenByRoomID(OnBase<SignalingCertificate> base, String roomID) {
        Open_im_sdk.signalingGetTokenByRoomID(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), roomID);
    }

    /**
     * 更新会议室设置
     * 所有配置key:
     * String roomID,
     * String meetingName,
     * String ex,
     * long startTime,
     * long endTime,
     * boolean participantCanUnmuteSelf,
     * boolean participantCanEnableVideo,
     * boolean onlyHostInviteUser,
     * boolean onlyHostShareScreen,
     * boolean joinDisableMicrophone,
     * boolean joinDisableVideo,
     * boolean isMuteAllVideo,
     * boolean isMuteAllMicrophone,
     * List<String> addCanScreenUserIDList,
     * List<String> reduceCanScreenUserIDList,
     * List<String> addDisableMicrophoneUserIDList,
     * List<String> reduceDisableMicrophoneUserIDList,
     * List<String> addDisableVideoUserIDList,
     * List<String> reduceDisableVideoUserIDList,
     * List<String> addPinedUserIDList,
     * List<String> reducePinedUserIDList,
     * List<String> addBeWatchedUserIDList,
     * List<String> reduceBeWatchedUserIDList,
     */
    public void signalingUpdateMeetingInfo(OnBase<String> base, Map<String, Object> configure) {
//        Open_im_sdk.signalingUpdateMeetingInfo(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), JsonUtil.toString(configure));
    }

    /**
     * 创建会议室
     *
     * @param meetingName       会议主题
     * @param meetingHostUserID 会议主持人/发起人
     * @param startTime         开始时间s
     * @param duration          时长s
     * @param inviteeUserIDList 被邀请的人
     * @param ex                其他
     */
    public void signalingCreateMeeting(OnBase<SignalingCertificate> base, String meetingName, String meetingHostUserID, long startTime, long duration, List<String> inviteeUserIDList, String ex) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("meetingName", meetingName);
        map.put("meetingHostUserID", meetingHostUserID);
        map.put("startTime", startTime);
        map.put("meetingDuration", duration);
        map.put("inviteeUserIDList", inviteeUserIDList);
        map.put("ex", ex);
//        Open_im_sdk.signalingCreateMeeting(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 创建会议室
     *
     * @param meetingID           会议ID
     * @param meetingName         会议主题
     * @param participantNickname 参与者临时名
     */
    public void signalingJoinMeeting(OnBase<SignalingCertificate> base, String meetingID, String meetingName, String participantNickname) {
        Map<String, Object> map = new ArrayMap<>();
        map.put("meetingID", meetingID);
        map.put("meetingName", meetingName);
        map.put("participantNickname", participantNickname);
//        Open_im_sdk.signalingJoinMeeting(BaseImpl.objectBase(base, SignalingCertificate.class), ParamsUtil.buildOperationID(), JsonUtil.toString(map));
    }

    /**
     * 主持人对指定的某一个入会人员设置禁言
     *
     * @param roomID     会议ID
     * @param streamType video/audio
     * @param userID     用户ID
     * @param mute       禁言 video或audio，根据streamType
     * @param muteAll    禁言 video和audio
     */
    public void signalingOperateStream(OnBase<String> base, String roomID, String streamType, String userID, boolean mute, boolean muteAll) {
//        Open_im_sdk.signalingOperateStream(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), roomID, streamType, userID, mute, muteAll);
    }

    /**
     * 获取所有的未完成会议
     */
    public void signalingGetMeetings(OnBase<MeetingInfoList> base) {
//        Open_im_sdk.signalingGetMeetings(BaseImpl.objectBase(base, MeetingInfoList.class), ParamsUtil.buildOperationID());
    }

    /**
     * 结束会议
     *
     * @param roomID 房间ID 或 meetingID
     */
    public void signalingCloseRoom(OnBase<MeetingInfoList> base, String roomID) {
//        Open_im_sdk.signalingCloseRoom(BaseImpl.objectBase(base, MeetingInfoList.class), ParamsUtil.buildOperationID(), roomID);
    }

    public void signalingSendCustomSignal(OnBase<String> base, String roomID, String customInfo) {
//        Open_im_sdk.signalingSendCustomSignal(BaseImpl.stringBase(base), ParamsUtil.buildOperationID(), customInfo, roomID);
    }
}
