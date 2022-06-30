package io.openim.android.sdk.manager;

import java.util.List;

import io.openim.android.sdk.listener.BaseImpl;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnWorkMomentsListener;
import io.openim.android.sdk.listener._WorkMomentsListener;
import io.openim.android.sdk.models.WorkMomentsInfo;
import io.openim.android.sdk.utils.ParamsUtil;
import open_im_sdk.Open_im_sdk;

/**
 * 工作圈/朋友圈
 */
public class WorkMomentsManager {

    public void setWorkMomentsListener(OnWorkMomentsListener listener) {
        Open_im_sdk.setWorkMomentsListener(new _WorkMomentsListener(listener));
    }

    public void getWorkMomentsUnReadCount(OnBase<String> base) {
        Open_im_sdk.getWorkMomentsUnReadCount(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }

    public void getWorkMomentsNotification(OnBase<List<WorkMomentsInfo>> base, long offset, long count) {
        Open_im_sdk.getWorkMomentsNotification(BaseImpl.arrayBase(base, WorkMomentsInfo.class), ParamsUtil.buildOperationID(), offset, count);
    }

    public void clearWorkMomentsNotification(OnBase<String> base) {
        Open_im_sdk.clearWorkMomentsNotification(BaseImpl.stringBase(base), ParamsUtil.buildOperationID());
    }
}
