package io.itsnate.wagchallenge.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import io.itsnate.wagchallenge.R;
import io.itsnate.wagchallenge.model.StackOverflowUser;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.ViewHolder> {
    ArrayList<StackOverflowUser> users;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stackoverflow_user_view, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView userNameView = holder.constraintLayout.findViewById(R.id.user_name);
        TextView bronzeCount = holder.constraintLayout.findViewById(R.id.bronze_count);
        TextView silverCount = holder.constraintLayout.findViewById(R.id.silver_count);
        TextView goldCount = holder.constraintLayout.findViewById(R.id.gold_count);

        StackOverflowUser user = users.get(position);

        userNameView.setText(user.getDisplayName());
        bronzeCount.setText(user.getBadgeCounts().getBronze().toString());
        silverCount.setText(user.getBadgeCounts().getSilver().toString());
        goldCount.setText(user.getBadgeCounts().getGold().toString());
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public UserViewAdapter(ArrayList<StackOverflowUser> users) {
        this.users = users;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout constraintLayout;

        public ViewHolder(RelativeLayout constraintLayout) {
            super(constraintLayout);
            this.constraintLayout = constraintLayout;
        }
    }
}
