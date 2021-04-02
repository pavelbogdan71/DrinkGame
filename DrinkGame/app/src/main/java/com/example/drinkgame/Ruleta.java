package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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


    public void spinWheel(View view) throws InterruptedException {
            Intent intent = getIntent();
            ArrayList<Player> players = intent.getParcelableArrayListExtra("players");
            ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1,players);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                int i=0;
                @Override
                public void run() {
                    if(i <10)
                    {
                        Player firstPlayer = players.get(0);
                        adapter.remove(firstPlayer);
                        adapter.add(firstPlayer);
                        players.remove(firstPlayer);
                        players.add(firstPlayer);

                        adapter.notifyDataSetChanged();
                        handler.postDelayed(this, 100);

                        i++;
                    }else{
                        handler.removeCallbacks(this);
                    }

                }
                }, 1000);

                listView.setAdapter(adapter);




    }


}