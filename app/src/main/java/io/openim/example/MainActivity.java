package io.openim.example;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.OnConnListener;


/**
 * 此项目是纯纯的sdk
 * demo 是另一个地址
 **/
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OpenIMClient.getInstance().initSDK(getApplication(),1, "w323", "321323", null, 1, true,
            "", false, new OnConnListener() {
                @Override
                public void onConnectFailed(long code, String error) {

                }

                @Override
                public void onConnectSuccess() {

                }

                @Override
                public void onConnecting() {

                }

                @Override
                public void onKickedOffline() {

                }

                @Override
                public void onUserTokenExpired() {

                }
            });
    }
}
