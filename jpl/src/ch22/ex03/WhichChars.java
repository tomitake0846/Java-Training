package ch22.ex03;

import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class WhichChars {
	private Map<Byte,BitSet> map;

	public WhichChars(String str) {
		map = new HashMap<Byte,BitSet>();
		byte[] ary;
		for(int i=0;i<str.length();i++) {
			ary = (""+str.charAt(i)).getBytes();

			//if only lower byte (1 byte character)
			if(ary.length == 1) {
				set((byte)0,ary);
			} else {
				set(ary[0],getLowerBytes(ary));
			}
		}
	}

	private void set(byte key,byte[] value) {
		System.out.println(value.length);
		ByteBuffer bb = ByteBuffer.wrap(value);
		System.out.println(bb);
		int i = bb.getInt();
		if(map.containsKey(key)) {
			map.get(key).set(i);
		} else {
			BitSet bs = new BitSet();
			bs.set(i);
			map.put(key, bs);
		}
	}

	public String toString() {
		String desc = "[";

		for(byte key : map.keySet()) {
			BitSet bs = map.get(key);
			long[] lowerBytes = bs.toLongArray();
			byte[] result;
			for(int i=0;i<lowerBytes.length;i++) {
				result = concatUpperAndLower(key,lowerBytes[i]);
				desc += ByteBuffer.wrap(result).getChar() + ",";
			}
		}

		return desc+"]";
	}

	private byte[] getLowerBytes(byte[] bytes) {
		byte[] result = new byte[bytes.length-1];

		for(int i=0;i<result.length;i++) {
			result[i] = bytes[i+1];
		}

		return result;
	}

	private byte[] concatUpperAndLower(byte upper,long lower) {
		ByteBuffer buffer = ByteBuffer.allocate(128);
//		buffer = buffer.putLong(lower);
		buffer.putLong(lower);
		byte[] lowerByte = buffer.array();

		byte[] result = new byte[lowerByte.length + 1];
		result[0] = upper;

		for(int i=1;i<result.length;i++) {
			result[i] = lowerByte[i-1];
		}

		return result;
	}
}
