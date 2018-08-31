package android.blockchain.hackathon.qrcode;

import android.blockchain.hackathon.R;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;


public class QRCodeGenerateActivity extends AppCompatActivity {

    ImageView QRImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        QRImage = findViewById(R.id.id_img_qrcode);
        Bitmap myBitmap = QRCode.from("afdsfasdfa").withCharset("UTF-8").withSize(700, 700).bitmap();
        QRImage.setImageBitmap(myBitmap);
    }
}
