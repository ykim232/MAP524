package com.example.myapplication;

import static android.widget.Toast.makeText;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    String[] fruits;
    String[] addresses;
    List<Integer> images;
    List<Boolean> open;

    MyAdapter(Context context, String[] fruits, String[] addresses, List<Integer> images, List<Boolean> open) {
        this.context = context;
        this.fruits = fruits;
        this.addresses = addresses;
        this.images = images;
        this.open = open;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtFruit.setText(fruits[position]);
        holder.txtAddress.setText(addresses[position]);
        holder.images.setImageResource(images.get(position).intValue());
        holder.open.setChecked(open.get(position).booleanValue());
    }

    @Override
    public int getItemCount() {
        return fruits.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtFruit;
        TextView txtAddress;
        CheckBox open;
        ImageView images;
        String type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFruit = itemView.findViewById(R.id.txtFruit);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            open = itemView.findViewById(R.id.check);
            images = (ImageView) itemView.findViewById(R.id.imgLogo);
//            itemView.setOnClickListener(this);

            txtFruit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog("Store Name");
                }
            });
            txtAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog("Store Address");
                }
            });
            images.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog("Store Logo");
                }
            });
            open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog("Status");
                }
            });
        }

        @Override
        public void onClick(View view) {
//            int index = getAdapterPosition();
//            Toast.makeText(context, "You clicked Store Logo", Toast.LENGTH_SHORT).show();
//            Toast.makeText(context, fruits[index], Toast.LENGTH_SHORT).show();
//            showDialog();
        }
        void showDialog(String str) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Click Information");
            alertDialog.setIcon(R.drawable.ic_baseline_info_24);
            alertDialog.setMessage("You clicked " + str);
//            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(context, "Yes button clicked", Toast.LENGTH_SHORT).show();
//                }
//            });
            alertDialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alertDialog.create().show();
        }
    }
}
