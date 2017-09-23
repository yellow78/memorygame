package com.cowgame.memorygame;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageButton;

public final class StartAnimationCon {

//	private static ImageButton imgbtn;
//	static int backimg;

//	public static void StartAnimationCon(float start, float end, ImageButton imgbtnstart, int img) {
//		// 计算中心点
//		backimg = img;
//		imgbtn = imgbtnstart;
//		final float centerX = imgbtn.getWidth() / 2.0f;
//		final float centerY = imgbtn.getHeight() / 2.0f;
//		// Create a new 3D rotation with the supplied parameter
//		// The animation listener is used to trigger the next animation
//		// final Rotate3dAnimation rotation =new Rotate3dAnimation(start, end,
//		// centerX, centerY, 310.0f, true);
//		// Z轴的缩放为0
//		Rotate3dAnimation rotation = new Rotate3dAnimation(start, end, centerX, centerY, 0f, true);
//		rotation.setDuration(250);
//		rotation.setFillAfter(true);
//		// rotation.setInterpolator(new AccelerateInterpolator());
//		// 匀速旋转
//		rotation.setInterpolator(new LinearInterpolator());
//		// 设置监听
//		StartNextRotate startNext = new StartNextRotate();
//		rotation.setAnimationListener(startNext);
//		imgbtn.startAnimation(rotation);
//	}

	public static void StartAnimationCon(float start, float end, ImageButton imgbtnstart, int img) {
		// 计算中心点
		final int backimg = img;
		final ImageButton imgbtn = imgbtnstart;
		float centerX = imgbtn.getWidth() / 2.0f;
		float centerY = imgbtn.getHeight() / 2.0f;
		// Create a new 3D rotation with the supplied parameter
		// The animation listener is used to trigger the next animation
		// final Rotate3dAnimation rotation =new Rotate3dAnimation(start, end,
		// centerX, centerY, 310.0f, true);
		// Z轴的缩放为0
		Rotate3dAnimation rotation = new Rotate3dAnimation(start, end, centerX, centerY, 0f, true);
		rotation.setDuration(250);
		rotation.setFillAfter(true);
		// rotation.setInterpolator(new AccelerateInterpolator());
		// 匀速旋转
		rotation.setInterpolator(new LinearInterpolator());
		// 设置监听
		rotation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
//				animation.cancel();
//				imgbtn.clearAnimation();
//				imgbtn.animate().cancel();
//				rotation.setAnimationListener(null);
//				imgbtn.setImageResource(backimg);
//				final float centerX = imgbtn.getWidth() / 2.0f;
//				final float centerY = imgbtn.getHeight() / 2.0f;
//				// Create a new 3D rotation with the supplied parameter
//				// The animation listener is used to trigger the next animation
//				// final Rotate3dAnimation rotation =new
//				// Rotate3dAnimation(start, end,
//				// centerX, centerY, 310.0f, true);
//				// Z轴的缩放为0
//				final Rotate3dAnimation rotation2 = new Rotate3dAnimation(270, 360, centerX, centerY, 0f, true);
//				rotation2.setDuration(250);
//				// rotation.setInterpolator(new AccelerateInterpolator());
//				// 匀速旋转
//				rotation2.setInterpolator(new LinearInterpolator());
//				rotation2.setAnimationListener(new AnimationListener(){
//
//					@Override
//					public void onAnimationStart(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onAnimationEnd(Animation animation) {
//						// TODO Auto-generated method stub
//						animation.cancel();
//						imgbtn.clearAnimation();
//						imgbtn.animate().cancel();
//						rotation2.setAnimationListener(null);
//					}
//
//					@Override
//					public void onAnimationRepeat(Animation animation) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//				});
//				imgbtn.startAnimation(rotation2);

				AnimationNoListener(270, 360, imgbtn, backimg);
			}
		});
		imgbtn.startAnimation(rotation);
	}

	public static void AnimationNoListener(float start, float end, ImageButton imgbtnstart, int img) {
		int backimg = img;
		ImageButton imgbtn = imgbtnstart;
		imgbtn.setImageResource(backimg);
		float centerX = imgbtn.getWidth() / 2.0f;
		float centerY = imgbtn.getHeight() / 2.0f;
		// Create a new 3D rotation with the supplied parameter
		// The animation listener is used to trigger the next animation
		// final Rotate3dAnimation rotation =new
		// Rotate3dAnimation(start, end,
		// centerX, centerY, 310.0f, true);
		// Z轴的缩放为0
		Rotate3dAnimation rotation2 = new Rotate3dAnimation(270, 360, centerX, centerY, 0f, true);
		rotation2.setDuration(250);
		// rotation.setInterpolator(new AccelerateInterpolator());
		// 匀速旋转
		rotation2.setInterpolator(new LinearInterpolator());
		imgbtn.startAnimation(rotation2);
	}
//
//	public static class StartNextRotate implements AnimationListener {
//
//		public void onAnimationEnd(Animation animation) {
//			// TODO Auto-generated method stub
//			AnimationNoListener(270, 360);
//			// imgbtn.startAnimation(rotation);
//		}
//
//		public void onAnimationRepeat(Animation animation) {
//			// TODO Auto-generated method stub
//
//		}
//
//		public void onAnimationStart(Animation animation) {
//			// TODO Auto-generated method stub
//
//		}
//
//	}

}

