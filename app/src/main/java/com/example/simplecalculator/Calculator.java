package com.example.simplecalculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calculator extends Fragment {
    Button clear, one, two, three, four, five, six, seven, eight, nine, zero, dot,
        plus, minus, multiply, divide, equal;
    TextView result_field;

    public Calculator() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final MainActivity mainActivity = (MainActivity) getActivity();
        result_field = view.findViewById(R.id.result_field);
        ((MainActivity) getActivity()).result_field = result_field;
        clear = view.findViewById(R.id.number_clear);
        one = view.findViewById(R.id.number_one);
        two = view.findViewById(R.id.number_two);
        three = view.findViewById(R.id.number_three);
        four = view.findViewById(R.id.number_four);
        five = view.findViewById(R.id.number_five);
        six = view.findViewById(R.id.number_six);
        seven = view.findViewById(R.id.number_seven);
        eight = view.findViewById(R.id.number_eight);
        nine = view.findViewById(R.id.number_nine);
        zero = view.findViewById(R.id.number_zero);
        dot = view.findViewById(R.id.number_dot);
        plus = view.findViewById(R.id.operation_plus);
        minus = view.findViewById(R.id.operation_minus);
        multiply = view.findViewById(R.id.operation_multiply);
        divide = view.findViewById(R.id.operation_divide);
        equal = view.findViewById(R.id.operation_equals);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onNumberClick(v);
            }
        });
       plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onOperationClick(v);
            }
        });
       minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onOperationClick(v);
            }
        });
       multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onOperationClick(v);
            }
        });
       divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onOperationClick(v);
            }
        });
       equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onOperationClick(v);
            }
        });

    }
}
