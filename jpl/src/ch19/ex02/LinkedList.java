package ch19.ex02;
/**<code>Linked List</code>
 *
 * @version 1.0
 * @author test
 * @since 1.0
 */

public class LinkedList {
	/** value **/
	private Object value;

	/** pointer for the next element. **/
	private LinkedList next;

	/** pointer for the first element. **/
	private static LinkedList HEAD;

	/** pointer for the last element.**/
	private static LinkedList TAIL;

	/**
	 * Constractor.
	 * In addition,add argument 'value'  to this LinkedList.
	 * @param value value want to add.
	 */
	public LinkedList(Object value) {
		add(value);
	}
	/**
	 * Constractor without argument.
	 */
	public LinkedList() {};

	/**
	 * add the new value to this LinkedList and update 'HEAD' and 'TAIL'.
	 * @param value value want to add.
	 */
	public void add(Object value) {
		/*create a new LInkedList instance and set the value.*/
		LinkedList item = new LinkedList();
		item.value = value;
		if(LinkedList.HEAD == null) {
			LinkedList.HEAD = item;
			LinkedList.TAIL = item;
		} else {
			LinkedList.TAIL.next = item;
			LinkedList.TAIL = item;
		}
	}
	/**
	 * get 'index'th element from this linkedList.
	 * @param index 'index'th
	 * @return 'index'th element
	 */
	public LinkedList getNode(int index) {
		index --;
		if(index < 0 ) {
			return null;
		}
		LinkedList dummy = LinkedList.HEAD;
		for(int i=0;i<index;i++) {
			if(!dummy.hasMoreElement()) {
				return null;
			}
			dummy = dummy.next;
		}
		return dummy;
	}

	/**
	 * Take out value , this filed's 'value'.
	 * @return this filed's 'value'.
	 */
	public Object getValue() {
		return this.value;
	}
	/**
	 * counting number of element this LinkedList.
	 * @return number of element this LinkedList.
	 */

	public int count() {
		int count=0;

		LinkedList dummy = LinkedList.HEAD;

		if(dummy != null) {
			count++;
		} else {
			return count;
		}

		while(dummy.hasMoreElement()) {
			dummy = dummy.next;
			count ++;
		}

		return count;
	}

	@Override
	/**
	 * return the all element as String type.
	 * @return String.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		LinkedList item;

		int i=1;

		while((item = getNode(i)) != null) {
			sb.append(item.getValue());
			sb.append(",");
			i++;
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * if LInkedList has "next" . it returns true.
	 * @return true ... There is the next element.
	 * false ... There is no more element　, this is last element.
	 * */
	private boolean hasMoreElement() {
		return this.next != null;
	}
}
