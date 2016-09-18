package com.example.kali.test2;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 9/17/16.
 */
public class TopSectionFragment extends Fragment {


    private static EditText top_text;
    private static EditText bottom_text;
 //   private static Button meme_button;

    TopSectionListener activityCommander ;

    public interface TopSectionListener {

        void createMeme (String top , String bottom);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container , @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_secction_fragment,container,false);


        top_text = (EditText)view. findViewById(R.id.top_text);
        bottom_text = (EditText)view.findViewById(R.id.bottom_text);


        //refrence to meme button
   final Button meme_button = (Button) view.findViewById(R.id.meme_button);
        meme_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        activityCommander.createMeme(top_text.getText().toString(),bottom_text.getText().toString());
                    }
                }
        );


        return view;


    }




}
