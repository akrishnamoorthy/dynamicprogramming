package dynamicprogramming;

import java.util.ArrayList;
/**
 * By Self
 */
/**
 * STar item is an item greater than all items on right
 * super star is greater than all item on right and left
 *
 * 10 2 300 45 67 44 30 10
 * Star = 30 , 44 ,67 , 300
 * Super start = 300
 *
 * 1 200 4 59 6 7 44 9 100 2
  */
public class StarSupserStar {

    public static void main(String arg[]){
        ArrayList<Integer> listofintegers = new ArrayList<>();
        Integer star = null;

        listofintegers.add(1);
        listofintegers.add(2);
        listofintegers.add(4);
        listofintegers.add(59);
        listofintegers.add(6);
        listofintegers.add(7);
        listofintegers.add(44);
        listofintegers.add(9);
        listofintegers.add(0);
        listofintegers.add(2);

        int index = listofintegers.size()-1;
        star = listofintegers.get(index);
        System.out.println("Star " + star);
        while(index >= 0){
            int number = listofintegers.get(index);
            if(number > star){
                star = number;
                System.out.println("Star " + star);
            }
            index --;
        }
        System.out.println("Super Star " + star);

    }


}
