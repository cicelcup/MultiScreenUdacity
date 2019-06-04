/*Word class for storage the words in English, Mitow and its corresponding image*/
package com.example.miwok;

public class Word {
    //Atributes established
    private String mMiwokWord;
    private String mDefaultWord;
    //Constant for defining the no image provided
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Constructor with three parameters
    public Word(String mDefaultWord, String mMiwokWord, int mImage) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
        this.mImageResourceId = mImage;
    }

    //Constructor with two parameters
    public Word(String mDefaultWord, String mMiwokWord) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
    }

    //Getters of the variables
    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    //method to define if the word class has an image associated or not
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
