package com.example.test.ui.calling;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CallingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CallingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Calling fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
