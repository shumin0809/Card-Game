package com.example.cardgame.cardgame.ui.viewHolder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.AlertDialog.Builder;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.cardgame.cardgame.R;
import com.example.cardgame.cardgame.ui.adapter.AptExpandableAdapter;
import com.example.cardgame.cardgame.ui.fragment.FirstFragment;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by feicao on 11/6/15.
 */
public class MyAptChildViewHolder extends ChildViewHolder {

    public TextView myAptTime;
    public TextView myAptDetail;
    public TextView myAptInitiator;
    public TextView myAptLocation;
    public TextView myAptPhoneNum;
    public TextView myAptEmail;
    public TextView myAptComment;
    public ImageButton imageButton;
    public AlertDialog.Builder builder;
    public Context context;

    public MyAptChildViewHolder(View itemView) {
        super(itemView);

        myAptTime = (TextView) itemView.findViewById(R.id.time);
        myAptDetail = (TextView) itemView.findViewById(R.id.detail);
        myAptInitiator = (TextView) itemView.findViewById(R.id.initiator);
        myAptLocation = (TextView) itemView.findViewById(R.id.location);
        myAptPhoneNum = (TextView) itemView.findViewById(R.id.phoneNum);
        myAptEmail = (TextView) itemView.findViewById(R.id.email);
        myAptComment = (TextView) itemView.findViewById(R.id.comment);

        imageButton=(ImageButton)itemView.findViewById(R.id.button_cancel);
        context = itemView.getContext();
        builder=new AlertDialog.Builder(context);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAppointment();
            }
        });
    }

    public void cancelAppointment(){
        //set alert dialog and remove appointment from parse
        builder.setMessage("Are you sure to cancel current appointment?");
        builder.setTitle("Confirmation");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }

        );
        builder.create().show();
        }
    }
