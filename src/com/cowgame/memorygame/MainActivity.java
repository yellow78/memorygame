package com.cowgame.memorygame;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AdView mAdView = (AdView) findViewById(R.id.layoutadmob);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//		runOnUiThread(new Runnable() {
//            public void run() {
//            	AdView mAdView = (AdView) findViewById(R.id.layoutadmob);
//                AdRequest adRequest = new AdRequest.Builder().addTestDevice("7BB034A969F50CED1ACA447D65980A7A").build();
//                mAdView.loadAd(adRequest);
//            }
//        });
	}

	public void saveclick(View v) {
		Intent storeintent = new Intent();
		storeintent.setClass(MainActivity.this, com.cowgame.memorygame_savegame.savelayout.class);
		MainActivity.this.startActivity(storeintent);
		MainActivity.this.finish();
	}
	
	public void startclick(View v) {
		Dialog dialog = new Dialog(MainActivity.this, R.style.stagepopDialog);// 指定自定義樣式
		dialog.setContentView(R.layout.gamepop);// 指定自定義layout

		// 可自由調整佈局內部元件的屬性
		LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.lldialog);
		ll.getLayoutParams().width = 500;

		Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		
		// dialogWindow.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
//		lp.x = 500; // 新位置X坐標
//		lp.y = 450; // 新位置Y坐標
//		lp.width = 100; // 寬度
//		lp.height = 100; // 高度
//		lp.alpha = 0.7f; // 透明度

		// 新增自定義按鈕點擊監聽
		// Button btn = (Button)dialog.findViewById(R.id.dialog_button_ok);
		// btn.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// }
		// });

		// 顯示dialog
		final SeekBar gamepopseekbar = (SeekBar) dialog.findViewById(R.id.seekBar1);
		
		final TextView seekbartxt = (TextView) dialog.findViewById(R.id.gamepoptext);
		
		final Button gamepopbtn = (Button) dialog.findViewById(R.id.gamepopbtn);
		
		gamepopbtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int seekint = gamepopseekbar.getProgress();
				if(seekint == 0){
					Intent storeintent = new Intent();
					storeintent.setClass(MainActivity.this, com.cowgame.memorygame_gameplay1.playgamelayout.class);
					MainActivity.this.startActivity(storeintent);
					MainActivity.this.finish();
				}
				if(seekint == 35){
					Intent storeintent = new Intent();
					storeintent.setClass(MainActivity.this, com.cowgame.memorygame_gameplay2.playgamelayout.class);
					MainActivity.this.startActivity(storeintent);
					MainActivity.this.finish();
				}
				if(seekint == 70){
					Intent storeintent = new Intent();
					storeintent.setClass(MainActivity.this, com.cowgame.memorygame_gameplay3.playgamelayout.class);
					//storeintent.setClass(mainlayout.this, com.fly.flymemorygame.MainActivity.class);
					MainActivity.this.startActivity(storeintent);
					MainActivity.this.finish();
				}
				if(seekint == 100){
					Intent storeintent = new Intent();
					storeintent.setClass(MainActivity.this, com.cowgame.memorygame_gameplay4.playgamelayout.class);
					//storeintent.setClass(mainlayout.this, com.fly.flymemorygame.MainActivity.class);
					MainActivity.this.startActivity(storeintent);
					MainActivity.this.finish();
				}
			}
			
		});

		gamepopseekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				int seekint = gamepopseekbar.getProgress();
				if(seekint < 25){
					gamepopseekbar.setProgress(0);
					seekbartxt.setText("6X4");
				}
				if(seekint >= 25 && seekint < 50){
					gamepopseekbar.setProgress(35);
					seekbartxt.setText("6X5");
				}
				if(seekint >= 50 && seekint < 75){
					gamepopseekbar.setProgress(70);
					seekbartxt.setText("6X6");
				}
				if(seekint >= 75){
					gamepopseekbar.setProgress(100);
					seekbartxt.setText("6X8");
				}
			}
		});
		dialog.show();
	}
	
}
