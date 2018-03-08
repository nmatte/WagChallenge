package io.itsnate.wagchallenge.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import io.itsnate.wagchallenge.R;
import io.itsnate.wagchallenge.model.StackOverflowUser;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.ViewHolder> {
    ArrayList<StackOverflowUser> users;
    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stackoverflow_user_view, parent, false);
        context = parent.getContext();
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView userNameView = holder.constraintLayout.findViewById(R.id.user_name);
        TextView bronzeCount = holder.constraintLayout.findViewById(R.id.bronze_count);
        TextView silverCount = holder.constraintLayout.findViewById(R.id.silver_count);
        TextView goldCount = holder.constraintLayout.findViewById(R.id.gold_count);
        final ProgressBar progressBar = holder.constraintLayout.findViewById(R.id.gravatar_progress);
        ImageView gravatar = holder.constraintLayout.findViewById(R.id.gravatar);
        StackOverflowUser user = users.get(position);

        userNameView.setText(user.getDisplayName());
        bronzeCount.setText(user.getBadgeCounts().getBronze().toString());
        silverCount.setText(user.getBadgeCounts().getSilver().toString());
        goldCount.setText(user.getBadgeCounts().getGold().toString());

        Glide.with(context)
                .load(user.getGravatarUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(gravatar);

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
