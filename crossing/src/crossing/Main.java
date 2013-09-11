package crossing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Path path = Paths.get("crossing.txt");
		List<String> lists = Files.readAllLines(path, Charset.defaultCharset());
		String[] listStr = (String[]) lists.toArray(new String[lists.size()]);
		int[] listInt = new int[listStr.length];
		for (int i = 0; i < listInt.length; i++) {
			listInt[i] = Integer.valueOf(listStr[i]);
		}
		ForkJoinPool pool = new ForkJoinPool();
		long count = pool.invoke(new Task(listInt, 0, listInt.length, 1));
		System.out.println(count);
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
