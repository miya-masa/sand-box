package crossing;

import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Long> {

	// private static final int THRESHOLD = 128;
	private static final int FRONT_THRESHOLD = 128;
	private static final int LAST_THRESHOLD = 1024;

	private int[] listInt;

	private int place;

	private int startIndex;
	private int lastIndex;

	public Task(int[] listInt, int startIndex, int lastIndex, int place) {
		this.listInt = listInt;
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
		this.place = place;
	}

	@Override
	protected Long compute() {
		if ((place == 1 && lastIndex - startIndex < FRONT_THRESHOLD)
				|| (place == 2 && lastIndex - startIndex < LAST_THRESHOLD)) {
			long count = 0;
			for (int index = startIndex; index < lastIndex; index++) {
				int target = listInt[index];
				for (int i = index + 1; i < listInt.length; i++) {
					// 自分より後ろに定義されている数字で小さいものをカウント
					int compared = listInt[i];
					if (target > compared) {
						count++;
					}
				}
			}
			return count;
		} else {
			int half = (lastIndex - startIndex) / 20;
			Task task = new Task(listInt, startIndex, startIndex + half, 1);
			task.fork();
			Task task2 = new Task(listInt, startIndex + half, lastIndex, 2);
			task2.fork();
			return task2.join() + task.join();
		}

	}
}
