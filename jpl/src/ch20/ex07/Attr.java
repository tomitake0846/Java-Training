package ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Attr implements Serializable{
	private final String name;
	private String value = null;
	public Attr(String name) {
		this.name = name;
	}
	public Attr(String name,String value) {
		this.name = name;
		this.value = value;
	}

	public Attr(File file) throws IOException{
		try(FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);) {
			this.name = dis.readUTF();
			this.value = dis.readUTF();
		}
	}

	public void writeAttr(String path) throws IOException{
		File file = new File(path);
		try(FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);) {
			dos.writeUTF(this.name);
			dos.writeUTF(this.value);
		}
	}

	public String getName() {
		return this.name;
	}
	public Object getValue() {
		return this.value;
	}
	public String setValue(String newValue) {
		String oldValue = this.value;
		this.value = newValue;
		return oldValue;
	}
	public String toString() {
		return name+"='" + value +"'";
	}

}
