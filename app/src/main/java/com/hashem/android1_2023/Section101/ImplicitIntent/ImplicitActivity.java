package com.hashem.android1_2023.Section101.ImplicitIntent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hashem.android1_2023.R;

public class ImplicitActivity extends AppCompatActivity {
    Button callBt, websiteBt, whatsAppBt, addImageBt;
    ImageView capturedImage;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK){
                       Intent intent = result.getData();
                       Bitmap bm = (Bitmap) intent.getExtras().get("data");
                       capturedImage.setImageBitmap(bm);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit2);

        callBt = findViewById(R.id.callBt);
        websiteBt = findViewById(R.id.websiteBt);
        whatsAppBt = findViewById(R.id.whatsAppBt);
        addImageBt = findViewById(R.id.addImageBt);

        capturedImage = findViewById(R.id.capturedImage);

        callBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = "77467745";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));

                startActivity(intent);


            }
        });

        websiteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://developer.android.com/reference/android/content/Intent";

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                startActivity(intent);

            }
        });
        whatsAppBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whatsAppUrl = "https://wa.me/593098502";

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(whatsAppUrl));
                startActivity(intent);

            }
        });
        addImageBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                launcher.launch(intent);


            }
        });
    }
}