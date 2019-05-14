package com.kitri.jdbctest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
	
public class PropertiesTest {
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(new File("src\\com\\kitri\\jdbctest\\test.properties")));
			String name = prop.getProperty("name_cn");
			System.out.println(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
