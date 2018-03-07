package io.itsnate.wagchallenge.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.itsnate.wagchallenge.R;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    String[] data;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.demo_text_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(this.data[position]);
    }

    @Override
    public int getItemCount() {
        return this.data.length;
    }

    public DemoAdapter(String[] data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }
}
