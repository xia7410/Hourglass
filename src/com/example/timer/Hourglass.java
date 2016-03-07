package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.TextView;

/**
 * ɳ©��������ʾ����ʱ�ķ�װ��
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
	 * @param tv ����TextView�ؼ�
	 * @param num ���뵹��ʱ��������
	 * @param str ����ʱ�����ֺ��������
	 */
	public Hourglass(TextView tv, int num, String str){
		textView = tv;
		number = num;
		string = str;
	}
	
	/**
	 * ִ�е���ʱ����
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
