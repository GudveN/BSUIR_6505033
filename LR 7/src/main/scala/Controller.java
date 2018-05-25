import scala.collection.mutable.MutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

public static void main(String[] args){

    Scanner in = new Scanner(System.in);

    System.out.print("Enter string : ");
    String MASSSTRING;
    try {
        MASSSTRING = in.nextLine();
    }
    catch (Exception ex){
        return;
    }

    System.out.print("Enter a CHANGE : ");
    int Change;
    try {
        Change = in.nextInt();
    }
    catch (Exception ex){
        return;
    }

    main.scala.Main.Feather OBJ1 = new main.scala.Main.Feather("Feather");
    main.scala.Main.Pencil OBJ2 = new main.scala.Main.Pencil("Pencil");
    main.scala.Main.PenClass OBJ3 = new main.scala.Main.PenClass("PenClass");

    System.out.printf("\nFirst function : " + main.scala.Main.func1(MASSSTRING) + "\n------------------\n");

    switch (Change) {
        case 1:{
            System.out.printf("Second function : " + main.scala.Main.func2(OBJ1,MASSSTRING) + "\n------------------\n");
            break;
        }
        case 2:{
            System.out.printf("Second function : " + main.scala.Main.func2(OBJ2,MASSSTRING) + "\n------------------\n");
            break;
        }
        case 3:{
            System.out.printf("Second function : " + main.scala.Main.func2(OBJ3,MASSSTRING) + "\n------------------\n");
            break;
        }
    }
}

}
