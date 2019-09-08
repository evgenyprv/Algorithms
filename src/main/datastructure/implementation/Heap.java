package main.datastructure.implementation;

import java.util.Comparator;

import main.datastructure.Entry;
import main.datastructure.PriorityQueue;

public class Heap<K, V> implements PriorityQueue<K, V>, Comparator<V> {
	
	private int size;
	private ArrayList<HeapEntry<K, V>> heap;

	public class HeapEntry<K, V> implements Entry<K,V> {
		
		private V value;
		private K key;
		
		public HeapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {return key;}
		public V getValue() {return value;}

	}

	public Heap() {
		heap = new ArrayList<>();
		size = 0;
	}
	
	@Override
	public int size() {return size;}

	@Override
	public boolean isEmpty() {return size == 0;}

	@Override
	public Entry<K,V> peek() {return heap.get(0);}
	
	public int left(int index) {
		return 2 * index + 1;
	}
	
	public int right(int index) {
		return 2* index + 2;
	}
	
	public int parent(int index) {
		return (index - 1) / 2;
	}
	
	public boolean isLeaf(int index) {
		if(this.left(index) < this.size() && this.right(index) < this.size()) {
			if(heap.get(this.left(index)) != null || heap.get(this.right(index)) != null) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void add(K key, V value) {
		HeapEntry<K, V> newEntry = new HeapEntry<>(key, value);
		heap.add(newEntry);
		size++;
		upHeapify(this.size()-1);
	}
	
	private void upHeapify(int child) {
		int parent = parent(child);

		if (!(compare(heap.get(parent).getValue(),heap.get(child).getValue()) <= 0)){
			swap(parent, child);
			upHeapify(parent);
		}

	}
	
	@Override
	public Entry<K, V> remove() {
		HeapEntry<K, V> result = heap.get(0);
		heap.set(0, heap.remove(--size));
		downHeapify(0);
		return result;
	}

	private void downHeapify(int parent) {
		if(!isLeaf(parent)) {
		
			if(compare(heap.get(this.left(parent)).getValue(),heap.get(parent).getValue()) < 0){
				int left = this.left(parent);
				swap(parent, left);
				downHeapify(left);
			}
			
			if(compare(heap.get(parent).getValue(),heap.get(this.right(parent)).getValue()) > 0){
				int right = this.right(parent);
				swap(parent, right);
				downHeapify(right);
			}
		}
	}
	
	private void swap(int parentId, int childId) {
		HeapEntry<K, V> parent = heap.get(parentId);
		HeapEntry<K, V> child = heap.get(childId);
		heap.set(parentId, child);
		heap.set(childId, parent);
	}
	
	public String toString() {
		int len = heap.size();
		
		String result = "[";
		
		for(int i = 0; i < len; i++) {
			if(i+1 == len) {
				result += heap.get(i).getValue() + "]";
				break;
			}
			result += heap.get(i).getValue() + ", ";
		}
		return result;
	}

	@Override
	public int compare(V o1, V o2) {
		if(Math.abs(o1.hashCode()) < Math.abs(o2.hashCode())) {
			return -1;
		}else if(Math.abs(o1.hashCode())  > Math.abs(o2.hashCode())) {
			return 1;
		}else {
			return 0;
		}
	}
}
