package io.openim.android.sdk;

import androidx.annotation.NonNull;

import io.openim.android.sdk.util.CollectionUtils;
import io.openim.android.sdk.util.JsonUtil;
import io.openim.android.sdk.util.StringUtils;

/**
 * Open-IM sdk init config
 * <p/>
 * Created by alvince on 2021/9/24
 *
 * @author alvince.zy@gmail.com
 */
public class OpenIMConfig {

    private String hostUrl;
    private String wsHostUrl;
    private String storageDir;

    OpenIMConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public String getHostUrl() {
        return StringUtils.orEmpty(hostUrl);
    }

    @NonNull
    public String getWsHostUrl() {
        return StringUtils.orEmpty(wsHostUrl);
    }

    @NonNull
    public String getStorageDir() {
        return StringUtils.orEmpty(storageDir);
    }

    String toJson() {
        // fastjson is unreliable, should instead with google/gson in android
        return JsonUtil.toString(
            CollectionUtils.simpleMapOf(
                "platform", 2, "ipApi", StringUtils.orEmpty(getHostUrl()), "ipWs", StringUtils.orEmpty(getWsHostUrl()), "dbDir", getStorageDir()
            )
        );
    }

    public static final class Builder {
        private String mHostUrl;
        private String mWsHostUrl;
        private String mStorageDir;

        Builder() {
        }

        public Builder setHostUrl(String url) {
            mHostUrl = url;
            return this;
        }

        public Builder setWsHostUrl(String url) {
            mWsHostUrl = url;
            return this;
        }

        public Builder setStorageDir(String path) {
            mStorageDir = path;
            return this;
        }

        public OpenIMConfig build() {
            OpenIMConfig config = new OpenIMConfig();
            config.hostUrl = StringUtils.orEmpty(mHostUrl);
            config.wsHostUrl = StringUtils.orEmpty(mWsHostUrl);
            config.storageDir = StringUtils.orEmpty(mStorageDir);
            return config;
        }
    }
}
