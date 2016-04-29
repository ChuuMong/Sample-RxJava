package chuumong.io.samplerxjava.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import chuumong.io.samplerxjava.R;
import chuumong.io.samplerxjava.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity implements MainAdapter.ItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mainList;
    private MainAdapter adapter;
    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = Arrays.asList(getResources().getStringArray(R.array.list));
        mainList = (RecyclerView) findViewById(R.id.list_main);
        adapter = new MainAdapter(items, this);

        mainList.setLayoutManager(new LinearLayoutManager(this));
        mainList.setAdapter(adapter);

    }

    @Override
    public void onClickListener(View view, int position) {
        Log.d(TAG, "onClickListener: " + position);

        switch (position) {
            case 0:
                startActivity(SimpleObservableActivity.start(this));
                break;
            case 1:
                startActivity(SimpleSubscriberActivity.start(this));
                break;
            case 2:
                startActivity(SimpleMapActivity.start(this));
                break;
            case 3:
                startActivity(ViewEventActivity.start(this));
                break;
            case 4:
                startActivity(MergeWithActivity.start(this));
                break;
            case 5:
                startActivity(ScanActivity.start(this));
        }
    }
}
