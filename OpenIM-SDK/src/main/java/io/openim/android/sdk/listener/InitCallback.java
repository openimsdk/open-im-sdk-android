package io.openim.android.sdk.listener;

import androidx.annotation.NonNull;

/**
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public interface InitCallback {

    void onSucceed();

    void onFailed(@NonNull Throwable throwable);
}
