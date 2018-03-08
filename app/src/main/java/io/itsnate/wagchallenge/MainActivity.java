package io.itsnate.wagchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.itsnate.wagchallenge.model.StackOverflowUserFactory;
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

        fetchUsers();
    }

    private void fetchUsers() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.stackexchange.com/2.2/users?site=stackoverflow";

        JsonObjectRequest userRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        userViewAdapter = new UserViewAdapter(StackOverflowUserFactory.fromJson(response));
                        userView.setAdapter(userViewAdapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.getLogger("Json Request").log(Level.INFO, "Request error: " + error.getMessage());
                    }
                });

        queue.add(userRequest);
    }
}
