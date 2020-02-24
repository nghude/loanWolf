package com.example.loanwolf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    double principal , rate, minPayment, interestPaid;
    int numPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        principal = (double) getIntent().getExtras().get("PRINCIPAL");
        rate = (double) getIntent().getExtras().get("RATE");
        minPayment = (double) getIntent().getExtras().get("MIN_PAYMENTS");
        numPayments = (int) getIntent().getExtras().get("NUM_PAYMENTS");

        String sto = "";
        int count = 0;

        while (count != numPayments){

            count++;

            interestPaid = getInterestPayment(principal,rate,numPayments);
            principal = principal - (minPayment - interestPaid);
            sto += "\nMonth " + count + ":\n";
            sto += "You paid $" + interestPaid + " in interest.\n";
            sto += "You paid $" + (minPayment - interestPaid) + " of your principal.\n";
            sto += "You now owe $" + principal + ".\n";


        }


        TextView disp = (TextView) findViewById(R.id.summaryText);

        disp.setText(sto);

    }

    private double getInterestPayment (double principal, double rate, int numPayments) {

        return (rate/numPayments) * principal;

    }
}
