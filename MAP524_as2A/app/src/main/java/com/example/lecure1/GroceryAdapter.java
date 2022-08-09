package com.example.lecure1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class GroceryAdapter extends BaseAdapter {
        Context context;
        String[] stores;
        String[] address;
        int[] open;
        int[] logo;

    GroceryAdapter(Context contexts, String[] stores, String[] address, int[] open, int[] logo) {
            this.context = context;
            this.stores = stores;
            this.address = address;
            this.open = open;
            this.logo = logo;
        }
        @Override
        public int getCount() {
            return stores.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.activity_list, viewGroup, false);

            TextView txtStore = view.findViewById(R.id.txtLogo);
            txtStore.setText(stores[i]);

            TextView txtAddress = view.findViewById(R.id.address);
            txtAddress.setText(address[i]);

            CheckBox checkOpen = view.findViewById(R.id.checkBox);
            checkOpen.setText(open[i]);

            ImageView imgLogo = view.findViewById(R.id.imgLogo);
//        imgLogo.setImageBitmap(logo[i]);


            return view;
        }
    }

