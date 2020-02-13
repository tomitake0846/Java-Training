package ch17.ex05;

import java.util.HashMap;
import java.util.Map;

class ResourceImpl implements Resource{

//	private int keyHash;
	private boolean needsRelease = false;
	private Map<Object,Object> resourceMap = new HashMap<Object,Object>();

	ResourceImpl(Object key,Object...args) {
//		keyHash = System.identityHashCode(key);

		//set outer resources.
		resourceMap.put(key, args);

		needsRelease = true;
	}
	public void use(Object key,Object...args ) {
//		if(System.identityHashCode(key) != keyHash) {
//			throw new IllegalArgumentException("wrong key");
//		}
		if(!resourceMap.containsKey(key)) {
			throw new IllegalArgumentException("wrong key");
		}
		if(resourceMap.get(key) == null) {
			throw new IllegalArgumentException("wrong key");
		}

		//use resources
	}

	public synchronized void release() {
		if(needsRelease) {
			needsRelease = false;
		}
		//release resources.
	}

}
