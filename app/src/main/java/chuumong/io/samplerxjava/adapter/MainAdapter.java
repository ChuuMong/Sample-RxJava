package chuumong.io.samplerxjava.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chuumong.io.samplerxjava.R;

/**
 * Created by LeeJongHun on 2016-04-29.
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<String> lists;
    private final ItemClickListener listener;

    public MainAdapter(List<String> lists, ItemClickListener listener) {
        this.lists = lists;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String item = lists.get(position);
        holder.itemView.setOnClickListener(v -> listener.onClickListener(v, position));
        ((MainViewHolder) holder).textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    private static class MainViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public interface ItemClickListener {

        void onClickListener(View view, int position);
    }
}
