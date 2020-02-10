package ch20.ex09;

import java.io.File;

public class FileProperty {

	public void print(String...pathes) {
		for(String path : pathes) {
			print(path);
		}
	}
	public void print(String path) {
		File file = new File(path);
		if(!file.exists()) {
			return;
		}
		System.out.println("path :"+file.getAbsolutePath());
		System.out.println("name :"+file.getName());
		System.out.println("parent :" + file.getParent());
		System.out.println("totalSpace :"+file.getTotalSpace());
		System.out.println("usableSpace :" + file.getUsableSpace());
		System.out.println("size :"+file.length());
		System.out.println("canExecute :"+file.canExecute());
		System.out.println("canRead :"+file.canRead());
		System.out.println("canWrite :"+file.canWrite());
		System.out.println("is file :"+file.isFile());
		System.out.println("is directory :"+file.isDirectory());
		System.out.println("is hidden :" + file.isHidden());
	}
}
