package main.datastructure.implementation;

import java.util.Comparator;
import java.util.Optional;

public class NTree<K,V> implements Comparator<V> {

    public class TreeNode<K,V>{

        private K key;
        private V value;
        private TreeNode<K,V> parent;
        private ArrayList<TreeNode<K,V>> children;

        public TreeNode(K key, V value, TreeNode<K,V> parent){
            this.key=key;
            this.value=value;
            this.parent=parent;
            this.children = new ArrayList<>();
        }

        public K getKey(){return this.key;}
        public V getValue(){return this.value;}
        public TreeNode<K,V> getParent(){return this.parent;}
        public ArrayList<TreeNode<K,V>> getChildren(){return this.children;}

        public void addChild(TreeNode<K,V> child){ children.add(child);}
        public TreeNode<K,V> getSingleChild(int id){
            return Optional.ofNullable(children.get(id)).orElse(null);
        }
    }

    private TreeNode<K,V> root;

    public NTree(){}

    public TreeNode<K,V> getRoot(){return this.root;}

    public void createRoot(V value){ root = new TreeNode<>(null, value, null); }

    public void createRoot(K key, V value){ root = new TreeNode<>(key, value, null); }

    public void insert(V value, TreeNode<K,V> parent){ insert(null, value, root, parent); }

    public void insert(K key, V value, TreeNode<K,V> parent){ insert(key, value, root, parent); }

    public void insert(K key, V value, TreeNode<K,V> parent, TreeNode<K,V> node) {
        if(compare(parent.getValue(), node.getValue()) == 0){
            TreeNode<K,V> newChild = new TreeNode<>(key, value, parent);
            parent.addChild(newChild);
        }

        int len = parent.getChildren().size();

        for(int i = 0 ; i < len; i++){
            insert(key, value, parent.getSingleChild(i), node);
        }
    }

    public void remove(V value, TreeNode<K,V> parent){ remove(null, value, parent); }

    public void remove(K key, V value, TreeNode<K,V> parent) {
        int len = parent.getChildren().size();
        for(int i = 0; i < len; i++){
            if(compare(value, parent.getSingleChild(i).getValue()) == 0){
                parent.getChildren().remove(i);
                break;
            }
            remove(key, value, parent.getSingleChild(i));
        }
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode<K,V> node){
        if(Optional.ofNullable(node).isPresent()){
            int len = node.getChildren().size();
            for(int i = 0; i < len; i++){
                postOrderTraversal(node.getSingleChild(i));
            }
            System.out.println(node.getValue());
        }
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(TreeNode<K,V> node){
        if(Optional.ofNullable(node).isPresent()){
            int len = node.getChildren().size();
            System.out.println(node.getValue());
            for(int i = 0 ; i < len; i++){
                preOrderTraversal(node.getSingleChild(i));
            }
        }
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
