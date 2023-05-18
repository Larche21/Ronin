package ru.myitschool.ronin;

public class Skel {
    float x, y;
    float width, height;
    float vx, vy;

    public Skel(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float scrX() {
        return x-width/2;
    }

    public float scrY() {
        return y;
    }
}

