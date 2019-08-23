package ch01.ex15;

import java.util.HashMap;
import java.util.Map;

public class ExtendedLookup implements ExtendedLookupInterface{
	private Map<String,Object> nameMap;

	public ExtendedLookup() {
		this.nameMap = new HashMap<String,Object>();
	}

	public Object find(String name) {
		if(nameMap.containsKey(name)) {
			return nameMap.get(name);
		} else {
			return null;
		}
	}
	public void add(String name,Object value) {
		if(nameMap.containsKey(name)) {
			throw new RuntimeException("Name ["+name+"] is already used.");
		}  else {
			nameMap.put(name,value);
		}
	}
	public void remove(String name) {
		if(nameMap.containsKey(name)) {
			nameMap.remove(name);
		} else {
			throw new RuntimeException("Name [" + name + "] is not used.");
		}
	}
}
