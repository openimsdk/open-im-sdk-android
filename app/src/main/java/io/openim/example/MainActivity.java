package io.openim.example;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 此项目是纯纯的sdk
 * demo 是另一个地址
 **/
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) &&
                    Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }
    }
}
