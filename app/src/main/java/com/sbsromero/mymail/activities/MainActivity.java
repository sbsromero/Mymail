package com.sbsromero.mymail.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.stetho.Stetho;
import com.sbsromero.mymail.R;
import com.sbsromero.mymail.fragments.FragmentDetailMessage;
import com.sbsromero.mymail.fragments.FragmentListViewMessage;
import com.sbsromero.mymail.models.Mail;

public class MainActivity extends AppCompatActivity implements FragmentListViewMessage.MailListener {

    private boolean isMultipanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultipanel();
        Stetho.initializeWithDefaults(this);
    }

    @Override
    public void sendMail(Mail mail) {

        if (isMultipanel) {
            FragmentDetailMessage fragmentDetailMessage = (FragmentDetailMessage) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailMessage);
            fragmentDetailMessage.renderData(mail);
        } else {
            Intent intent = new Intent(MainActivity.this, DetailMessageActivity.class);
            intent.putExtra("mail", mail);
            startActivity(intent);
        }
    }

    public void setMultipanel() {
        isMultipanel = (getSupportFragmentManager().findFragmentById(R.id.fragmentDetailMessage) != null);
    }
}
