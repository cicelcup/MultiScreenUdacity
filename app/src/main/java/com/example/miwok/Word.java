package com.example.miwok;

public class Word {
    private String mMiwokWord;
    private String mdefaultWord;

    public Word(String mMiwokWord, String mdefaultWord) {
        this.mMiwokWord = mMiwokWord;
        this.mdefaultWord = mdefaultWord;
    }

    public String getMdefaultWord() {
        return mdefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }
}
