package com.example.bearch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class musicanDetail extends AppCompatActivity {

    String province;
    String genre;
    String band;
    String instrument;
    String location;
    String email;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musican_detail);
        getWindow().setBackgroundDrawableResource(R.drawable.brushed2);

//        get extras from intent
        Intent intent = getIntent();
        String musican = intent.getStringExtra("musican");

//        define textViews
        TextView Email = findViewById(R.id.email);
        TextView Name = findViewById(R.id.name);
        TextView Location = findViewById(R.id.city);
        TextView Province = findViewById(R.id.province);
        TextView Genre = findViewById(R.id.genre);
        TextView Instrument = findViewById(R.id.instrument);

//        make Jobject from extras of the intent
        try{
            JSONObject Jobject = new JSONObject(musican);

            name = Jobject.getString("name");
            email = Jobject.getString("email");
            location = Jobject.getString("location");
            band = Jobject.getString("band");
            instrument = Jobject.getString("instrument");
            genre = Jobject.getString("genre");
            province = Jobject.getString("province");

        }catch(Exception e){
            e.printStackTrace();
        }

//        set values in the image and text views
        new getUserImage().execute(email);
        Name.setText(name);
        Location.setText(location);
        Genre.setText(genre);
        Instrument.setText(instrument);
        Email.setText(email);
        Province.setText(province);
    }

//    function for calling the api for the user image from the database
    public class getUserImage extends AsyncTask<String, Void, String> {

        Bitmap bitmap;
        String result;

//        if request is finished
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ImageView imageView = findViewById(R.id.imageView4);

//            check if user there is a correct picture in preferences
            if (!result.equals("null") && !result.equals(" ")) {
                try {
                    byte[] encodeByte = Base64.decode(result, Base64.DEFAULT);
                    bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

//        function that make request to api for image of user
        @Override
        protected String doInBackground(String... strings) {
            String Email = strings[0];

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS).build();

            String url_band = "http://10.0.2.2/api/read_user_image.php" + "?user_id="
                    + Email;
            Request request = new Request.Builder()
                    .url(url_band)
                    .build();

            Response response = null;

            try{
                response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()) {
                    result = response.body().string();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
