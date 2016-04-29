package chuumong.io.samplerxjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Arrays;

import chuumong.io.samplerxjava.R;
import rx.Observable;

public class SimpleSubscriberActivity extends AppCompatActivity {

    public static Intent start(Context context) {
        return new Intent(context, SimpleSubscriberActivity.class);
    }

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_subscriber);

        textView = (TextView) findViewById(R.id.text);

        Observable<String> testObservable1 = Observable.just("Hello RxAndroid!!");
        testObservable1.subscribe(s -> textView.setText(s));

        Observable<String> testObservable2 = Observable.from(Arrays.asList("Hello", "Nice")).filter(s -> {
            if (s.equals("Hello")) {
                return false;
            }
            return true;
        });

        testObservable2.subscribe(s -> {
            String tempStr = textView.getText().toString();
            textView.setText(s + " " + tempStr);
        });
    }
}
