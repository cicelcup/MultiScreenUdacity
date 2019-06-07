/*Word class for storage the words in English, miwok and its corresponding image*/
package com.example.miwok;

class Word {
    //Attributes established
    private String mMiwokWord;
    private String mDefaultWord;
    private int mSound;
    //Constant for defining the no image provided
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Constructor with four parameters
    Word(String mDefaultWord, String mMiwokWord, int mImage, int mSound) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
        this.mImageResourceId = mImage;
        this.mSound = mSound;
    }

    //Constructor with three parameters
    Word(String mDefaultWord, String mMiwokWord, int mSound) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
        this.mSound = mSound;
    }

    //Getters of the variables
    String getDefaultWord() {
        return mDefaultWord;
    }

    String getMiwokWord() {
        return mMiwokWord;
    }

    int getImageResourceId() {
        return mImageResourceId;
    }

    int getSound() {
        return mSound;
    }

    //method to define if the word class has an image associated or not
    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /*method to String for testing the attributes from a class
    @Override
    public String toString() {
        return "Word{" +
                "mMiwokWord='" + mMiwokWord + '\'' +
                ", mDefaultWord='" + mDefaultWord + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mSound=" + mSound +
                '}';
    }
    */
}
