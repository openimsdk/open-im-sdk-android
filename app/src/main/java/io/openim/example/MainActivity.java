package io.openim.example;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnConnListener;
import io.openim.android.sdk.listener.OnConversationListener;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.AdvancedMessage;
import io.openim.android.sdk.models.AtUserInfo;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.FileElem;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.KeyValue;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.OfflinePushInfo;
import io.openim.android.sdk.models.PictureInfo;
import io.openim.android.sdk.models.RichMessage;
import io.openim.android.sdk.models.SearchResult;
import io.openim.android.sdk.models.SoundElem;
import io.openim.android.sdk.models.TypeKeySetResult;
import io.openim.android.sdk.models.UserInfo;
import io.openim.android.sdk.models.UsersOnlineStatus;


/**
 * 此项目是纯纯的sdk
 * demo 是另一个地址
 **/
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
