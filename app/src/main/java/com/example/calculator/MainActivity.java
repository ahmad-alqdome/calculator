package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button zeroBtn , oneBtn , twoBtn ,threeBtn , fourBtn , fiveBtn ,sixBtn,sevenBtn,eightBtn , nineBtn ,
    leftBtn,rightBtn,addBtn,subBtn,multBtn,divisionBtn,backBtn,ACBtn,equalBtn;
TextView rslt1 , finalrslt;
    double x=0;
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

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("0");
            }
        });


        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("1");
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("2");
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("3");
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("4");
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("5");
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("6");
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("7");
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("8");
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append("9");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append(" + ");
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append(" - ");
            }
        });
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append(" × ");
            }
        });
        divisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.append(" ÷ ");
            }
        });
        ACBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rslt1.setText("");
                finalrslt.setText("");
                x=0;


            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = rslt1.getText().toString();
                if (str.length() >= 1) {
                    str = str.substring(0, str.length() - 1);
                    rslt1.setText(str);
                }
            }
        });
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    rslt1.append("( ");

                }

        });
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rslt1.append(" )");

            }

    });



        equalBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                try {
                EvaluateString obj = new EvaluateString();
                String str=rslt1.getText().toString();
                x= obj.evaluate(str);
               String str2=Double.toString(x);
                finalrslt.setText(str2);
                rslt1.setText("");

            }
            catch (Exception e) {
                    finalrslt.setText("Error");
            }
            }


        });

    }
}