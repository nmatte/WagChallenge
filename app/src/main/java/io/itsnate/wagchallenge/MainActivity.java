package io.itsnate.wagchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.itsnate.wagchallenge.ui.adapter.DemoAdapter;

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

        userViewAdapter = new DemoAdapter(new String[] {"Hello", "Hola", "Ciao", "Guten tag"});
        userView.setAdapter(userViewAdapter);

    }
}
