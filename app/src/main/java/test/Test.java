package test;

/**
 * Created by apple on 16/11/28.
 */

public class Test {
    public static void main(String []args){
        new Thread(() -> {System.out.print("ll");}).start();
    }
}
