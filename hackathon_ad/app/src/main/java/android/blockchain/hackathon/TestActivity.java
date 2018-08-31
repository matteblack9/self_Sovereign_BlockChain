package android.blockchain.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;


public class TestActivity extends AppCompatActivity {
    Button button;
    File tempDir;
    private String PASSWORD = "Pa55w0rd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = findViewById(R.id.id_quickstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    quickStart();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void quickStart() throws IOException {

    }
}
