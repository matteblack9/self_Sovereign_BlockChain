package android.blockchain.hackathon.authDetail;

import android.blockchain.hackathon.R;
import android.blockchain.hackathon.main.AuthRecyclerViewItem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AuthDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_detail);

        Intent get_intent = getIntent();
        AuthRecyclerViewItem item = (AuthRecyclerViewItem) get_intent.getSerializableExtra("item");

    }
}
