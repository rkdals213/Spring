package com.ssafy.s0518.step4.di;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputImpl implements FileOutput{

	@Override
	public void output(String str) {
		try {
			FileWriter fw = new FileWriter("hello.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {e.printStackTrace();}
		
	}//output

}
