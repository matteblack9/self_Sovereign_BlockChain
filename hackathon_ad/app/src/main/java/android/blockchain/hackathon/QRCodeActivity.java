package android.blockchain.hackathon;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.zxing.EncodeHintType;

import net.glxn.qrgen.android.QRCode;


public class QRCodeActivity extends AppCompatActivity {

    ImageView QRImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        QRImage = findViewById(R.id.id_img_qrcode);
        Bitmap myBitmap = QRCode.from("afdsfasdfa").withHint(EncodeHintType.CHARACTER_SET, "UTF-8").withSize(700, 700).bitmap();
        QRImage.setImageBitmap(myBitmap);
    }
}
