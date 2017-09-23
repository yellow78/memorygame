package com.cowgame.memorygame_savegame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.json.JSONException;
import org.json.JSONObject;

import com.cowgame.memorygame.MainActivity;
import com.cowgame.memorygame.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class savelayout extends Activity {
	public static int score01 = 0;
	public static int score02 = 0;
	public static int score03 = 0;
	public static int score04 = 0;
	public static int score05 = 0;
	public static int score06 = 0;
	public static int score07 = 0;
	public static int score08 = 0;
	public static int score09 = 0;
	public static int score10 = 0;

	private static JSONObject mSettings;
	private TextView no1text;
	private TextView no2text;
	private TextView no3text;
	private TextView no4text;
	private TextView no5text;
	private TextView no6text;
	private TextView no7text;
	private TextView no8text;
	private TextView no9text;
	private TextView no10text;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.savegame);

		mInstance = this;
		init(savelayout.this);
		
		no1text = (TextView) findViewById(R.id.notext1);
		no2text = (TextView) findViewById(R.id.notext2);
		no3text = (TextView) findViewById(R.id.notext3);
		no4text = (TextView) findViewById(R.id.notext4);
		no5text = (TextView) findViewById(R.id.notext5);
		no6text = (TextView) findViewById(R.id.notext6);
		no7text = (TextView) findViewById(R.id.notext7);
		no8text = (TextView) findViewById(R.id.notext8);
		no9text = (TextView) findViewById(R.id.notext9);
		no10text = (TextView) findViewById(R.id.notext10);
		
		no1text.setText(String.valueOf(score01));
		no2text.setText(String.valueOf(score02));
		no3text.setText(String.valueOf(score03));
		no4text.setText(String.valueOf(score04));
		no5text.setText(String.valueOf(score05));
		no6text.setText(String.valueOf(score06));
		no7text.setText(String.valueOf(score07));
		no8text.setText(String.valueOf(score08));
		no9text.setText(String.valueOf(score09));
		no10text.setText(String.valueOf(score10));
	}

	private static savelayout mInstance;

	public static savelayout getInstance() {
		return mInstance;
	}

	private static void readSettings(Context context) {
		File saveFile = new File(context.getFilesDir().getPath() + "/cowmemorygame.dat");
		if (!saveFile.exists()) {
			try {
				mSettings = new JSONObject();
				mSettings.put("score01", 0);
				mSettings.put("score02", 0);
				mSettings.put("score03", 0);
				mSettings.put("score04", 0);
				mSettings.put("score05", 0);
				mSettings.put("score06", 0);
				mSettings.put("score07", 0);
				mSettings.put("score08", 0);
				mSettings.put("score09", 0);
				mSettings.put("score10", 0);
				saveFile.createNewFile();
				FileOutputStream stream = new FileOutputStream(saveFile);
				stream.write(mSettings.toString().getBytes("UTF-8"));
				stream.flush();
				stream.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				FileInputStream stream = new FileInputStream(saveFile);
				byte[] buffer = new byte[stream.available()];
				stream.read(buffer);
				stream.close();

				mSettings = new JSONObject(new String(buffer, "UTF-8"));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeSettings(Context context) {
		try {
			mSettings.put("score01", score01);
			mSettings.put("score02", score02);
			mSettings.put("score03", score03);
			mSettings.put("score04", score04);
			mSettings.put("score05", score05);
			mSettings.put("score06", score06);
			mSettings.put("score07", score07);
			mSettings.put("score08", score08);
			mSettings.put("score09", score09);
			mSettings.put("score10", score10);

		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		File saveFile = new File(context.getFilesDir().getPath() + "/cowmemorygame.dat");
		FileOutputStream stream;
		try {
			stream = new FileOutputStream(saveFile);
			stream.write(mSettings.toString().getBytes("UTF-8"));
			stream.flush();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init(Activity act) {
		readSettings(act.getApplicationContext());
		try {
			score01 = mSettings.getInt("score01");
			score02 = mSettings.getInt("score02");
			score03 = mSettings.getInt("score03");
			score04 = mSettings.getInt("score04");
			score05 = mSettings.getInt("score05");
			score06 = mSettings.getInt("score06");
			score07 = mSettings.getInt("score07");
			score08 = mSettings.getInt("score08");
			score09 = mSettings.getInt("score09");
			score10 = mSettings.getInt("score10");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void backbtn(View v) {
		Intent storeintent = new Intent();
		storeintent.setClass(savelayout.this, com.cowgame.memorygame.MainActivity.class);
		savelayout.this.startActivity(storeintent);
		savelayout.this.finish();
	}
}
