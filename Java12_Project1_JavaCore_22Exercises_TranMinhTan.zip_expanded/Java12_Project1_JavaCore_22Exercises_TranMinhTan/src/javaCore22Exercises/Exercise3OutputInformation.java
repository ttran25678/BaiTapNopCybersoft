package javaCore22Exercises;

public class Exercise3OutputInformation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println("Java Version: "+System.getProperty("java.version"));
		System.out.println("Java Runtime Version: "+java.lang.Runtime.version());
		System.out.println("Java Home: "+System.getProperty("java.home"));
		System.out.println("Java Vendor: "+System.getProperty("java.vendor"));
		System.out.println("Java Vendor URL: "+System.getProperty("java.vendor.url"));
		System.out.println("Java Class Path: "+System.getProperty("java.class.path"));
	}

}
