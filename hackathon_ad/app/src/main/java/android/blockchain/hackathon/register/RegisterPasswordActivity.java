package android.blockchain.hackathon.register;

import android.blockchain.hackathon.R;
import android.blockchain.hackathon.main.MainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegisterPasswordActivity extends AppCompatActivity {
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);

        btn_register = findViewById(R.id.id_btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterPasswordActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
