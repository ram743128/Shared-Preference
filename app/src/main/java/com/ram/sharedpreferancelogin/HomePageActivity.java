package com.ram.sharedpreferancelogin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    private TextView mShowTv;
    private SharedPreferences msp;
    private String mName;
    private SharedPreferences.Editor mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mShowTv=(TextView)findViewById(R.id.tv);
        msp=getSharedPreferences(Constant.PREF_NAME,MODE_PRIVATE);
        mName=msp.getString(Constant.NAME,"");
        mShowTv.setText("Welcome  "+mName);
        mEdit=msp.edit();
    }

    public void Logout(View view) {
        msp.edit().clear().apply();
        finish();

    }
}
