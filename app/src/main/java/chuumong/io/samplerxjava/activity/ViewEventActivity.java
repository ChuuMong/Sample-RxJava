package chuumong.io.samplerxjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import java.util.Random;

import chuumong.io.samplerxjava.R;

public class ViewEventActivity extends AppCompatActivity {

    private static final String TAG = ViewEventActivity.class.getSimpleName();

    public static Intent start(Context context) {
        return new Intent(context, ViewEventActivity.class);
    }

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text);

        RxView.clicks(button).map(event -> new Random().nextInt()).subscribe(value -> {
            textView.setText("Number : " + value);
        }, throwable -> {
            Log.e(TAG, "error: " + throwable.getMessage());
            throwable.printStackTrace();
        });
    }
}
