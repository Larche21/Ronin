package ru.myitschool.ronin;

import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

public class Ronin {
    float x,y;
    float width , height;
    float vx, vy;
    float targetX, targetY;
    boolean isOnLadder;
    boolean isFalling;
    boolean direction; // false - вправо, true - влево

    public Ronin(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(float[] levels) {
        x += vx;
        y += vy;
        if(isFalling) {
            for (int i = 0; i < levels.length; i++) {
                if(isOnLevel(levels[i])){
                    isFalling = false;
                    vy = 0;
                }
            }
        } else {
            if (vx > 0 && x >= targetX || vx < 0 && x <= targetX) {
                vx = 0;
                x = targetX;
            }
            if (vy > 0 && y >= targetY || vy < 0 && y <= targetY) {
                vy = 0;
                y = targetY;
            }
        }

        //outOfScreen();
    }

    boolean die(){
        return y < -height*10;
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
        if(tx>x) {
            vx = 5;
            direction = false;
        }
        else {
            vx = -5;
            direction = true;
        }

        targetY = ty;
        if(ty>y) vy = 5;
        else vy = -5;
    }

    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y-height < ty && ty < y;
    }

    boolean isOnLevel(float yLevel) {
        if(yLevel-Math.abs(vy) < y && y < yLevel+Math.abs(vy)){
            y = yLevel;
            return true;
        }
        return false;
    }
}



