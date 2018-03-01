package com.xy.framework.Observable;

import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {

	/**
	 * 业务方法，一旦执行某个操作，则通知观察者
	 */
	public void doBusiness() {
		if (true) {
			System.out.println("=====================");
			super.setChanged();
		}
		notifyObservers("现在还没有的参数");
	}

	public static void main(String[] args) {
		
		Wolf wolf = new Wolf("wolf1");  
		Observer sheep1 = new MailObserver();  
		Observer sheep3 = new JMSObserver();  
        //注册观察者,sheep1,sheep2加入，sheep3未加入  
        wolf.addObserver(sheep1);  
        wolf.addObserver(sheep3);  
        String wolfStat = "hungry";  
        //wolf begin cry  
        wolf.cry(wolfStat);  
	}
}