package com.example.test.ui.calling;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.fragment.app.Fragment;

public class CallingFragment extends Fragment {

    public void onClick(View v) {
        //전화 걸기
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:119"));
        startActivity(intent);
    }

}