package designpatterns;

public class EmptyTree<K,V> {
	public static EmptyTree SINGLETON = new EmptyTree();
	
	public EmptyTree getInstance(){
		return SINGLETON;
	}
	
	public void add(K key, V value) {
		throw new UnsupportedOperationException();
		//can't add to this
	}
}
