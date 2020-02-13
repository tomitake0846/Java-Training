package ch17.ex02;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	public byte[] readFile(File file) {

		byte[] data;
		if(lastFile != null) {
			if(file.equals(lastFile.get())) {
				data = lastData.get();
				if(data != null) {
					return data;
				}
			}
		}
		data = readByteFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;


	}

	private byte[] readByteFromFile(File file) {
		Path p = file.toPath();
		byte[] result=null;
		try {
			result = Files.readAllBytes(p);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;
	}
}
