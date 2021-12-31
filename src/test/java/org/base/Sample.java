package org.base;

import java.io.IOException;

public class Sample {
	public static void main(String[] args) throws IOException {
		LibGLobal lobal = new LibGLobal();
		lobal.getDriver();
		
		lobal.loadUrl("https://adactinhotelapp.com/");
		lobal.maximize();
		
		
		
		
	}

}
