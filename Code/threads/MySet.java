package threads;

import java.util.ArrayList;
import java.util.List;

public class MySet {
	List myElements = new ArrayList();

	public boolean add(Object o) {
		synchronized (myElements) {
			return myElements.add(o);
		}
	}

	public Object remove() {
		synchronized (myElements) {
			if (myElements.isEmpty() == false)
				return myElements.remove(0); // removes & returns object at position 0
			return null;
		}
	}
}
