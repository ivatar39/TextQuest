package com.example.ivan.textquest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class GameActivity extends AppCompatActivity {

    private TextView    textEncounter;
    private ImageView   imageView;

    private Button      option1;
    private Button      option2;
    private Button      option3;
    private Button      option4;


    private static ArrayList<Encounter> encounters;
    private static ArrayList<Option> options;
    private static Encounter encounter;
    public static int step = 0;

    private void fetchEncounters() {
        step = 0;
        encounters = new ArrayList<Encounter>();



        options = new ArrayList<Option>();
        options.add(new Option("вперёд",1));
        options.add(new Option("вперёд",2));
        options.add(new Option("вперёд",3));
        encounter = new Encounter("Вы вошли в бар, и подсушали разговор о сокровищах зарытых на острове.\n" + "У незнакомцев была карта", BitmapFactory.decodeResource(getResources(), R.drawable.treasure_map),  options);
        encounters.add(encounter);

        options = new ArrayList<Option>();
        options.add(new Option("вперёд",1));
        options.add(new Option("вперёд",2));
        options.add(new Option("вперёд",3));
        encounter = new Encounter("Вы вошли в бар, и подсушали разговор о сокровищах зарытых на острове.\n" + "У незнакомцев была карта", BitmapFactory.decodeResource(getResources(), R.drawable.niger),  options);
        encounters.add(encounter);

        options = new ArrayList<Option>();
        options.add(new Option("вперёд",1));
        options.add(new Option("вперёд",2));
        options.add(new Option("вперёд",3));
        encounter = new Encounter("Вы вошли в бар, и подсушали разговор о сокровищах зарытых на острове.\n" + "У незнакомцев была карта", BitmapFactory.decodeResource(getResources(), R.drawable.nigers),  options);
        encounters.add(encounter);

        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        textEncounter = (TextView) (findViewById(R.id.tv_field_text));
        imageView = (ImageView) (findViewById(R.id.iv_image));

        option1 = (Button) (findViewById(R.id.bt_option1));
        option2 = (Button) (findViewById(R.id.bt_option2));
        option3 = (Button) (findViewById(R.id.bt_option3));
        option4 = (Button) (findViewById(R.id.bt_option4));

        fetchEncounters();
        newEncounter();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEncounter(1);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEncounter(2);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEncounter(3);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEncounter(4);
            }
        });
    }

    private void newEncounter() {

        Encounter encounter = encounters.get(step);
        textEncounter.setText(encounter.getTextEncounter());
        imageView.setImageBitmap(encounter.getImageEncounter());

        switch (encounter.optionsEncounter.size()) {
            case 1:
                option1.setText(String.valueOf(encounter.optionsEncounter.get(0).textOption));
                option2.setVisibility(View.GONE);
                option3.setVisibility(View.GONE);
                option4.setVisibility(View.GONE);
                break;
            case 2:
                option1.setText(String.valueOf(encounter.optionsEncounter.get(0).textOption));
                option2.setText(String.valueOf(encounter.optionsEncounter.get(1).textOption));
                option3.setVisibility(View.GONE);
                option4.setVisibility(View.GONE);
                break;
            case 3:
                option1.setText(String.valueOf(encounter.optionsEncounter.get(0).textOption));
                option2.setText(String.valueOf(encounter.optionsEncounter.get(1).textOption));
                option3.setText(String.valueOf(encounter.optionsEncounter.get(2).textOption));
                option4.setVisibility(View.GONE);
                break;
            case 4:
                option1.setText(String.valueOf(encounter.optionsEncounter.get(0).textOption));
                option2.setText(String.valueOf(encounter.optionsEncounter.get(1).textOption));
                option3.setText(String.valueOf(encounter.optionsEncounter.get(2).textOption));
                option4.setText(String.valueOf(encounter.optionsEncounter.get(3).textOption));
                break;
                default: break;
        }
        step++;
    }

    private void checkEncounter(int a) {
        if (step + 1>= encounters.size()) finish();
        Encounter encounter = encounters.get(step);
        if (encounter.optionsEncounter.get(a-1).outcome == 1) newEncounter();        //Хороший вариант
        else if (encounter.optionsEncounter.get(a-1).outcome == 2) newEncounter();   //Средний вариант
        else if (encounter.optionsEncounter.get(a-1).outcome == 3) newEncounter();   //Плохой вариант
        else if (encounter.optionsEncounter.get(a-1).outcome == 4) newEncounter();   //Смерть
    }
}
