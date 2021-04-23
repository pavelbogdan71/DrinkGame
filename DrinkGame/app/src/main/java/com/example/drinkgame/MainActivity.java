package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.drinkgame.models.Provocare;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.playButton);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"FtyStrategycideNcv-elGl.ttf");
        playButton.setTypeface(typeface);
    }


    public void playButtonPressed(View view) throws IOException {
        Intent intent = new Intent(this,NameList.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

}