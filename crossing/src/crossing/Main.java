package crossing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("crossing.txt");
		List<String> lists = Files.readAllLines(path, Charset.defaultCharset());
		long startTime = System.currentTimeMillis();
		String[] listss = (String[]) lists.toArray(new String[lists.size()]);
		int[] list = new int[listss.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.valueOf(listss[i]);
		}
		long count = 0;
		for (int index = 0; index < list.length; index++) {
			int target = list[index];
			for (int i = index + 1; i < list.length; i++) {
				int compared = list[i];
				if (target > compared) {
					count++;
				}
			}
			for (int i = 0; i < index; i++) {
				int compared = list[i];
				if (target < compared) {
					count++;
				}
			}
		}
		System.out.println(count / 2);
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
