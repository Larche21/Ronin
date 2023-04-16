package ru.myitschool.ronin;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenGame implements Screen {
    MyGG gg;
    Ronin ronin;
    Texture imgGame1;




    public ScreenGame(MyGG myGG) {
        gg = myGG;
        imgGame1 = new Texture("Game1.png");








    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //касания

        } /*else if(isGyroscopePresent) {
            ship.vx = Gdx.input.getGyroscopeY()*10;
        }*/

        // события



        // отрисовка графики


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


