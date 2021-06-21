package datastructures.graph;

import java.util.*;

public class Permutation {
    List<List<Integer>> permutationsList = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] arr = new int[3];
       LinkedList<Integer> x = new LinkedList<>();
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        Permutation permutation = new Permutation();
        permutation.permute(new ArrayList<Integer>(), permutation.converToList(arr));

    }

    public void permute(List<Integer> part1, List<Integer> part2) {
        System.out.println(" Part 1 " + part1.toString());
        System.out.println(" Part 2 " + part2.toString());
        if (part2.size() == 0) {
            System.out.println("jhere" + part1);
            List x = new ArrayList();
            x.addAll(part1);
            permutationsList.add(x);
            return;
        }

        for (int i = 0; i < part2.size(); i++) {
            ArrayList<Integer> clonedPart1 = new ArrayList<>();
            clonedPart1.addAll(part1);
            clonedPart1.add(part2.get(i));
            List<Integer> part2_new = new ArrayList<>();
            part2_new.addAll(part2.subList(0, i));
            part2_new.addAll(part2.subList(i + 1, part2.size()));
           // part2 = part2_new;
            permute(clonedPart1, part2_new);
            System.out.println(" After Part 1 " + part1.toString());
            System.out.println(" after Part 2 " + part2.toString());
        }
    }

    public List converToList(int[] nums) {
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            newList.add(nums[i]);
        }
        return newList;
    }
}

