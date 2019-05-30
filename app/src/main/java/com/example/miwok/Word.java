package com.example.miwok;

public class Word {
    private String mMiwokWord;
    private String mDefaultWord;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String mDefaultWord, String mMiwokWord, int mImage) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
        this.mImageResourceId = mImage;
    }

    public Word(String mDefaultWord, String mMiwokWord) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
