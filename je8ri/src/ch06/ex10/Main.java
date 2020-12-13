package ch06.ex10;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException{
		URL url = WebUtils.toURL("https://www-creators.com/archives/5039");

		CompletableFuture.supplyAsync(() -> WebUtils.readPage(url))
		.handle((u,error) -> {
			if(error != null) {
				System.err.println(error.getMessage());
				System.exit(1);
			}
			return u;
		})
		.thenApply(list -> WebUtils.getLinks(list))
		.handle((u,error) -> {
			if(error != null) {
				System.err.println(error.getMessage());
				System.exit(1);
			}
			return u;
		})
		.thenAccept(links -> {
			for(URL u : links) System.out.println(u);
		});
		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
		}
	}
