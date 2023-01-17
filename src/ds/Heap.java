package ds;

public class Heap {
    int[] nodes;
    int size;                

    public Heap(int size){
        nodes = new int[size];
        this.size = 0;
    }

    public int leftChild(int idx){
        return nodes[2*idx +1];
    }

    public int rightChild(int idx){
        return nodes[2*idx +2];
    }

    public int parent(int idx){
        return (idx%2==0)?(idx-2)/2:(idx-1)/2;
    }

    private void swap(int idx1, int idx2){
        int tmp  = nodes[idx1];
        nodes[idx1]= nodes[idx2];
        nodes[idx2]= tmp;
    }

    private void heapifyUp(){
        int lastNodeIndex = size-1;
        while(lastNodeIndex>0 && nodes[parent(lastNodeIndex)] < nodes[lastNodeIndex]){
            swap(parent(lastNodeIndex),lastNodeIndex);
            lastNodeIndex=parent(lastNodeIndex);
        }
    }

    public void insert(int value){
        if(size<nodes.length-1){
            nodes[size] = value;
            size++;
            heapifyUp();
        }
        else System.out.println("max size exceeded");
   }

   public int peak(){
    return nodes[0];
   }

   public void heapifyDown(){
    int peakIndex = 0;
    boolean swaped=true;
    while(peakIndex < size && swaped){
        if(nodes[rightChild(peakIndex)] > nodes[peakIndex]) swap(peakIndex, rightChild(peakIndex));
        else if(nodes[leftChild(peakIndex)] > nodes[peakIndex]) swap(peakIndex, leftChild(peakIndex));
        else swaped=false;
    }
   }

   public int remove(){
    if(size <= 0) return -1;
    int peak = peak();
    nodes[0] = nodes[size-1];
    size--;
    heapifyDown();

    return peak;
   }

   private void _inOrderPrint(int root){
    if(root >= size) return;
    System.out.print(" --> "+nodes[root]);
    _inOrderPrint(2*root+1);
    _inOrderPrint(2*root+2);
   }
   public static void inOrderPrint(Heap heap){
    heap._inOrderPrint(0);
   }

   public static void main(String[] args) {
    Heap heap = new Heap(50);
    heap.insert(8);
    heap.insert(24);
    heap.insert(98);
    heap.insert(1);

    Heap.inOrderPrint(heap);
    System.out.println();
    System.out.println("peak: "+heap.peak());
    System.out.println(heap.remove());
    System.out.println(heap.remove());
    System.out.println(heap.remove());
    System.out.println(heap.remove());

   }
 
}