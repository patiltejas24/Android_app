package com.example.kali.test2;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//
//public class Database extends AppCompatActivity {
//
//    MyDBHandler dbHandler;
//    EditText database_output;
//    TextView database_text;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.database);
//
//         database_text = (TextView) findViewById(R.id.database_output);
//         database_output = (EditText) findViewById(R.id.database_text);
//
//        dbHandler = new MyDBHandler(this, null, null, 1);
//
//        printDatabase();
//    }
//
//
//    public void addButtonCilcked(View view){
//
//        Product product = new Product(database_text.getText().toString());
//        dbHandler.addProduct(product);
//        printDatabase();
//
//    }
//
//
//    public void deleteButtonClicked (View view){
//
//        String inputText = database_text.getText().toString();
//        dbHandler.deleteProduct(inputText);
//        printDatabase();
//    }
//
//
//    public void printDatabase() {
//
//
//        String dbString = dbHandler.databaseToString();
//        database_output.setText(dbString);
//        database_text.setText("");
//
//
//    }
//
//}

// Lesson 54


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Database extends AppCompatActivity {
// Declare references

    EditText userInput;
    TextView recordsTextView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.user_Input);
        recordsTextView = (TextView) findViewById(R.id.records_TextView);
        /* Can pass nulls because of the constants in the helper.
         * the 1 means version 1 so don't run update.
         */
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Print the database

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        recordsTextView.setText(dbString);
       // userInput.setText(" ");
    }

    //add your elements onclick methods.
    //Add a product to the database
    public void addButtonClicked(View view){
        // dbHandler.add needs an object parameter.
        Product product = new Product(userInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        // dbHandler delete needs string to find in the db
        String inputText = userInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

}