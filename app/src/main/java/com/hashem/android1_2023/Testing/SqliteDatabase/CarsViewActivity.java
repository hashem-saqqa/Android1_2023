package com.hashem.android1_2023.Testing.SqliteDatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityCarsViewBinding;

import java.util.ArrayList;

public class CarsViewActivity extends AppCompatActivity {
    ActivityCarsViewBinding binding;
    Bitmap image;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK){
                        image = (Bitmap) result.getData().getExtras().get("data");
                        binding.addImageIv.setImageBitmap(image);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDatabase db = new MyDatabase(this);

        System.out.println("Hi from Ahmed");


        binding.addImageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher.launch(intent);

            }
        });

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = db.insertContact(new Contact("Ahmed", "Ahmed@gmail.com", "059887354352", 2004,image));
                Log.d("databaseTest", "insert: " + result);
//                Contact contact = new Contact("Mohammed", "Mohammed@gmail.com", "7773476435", 2005);
//                contact.setId(1);
//                int count = db.updateContact(contact);
//                Log.d("databaseTest", "update: " + count);
//                int count2 = db.deleteContact(2);
//                Log.d("databaseTest", "delete: " + count2);
//
                ArrayList<Contact> c = db.getAllContacts();
                Log.d("databaseTest", "getData: "+c);
                binding.viewImageIv.setImageBitmap(c.get(c.size()-1).getImage());
            }
        });
    }
}
