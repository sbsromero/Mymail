package com.sbsromero.mymail.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sbsromero.mymail.R;
import com.sbsromero.mymail.fragments.FragmentDetailMessage;
import com.sbsromero.mymail.models.Mail;

public class DetailMessageActivity extends AppCompatActivity {

    private Mail mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_message);

        if(getIntent().getExtras()!=null){
            mail = (Mail) getIntent().getSerializableExtra("mail");
        }
        FragmentDetailMessage fragmentDetailMessage = (FragmentDetailMessage) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailMessage);
        fragmentDetailMessage.renderData(mail);
    }
}
