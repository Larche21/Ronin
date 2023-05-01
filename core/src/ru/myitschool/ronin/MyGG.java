package ru.myitschool.ronin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;

public class MyGG extends Game {
	public static final int SCR_WIDTH = 1920, SCR_HEIGHT =1080;

	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;
	BitmapFont fontSmall, fontLarge, fontTitle;

	ScreenIntro screenIntro;
	ScreenGame screenGame;
	ScreenGame2 screenGame2;
	ScreenGame3 screenGame3;
	ScreenSettings screenSettings;
	ScreenAbout screenAbout;

	boolean soundOn = true;
	boolean musicOn = true;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();
		generateFont();

		screenIntro = new ScreenIntro(this);
		screenGame = new ScreenGame(this);
		screenGame2 = new ScreenGame2(this);
		screenGame3 = new ScreenGame3(this);
		screenSettings = new ScreenSettings(this);
		screenAbout = new ScreenAbout(this);
		setScreen(screenIntro);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fontSmall.dispose();
		fontLarge.dispose();
	}

	void generateFont(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OLIVIA.TTF"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 60;
		parameter.color = Color.valueOf("000000");
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 2;
		parameter.borderStraight = true;
		parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
		fontSmall = generator.generateFont(parameter);
		parameter.size = 80;
		fontLarge = generator.generateFont(parameter);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("OLIVIA.TTF"));
		parameter.size = 80;
		parameter.color = Color.valueOf("be1616");
		fontTitle = generator.generateFont(parameter);
		generator.dispose();
	}
}
