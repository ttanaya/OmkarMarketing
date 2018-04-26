package com.example.owner.omkarmarketing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    Button customer, vendor, stocks, invoice, recovery, payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        customer = findViewById(R.id.customer);
        vendor = findViewById(R.id.vendor);
        stocks = findViewById(R.id.stocks);
        invoice = findViewById(R.id.invoice);
        recovery = findViewById(R.id.recovery);
        payment = findViewById(R.id.payment);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, customer.class));
            }
        });

        vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, Vendor.class));

            }
        });
        stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, stocks.class));
            }
        });
//        invoice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(homepage.this, invoice.class));
//            }
//        });
//        recovery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(homepage.this, recovery.class));
//            }
//        });
//        payment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(homepage.this, payment.class));
//            }
//        });
    }
}
