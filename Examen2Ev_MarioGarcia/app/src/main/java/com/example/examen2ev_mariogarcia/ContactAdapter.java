package com.example.examen2ev_mariogarcia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private List<Contacto> contactoList;

    public ContactAdapter(Context context, List<Contacto> contactoList) {
        this.context = context;
        this.contactoList = contactoList;
    }

    @Override
    public int getCount() {
        return contactoList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        }

        Contacto contacto = contactoList.get(position);

        ImageView imageView = convertView.findViewById(R.id.contactImage);
        TextView nameTextView = convertView.findViewById(R.id.contactName);
        TextView phoneTextView = convertView.findViewById(R.id.contactPhone);
        TextView emailTextView = convertView.findViewById(R.id.contactEmail);

        imageView.setImageResource(contacto.getImageResourceId());
        nameTextView.setText(contacto.getName());
        phoneTextView.setText(contacto.getPhone());
        emailTextView.setText(contacto.getEmail());

        return convertView;
    }
}
