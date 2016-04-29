package chuumong.io.samplerxjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import chuumong.io.samplerxjava.R;
import rx.Observable;
import rx.Subscriber;

public class SimpleObservableActivity extends AppCompatActivity {

    private static final String TAG = SimpleObservableActivity.class.getSimpleName();

    private TextView textView;

    public static Intent start(Context context) {
        return new Intent(context, SimpleObservableActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_observable);
        textView = (TextView) findViewById(R.id.text);

        final long startTime = System.currentTimeMillis();

        Observable<String> simpleObservable = Observable.create(subscriber -> {
            subscriber.onNext("Hello RxAndroid!!");
            subscriber.onCompleted();
        });

        simpleObservable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + (int) (System.currentTimeMillis() - startTime) + "ms");
                textView.setText(s);
            }
        });
    }
}
