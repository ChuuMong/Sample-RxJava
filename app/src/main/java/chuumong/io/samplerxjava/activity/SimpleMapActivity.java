package chuumong.io.samplerxjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import chuumong.io.samplerxjava.R;
import rx.Observable;

public class SimpleMapActivity extends AppCompatActivity {

    public static Intent start(Context context) {
        return new Intent(context, SimpleMapActivity.class);
    }

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_map);

        textView = (TextView) findViewById(R.id.text);

        Observable<String> simpleObservable = Observable.just("Hello RxAndroid");
        simpleObservable.map(s -> s.length()).subscribe(integer -> textView.setText(String.format("length : " + integer)));
    }
}
