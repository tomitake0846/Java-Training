package ch20.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransrateByte {

	public void transrate(char from,char to,String filePath) {
		File inputFile = new File(filePath);
		File outputFile = new File(inputFile.getAbsolutePath() + "convert.txt");

		try(InputStream in = new FileInputStream(inputFile);
			OutputStream out = new FileOutputStream(outputFile);) {
			int dummy;
			while((dummy = in.read()) != -1 ) {
				out.write((dummy == from ? to : dummy ));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
