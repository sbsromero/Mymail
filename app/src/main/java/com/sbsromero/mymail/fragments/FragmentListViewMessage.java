package com.sbsromero.mymail.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbsromero.mymail.R;
import com.sbsromero.mymail.Utils.Util;
import com.sbsromero.mymail.adapters.MailAdapter;
import com.sbsromero.mymail.models.Mail;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListViewMessage extends Fragment {

    public List<Mail> mensajes;
    public RecyclerView recyclerViewMainActivity;
    public MailAdapter mailAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public MailListener mailListener;

    public FragmentListViewMessage() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mailListener = (MailListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement MailListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mailListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view_message, container, false);
        mensajes = Util.getDummyData();
        recyclerViewMainActivity = (RecyclerView) view.findViewById(R.id.recyclerViewMainActivity);

        layoutManager = new LinearLayoutManager(getActivity());
        mailAdapter = new MailAdapter(mensajes, R.layout.recycler_view_item_mail, new MailAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Mail mail, int position) {
                sendData(mensajes.get(position));
            }
        });
        recyclerViewMainActivity.setLayoutManager(layoutManager);
        recyclerViewMainActivity.setAdapter(mailAdapter);
        recyclerViewMainActivity.addItemDecoration(new DividerItemDecoration(
                getActivity(),
                ((LinearLayoutManager) layoutManager).getOrientation())
        );
        return view;
    }

    public void sendData(Mail mail) {
        mailListener.sendMail(mail);
    }

    public interface MailListener {
        void sendMail(Mail mail);
    }


}
