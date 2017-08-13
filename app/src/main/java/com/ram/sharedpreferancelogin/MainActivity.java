package com.ram.sharedpreferancelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText mName;
    private EditText mPassword;
    private SharedPreferences mSp;
    private SharedPreferences.Editor mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = (EditText)findViewById(R.id.Name_et);
        mPassword = (EditText)findViewById(R.id.password_et);
        mSp = getSharedPreferences(Constant.PREF_NAME,MODE_APPEND);
        mEdit = mSp.edit();//calling the edit method of shared referance istance.
    }

    public void Login(View view) {
        Intent intent=new Intent(MainActivity.this,HomePageActivity.class);
        mEdit.putString(Constant.NAME,mName.getText().toString());
        mEdit.putString(Constant.PASSWORD,mPassword.getText().toString());
        mEdit.apply();
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mName.setText("");
        mPassword.setText("");
    }
}
