package dynamicprogramming;

import java.util.*;
import java.util.stream.IntStream;

public class GCD {

    public void addEdge(int start, int end, double weight ,  Map<Integer,List<Object[]>> adjList ){
        Stack stck = new Stack();

        if(adjList.get(start) == null){
            List<Object[]> edgeInfo = new ArrayList<>();
            edgeInfo.add(new Object[]{end, weight});
            adjList.put(start, edgeInfo);
        }else{
            adjList.get(start).add(new Object[]{end, weight});
            //adjList.put(edges[i][0],new Object[]{edges[i][1], succProb[i]} )
        }
        int[][] arr = new int[][]{new int[]{1,2, 3},new int[]{3,4, 4 }};
        Map<Integer,List> arrmap = new HashMap<>();
        IntStream.range(0, arr.length).forEach(x -> {
            List<int[]> existing = arrmap.get(arr[x][0]) == null ? new ArrayList() :  arrmap.get(arr[x][0]);
            existing.add(new int[]{arr[x][1], arr[x][2]});
            arrmap.put(arr[x][0], existing);
        });
        System.out.println(arrmap);
        int[] vals = (int[])arrmap.get(1).get(0);
        System.out.println(vals[0]);

//
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        PriorityQueue<Object[]> queue = new PriorityQueue<Object[]>((a,b) ->  Double.compare((Double)b[0],(Double) a[0]));
        boolean visited[] = new boolean[n];

        Map<Integer,Double> finalList = new HashMap<Integer,Double>();

        Map<Integer,List<Object[]>> adjList = new HashMap<>();

        for(int i = 0; i < edges.length ;i++){
            addEdge(edges[i][0], edges[i][1], succProb[i], adjList);
            addEdge(edges[i][1], edges[i][0], succProb[i], adjList);

        }
        // [ probability , key ]
        // src --> [dest, probabiltiy ][dest2 , probabilty]
        queue.add(new Object[]{-1.0, start});
        while(!queue.isEmpty()){

            Object[] top =  queue.remove();
            double prob = (Double)top[0];
            int key = (Integer) top[1];
            if(key == end){
                return prob;
            }
            if(visited[key]){
                continue;
            } else {
                visited[key] = true;
                if(adjList.get(key) == null){
                    continue;
                }
                for (Object[] edge : adjList.get(key)) {
                    if((Integer)edge[0] == key){
                        continue;
                    }
                    if (finalList.get(edge[0]) != null &&
                            finalList.get(edge[0]) < Math.abs(prob * (Double) edge[1])) {
                        finalList.put((Integer) edge[0], Math.abs(prob * (Double) edge[1]));
                        queue.add(new Object[]{prob * (Double) edge[1], edge[0]});
                    } else if (finalList.get(edge[0]) == null) {
                        finalList.put((Integer) edge[0], Math.abs(prob * (Double) edge[1]));
                        queue.add(new Object[]{Math.abs(prob * (Double) edge[1]), edge[0]});
                    }
                }
            }
        }
        if(finalList.get(end) != null) {
            return finalList.get(end);
        }else{
            return 0;
        }

    }


    public static void main(String args[]){
        GCD gcd = new GCD();
        double x = gcd.maxProbability(5,new int[][]{
                new int[]{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}, },new double[]
                { 0.37 ,0.17,0.93,0.23,0.39,0.04}, 3,4 );
        System.out.println(x);

    }
}

