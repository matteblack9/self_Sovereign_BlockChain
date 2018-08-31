package android.blockchain.hackathon.register;

import android.blockchain.hackathon.MainBaseActivity;
import android.blockchain.hackathon.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends MainBaseActivity {

    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_register = findViewById(R.id.id_btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, RegisterPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
