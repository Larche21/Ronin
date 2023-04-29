package ru.myitschool.ronin;

import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

public class Ronin  extends  Object {


    public Ronin(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public void move() {
        super.move();
        outOfScreen();
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
    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y-height < ty && ty < y;
    }
}


