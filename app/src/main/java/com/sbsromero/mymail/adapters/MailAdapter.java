package com.sbsromero.mymail.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sbsromero.mymail.R;
import com.sbsromero.mymail.models.Mail;

import java.util.List;

/**
 * Created by sumset on 26/10/17.
 */

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {

    private Context context;
    private List<Mail> mensajes;
    private int layout;
    private OnItemClickListener itemClickListener;


    public MailAdapter(List<Mail> mensajes, int layout, OnItemClickListener itemClickListener) {
        this.mensajes = mensajes;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mensajes.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return mensajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewMail;
        public TextView textViewImageViewMail;
        public TextView textViewTitleMail;
        public TextView textViewBodyMail;
        private final int SUBJECT_MAX_LENGHT = 35;
        private final int MESSAGE_MAX_LENGHT = 35;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewMail = itemView.findViewById(R.id.textViewMail);
            textViewImageViewMail = itemView.findViewById(R.id.textViewImageViewMail);
            textViewTitleMail = itemView.findViewById(R.id.textViewTitleMail);
            textViewBodyMail = itemView.findViewById(R.id.textViewBodyMail);
        }

        public void bind(final Mail mail, final OnItemClickListener listener){
            textViewMail.getBackground().setColorFilter(Color.parseColor(mail.getColor()), PorterDuff.Mode.SRC);
            textViewImageViewMail.setText((mail.getSenderName().charAt(0)+"").toUpperCase());

            String textoBody;
            if(mail.getMessage().length() > MESSAGE_MAX_LENGHT){
                textoBody = mail.getMessage().substring(0,MESSAGE_MAX_LENGHT)+"...";
                textViewBodyMail.setText(textoBody);
            }else{
                textViewBodyMail.setText(mail.getMessage());
            }

            String textoSubject;
            if(mail.getSubject().length() > SUBJECT_MAX_LENGHT){
                textoSubject = mail.getSubject().substring(0,SUBJECT_MAX_LENGHT)+"...";
                textViewTitleMail.setText(textoSubject);
            }else{
                textViewTitleMail.setText(mail.getSubject());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(mail,getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Mail mail,int position);
    }
}
