package exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Graph{
    public Set<Integer> nodes;
    int edgeCount=0;
    int nodesCount=0;
    public Map<Integer,List<Integer>> adjList;

    public Graph(){
        nodes = new HashSet<>();
        adjList = new HashMap<>();
    }

    public void insert(int node){
        nodes.add(node);
        nodesCount++;
        adjList.put(node, new LinkedList<>());
    }

    public void makeEdge(int node1 , int node2){
        if(nodes.contains(node1) && nodes.contains(node2)){
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
            edgeCount++;
        }
    }


    public List<Integer> getNeighbors(int node){
        
        return adjList.getOrDefault(node,null);
    }


    public int evenLevelsSum(int root){
        Queue<Integer> queue = new LinkedList<>();
        int sum=0;

        if(nodesCount==0 || edgeCount ==0) return 0;

        // add the root witht level 1
        queue.add(root);
        int level = 1;


        while(!queue.isEmpty()){
                int len = queue.size();
                /*
                 * for all nodes of this level:
                 *  insert its neighbors in the queue
                 *  if this level is even then add its nodes to the sum 
                 */
                for(int i =0 ; i < len ; i++ ){
                    int node = queue.poll();
                    if(getNeighbors(node)!=null)
                    for(int neighbor: getNeighbors(node)){
                        queue.add(neighbor);
                    }
                    if(level%2==0) sum+=node;
                }
                // increment for next level
                level++;
        }
        return sum;
    }


    public void makeGraphDirected(){
        if(nodesCount>0 && edgeCount>0)
        adjList.forEach((node,neighbors)->{
            if(neighbors!=null)
            neighbors.forEach(neighbor->{
                if(getNeighbors(neighbor)!=null)getNeighbors(neighbor).remove(node);
            });
        });
    }

    public void printGraph(){
        adjList.forEach((node,neighbors)->{
            neighbors.forEach(neighbor->{
                System.out.println(node+" --> "+neighbor);
            });
        });
    }
}

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();

        /*---- READING INPUT----- */
        int nodesCount = sc.nextInt();

        for(int i = 0 ; i < nodesCount ; i++){
            graph.insert(sc.nextInt());
        }

        for(int i = 0 ; i < nodesCount-1 ; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph.makeEdge(node1, node2);
        }

        /*------------- Solution ------- */

        // this will prevent infinit loop
        graph.makeGraphDirected();

        System.out.println(graph.evenLevelsSum(1));

        // List<Integer> l=null;
        // for(int n: l){
        //     System.out.println(n);
        // }

    }
    
}
