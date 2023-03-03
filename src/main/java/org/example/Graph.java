package org.example;

import java.util.*;
public class Graph {
    // Java program to print DFS
    // traversal from a given a graph


    // This class represents a
    // directed graph using adjacency
    // list representation
    private int vertices; // No. of vertices

    // Array of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked") Graph(int v)
    {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < vertices; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertices];

        // Initialize stack
        Stack<Integer> stack = new Stack<>();

        // Add the current node to stack
        stack.push(v);

        while (stack.size() > 0) {
            int currentNode = stack.pop(); // grab the current node value off the top of the stack
            System.out.println(currentNode);  // print the current node
            visited[currentNode] = true; // Mark the current node as visited
            for (Integer node : adj[currentNode]) {
                // System.out.println(node);
                if(!visited[node]) {
                    stack.push(node);
                }
            }
        }


        // RECURSIVE OPTION
        // Call the recursive helper
        // function to print DFS
        // traversal
        // DFSUtil(v, visited);
    }

    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertices];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s If an adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
// This code is contributed by Aakash Hasija