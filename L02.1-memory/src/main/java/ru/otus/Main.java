package ru.otus;

/**
 * \* @author AleKras on 29.10.2023
 * \* Description:
 * \*
 */

import java.lang.management.ManagementFactory;

/**
 * VM options -Xmx512m -Xms512m
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
	public static void main(String... args) throws InterruptedException {
		System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

		int size = 20_000_000;
//
		System.out.println("Starting the loop");
		while (true) {
			System.gc();
			Thread.sleep(10);
			Runtime runtime = Runtime.getRuntime();
			long mem = runtime.totalMemory() - runtime.freeMemory();
			System.out.println("memory "+mem);

			Object[] array = new Object[size];
			long mem2 = runtime.totalMemory() - runtime.freeMemory();
			System.out.println("memory size before objects were created: "+(mem2-mem)/size);

			System.out.println("New array of size: " + array.length + " created");
			for (int i = 0; i < size; i++) {
				array[i] = new Object();
//				array[i] = new String(""); //String pool
//				array[i] = new String(new char[0]); //without String pool
//				array[i] = new MyClass();
			}
			System.out.println("Created " + size + " objects.");
			long mem3 = runtime.totalMemory() - runtime.freeMemory();
			System.out.println("memory size after objects are created: "+(mem3-mem2)/size);

			Thread.sleep(1000); //wait for 1 sec
		}
	}

	private static class MyClass {
		private int i = 0;
		private long l = 1;
	}
}