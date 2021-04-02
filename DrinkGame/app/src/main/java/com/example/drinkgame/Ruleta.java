package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.drinkgame.models.Player;

import java.util.ArrayList;
import java.util.List;

public class Ruleta extends AppCompatActivity {

    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);

        Intent intent = getIntent();
        ArrayList<Player> players = intent.getParcelableArrayListExtra("players");

        listView = (ListView)findViewById(R.id.playersList);
        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1,players);
        listView.setAdapter(adapter);
    }

}