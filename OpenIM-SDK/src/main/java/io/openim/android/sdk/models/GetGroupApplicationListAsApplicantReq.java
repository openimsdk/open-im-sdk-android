package io.openim.android.sdk.models;

public class GetGroupApplicationListAsApplicantReq {
    private String[] groupIDs;
    private int[] handleResults;

    public String[] getGroupIDs() {
        return groupIDs;
    }

    public void setGroupIDs(String[] groupIDs) {
        this.groupIDs = groupIDs;
    }

    public int[] getHandleResults() {
        return handleResults;
    }

    public void setHandleResults(int[] handleResults) {
        this.handleResults = handleResults;
    }
}
