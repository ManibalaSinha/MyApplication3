package com.manibala.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    InputStream inputStream;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputStream = getResources().openRawResource(R.raw.sample);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                String csvLine;
                while((csvLine=reader.readLine())!= null){
                    data=csvLine.split(",");
                    //Log.e("Data", ""+data[0]);
                    Log.e("Data"," " + data[0]+ " "+ data[1]+ " "+ data[2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



    }

}
