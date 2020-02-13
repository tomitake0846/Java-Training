package ch17.ex05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>,Resource> refs;
	boolean shutdown = false;
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>,Resource>();
	}

	//shutdownメソッド実行時に、queue内の参照をすべて解放
	public synchronized void shutdown() {
		if(!shutdown) {
			shutdown = true;
		}

		Reference<?> ref = null;
		while((ref = queue.poll()) != null) {
			Resource res = refs.get(ref);
			refs.remove(ref);
			res.release();
			ref.clear();
		}
	}

	public synchronized Resource getResource(Object key) {
		if(shutdown) {
			throw new IllegalStateException();
		}
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key,queue);
		refs.put(ref,res);
		return res;
	}

}
