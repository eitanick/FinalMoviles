package com.example.android.miwok;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;


/**
 * Created by Anthony on 10/10/2017.
 */

public class WordAdapater extends ArrayAdapter<Word> {


    public WordAdapater(Context context, ArrayList<Word> words){

    super (context,0,words);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        Word currentWord= getItem(position);

        TextView miwokText= (TextView)listItemView.findViewById(R.id.miwok_textview);
        miwokText.setText(currentWord.getmMiwoktTranslation());

        TextView defautlText= (TextView)listItemView.findViewById(R.id.defaut_textview);
        defautlText.setText(currentWord.getmDefaultTranslation());


        ImageView imageView= (ImageView) listItemView.findViewById(R.id.
        image);
        if (currentWord.hasImage()){
        imageView.setImageResource(currentWord.getmImageSourceId());}

        else   {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;

    }
}
