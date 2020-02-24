package com.example.loanwolf;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class Collection extends AppCompatActivity {


    double principal, rate, minPayment;
    int numPayments;

    EditText princ;
    EditText interest;
    EditText minimum;
    EditText numPay;

    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        princ = (EditText) findViewById(R.id.princ);
        interest = (EditText) findViewById(R.id.interest);
        minimum = (EditText) findViewById(R.id.minimum);
        numPay = (EditText) findViewById(R.id.numPay);

        calculate = (Button) findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                principal = Double.parseDouble(princ.getText().toString());
                rate = Double.valueOf(interest.getText().toString());
                minPayment = Double.valueOf(minimum.getText().toString());
                numPayments = Integer.valueOf(numPay.getText().toString());

                /*showToast(String.valueOf(principal));
                showToast(String.valueOf(rate));
                showToast(String.valueOf(minPayment));
                showToast(String.valueOf(numPayments));*/

                Intent intent = new Intent(Collection.this, SecondActivity.class);
                intent.putExtra("PRINCIPAL", principal);
                intent.putExtra("RATE", rate);
                intent.putExtra("MIN_PAYMENTS", minPayment);
                intent.putExtra("NUM_PAYMENTS", numPayments);
                startActivity(intent);

            }
        });

    }

    private void showToast(String tst){
        Toast.makeText(Collection.this, tst, Toast.LENGTH_SHORT).show();
    }
}
