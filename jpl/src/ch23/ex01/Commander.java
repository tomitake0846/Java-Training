package ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Commander {

	private final int BUFFER_SIZE = 1024;

	public Process UserProg(String cmd) throws IOException {
		String command = "cmd /c " + cmd;
		Process p = Runtime.getRuntime().exec(command);

		// standard input(keyboad)
		plugTogether(System.in,p.getOutputStream());


		plugTogether(System.out,p.getInputStream());
		plugTogether(System.err,p.getErrorStream());
		return p;
	}

	// is ... standard input(keybord)
	private void plugTogether(InputStream is,OutputStream os) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		int offset=0;
		is.read(buffer,offset,buffer.length - offset);
		os.write(buffer);
	}

	private void plugTogether(OutputStream os,InputStream is) throws IOException{
		byte[] buffer = new byte[BUFFER_SIZE];
		int offset=0;
		while( (is.read(buffer,offset,buffer.length - offset)) != -1) {
			os.write(buffer);
		}
	}
}
