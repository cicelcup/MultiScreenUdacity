package com.example.miwok;

public class Word {
    private String mMiwokWord;
    private String mDefaultWord;

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
}
