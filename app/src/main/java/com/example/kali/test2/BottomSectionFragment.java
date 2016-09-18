package com.example.kali.test2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.support.v4.app.Fragment;


public class BottomSectionFragment extends Fragment {

    private static TextView bottom_meme_text ;
    private static TextView top_meme_text ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.bottom_section_fragment, container, false);


        top_meme_text = (TextView) view.findViewById(R.id.top_meme_text);
        bottom_meme_text = (TextView) view.findViewById(R.id.bottom_meme_text);

        return view;
    }

    public void setMemeText (String top , String bottom){

        top_meme_text.setText(top);
        bottom_meme_text.setText(bottom);
    }



}