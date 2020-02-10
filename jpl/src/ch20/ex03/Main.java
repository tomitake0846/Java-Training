package ch20.ex03;

import java.io.IOException;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) {

		String target = "abracatabra!";
		try {
			String enc = encrypto(target);
			System.out.println(enc);
			String dec = decrypto(enc);
			System.out.println(dec);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public static String encrypto(String target) throws IOException{
		StringReader src = new StringReader(target);
		EncryptoOutputStream  fr = new EncryptoOutputStream(src);
		StringBuilder sb = new StringBuilder();
		int c;
		while( (c = fr.Encrypto(13)) != -1 ) {
			sb.append((char)c);
		}
		fr.close();
		return sb.toString();
	}
	public static String decrypto(String target) throws IOException{
		StringReader src = new StringReader(target);
		DecryptoInputStream  fr = new DecryptoInputStream(src);
		StringBuilder sb = new StringBuilder();
		int c;
		while( (c = fr.Decrypto(13)) != -1 ) {
			sb.append((char)c);
		}
		fr.close();
		return sb.toString();
	}
}
