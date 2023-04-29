package ru.myitschool.ronin;



import static ru.myitschool.ronin.MyGG.SCR_HEIGHT;
import static ru.myitschool.ronin.MyGG.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    MyGG gg;
    Texture imgBG;
    TextButton btnBack;
    String textAbout =  "THIS IS A GAME ABOUT WAR\n" +
                        "CREATED AT SAMSUNG IT SCHOOL\n" +
                        "WITCH WILL BE INTERESTING\n"+
                        "TO EVERYONE";

    public ScreenAbout(MyGG myGG){
        gg = myGG;
        btnBack = new TextButton(gg.fontLarge, "BACK", 100, 200);
        imgBG = new Texture("About.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
// обработка касаний
        if(Gdx.input.justTouched()) {
            gg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gg.camera.unproject(gg.touch);
            if(btnBack.hit(gg.touch.x, gg.touch.y)){
                gg.setScreen(gg.screenIntro);
            }
        }

        // отрисовка графики
        gg.camera.update();
        gg.batch.setProjectionMatrix(gg.camera.combined);
        gg.batch.begin();
        gg.batch.draw(imgBG, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        gg.fontSmall.draw(gg.batch, textAbout, 500, 650);
        btnBack.font.draw(gg.batch, btnBack.text, btnBack.x, btnBack.y);
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
    public void dispose(){

    }
}
