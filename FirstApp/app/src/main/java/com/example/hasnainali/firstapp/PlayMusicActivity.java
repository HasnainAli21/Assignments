package com.example.hasnainali.firstapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PlayMusicActivity extends AppCompatActivity {

    ListView LV;
    List<String> list;
    ListAdapter adapter;
    MediaPlayer MP;
    Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        play = (Button) findViewById(R.id.btnPlay);
        LV = (ListView) findViewById(R.id.ListMusic);
        list = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for(int i=0 ; i<fields.length ; i++)
        {
            list.add(fields[i].getName());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        LV.setAdapter(adapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(MP != null)
                {
                    MP.release();
                }
                int resID = getResources().getIdentifier(list.get(i),"raw",getPackageName());
                MP = MediaPlayer.create(PlayMusicActivity.this,resID);
                MP.start();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MP.isPlaying())
                {
                    MP.pause();
                    play.setText("Play");
                }
                else
                {
                        MP.start();
                        play.setText("Pause");

                }
            }
        });
    }
    @Override

    protected void onStop()
    {
        super.onStop();
        MP.stop();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        MP.stop();
    }
}
