package android.blockchain.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends MainBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, FingerPrintAuthActivity.class));
                finish();
            }
        }, 1000);
    }
}
