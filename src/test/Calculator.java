package test;

public class Calculator {

     private  RoundNumber roundNumber;

    public int add(int a, int b){
        return roundNumber.round(a + b);
    }

    public void subtract(){


    }

    public RoundNumber getRoundNumber() {
        return roundNumber;
    }
}
