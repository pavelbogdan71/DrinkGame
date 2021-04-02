package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NameList extends AppCompatActivity {

    private Button addButton;
    private ArrayList<String> players = new ArrayList<String>();
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

        if(input==null || input.trim().equals(""))
        {
            Toast.makeText(getBaseContext(),"Input field is empty",Toast.LENGTH_LONG).show();
        }
        else{
            players.add(0,input);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,players);
            listView.setAdapter(adapter);
            ((EditText)findViewById(R.id.addPersonName)).setText("");
        }

    }

    public void playButton(View view){
        Intent intent = new Intent(this,Ruleta.class);

        startActivity(intent);
        overridePendingTransition(0,0);
    }

}