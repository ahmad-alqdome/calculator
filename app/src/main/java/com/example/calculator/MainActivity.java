package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button zeroBtn , oneBtn , twoBtn ,threeBtn , fourBtn , fiveBtn ,sixBtn,sevenBtn,eightBtn , nineBtn ,
    leftBtn,rightBtn,addBtn,subBtn,multBtn,divisionBtn,backBtn,ACBtn,equalBtn;
TextView rslt1 , finalrslt;
    double x=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zeroBtn=findViewById(R.id.zeroID);
        oneBtn=findViewById(R.id.oneID);
        twoBtn=findViewById(R.id.twoID);
        threeBtn=findViewById(R.id.threeID);
        fourBtn=findViewById(R.id.fourID);
        fiveBtn=findViewById(R.id.fiveID);
        sixBtn=findViewById(R.id.sixID);
        sevenBtn=findViewById(R.id.sevenID);
        eightBtn=findViewById(R.id.eightID);
        nineBtn=findViewById(R.id.nineID);
        ACBtn=findViewById(R.id.acID);
        addBtn=findViewById(R.id.addID);
        subBtn=findViewById(R.id.subID);
        leftBtn=findViewById(R.id.leftID);
        rightBtn=findViewById(R.id.rightID);
        divisionBtn=findViewById(R.id.divisonID);
        multBtn=findViewById(R.id.multID);
        backBtn=findViewById(R.id.backID);
        equalBtn=findViewById(R.id.equalID);
        rslt1=findViewById(R.id.rslt1ID);
        finalrslt=findViewById(R.id.finalrsltID);

        // Number  zero
        zeroBtn.setOnClickListener(view -> rslt1.append("0"));


        // Number One
        oneBtn.setOnClickListener(view -> rslt1.append("1"));
        //Number Two
        twoBtn.setOnClickListener(view -> rslt1.append("2"));
        //Number Three
        threeBtn.setOnClickListener(view -> rslt1.append("3"));
        // Number Four
        fourBtn.setOnClickListener(view -> rslt1.append("4"));
        //Number Five
        fiveBtn.setOnClickListener(view -> rslt1.append("5"));
        //Number Six
        sixBtn.setOnClickListener(view -> rslt1.append("6"));
        //Number Seven
        sevenBtn.setOnClickListener(view -> rslt1.append("7"));

        //Number Eight
        eightBtn.setOnClickListener(view -> rslt1.append("8"));

        //Number Nine
        nineBtn.setOnClickListener(view -> rslt1.append("9"));

        // Addition
        addBtn.setOnClickListener(view -> rslt1.append(" + "));
        //Subtraction
        subBtn.setOnClickListener(view -> rslt1.append(" - "));
        //Multiple
        multBtn.setOnClickListener(view -> rslt1.append(" × "));
        //Division
        divisionBtn.setOnClickListener(view -> rslt1.append(" ÷ "));
        ACBtn.setOnClickListener(view -> {                // AC on click convert  text result to empty
            rslt1.setText("");
            finalrslt.setText("");
            x=0;


        });
        //backspace
        backBtn.setOnClickListener(view -> {
            String str = rslt1.getText().toString();
            if (str.length() >= 1) {
                str = str.substring(0, str.length() - 1);
                rslt1.setText(str);
            }
        });
        // left bracket
        leftBtn.setOnClickListener(view -> rslt1.append("( "));

        // right bracket
        rightBtn.setOnClickListener(view -> rslt1.append(" )"));



        /*
        When you click on Equal, the text in the first
        result will be sent to Class EvaluateString

         */
        equalBtn.setOnClickListener(view -> {
            try {
                String str=rslt1.getText().toString();
            x= EvaluateString.evaluate(str);
           String str2=Double.toString(x);
            finalrslt.setText(str2);
            rslt1.setText("");
        }
        catch (Exception e) {
                finalrslt.setText("Error");
        }
        });

    }
}