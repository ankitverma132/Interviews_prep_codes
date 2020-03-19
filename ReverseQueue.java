package StackAndQueue;

public class ReverseQueue {

	public static void main(String[] args) throws QueueEmptyException {

		QueueUsingLL queueLL = new QueueUsingLL();

		for (int i = 1; i <= 5; i++) {
			queueLL.enqueue(i);
		}
		reverseQueue(queueLL);

		while (!queueLL.isEmpty()) {
			try {
				System.out.println(queueLL.dequeue());
			} catch (QueueEmptyException e) {

			}
		}

	}

	public static void reverseQueue(QueueUsingLL<Integer> q) throws QueueEmptyException {

		if (q.size() == 0) {
			return;
		}

		int temp = q.dequeue();
		reverseQueue(q);
		q.enqueue(temp);

	}
}
