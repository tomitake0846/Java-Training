package ch17.ex04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>,Resource> refs;
	final Thread reaper;
	boolean shutdown = false;
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>,Resource>();
		reaper = new ReaperThread();
		reaper.start();
	}
	public synchronized void shutdown() {
		if(!shutdown) {
			shutdown = true;
			reaper.interrupt();
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


	class ReaperThread extends Thread{
		public void run() {
			boolean running = true;
			Reference<?> ref = null;
			//queueが空ではない or shutdownがfalse
			while(running || (ref = queue.poll()) != null) {
				try {
					if(ref == null) {
						ref = queue.remove();
					}
					Resource res = null;
					synchronized(ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch(InterruptedException e) {
					running = false;
				}
			}
		}
	}

}
