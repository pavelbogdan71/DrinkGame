package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.drinkgame.models.Player;

import java.util.ArrayList;

public class NameList extends AppCompatActivity {

    private Button addButton;
    private ArrayList<Player> players = new ArrayList<Player>();
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);
    }

    public void addPlayer(View view) {
        editText = (EditText)findViewById(R.id.addPersonName);
        listView = (ListView)findViewById(R.id.playersList);

        String input = editText.getText().toString();
        Player player = new Player(input);

        if(input==null || input.trim().equals(""))
        {
            Toast.makeText(getBaseContext(),"Input field is empty",Toast.LENGTH_LONG).show();
        }
        else{
            players.add(0,player);
            ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1,players);
            listView.setAdapter(adapter);
            ((EditText)findViewById(R.id.addPersonName)).setText("");
        }

    }

    public void playButton(View view){
        Intent intent = new Intent(this,Ruleta.class);
        intent.putParcelableArrayListExtra("players", players);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

}