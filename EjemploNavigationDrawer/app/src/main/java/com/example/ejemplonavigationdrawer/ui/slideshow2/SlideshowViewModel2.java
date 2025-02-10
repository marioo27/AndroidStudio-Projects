package com.example.ejemplonavigationdrawer.ui.slideshow2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel2 extends ViewModel {

    private final MutableLiveData<String> mText;

    public SlideshowViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("BULBASUR");
    }

    public LiveData<String> getText() {
        return mText;
    }
}