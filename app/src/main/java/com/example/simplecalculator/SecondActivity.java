package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Boolean isActive=false , haveDot=false, isEmpty=true, isResult=false;
    Double firstValue, secondValue, result;
    String operation;
    TextView result_field;
    public void share(View view){
        if (isResult) {
            Intent intent = new Intent();
            intent.putExtra("text_result", result_field.toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("lol", "strange");
        outState.putString("saved_resultField", result_field.getText().toString());
        outState.putString("saved_operation", operation);
        outState.putBoolean("saved_haveDot", haveDot);
        outState.putBoolean("saved_isEmpty", isEmpty);
        outState.putBoolean("saved_isResult", isResult);
        outState.putBoolean("saved_isActive", isActive);
        try {
            outState.putDouble("saved_firstValue", firstValue);
        }catch (Exception e){}
        try {
            outState.putDouble("saved_secondValue", secondValue);
        }catch (Exception e){}
        try {
            outState.putDouble("saved_result", result);
        }catch (Exception e){}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        result_field = findViewById(R.id.res);
        try {
            result_field.setText(savedInstanceState.getString("saved_resultField"));
        }catch (Exception e){}
        try {
            operation = savedInstanceState.getString("saved_operation");
        }catch (Exception e){}
        try {
            haveDot=savedInstanceState.getBoolean("saved_haveDot");
        }catch (Exception e){}
        try {
            isResult = savedInstanceState.getBoolean("saved_isResult");
        }catch (Exception e){}
        try {
            isEmpty = savedInstanceState.getBoolean("saved_isEmpty");
        }catch (Exception e ){}
        try {
            isActive=savedInstanceState.getBoolean("saved_isActive");
        }catch (Exception e){}
        try {
            firstValue=savedInstanceState.getDouble("saved_firstValue");
        }catch (Exception e){}
        try {
            secondValue=savedInstanceState.getDouble("saved_secondValue");
        }catch (Exception e){}
        try {
            result=savedInstanceState.getDouble("saved_result");
        }catch (Exception e){}
        if (isResult){
            result_field.setText(result.toString());
            isResult=false;
        }

    }

    public void onNumberClick(View view) {
        if (isResult){
            result_field.setText(result.toString());
            isResult=false;
        }
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
                    if (!haveDot) {
                        if (isEmpty) {
                            result_field.append("0.");
                        }else result_field.append(".");
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
        if (isResult){
            result_field.setText(result.toString());
            isResult=false;
        }
        if (view.getId() == R.id.equal){
            if (operation != null && isActive) {
                        String two = result_field.getText().toString().replace(firstValue + operation + "", "");
                        try {
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
                        isResult=true;
                        }catch (Exception e ){
                            result_field.setText("");
                        }
                        operation=null;
                        isActive=false;
                        haveDot=true;
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
        result_field.setText(firstValue +"+"+secondValue+"="+result.toString());
    }
    public void minus_op(){
        result = firstValue - secondValue;
        result_field.setText(firstValue +"-"+secondValue+"="+result.toString());
    }public void multiply_op(){
        result = firstValue * secondValue;
        result_field.setText(firstValue +"*"+secondValue+"="+result.toString());
    }public void divide_op(){
            result = firstValue / secondValue;
            result_field.setText(firstValue +"/"+secondValue+"="+result.toString());
    }
}
