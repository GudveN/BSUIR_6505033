import scala.collection.mutable.MutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

public static void main(String[] args){

    Scanner in = new Scanner(System.in);

    System.out.print("Enter size of mas : ");

    final int SIZE_OF_MAS=in.nextInt();

    double[] MASS;

   String[] MASSSTRING;

    try {
        MASS = new double[SIZE_OF_MAS];
        MASSSTRING = new String[SIZE_OF_MAS];
    }
    catch (NegativeArraySizeException ex){
        return;
    }

    for(int i=0; i<SIZE_OF_MAS; i++){
        System.out.printf("MASS[" + i + "] = ");
        MASS[i]=in.nextDouble();
    }

    for(int i=0; i<SIZE_OF_MAS; i++){
        System.out.printf("STRING[" + i + "] = ");
        MASSSTRING[i]=in.next();
    }

    System.out.printf("\nFirst function : " + main.scala.Main.prefunc1(MASS) + "\n------------------\n");

    System.out.printf("Second function : " + main.scala.Main.prefunc2(MASS) + "\n------------------\n");

    System.out.printf("Third function : " +  main.scala.Main.prefunc3(MASSSTRING) + "\n------------------\n");
}

}
