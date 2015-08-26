package com.yatatsu.sample_implicit_intent_working;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * LandingActivity
 *
 * Created by kitagawatatsuya on 2015/08/27.
 */
public class LandingActivity extends AppCompatActivity {

    private static final String TAG = "LandingActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_landing);
        textView = (TextView) findViewById(R.id.message);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        Log.d(TAG, "-------- intent >> " + getIntent());

        if (getIntent().getData() != null) {
            handleData(getIntent().getData());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent");

        Log.d(TAG, "-------- intent >> " + intent);

        if (intent.getData() != null) {
            handleData(intent.getData());
        }
    }

    private void handleData(Uri uri) {
        Log.d(TAG, "handleData: " + uri.toString());
        String message = uri.getQueryParameter("message");
        textView.setText(message);
    }
}
