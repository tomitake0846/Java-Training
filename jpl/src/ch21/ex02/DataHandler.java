package ch21.ex02;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.WeakHashMap;

public class DataHandler {
	Map<File,byte[]> weakMap = new WeakHashMap<File,byte[]>();
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	public byte[] readFile(File file) {
		byte[] data;
		if(weakMap.containsKey(file)) {
			data = weakMap.get(file);
			if(data != null) {
				return data;
			}
		}

		data = readByteFromFile(file);
		weakMap.put(file, data);
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
