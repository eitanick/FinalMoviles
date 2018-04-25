package com.example.android.miwok;

/**
 * Created by Anthony on 10/10/2017.
 */

public class Word {

    private int mImageSourceId=NO_IMAGE_PROVIDED;
    private String mDefaultTranslation;
    private String mMiwoktTranslation;

    private static final int NO_IMAGE_PROVIDED=-1;
    public Word(  String DefaultTranslation,String MiwoktTranslation){

        setmDefaultTranslation(DefaultTranslation);
        setmMiwoktTranslation(MiwoktTranslation);

    }
    public Word(  String DefaultTranslation,String MiwoktTranslation,int imageSourceId){

        setmDefaultTranslation(DefaultTranslation);
        setmMiwoktTranslation(MiwoktTranslation);
        setmImageSourceId(imageSourceId);


    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getmMiwoktTranslation() {
        return mMiwoktTranslation;
    }

    public void setmMiwoktTranslation(String mMiwoktTranslation) {
        this.mMiwoktTranslation = mMiwoktTranslation;
    }


    public int getmImageSourceId() {
        return mImageSourceId;
    }

    public void setmImageSourceId(int mImageSourceId) {
        this.mImageSourceId = mImageSourceId;
    }

    public boolean hasImage(){
        return mImageSourceId!=NO_IMAGE_PROVIDED;
    }
}
