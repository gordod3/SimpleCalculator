package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Boolean isActive=false , haveDot=false, isEmpty=true;
    Double firstValue, secondValue, result;
    String operation;
    TextView result_field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_field = findViewById(R.id.res);
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
                case R.id.nine:
                    result_field.append("9");
                    isEmpty=false;
                break;
                case R.id.eight:
                    result_field.append("8");
                    isEmpty=false;
                break;
                case R.id.seven:
                    result_field.append("7");
                    isEmpty=false;
                break;
                case R.id.six:
                    result_field.append("6");
                    isEmpty=false;
                break;
                case R.id.five:
                    result_field.append("5");
                    isEmpty=false;
                break;
                case R.id.four:
                    result_field.append("4");
                    isEmpty=false;
                break;
                case R.id.three:
                    result_field.append("3");
                    isEmpty=false;
                break;
                case R.id.two:
                    result_field.append("2");
                    isEmpty=false;
                break;
                case R.id.one:
                    result_field.append("1");
                    isEmpty=false;
                break;
                case R.id.zero:
                    result_field.append("0");
                    isEmpty=false;
                break;
                case R.id.dot:
                    if (!haveDot && !isEmpty) {
                        result_field.append(".");
                    }
                    haveDot=true;
                    isEmpty=false;
                    break;
                case R.id.clear:
                    result_field.setText("");
                    isActive=false;
                    operation=null;
                    haveDot=true;
                    isEmpty=true;
                    break;
        }
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.equal){
            if (operation != null && isActive) {
                        String two = result_field.getText().toString().replace(firstValue + operation + "", "");
                        secondValue = Double.valueOf(two);
                        switch (operation) {
                            case "+":
                                plus_op();
                                break;
                            case "-":
                                minus_op();
                                break;
                            case "*":
                                multiply_op();
                                break;
                            case "/":
                                divide_op();
                                break;
                        }
                        operation=null;
                        isActive=false;
                    }
        }
        if (!isActive && operation == null && !isEmpty) {
            switch (view.getId()) {
                case R.id.plus:
                    operation = "+";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "+");
                    isActive=true;
                    break;
                case R.id.minus:
                    operation = "-";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "-");
                    isActive=true;
                    break;
                case R.id.divide:
                    operation = "/";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "/");
                    isActive=true;
                    break;
                case R.id.multiply:
                    operation = "*";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "*");
                    isActive=true;
                    break;
            }
        }
    }
    public void plus_op(){
        result = firstValue + secondValue;
        result_field.setText(result.toString());
    }
    public void minus_op(){
        result = firstValue - secondValue;
        result_field.setText(result.toString());
    }public void multiply_op(){
        result = firstValue * secondValue;
        result_field.setText(result.toString());
    }public void divide_op(){
            result = firstValue / secondValue;
            result_field.setText(result.toString());
    }
}
