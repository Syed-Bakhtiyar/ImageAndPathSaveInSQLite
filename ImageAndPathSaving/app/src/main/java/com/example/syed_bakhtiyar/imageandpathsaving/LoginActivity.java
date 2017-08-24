package com.example.syed_bakhtiyar.imageandpathsaving;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syed_bakhtiyar.imageandpathsaving.Database.DatabaseHelber;
import com.example.syed_bakhtiyar.imageandpathsaving.ImagesData.MyImages;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {//implements LoaderCallbacks<Cursor> {


    String data;

    ArrayList<MyImages> arrayList;

    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6;

    RadioButton radioButton1, radioButton2;

    private int REQUEST_IMAGE_CAPTURE = 1;

    byte[] image;

    int flow = 0;

    Bitmap imageBitmap;

    Uri uri;

    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;


    int which = 0;

    DatabaseHelber databaseHelber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        arrayList = new ArrayList<>();

        imageButton1 = (ImageButton) findViewById(R.id.img1);

        imageButton2 = (ImageButton) findViewById(R.id.img2);

        imageButton3 = (ImageButton) findViewById(R.id.img3);

        imageButton4 = (ImageButton) findViewById(R.id.img4);

        imageButton5 = (ImageButton) findViewById(R.id.img5);

        imageButton6 = (ImageButton) findViewById(R.id.img6);

        radioButton1 = (RadioButton) findViewById(R.id.for_image);

        radioButton2 = (RadioButton) findViewById(R.id.for_path);

        radioButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                flow = 1;


            }
        });

        radioButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flow = 2;
            }
        });

        mEmailView = (EditText) findViewById(R.id.data);


        imageButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flow != 0)
                            openImage();

            }
        });

        imageButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flow != 0)
                    openImage();

            }
        });

        imageButton3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flow != 0)
                    openImage();

            }
        });

        imageButton4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flow != 0)
                    openImage();

            }
        });

        imageButton5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flow != 0)
                    openImage();

            }
        });

        imageButton6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flow != 0)
                    openImage();

            }
        });

        findViewById(R.id.save).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flow == 0){

                    Toast.makeText(LoginActivity.this, "Please Check any one of the above", Toast.LENGTH_SHORT).show();

                    return;
                }

                Toast.makeText(LoginActivity.this, "ok"+flow, Toast.LENGTH_SHORT).show();


            }
        });

        mLoginFormView = findViewById(R.id.login_form);

    }


    public void openImage(){

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    public void setImage(){

        if(which == 1){


            imageButton1.setImageBitmap(imageBitmap);


        }else if(which == 2) {

            imageButton2.setImageBitmap(imageBitmap);



        }else if(which == 3) {


            imageButton3.setImageBitmap(imageBitmap);


        }else if(which == 4) {

            imageButton4.setImageBitmap(imageBitmap);



        }else if(which == 5) {

            imageButton5.setImageBitmap(imageBitmap);



        }else if(which == 6) {


            imageButton6.setImageBitmap(imageBitmap);


        }


    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {



        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data!=null) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");



            uri = data.getData();

            Log.d("path", "onActivityResult: "+uri);

            setImage();

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            imageBitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);

            String path = MediaStore.Images.Media.insertImage(getContentResolver(),imageBitmap,"Title",null);

            Log.d("path", "onActivityResult: "+path);

            image = stream.toByteArray();

            if(flow == 1){

                arrayList.add(new MyImages(image,null,which));


            }else {

                arrayList.add(new MyImages(null,path.toString(),which));

            }

//            arrayList.add(image,image);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public String getPath(){



        return null;
    }

}
