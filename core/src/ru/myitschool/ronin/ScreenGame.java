package ru.myitschool.ronin;



import static ru.myitschool.ronin.MyGG.SCR_HEIGHT;
import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenGame implements Screen {
    MyGG gg;
    Ronin ronin;
    Texture imgGame1;
    TextButton  btnExit;

    public ScreenGame(MyGG myGG) {
        gg = myGG;
        imgGame1 = new Texture("Game1.png");
        btnExit = new TextButton(gg.fontSmall, "EXIT", SCR_WIDTH-120, SCR_HEIGHT);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //касания
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            if(btnExit.hit(gg.touch.x, gg.touch.y)){
                gg.setScreen(gg.screenIntro);
            }
        }



    // события


    // отрисовка графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgGame1, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnExit.font.draw(gg.batch, btnExit.text, btnExit.x, btnExit.y);
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


