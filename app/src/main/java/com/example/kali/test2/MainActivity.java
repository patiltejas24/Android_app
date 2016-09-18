package com.example.kali.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

//to access the text box
import android.widget.TextView;



public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for button 1 create the instance
        Button  SignIn = (Button) findViewById(R.id.SignIn);

        //tel the button to listen
        SignIn.setOnClickListener(
                new View.OnClickListener()
                {
                    //calling the method
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(findViewById(R.id.SignIn).getContext(),BlocksOnScreen.class);
                        startActivity(intent);

                    }
                }
        );

        //for button 1 create the instance
        Button change_text_button_two = (Button) findViewById(R.id.change_text_button_two);

        //tel the button to listen
        change_text_button_two.setOnLongClickListener(
                new View.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View view) {
                        //calling the method

                        TextView textView = (TextView) findViewById(R.id.mytextView);
                        textView.setText("wow ");
                        return false;
                    }


                }
        );


        //button to change the text onClick
        Button change_text_button = (Button) findViewById(R.id.change_text_button);
        change_text_button.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View vie)
                    {
                        TextView textView = (TextView) findViewById(R.id.mytextView);
                        textView.setText("grtttt");

                    }
                }
        );

        Button gesture_button = (Button) findViewById(R.id.gesture_button);
        gesture_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(findViewById(R.id.gesture_button).getContext(),Gestures.class);
                        startActivity(intent);
                    }
                }
        );

        Button database_button = (Button) findViewById(R.id.database_button);
        database_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(findViewById(R.id.database_button).getContext(),Database.class);
                        startActivity(intent);
                    }
                }
        );

        Button fragments_button = (Button) findViewById(R.id.fragments_button);
        fragments_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(findViewById(R.id.fragments_button).getContext(),Fragments.class);
                        startActivity(intent);
                    }
                }
        );


    }
}
