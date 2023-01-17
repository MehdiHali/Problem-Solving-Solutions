package graphs;

import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.Queue;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

class Graph {
    Set<Integer> nodes;
    int edgeCount;
    Map<Integer,List<Integer>> adjList; 

    public Graph(){
        this.nodes = new HashSet<Integer>();
        adjList = new HashMap<Integer,List<Integer>>();
        edgeCount=0;
    }

    public void add(int node){
        nodes.add(node);
        adjList.put(node,new LinkedList<Integer>());
    }

    public void makeEdge(int node1, int node2){
        if(nodes.contains(node1) && nodes.contains(node2)){
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
            edgeCount++;
        }
    }

    public List<Integer> getNeighbors(int node){
        return adjList.getOrDefault(node, null);
    }

    public void printGraph(){
        adjList.forEach((node,neighbors)->{
            for(int neighbor: neighbors)
                System.out.println(node+"-->"+neighbor);
        });
    }

    public int evenLevelsSum(int root){
        // CRAZY STUFF !!!
        Deque<Integer> queue = new LinkedList<Integer>();
        queue.add(root);
        int level = 1;
        int sum=0;
        while(!queue.isEmpty()){

            for(int node: queue){
                for(int neighbor: getNeighbors(node)){
                    queue.add(neighbor);
                    if(level%2!=0) sum += neighbor;
                }
                queue.remove(node);
            }
            level++;
        }
        return sum;
    }

    // root level 1
    public int evenLevelsSum(int root, int level){
        List<Integer> neighbors = getNeighbors(root);
        int sum=0;
        if(!neighbors.isEmpty())
            for(int node: neighbors) evenLevelsSum(node, level+1);

        if(level%2!=0) return sum+0; 
        else return sum+1;
    }
}

public class TreePuzzl {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.nextLine();

        Graph graph = new Graph();
        for(int i = 0 ; i< n ; i++){
            int node = sc.nextInt();
            graph.add(node);
        }
        for(int i = 0 ; i < n-1 ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.makeEdge(start, end);
        }



        graph.printGraph();
        System.out.println("sum even levels: "+graph.evenLevelsSum(1));

    }
}
