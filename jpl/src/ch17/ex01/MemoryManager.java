package ch17.ex01;

public class MemoryManager {
	private Runtime rt;
	public MemoryManager() {
		this.rt = Runtime.getRuntime();
	}

	public long getCurrentFreeMemory() {
		return this.rt.freeMemory();
	}
	public void callGC() {
		rt.gc();
	}
}
