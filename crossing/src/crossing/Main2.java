package crossing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main2 {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Path path = Paths.get("crossing.txt");
		List<String> lists = Files.readAllLines(path, Charset.defaultCharset());
		String[] listStr = (String[]) lists.toArray(new String[lists.size()]);
		int[] listInt = new int[listStr.length];
		for (int i = 0; i < listInt.length; i++) {
			listInt[i] = Integer.valueOf(listStr[i]);
		}
		long count = 0;
		int[] temp = new int[listInt.length];
		for (int i = 0; i < listInt.length; i++) {
			int j = listInt[i] - 1;
			temp[j] = 1;
			for (int j2 = j + 1; j2 < temp.length; j2++) {
				count += temp[j2];
			}
		}
		System.out.println(count);
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
