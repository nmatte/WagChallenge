package io.itsnate.wagchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.itsnate.wagchallenge.model.StackOverflowUser;
import io.itsnate.wagchallenge.ui.adapter.UserViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userView;
    private RecyclerView.Adapter userViewAdapter;
    private RecyclerView.LayoutManager userLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userView = findViewById(R.id.user_view);
        userView.setHasFixedSize(true);

        userLayoutManager = new LinearLayoutManager(this);
        userView.setLayoutManager(userLayoutManager);

        ArrayList<StackOverflowUser> users = new ArrayList();
        users.add(new StackOverflowUser(new StackOverflowUser.BadgeCounts(0, 1, 5), "Jim", null));
        users.add(new StackOverflowUser(new StackOverflowUser.BadgeCounts(5, 1, 5), "Bob", null));
        users.add(new StackOverflowUser(new StackOverflowUser.BadgeCounts(10, 1, 7), "JimBob", null));
        userViewAdapter = new UserViewAdapter(users);
        userView.setAdapter(userViewAdapter);
    }
}
