package com.sbsromero.mymail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sbsromero.mymail.R;
import com.sbsromero.mymail.models.Mail;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailMessage extends Fragment {

    public Mail mail;
    public TextView textViewSubjectContent;
    public TextView textViewFromContent;
    public TextView textViewBodyMail;
    public RelativeLayout relativeLayoutDetails;



    public FragmentDetailMessage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_message,container,false);
        textViewSubjectContent = view.findViewById(R.id.textViewSubjectContent);
        textViewFromContent = view.findViewById(R.id.textViewFromContent);
        textViewBodyMail = view.findViewById(R.id.textViewBodyMail);
        relativeLayoutDetails = view.findViewById(R.id.relativeLayoutDetails);
        return view;
    }

    public void renderData(Mail mail){
        relativeLayoutDetails.setVisibility(View.VISIBLE);
        textViewSubjectContent.setText(mail.getSubject());
        textViewFromContent.setText(mail.getSenderName());
        textViewBodyMail.setText(mail.getMessage());
    }

}
