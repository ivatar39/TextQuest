package com.example.ivan.textquest;

import android.graphics.Bitmap;

public class Option {
    String textOption;
    int outcome;
    String textOutcome;
    Bitmap imageOutcome;

    public  Option() {

    }
    public Option(String textOption, int outcome) {
        this.textOption = textOption;
        this.outcome = outcome;
    }
    public Option(String textOption, int outcome, String textOutcome, Bitmap imageOutcome) {
        this.textOption = textOption;
        this.outcome = outcome;
        this.textOutcome = textOutcome;
        this.imageOutcome = imageOutcome;
    }
}