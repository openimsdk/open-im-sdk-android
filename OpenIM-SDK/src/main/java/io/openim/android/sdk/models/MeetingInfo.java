package io.openim.android.sdk.models;

import java.util.List;

public class MeetingInfo {
    private String roomID;
    private String meetingName;
    private String hostUserID;
    private long createTime;
    private long startTime;
    private long endTime;
    private boolean participantCanEnableVideo;
    private boolean onlyHostInviteUser;
    private boolean joinDisableVideo;
    private boolean participantCanUnmuteSelf;
    private boolean isMuteAllMicrophone;
    private List<String> inviteeUserIDList;

    public String getMeetingID() {
        return roomID;
    }

    public void setMeetingID(String roomID) {
        this.roomID = roomID;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getHostUserID() {
        return hostUserID;
    }

    public void setHostUserID(String hostUserID) {
        this.hostUserID = hostUserID;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isParticipantCanEnableVideo() {
        return participantCanEnableVideo;
    }

    public void setParticipantCanEnableVideo(boolean participantCanEnableVideo) {
        this.participantCanEnableVideo = participantCanEnableVideo;
    }

    public boolean isOnlyHostInviteUser() {
        return onlyHostInviteUser;
    }

    public void setOnlyHostInviteUser(boolean onlyHostInviteUser) {
        this.onlyHostInviteUser = onlyHostInviteUser;
    }

    public boolean isJoinDisableVideo() {
        return joinDisableVideo;
    }

    public void setJoinDisableVideo(boolean joinDisableVideo) {
        this.joinDisableVideo = joinDisableVideo;
    }

    public boolean isParticipantCanUnmuteSelf() {
        return participantCanUnmuteSelf;
    }

    public void setParticipantCanUnmuteSelf(boolean participantCanUnmuteSelf) {
        this.participantCanUnmuteSelf = participantCanUnmuteSelf;
    }

    public boolean isMuteAllMicrophone() {
        return isMuteAllMicrophone;
    }

    public void setMuteAllMicrophone(boolean muteAllMicrophone) {
        isMuteAllMicrophone = muteAllMicrophone;
    }

    public List<String> getInviteeUserIDList() {
        return inviteeUserIDList;
    }

    public void setInviteeUserIDList(List<String> inviteeUserIDList) {
        this.inviteeUserIDList = inviteeUserIDList;
    }
}
