package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    TextView result_field;
    Boolean isActive=false , haveDot=false, isEmpty=true, isResult=false;
    Double firstValue, secondValue, result;
    String operation;
    Calculator calculator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //=============================================================
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        calculator = new Calculator();
        transaction.replace(R.id.container, calculator);
        transaction.commit();
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

        //=============================================================

        //result_field = findViewById(R.id.mainResult);       //??????????????????
        try {
            result_field.setText(savedInstanceState.getString("saved_resultField"));
        }catch (Exception e){}
    }
    public void onShare(View view){
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, result.toString());
            intent.setType("text/plain");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }catch (Exception e){}
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //====================================================================

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

        //====================================================================

        outState.putString("saved_resultField", result_field.getText().toString());
    }
    public void onNumberClick(View view) {
        if (isResult){
            result_field.setText(result.toString());
            isResult=false;
        }
        switch (view.getId()){
            case R.id.number_nine:
                result_field.append("9");
                isEmpty=false;
                break;
            case R.id.number_eight:
                result_field.append("8");
                isEmpty=false;
                break;
            case R.id.number_seven:
                result_field.append("7");
                isEmpty=false;
                break;
            case R.id.number_six:
                result_field.append("6");
                isEmpty=false;
                break;
            case R.id.number_five:
                result_field.append("5");
                isEmpty=false;
                break;
            case R.id.number_four:
                result_field.append("4");
                isEmpty=false;
                break;
            case R.id.number_three:
                result_field.append("3");
                isEmpty=false;
                break;
            case R.id.number_two:
                result_field.append("2");
                isEmpty=false;
                break;
            case R.id.number_one:
                result_field.append("1");
                isEmpty=false;
                break;
            case R.id.number_zero:
                result_field.append("0");
                isEmpty=false;
                break;
            case R.id.number_dot:
                if (!haveDot) {
                    if (isEmpty) {
                        result_field.append("0.");
                    }else result_field.append(".");
                }
                haveDot=true;
                isEmpty=false;
                break;
            case R.id.number_clear:
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
        if (view.getId() == R.id.operation_equals){
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
                case R.id.operation_plus:
                    operation = "+";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "+");
                    isActive=true;
                    break;
                case R.id.operation_minus:
                    operation = "-";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "-");
                    isActive=true;
                    break;
                case R.id.operation_divide:
                    operation = "/";
                    firstValue = Double.valueOf(result_field.getText().toString());
                    result_field.setText(firstValue + "/");
                    isActive=true;
                    break;
                case R.id.operation_multiply:
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

    public void calculator(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        calculator = new Calculator();
        transaction.replace(R.id.container, calculator);
        transaction.commit();
    }
    public void share(View view){
        if (isResult) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Share share = new Share();
            transaction.replace(R.id.container, share);
            transaction.commit();
        }
    }
}
