package com.example.drinkgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drinkgame.models.Player;

import java.util.ArrayList;

public class NameList extends AppCompatActivity {

    private Button addButton;
    private Button playButton;
    private ArrayList<Player> players = new ArrayList<Player>();
    Typeface typeface;
    Typeface typefaceList;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);

        typeface = Typeface.createFromAsset(getAssets(),"FtyStrategycideNcv-elGl.ttf");
        typefaceList = Typeface.createFromAsset(getAssets(),"LuckiestGuy-Regular.ttf");
        addButton = (Button) findViewById(R.id.addPersonButton);
        addButton.setTypeface(typeface);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setTypeface(typeface);

        editText = (EditText)findViewById(R.id.addPersonName);

        editText.setTypeface(typefaceList);
    }



    public void addPlayer(View view) {

        listView = (ListView)findViewById(R.id.playersList);

        String input = editText.getText().toString();
        Player player = new Player(input);

        if(input==null || input.trim().equals(""))
        {
            Toast.makeText(getBaseContext(),"Input field is empty",Toast.LENGTH_LONG).show();
        }
        else{
            players.add(0,player);
            ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1,players){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    // Cast the list view each item as text view
                    TextView item = (TextView) super.getView(position,convertView,parent);

                    item.setGravity(Gravity.CENTER);
                    // Set the typeface/font for the current item
                    item.setTypeface(typefaceList);

                    // Set the list view item's text color
                    item.setTextColor(Color.parseColor("#821f00"));

                    // Change the item text size
                    item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
                    // return the view
                    return item;
                }
            };

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