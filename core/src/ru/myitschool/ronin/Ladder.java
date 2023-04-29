package ru.myitschool.ronin;
public class Ladder {
    float x1, x2, y1, y2;
    float x; // центр лестницы

    public Ladder(float x1, float x2, float y1, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        x = x1 + (x2 - x1) / 2;
    }
}
