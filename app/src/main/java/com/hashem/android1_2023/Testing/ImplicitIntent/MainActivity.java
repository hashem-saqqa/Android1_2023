package com.hashem.android1_2023.Testing.ImplicitIntent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hashem.android1_2023.R;

public class MainActivity extends AppCompatActivity {
    Button callBt,webSiteBt,whatsAppBt,addImageBt;
    ImageView selectedImage;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
//                        Intent i = result.getData();
//                        Uri b= (Uri) result.getData().getData();
//                        selectedImage.setImageURI(b);

                        Intent i = result.getData();
                        Bitmap bm = (Bitmap) result.getData().getExtras().get("data");
                        selectedImage.setImageBitmap(bm);

                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        callBt = findViewById(R.id.callBt);
        webSiteBt = findViewById(R.id.websiteBt);
        whatsAppBt = findViewById(R.id.openWhatsBt);
        addImageBt = findViewById(R.id.AddImageBt);
        selectedImage  = findViewById(R.id.selectedImage);

        callBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "592989725";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        webSiteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= "https://www.geeksforgeeks.org/implicit-and-explicit-intents-in-android-with-examples/";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        whatsAppBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url= "https://wa.me/972592989725";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
            }
        });
        addImageBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher.launch(intent);

//                Intent i = new Intent();
//                i.setType("image/*");
//                i.setAction(Intent.ACTION_GET_CONTENT);

//                Intent gallery = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//                launcher.launch(gallery);

            }
        });
    }

}