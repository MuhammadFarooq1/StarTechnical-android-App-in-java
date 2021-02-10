
package com.example.startechnical.Common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.startechnical.Admin.ManagSpecialCustomer;
import com.example.startechnical.R;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class LogingActivity extends AppCompatActivity {
   EditText etID_Name;
   EditText etId_Password;
   Button btn_ConfirmPassword;
    DatabaseReference firebaseDatabase;
    DatabaseReference firebaseDatabase2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        Init();


        btn_ConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etID_Name.getText().toString().trim();
                String password = etId_Password.getText().toString().trim();
//                 firebaseDatabase2 = FirebaseDatabase.getInstance().getReference().child("Logins").child(name);
//                firebaseDatabase2.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////                        if(snapshot.child(name).exists())
////                        {
////                            Toast.makeText(LogingActivity.this, "hai", Toast.LENGTH_SHORT).show();
////                        }
////                        else
//
//
//                            if(snapshot.child(password).exists())
//                        {
//                            Toast.makeText(LogingActivity.this, "hai na ", Toast.LENGTH_SHORT).show();
//                        }
//                            else
//                            {
//                                Toast.makeText(LogingActivity.this, "no bro  ", Toast.LENGTH_SHORT).show();
//                            }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
                String Cname = "Farooq";
                String Cpassword = "123#@abc";
                if ( ! name.equals(Cname) )
                {
                    etID_Name.setError(" Wrong Password ");
                }
                else if(! password.equals(Cpassword))
                {
                    etId_Password.setError(" Wrong Password ");

                }
                else if(name.equals(Cname) &&  password.equals(Cpassword))
                {
                    Intent manage_login = new Intent(LogingActivity.this, Dash_board.class);
                    startActivity(manage_login);
                }
                else
                {
                    Toast.makeText(LogingActivity.this, " Error ", Toast.LENGTH_SHORT).show();
                }













//                String name  = etID_Name.getText().toString().trim();
//                String password  = etId_Password.getText().toString().trim();
//                String Cname = "Farooq";
//                String Cpassword = "12@abc";
//                if (!name.equals(Cname))
//                {
//                    etID_Name.setError(" Wrong Name ");
//                }
//                  else  if (!password.equals(Cpassword))
//                {
//                    etId_Password.setError(" Wrong Password ");
//                }
//                  else
//                {
//                    Intent manage_SpecCustomer = new Intent(LogingActivity.this, Dash_board.class);
//                    startActivity(manage_SpecCustomer);
//                }

            }
        });

    }

    private void Init() {
        etID_Name = findViewById(R.id.etID_Name);
        etId_Password = findViewById(R.id.etId_Password);
        btn_ConfirmPassword = findViewById(R.id.btn_ConfirmPassword);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Logins");
    }
}