package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// TODO: Implementing View.OnClickListener
// This activity is implementing "View.OnClickListener" interface, so "onClick" method must be overridden.
public class Option3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInput;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        bindView();
        initView();
    }

    // You don't have to bind any functions to "android:onClick" in layout XML file.
    // onClick is public!?!?
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_process_3:
                greet();
                break;
            case R.id.next3:
                Intent next_3 = new Intent(Option3Activity.this, Option4Activity.class);
                startActivity(next_3);
                finish();
                break;
            case R.id.back3:
                Intent back_3 = new Intent(Option3Activity.this, Option2Activity.class);
                startActivity(back_3);
                finish();
                break;
        }
        hideKeyboardInput(v);
    }

    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_3);
        tvOutput = (TextView) findViewById(R.id.tv_body_3);
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_process_3).setOnClickListener(this); // Think about... Who is "this"?
        findViewById(R.id.next3).setOnClickListener(this);
        findViewById(R.id.back3).setOnClickListener(this);
    }


    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}

