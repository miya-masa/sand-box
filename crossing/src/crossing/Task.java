package crossing;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Long> {

	private static final int THRESHOLD = 128;
	// private static final int THRESHOLD = 2;

	private int[] listInt;

	private int startIndex;
	private int lastIndex;

	public Task(int[] listInt, int startIndex, int lastIndex) {
		this.listInt = listInt;
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
	}

	@Override
	protected Long compute() {
		if (lastIndex - startIndex < THRESHOLD) {
			long count = 0;
			for (int index = startIndex; index < lastIndex; index++) {
				int target = listInt[index];
				for (int i = index + 1; i < listInt.length; i++) {
					int compared = listInt[i];
					if (target > compared) {
						count++;
					}
				}
				for (int i = 0; i < index; i++) {
					int compared = listInt[i];
					if (target < compared) {
						count++;
					}
				}
			}
			return count;
		} else {
			int half = (lastIndex - startIndex) / 2;
			Task task = new Task(listInt, startIndex, startIndex + half);
			task.fork();
			Task task2 = new Task(listInt, startIndex + half, lastIndex);
			task2.fork();
			return task2.join() + task.join();
		}

	}

}
