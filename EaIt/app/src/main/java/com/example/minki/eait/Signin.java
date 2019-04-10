package com.example.minki.eait;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minki.eait.Common.Common;
import com.example.minki.eait.Common.User_Number;
import com.example.minki.eait.DTO.UserDTO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Signin extends AppCompatActivity {

    private EditText edtPhone, edtPassword;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtPhone = (MaterialEditText) findViewById(R.id.edtPhone);
        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSingIn);

        // Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(Signin.this);
                mDialog.setMessage("Please Waiting");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        // check if user not exist in database
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                            // Get user information
                            mDialog.dismiss();

                            UserDTO user = dataSnapshot.child(edtPhone.getText().toString()).getValue(UserDTO.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                //Toast.makeText(Signin.this, "Sign in seuccessfully", Toast.LENGTH_SHORT).show();
                                Intent homeIntent = new Intent(Signin.this,Home.class);
                                Common.currentUsers = user;
                                User_Number.User_Number = edtPhone.getText().toString();
                                startActivity(homeIntent);
                                finish();
                            } else {
                                Toast.makeText(Signin.this, "Sign in failed!!!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(Signin.this, "User nt exist in Database", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
