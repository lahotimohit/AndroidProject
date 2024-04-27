package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<contactmodel> arrcontact;
    RecyclerContactAdapter(Context context, ArrayList<contactmodel> arrcontact)
    {
        this.context=context;
        this.arrcontact = arrcontact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgcontact.setImageResource(arrcontact.get(position).img);
        holder.txtname.setText(arrcontact.get(position).name);
        holder.txtcontact.setText(arrcontact.get(position).number);
        holder.llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.addupdatelay);
                TextView txtupdate = dialog.findViewById(R.id.titletxt);
                EditText editname = dialog.findViewById(R.id.editname);
                EditText editnumber = dialog.findViewById(R.id.editnumber);
                Button fabtn = dialog.findViewById(R.id.btnadd);

                txtupdate.setText("Update Contact");
                fabtn.setText("Update");

                editname.setText(arrcontact.get(position).name);
                editnumber.setText(arrcontact.get(position).number);

                fabtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";
                        if(!editname.getText().toString().equals(""))
                        {
                            name=editname.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(context, "Please Enter Name.....", Toast.LENGTH_SHORT).show();
                        }
                        if(!editnumber.getText().toString().equals(""))
                        {
                            number=editnumber.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(context, "Please Enter Number.....", Toast.LENGTH_SHORT).show();
                        }
                        arrcontact.set(position,new contactmodel(arrcontact.get(position).img,name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                        dialog.show();
            }
        });
        holder.llayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete contact?")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrcontact.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrcontact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname, txtcontact;
        ImageView imgcontact;
        LinearLayout llayout;
        public ViewHolder (@NonNull View itemView)
        {
            super(itemView);

            imgcontact = itemView.findViewById(R.id.imageView1);
            txtname = itemView.findViewById(R.id.cname);
            txtcontact = itemView.findViewById(R.id.cnumber);
            llayout = itemView.findViewById(R.id.llview);
        }
    }

}
