package com.example.ivan.textquest;

import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class Encounter {
    private String      textEncounter;
    private Bitmap      imageEncounter;

     ArrayList <Option> optionsEncounter;

    Encounter(
            String textEncounter,
            Bitmap imageEncounter,
            ArrayList<Option> optionsEncounter) {

        this.textEncounter  = textEncounter;
        this.imageEncounter = imageEncounter;
        this.optionsEncounter = optionsEncounter;


    }






    String getTextEncounter() {
        return textEncounter;
    }

    public void setTextEncounter(String textEncounter) {
        this.textEncounter = textEncounter;
    }

    Bitmap getImageEncounter() {
        return imageEncounter;
    }

    public void setImageEncounter(Bitmap imageEncounter) {
        this.imageEncounter = imageEncounter;
    }
}
