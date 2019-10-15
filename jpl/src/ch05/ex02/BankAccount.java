package ch05.ex02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BankAccount {
	private Deque<Action> queue;

	public BankAccount() {
		this.queue = new ArrayDeque<>(10);
	}

	public History history() {
		History history = new History(this.queue);

		return history;
	}

	public void addAction(Action action) {
		//If queue.size() is 10 or more, the first element of queue remove.
		if(this.queue.size() >= 10) {
			queue.poll();
		}
		this.queue.add(action);
	}

	public static class History {
		private List<Action> list;
		private int index = 0;

		private History(Deque<Action> queue) {
			_init(queue);
		}

		public Action next() {

			if(list.size() <= index) {
				return null;
			}
			Action action = list.get(index++);
			return action;
		}

		private void _init(Deque<Action> queue) {
			this.list = new ArrayList<Action>();

			for(Action action : queue) {
				this.list.add(new Action(action));
			}
		}
	}

}
