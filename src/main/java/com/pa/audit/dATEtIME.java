package com.pa.audit;

import java.util.Random;

import org.springframework.boot.SpringApplication;

public class dATEtIME {

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("PA-"+System.currentTimeMillis()+"-"+random.nextLong());
		
		
	}
	
}
