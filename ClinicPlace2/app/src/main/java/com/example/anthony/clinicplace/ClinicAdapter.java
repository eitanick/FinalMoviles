package com.example.anthony.clinicplace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Anthony on 04/11/2017.
 */

public class ClinicAdapter extends ArrayAdapter<Clinica> {

    public ClinicAdapter(Context context , ArrayList<Clinica> clinicas){
        super(context,0,clinicas);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        Clinica currentWord= getItem(position);

        TextView miwokText= (TextView)listItemView.findViewById(R.id.miwok_textview);
        miwokText.setText(currentWord.getNombre());

        TextView defautlText= (TextView)listItemView.findViewById(R.id.defaut_textview);
        defautlText.setText(currentWord.getSede());


        ImageView imageView= (ImageView) listItemView.findViewById(R.id.
                image);
        if (currentWord.hasImage()){
            Glide.with(getContext())
                    .load(currentWord.getImageUrl())
                    .override(100,100)
                    .centerCrop()
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
      }

        else   {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;

    }

}
