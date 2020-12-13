package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {
	public static byte[] read(String path) throws IOException {
		return Files.readAllBytes(Paths.get(path));
	}

	public static List<String> readLine(String path) throws IOException {
		return Files.readAllLines(Paths.get(path));
	}

	public static byte[] reverse(byte[] bytes) {
		byte[] result = new byte[bytes.length];
		for(int i=0;i<result.length;i++) {
			result[i] = bytes[bytes.length - (i+1)];
		}
		return result;
	}
	public static byte[] concat(byte[] x, byte[] y) {
		byte[] result = new byte[x.length + y.length];
		for(int i=0;i<x.length;i++) {
			result[i] = x[i];
		}
		for(int i=0;i<y.length;i++) {
			result[x.length + i] = y[i];
		}
		return result;
	}

	public static void write(byte[] bytes, String path) throws IOException {
		Files.write(Paths.get(path), bytes);
	}
}
