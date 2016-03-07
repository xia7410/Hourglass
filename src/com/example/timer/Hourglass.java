package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.TextView;

/**
 * 沙漏，用于显示倒计时的封装类
 * @author YeXuDong
 *
 */
public class Hourglass {
	
	private Timer timer = new Timer();
	private TextView textView;
	private int number;
	private String string;
	private Handler handler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0x123:
				textView.setText(number-- + string);
				break;

			default:
				break;
			}
		};
		
	};
	
	/**
	 * 
	 * @param tv 传入TextView控件
	 * @param num 传入倒计时的总秒数
	 * @param str 传入时间数字后面的文字
	 */
	public Hourglass(TextView tv, int num, String str){
		textView = tv;
		number = num;
		string = str;
	}
	
	/**
	 * 执行倒计时操作
	 */
	public void time(){		
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(number != -1){
					handler.sendEmptyMessage(0x123);
				} else {
					timer.cancel();
				}
			}
		}, 0, 1000);
		
	}
	
}
