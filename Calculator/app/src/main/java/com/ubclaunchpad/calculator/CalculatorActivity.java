package com.ubclaunchpad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.*;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();

    private EditText inputOne;
    private EditText inputTwo;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button pow;


    @Override

    // initializing the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // retrieving inputs
        inputOne = (EditText) findViewById(R.id.firstInput);
        inputTwo = (EditText) findViewById(R.id.secondInput);
        add = (Button) findViewById(R.id.operation_add);
        sub = (Button) findViewById(R.id.operation_sub);
        mul = (Button) findViewById(R.id.operatio_multi);
        div = (Button) findViewById(R.id.operation_div);
        pow = (Button) findViewById(R.id.operation_pow);

        // click listeners
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        pow.setOnClickListener(this);

    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {

        float firstInput = 0;
        float secondInput = 0;
        float result = 0;

        if (TextUtils.isEmpty(inputOne.getText().toString()) || TextUtils.isEmpty(inputTwo.getText().toString())) {
            return;
        }
        firstInput = Float.parseFloat(inputOne.getText().toString());
        secondInput = Float.parseFloat(inputTwo.getText().toString());


        switch (v.getId())
        {
            case R.id.operation_add:
            {
                result = firstInput + secondInput;git
                break;
            }
            case R.id.operation_sub:
            {
                result = firstInput - secondInput;
                break;
            }
            case R.id.operation_multi:
            {
                result = firstInput * secondInput;
                break;
            }
            case R.id.operation_div:
            {
                result = firstInput / secondInput;
                 break;
            }
            // optional operation (power)
            case R.id.operation_pow:
            {
                result = (float) Math.power(firstInput, secondInput);
                break;
            }
            default:
            {
                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                break;
            }
        }
    }
}
