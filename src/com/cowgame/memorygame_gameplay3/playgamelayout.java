package com.cowgame.memorygame_gameplay3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.cowgame.memorygame.R;
import com.cowgame.memorygame.StartAnimationCon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class playgamelayout extends Activity {

	int[] showcards;
	private ImageButton savebtn1;
	private ImageButton savebtn2;
	private TextView combotext;
	private TextView scoretext;
	int saveimage1, saveimage2, closeimage;
	int runbtn = 0;
	int checkcards = 0;
	int combo = 0;
	int score = 0;

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

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playgame3);

		mInstance = this;
		init(playgamelayout.this);

		closeimage = R.drawable.back;

		combotext = (TextView) findViewById(R.id.textView2);
		scoretext = (TextView) findViewById(R.id.textView4);

		// 洗牌
		Shuffle();
	}

	private static playgamelayout mInstance;

	public static playgamelayout getInstance() {
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

	// 洗牌
	public void Shuffle() {
		int[] cards = new int[18];
		cards[0] = R.drawable.card1;
		cards[1] = R.drawable.card2;
		cards[2] = R.drawable.card3;
		cards[3] = R.drawable.card4;
		cards[4] = R.drawable.card5;
		cards[5] = R.drawable.card6;
		cards[6] = R.drawable.card7;
		cards[7] = R.drawable.card8;
		cards[8] = R.drawable.card9;
		cards[9] = R.drawable.card10;
		cards[10] = R.drawable.card11;
		cards[11] = R.drawable.card12;
		cards[12] = R.drawable.card13;
		cards[13] = R.drawable.card14;
		cards[14] = R.drawable.card15;
		cards[15] = R.drawable.card16;
		cards[16] = R.drawable.card17;
		cards[17] = R.drawable.card18;

		showcards = new int[36];

		ArrayList<Integer> cardslist = new ArrayList();
		for (int a = 0; a < 18; a++) {
			cardslist.add(cards[a]);
			cardslist.add(cards[a]);
		}
		for (int a = 0; a < 36; a++) {
			int random = (int) (Math.random() * cardslist.size());
			showcards[a] = cardslist.get(random);
			cardslist.remove(random);
		}

	}

	// 判斷牌面
	public void cardbtn(ImageButton imagebtn, int cardnumber) {
		if (runbtn == 0) {
			savebtn1 = imagebtn;
			saveimage1 = cardnumber;
			StartAnimationCon.StartAnimationCon(0, 90, savebtn1, saveimage1);
			runbtn++;
		}

		if (runbtn == 1 & savebtn1 != imagebtn) {
			savebtn2 = imagebtn;
			saveimage2 = cardnumber;
			StartAnimationCon.StartAnimationCon(0, 90, savebtn2, saveimage2);
			runbtn++;
		}

		if (runbtn == 2 & saveimage2 == saveimage1 & savebtn1 != imagebtn & savebtn2 != imagebtn) {
			savebtn1.setEnabled(false);
			savebtn2.setEnabled(false);
			savebtn1 = imagebtn;
			saveimage1 = cardnumber;
			StartAnimationCon.StartAnimationCon(0, 90, savebtn1, saveimage1);
			runbtn = 1;
			score = score + combo * 2 * 100 + 100;
			combo = combo + 1;
			combotext.setText(String.valueOf(combo));
			scoretext.setText(String.valueOf(score));

			checkcards++;
		}

		if (runbtn == 2 & saveimage2 != saveimage1 & savebtn1 != imagebtn & savebtn2 != imagebtn) {
			StartAnimationCon.StartAnimationCon(0, 90, savebtn1, closeimage);
			StartAnimationCon.StartAnimationCon(0, 90, savebtn2, closeimage);
			savebtn1 = imagebtn;
			saveimage1 = cardnumber;
			StartAnimationCon.StartAnimationCon(0, 90, savebtn1, saveimage1);
			combo = 0;
			runbtn = 1;
		}

		if (checkcards == 17) {
			if (runbtn == 2 & saveimage2 == saveimage1) {
				score = score + combo * 2 * 100 + 100;
				combo = combo + 1;
				combotext.setText(String.valueOf(combo));
				scoretext.setText(String.valueOf(score));
				if (score > score01) {
					score01 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第一名");
					dialog.show();
				} else if (score > score02) {
					score02 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第二名");
					dialog.show();
				} else if (score > score03) {
					score03 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第三名");
					dialog.show();
				} else if (score > score04) {
					score04 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第四名");
					dialog.show();
				} else if (score > score05) {
					score05 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第五名");
					dialog.show();
				} else if (score > score06) {
					score06 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第六名");
					dialog.show();
				} else if (score > score07) {
					score07 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第七名");
					dialog.show();
				} else if (score > score08) {
					score08 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第八名");
					dialog.show();
				} else if (score > score09) {
					score09 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第九名");
					dialog.show();
				} else if (score > score10) {
					score10 = score;
					writeSettings(playgamelayout.getInstance().getApplicationContext());
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("挑戰成功!排行榜第十名");
					dialog.show();
				} else {
					AlertDialog.Builder dialog = new AlertDialog.Builder(playgamelayout.this);
					dialog.setTitle("恭喜過關");
					dialog.setMessage("可惜沒進入排行榜");
					dialog.show();
				}
			}
		}

	}

	public void backbtn(View v) {
		Intent storeintent = new Intent();
		storeintent.setClass(playgamelayout.this, com.cowgame.memorygame.MainActivity.class);
		playgamelayout.this.startActivity(storeintent);
		playgamelayout.this.finish();
	}

	public void imgbtnon(View v) {

		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton1);
		int cardnumber = showcards[0];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon2(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton2);
		int cardnumber = showcards[1];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon3(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton3);
		int cardnumber = showcards[2];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon4(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton4);
		int cardnumber = showcards[3];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon5(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton5);
		int cardnumber = showcards[4];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon6(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton6);
		int cardnumber = showcards[5];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon7(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton7);
		int cardnumber = showcards[6];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon8(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton8);
		int cardnumber = showcards[7];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon9(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton9);
		int cardnumber = showcards[8];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon10(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton10);
		int cardnumber = showcards[9];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon11(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton11);
		int cardnumber = showcards[10];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon12(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton12);
		int cardnumber = showcards[11];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon13(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton13);
		int cardnumber = showcards[12];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon14(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton14);
		int cardnumber = showcards[13];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon15(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton15);
		int cardnumber = showcards[14];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon16(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton16);
		int cardnumber = showcards[15];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon17(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton17);
		int cardnumber = showcards[16];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon18(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton18);
		int cardnumber = showcards[17];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon19(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton19);
		int cardnumber = showcards[18];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon20(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton20);
		int cardnumber = showcards[19];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon21(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton21);
		int cardnumber = showcards[20];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon22(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton22);
		int cardnumber = showcards[21];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon23(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton23);
		int cardnumber = showcards[22];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon24(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton24);
		int cardnumber = showcards[23];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon25(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton25);
		int cardnumber = showcards[24];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon26(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton26);
		int cardnumber = showcards[25];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon27(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton27);
		int cardnumber = showcards[26];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon28(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton28);
		int cardnumber = showcards[27];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon29(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton29);
		int cardnumber = showcards[28];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon30(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton30);
		int cardnumber = showcards[29];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon31(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton31);
		int cardnumber = showcards[30];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon32(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton32);
		int cardnumber = showcards[31];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon33(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton33);
		int cardnumber = showcards[32];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon34(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton34);
		int cardnumber = showcards[33];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon35(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton35);
		int cardnumber = showcards[34];

		cardbtn(btnme, cardnumber);
	}

	public void imgbtnon36(View v) {
		ImageButton btnme = (ImageButton) this.findViewById(R.id.imageButton36);
		int cardnumber = showcards[35];

		cardbtn(btnme, cardnumber);
	}
}
