package ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTMLReader {
	public static InputStream readURL(String url) throws IOException {
		URL u = new URL(url);
		return u.openStream();
	}
	public static void copy(InputStream in,String path,CopyOption...options) throws IOException {
		Files.copy(in, Paths.get(path),options);
	}
}
