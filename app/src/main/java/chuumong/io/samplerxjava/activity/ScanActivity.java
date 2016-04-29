package chuumong.io.samplerxjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import chuumong.io.samplerxjava.R;
import rx.Observable;

public class ScanActivity extends AppCompatActivity {

    public static Intent start(Context context) {
        return new Intent(context, ScanActivity.class);
    }

    private TextView textCount;
    private TextView textNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        textCount = (TextView) findViewById(R.id.text_count);
        textNumber = (TextView) findViewById(R.id.text_number);

        Observable<Integer> minuse = RxView.clicks(findViewById(R.id.btn_minus)).map(event -> -1);
        Observable<Integer> pluse = RxView.clicks(findViewById(R.id.btn_plus)).map(event -> 1);

        Observable<Integer> together = Observable.merge(minuse, pluse);

        together.scan(0, (sum, number) -> sum + 1).subscribe(count -> textCount.setText(count.toString()));
        together.scan(0, (sum, number) -> sum + number).subscribe(number -> textNumber.setText(number.toString()));

    }
}
