package ru.myitschool.ronin;



import static ru.myitschool.ronin.MyGG.SCR_HEIGHT;
import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class ScreenGame implements Screen {
    MyGG gg;
    Texture imgGame1;
    TextButton  btnBack;

    Texture imgRonin;

    Ronin ronin;
    long timeStart;



    public ScreenGame(MyGG myGG) {
        gg = myGG;
        imgGame1 = new Texture("Game1.png");
        btnBack = new TextButton(gg.fontSmall, "Back", SCR_WIDTH-130, SCR_HEIGHT);
        imgRonin = new  Texture("Ronin.png");

        ronin = new Ronin(SCR_WIDTH/6f-100,433,500,500);

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
            if(btnBack.hit(gg.touch.x, gg.touch.y)){
                gg.setScreen(gg.screenIntro);
            }
            if(Gdx.input.isTouched()) {
                gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                gg.camera.unproject(gg.touch);
                ronin.vx = (gg.touch.x-ronin.x)/70;
            }
        }



    // события
        ronin.move();


    // отрисовка графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgGame1, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnBack.font.draw(gg.batch, btnBack.text, btnBack.x, btnBack.y);
        /*gg.batch.draw(imgRonin,-400,7,SCR_WIDTH,SCR_HEIGHT);*/
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


