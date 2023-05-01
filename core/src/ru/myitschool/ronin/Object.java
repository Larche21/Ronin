package ru.myitschool.ronin;

public class Object {

    float x,y;
    float width , height;
    float vx,vy;

    public Object(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float scrX() {
        return x-width/2;
    }

    public float scrY() {
        return y-height/2;
    }

    public void move(){
        x += vx;
        y += vy;
    }
}
