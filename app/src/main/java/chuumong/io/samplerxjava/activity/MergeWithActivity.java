package chuumong.io.samplerxjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import chuumong.io.samplerxjava.R;
import rx.Observable;

public class MergeWithActivity extends AppCompatActivity {

    public static Intent start(Context context) {
        return new Intent(context, MergeWithActivity.class);
    }

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_with);

        textView = (TextView) findViewById(R.id.text);

        Observable<String> left = RxView.clicks(findViewById(R.id.btn_left)).map(event -> "left");
        Observable<String> right = RxView.clicks(findViewById(R.id.btn_right)).map(event -> "right");

        Observable<String> together = Observable.merge(left, right);

        together.subscribe(text -> textView.setText(text));

//        together.map(text -> text.toUpperCase()).subscribe(text -> Toast.makeText(this, text, Toast.LENGTH_SHORT).show());
    }
}
