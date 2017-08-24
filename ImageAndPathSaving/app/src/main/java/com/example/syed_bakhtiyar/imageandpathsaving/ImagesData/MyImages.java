package com.example.syed_bakhtiyar.imageandpathsaving.ImagesData;

/**
 * Created by Syed_Bakhtiyar on 8/20/2017.
 */
public class MyImages {

    byte[] images;

    String path;

    int imageNumber;


    public MyImages(byte[] images, String path,int imageNumber) {
        this.images = images;
        this.path = path;
        this.imageNumber = imageNumber;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getImages() {
        return images;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {

        this.imageNumber = imageNumber;
    }

    public String getPath() {
        return path;
    }


}
