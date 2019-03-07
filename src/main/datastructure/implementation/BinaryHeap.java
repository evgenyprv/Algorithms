package main.datastructure.implementation;

import main.datastructure.PriorityQueue;

@SuppressWarnings("rawtypes")
public class BinaryHeap<V extends Comparable> implements PriorityQueue<V> {
	
	private int size;
	private ArrayList<HeapEntry<V>> heap;
	
	@SuppressWarnings("hiding")
	public class HeapEntry<V extends Comparable>{
		
		private V value;
		
		public HeapEntry(V value) {
			this.value = value;
		}

		public V getValue() {return value;}		
	}
	
	public BinaryHeap() {this(0);}

	public BinaryHeap(int flag) {
		heap = new ArrayList<>();
		size = 0;
	}
	
	@Override
	public int size() {return size;}

	@Override
	public boolean isEmpty() {return size == 0;}

	@Override
	public V peek() {return heap.get(0).getValue();}
	
	
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
	public void add(V value) {
		HeapEntry<V> newEntry = new HeapEntry<>(value);
		heap.add(newEntry);
		size++;
		upHeapify(this.size()-1);
	}
	
	@SuppressWarnings("unchecked")
	private void upHeapify(int child) {
		int parent = parent(child);

		if (!(heap.get(parent).getValue().compareTo(heap.get(child).getValue()) <= 0)){
			swap(parent, child);
			upHeapify(parent);
		}

	}

	public V remove() {
		V result = heap.get(0).getValue();
		heap.set(0, heap.remove(--size));
		downHeapify(0);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private void downHeapify(int parent) {
		if(!isLeaf(parent)) {
		
			if(heap.get(this.left(parent)).getValue().compareTo(heap.get(parent).getValue()) < 0){
				int left = this.left(parent);
				swap(parent, left);
				downHeapify(left);
			}
			
			if(heap.get(parent).getValue().compareTo(heap.get(this.right(parent)).getValue()) > 0){
				int right = this.right(parent);
				swap(parent, right);
				downHeapify(right);
			}
		}
	}
	
	private void swap(int parentId, int childId) {
		HeapEntry<V> parent = heap.get(parentId);
		HeapEntry<V> child = heap.get(childId);
		heap.set(parentId, child);
		heap.set(childId, parent);
		parent = null;
		child = null;
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
}
