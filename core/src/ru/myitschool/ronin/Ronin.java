package ru.myitschool.ronin;

import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

public class Ronin {
    float x,y;
    float width , height;
    float vx, vy;
    float targetX, targetY;
    boolean isOnLadder;

    public Ronin(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move() {
        x += vx;
        y += vy;
        if(vx > 0 && x >= targetX || vx < 0 && x <= targetX){
            vx = 0;
            x = targetX;
        }
        if(vy > 0 && y >= targetY || vy < 0 && y <= targetY){
            vy = 0;
            y = targetY;
        }
        //outOfScreen();
    }

    private void outOfScreen() {
        if (x < width / 2) {
            vx = 0;
            x = width / 2;
        }
        if (x > SCR_WIDTH - width / 2) {
            vx = 0;
            x = SCR_WIDTH - width / 2;
        }
    }
    public float scrX() {
        return x-width/2;
    }

    public float scrY() {
        return y;
    }

    void gotoXY(float tx, float ty){
        targetX = tx;
        if(tx>x) vx = 5;
        else vx = -5;

        targetY = ty;
        if(ty>y) vy = 5;
        else vy = -5;
    }

    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y-height < ty && ty < y;
    }
}



