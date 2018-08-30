package android.blockchain.hackathon;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.multidots.fingerprintauth.AuthErrorCodes;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

public class FingerPrintAuthActivity extends MainBaseActivity implements FingerPrintAuthCallback {

    FingerPrintAuthHelper mFingerPrintAuthHelper;

    ImageView fingerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print_auth);

        fingerImage = findViewById(R.id.id_img_finger);

        mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(this, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFingerPrintAuthHelper.stopAuth();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFingerPrintAuthHelper.startAuth();
    }

    @Override
    public void onNoFingerPrintHardwareFound() {
        //Device does not have finger print scanner.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("경고");
        builder.setMessage("해당 기기에서 지문 인식을 할 수 없습니다\n앱이 종료됩니다");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onNoFingerPrintRegistered() {
        //There are no finger prints registered on this device.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("경고");
        builder.setMessage("해당 기기에 등록된 지문이 없습니다\n기기에 지문을 등록해주세요");
        builder.setNegativeButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onBelowMarshmallow() {
        //Device running below API 23 version of android that does not support finger print authentication.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("경고");
        builder.setMessage("해당 기기의 버전이 너무 낮습니다\n앱이 종료됩니다");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        //Authentication sucessful.
        int colorFrom = ContextCompat.getColor(this, R.color.colorPrimaryDark);
        int colorTo = ContextCompat.getColor(this, R.color.custom_successFingerAuth);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(500);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DrawableCompat.setTint(fingerImage.getDrawable(), (int) valueAnimator.getAnimatedValue());
            }
        });
        colorAnimation.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FingerPrintAuthActivity.this, QRCodeActivity.class));
                finish();
            }
        }, 1000);
    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.viberate_horizontal);
        switch (errorCode) {    //Parse the error code for recoverable/non recoverable error.
            case AuthErrorCodes.CANNOT_RECOGNIZE_ERROR:
                //Cannot recognize the fingerprint scanned.
                fingerImage.startAnimation(animation);
                Toast.makeText(this, "등록되지 않은 지문입니다", Toast.LENGTH_SHORT).show();
                break;
            case AuthErrorCodes.NON_RECOVERABLE_ERROR:
                //This is not recoverable error. Try other options for user authentication. like pin, password.
                fingerImage.startAnimation(animation);
                break;
            case AuthErrorCodes.RECOVERABLE_ERROR:
                //Any recoverable error. Display message to the user.
                fingerImage.startAnimation(animation);
                Toast.makeText(this, "지문 인증에 실패했습니다 다시 한번 시도 해주세요", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
