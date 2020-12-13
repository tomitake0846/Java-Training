package ch09.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {
	public static byte[] read(String path) throws IOException {
		return Files.readAllBytes(Paths.get(path));
	}

	public static byte[] reverse(byte[] bytes) {
		byte[] result = new byte[bytes.length];
		for(int i=0;i<result.length;i++) {
			result[i] = bytes[bytes.length - (i+1)];
		}
		return result;
	}

	public static void write(byte[] bytes, String path) throws IOException {
		Files.write(Paths.get(path), bytes);
	}
}
