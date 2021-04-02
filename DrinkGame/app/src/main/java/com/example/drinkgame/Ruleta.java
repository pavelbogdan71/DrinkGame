package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.drinkgame.models.Player;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta extends AppCompatActivity {

    TextView stats;
    TextView textView;
    ListView listView;
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

                    listView.getChildAt(players.size()/2).setBackgroundColor(Color.GREEN);

                    if(i < new Random().nextInt(11)+10)
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

                        textView=(TextView)findViewById(R.id.provocare);
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(players.get(players.size()/2).getName() +" bea un shot");
                        players.get(players.size()/2).addShot();

                        handler.removeCallbacks(this);
                    }

                }
                }, 1000);


                listView.setAdapter(adapter);

    }


    public void showStats(View view){

        stats = (TextView)findViewById(R.id.stats);

        Intent intent = getIntent();
        ArrayList<Player> players = intent.getParcelableArrayListExtra("players");

        String statistici="";

        for(Player player : players)
        {
            statistici+=(player.getName()+" a baut "+player.getShots()+" shot-uri\n");
        }

        stats.setText(statistici);
        stats.setVisibility(View.VISIBLE);
    }

}