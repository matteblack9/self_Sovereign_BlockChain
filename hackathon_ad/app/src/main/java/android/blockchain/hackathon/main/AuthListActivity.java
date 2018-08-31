package android.blockchain.hackathon.main;

import android.blockchain.hackathon.R;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class AuthListActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    AuthRecyclerViewAdapter authRecyclerViewAdapter;
    ArrayList<AuthRecyclerViewItem> items = new ArrayList<>();

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_list);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        toolbar = findViewById(R.id.toolbar);

        collapsingToolbarLayout.setTitle("이름");
        this.setSupportActionBar(toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.custom_none));
        recyclerView = findViewById(R.id.id_recyclerview_main);

        AuthRecyclerViewItem item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);
        item = new AuthRecyclerViewItem("dfdfd", "이름이름", "내용내용");
        items.add(item);

        authRecyclerViewAdapter = new AuthRecyclerViewAdapter(this, items);
        recyclerView.setAdapter(authRecyclerViewAdapter);
        authRecyclerViewAdapter.notifyDataSetChanged();
    }
}
