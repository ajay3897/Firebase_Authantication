package com.example.ajay.firebase_authantication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText ed1,ed2;
    Button btn;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);//this is use for seen proceing by internet or loading page from server
        progressDialog.setMessage("Loading please wait.....");

        ed1=findViewById(R.id.et_mail);
        ed2=findViewById(R.id.et_pwd);
        btn=findViewById(R.id.bt_reg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });
    }
    public  void  loginUser()
    {
        String nm= ed1.getText().toString().trim();//trim is use to remove spaces between the Strings
        String passward=ed2.getText().toString().trim();
        if(TextUtils.isEmpty(nm))
        {
            Toast.makeText(this,"email field is empty",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(passward))
        {
            Toast.makeText(this,"passward field is empty",Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.signInWithEmailAndPassword(nm,passward).addOnCompleteListener(new OnCompleteListener<AuthResult>() {//sign in with emali
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this,"successfully log in",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,Home.class));
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this,"some error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
