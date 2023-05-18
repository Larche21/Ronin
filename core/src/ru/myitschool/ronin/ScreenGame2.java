package ru.myitschool.ronin;



import static ru.myitschool.ronin.MyGG.SCR_HEIGHT;
import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class ScreenGame2 implements Screen {
    MyGG gg;
    Texture imgGame1;
    TextButton  btnBack;

    Texture imgRonin;
    Texture imgSkel;

    Ronin ronin;
    Skel skel;
    long timeStart;

    float[] levels = new float[]{110, 337, 670}; // уровни экрана

    Ladder[] ladders = new Ladder[2];

    Ladder[] abysses = new Ladder[2]; // пропасти
    public ScreenGame2(MyGG myGG) {
        gg = myGG;
        imgGame1 = new Texture("Game2.png");
        btnBack = new TextButton(gg.fontSmall, "Back", SCR_WIDTH-130, SCR_HEIGHT);
        imgRonin = new  Texture("Ronin.png");
        imgSkel = new Texture("Skel.png");

        ronin = new Ronin(SCR_WIDTH/6f-100,levels[1],130,144);
        ladders[0] = new Ladder(561, 643, levels[1], levels[2]);
        ladders[1] = new Ladder(1659, 1732, levels[0], levels[1]);

        abysses[0] = new Ladder(0, 888, levels[2], levels[2]);
        abysses[1] = new Ladder(992, SCR_WIDTH, levels[0], levels[0]);

        skel = new Skel(SCR_WIDTH/6f+900, levels[2],130,190);

    }


    @Override
    public void show() {
        timeStart = TimeUtils.millis();


    }

    @Override
    public void render(float delta) {
        //касания
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            System.out.println(gg.touch.x +" "+ gg.touch.y);
            if(btnBack.hit(gg.touch.x, gg.touch.y)){
                gg.setScreen(gg.screenIntro);
            } else {
                if(!ronin.isOnLadder) {
                    ronin.gotoXY(gg.touch.x, ronin.y);
                }
                // хождение по лестницам
                for (int i = 0; i < ladders.length; i++) {
                    if(gg.touch.y<ronin.y){ // если нажали ниже ронина
                        if(ronin.x>ladders[i].x1 && ronin.x<ladders[i].x2 && ladders[i].y1<ronin.y){
                            ronin.gotoXY(ladders[i].x, ladders[i].y1);
                            ronin.isOnLadder = true;
                        }
                    } else if(gg.touch.y>ronin.y+ronin.height){ // если нажали выше ронина
                        if(ronin.x>ladders[i].x1 && ronin.x<ladders[i].x2 && ladders[i].y2>ronin.y){
                            ronin.gotoXY(ladders[i].x, ladders[i].y2);
                            ronin.isOnLadder = true;
                        }
                    }
                }
            }
        }



        // события
        ronin.move(levels);
        for (int i = 0; i < levels.length; i++) {
            if(ronin.y == levels[i]){
                ronin.isOnLadder = false;
            }
        }

        if(ronin.isOnLadder) {
            for (int i = 0; i < levels.length; i++) {
                if (ronin.isOnLevel(levels[i])) {
                    ronin.isOnLadder = false;
                }
            }
        }
        if(ronin.die()){
            gg.setScreen(gg.screenIntro);
        }

        // переходы на другие экраны
        if(ronin.x < ronin.width/2){
            gg.screenGame.ronin.x = SCR_WIDTH-gg.screenGame.ronin.width/2;
            gg.screenGame.ronin.y = ronin.y;
            ronin.targetX = ronin.x-ronin.vx;
            gg.setScreen(gg.screenGame);
        }
        if(ronin.x > SCR_WIDTH-ronin.width/2){
            gg.screenGame2.ronin.x = gg.screenGame2.ronin.width/2;
            gg.screenGame2.ronin.y = ronin.y;
            ronin.targetX = ronin.x-ronin.vx;
            gg.setScreen(gg.screenGame3);
        }


        // отрисовка графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgGame1, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnBack.font.draw(gg.batch, btnBack.text, btnBack.x, btnBack.y);
        gg.batch.draw(imgRonin, ronin.scrX(), ronin.scrY(), ronin.width, ronin.height);
        gg.batch.end();
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        imgGame1.dispose();
    }
}
