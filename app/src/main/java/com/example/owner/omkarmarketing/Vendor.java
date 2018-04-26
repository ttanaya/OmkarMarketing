package com.example.owner.omkarmarketing;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends AppCompatActivity {

    Button vendor;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vendor = findViewById(R.id.vendor);
        listView = findViewById(R.id.LV);

        final List<String> list = new ArrayList<>();

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading, Please Wait");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("vendors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();

                for (DataSnapshot snapshot :
                        dataSnapshot.getChildren()) {
                    String listItem =
                            snapshot.child("name").getValue().toString() + "\n" +
                                    snapshot.child("address").getValue().toString() + "\n" +
                                    snapshot.child("mobile").getValue().toString();
                    list.add(listItem);
                    arrayAdapter.notifyDataSetChanged();
                }

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        vendor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Vendor.this, DatabaseHelper.class));
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        finish();

        return super.onOptionsItemSelected(item);
    }
}