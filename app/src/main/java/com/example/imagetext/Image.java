package com.example.imagetext;

import java.util.Random;

public class Image {
    private String resourceImage;
    private int number;

    private int plus, minus;


    private int odd;


    public int getPlus() {
        number++;
        return number;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public int getMinus() {
        number--;
        return number;
    }

    public void setMinus(int minus) {
        this.minus = minus;
    }

    public Image(String resourceImage, int number) {
        this.resourceImage = resourceImage;
        this.number = number;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getNumber() {
        Random random = new Random();
        number = random.nextInt(100);

        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



}
