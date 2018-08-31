package android.blockchain.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import foundation.icon.icx.IconService;
import foundation.icon.icx.transport.http.HttpProvider;

public class TestActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = findViewById(R.id.id_quickstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quickStart();
            }
        });
    }

    private void quickStart() {
        IconService iconService = new IconService(new HttpProvider("https://13.125.227.83/api/ver3"));

// Gets a block matching the block height.
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
