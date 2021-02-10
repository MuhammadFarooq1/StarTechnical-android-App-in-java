package com.example.startechnical.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.startechnical.AssisterClasses.AdminAdapter;
import com.example.startechnical.AssisterClasses.Adminmodule;
import com.example.startechnical.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AdminProfile extends AppCompatActivity {
    RecyclerView recyclerView;
    AdminAdapter adminAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        recyclerView = findViewById(R.id.AdminRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        FirebaseRecyclerOptions<Adminmodule> options =
                new FirebaseRecyclerOptions.Builder<Adminmodule>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Logins") , Adminmodule.class)
                        .build();
        adminAdapter = new AdminAdapter(options,this);
        recyclerView.setAdapter(adminAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adminAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adminAdapter.stopListening();
    }
}