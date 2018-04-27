package main.scala

import scala.annotation.tailrec

/**
  * Main Object
  * @version 1.0
  * @author GudveN
  */
object Main {
  /**
    * Function to calculate exponential
    * @param exponent degree of number
    * @return function value
    */
  def exponentiate (exponent : Int) : Int = {
    if (exponent == 0)
      1
    else
      -2 * exponentiate (exponent - 1)
  }
  /**
    * The output function of the array
    * @param MASS array to output
    */
  def print_mass(MASS :Array[Int])  = {
    for(x <- MASS.indices) {
      print("\nMASS[" + x + "] = " + MASS(x))
    }
  }
  /**
    * Function for array input
    * @param MASS array to input
    */
  def scanf_mass(MASS : Array[Int]) = {
    for(x <- MASS.indices) {
      print("Enter[" + x + "] : ")
      MASS(x)=scala.io.StdIn.readInt()
    }
  }
  /**
    * A function to input the array size
    * @return array size
    */
  def enter_num():Int = {
    print("\nEnter the number to search : ")
    scala.io.StdIn.readInt()
  }
  /**
    * Function to enter the beginning of a series
    * @return beginning of a series
    */
  def enter_begin() : Int = {
    print("\nEnter BEGIN : ")
    scala.io.StdIn.readInt()
  }
  /**
    * Function to enter the end of the range
    * @return end of a series
    */
  def enter_end() : Int = {
    print("\nEnter END : ")
    scala.io.StdIn.readInt()
  }

  /**
    * Function to find the index of an element in an array (non recursive)
    * @param MASS array to find
    * @param Num the number you want to find
    * @return the index of the element that was found (-1 not found)
    */
  def find_x(MASS:Array[Int], Num:Int) : Int = {
    val X: Int = 0

    val seq = for (X <- MASS.indices if MASS(X) == Num)
      yield X

    val temp : Array[Int] = new Array[Int](seq.length + 1)
    temp(0) = -1
    seq.copyToArray(temp)

    temp(0)
  }

  /**
    * Function to call the main search function (tail recursive)
    * @param MASS array to find
    * @param Num the number you want to find
    * @return the index of the element that was found (-1 not found)
    */
  def pre_find_x_recursion_0(MASS:Array[Int], Num:Int) : Int = {
    /**
      * Function to find the index of an element in an array (tail recursive)
      * @param MASS array to find
      * @param Num the number you want to find
      * @param X index
      * @return the index of the element that was found (-1 not found)
      */
    def find_x_recursion_0(MASS: Array[Int], Num: Int, X: Int): Int = {
      if (X == MASS.length) {
        -1
      }
      else if (MASS(X) == Num) {
        X
      }
      else {
        find_x_recursion_0(MASS, Num, X + 1)
      }
    }
    find_x_recursion_0(MASS,Num,0)
  }

  /**
    * Function to call the main search function (recursive)
    * @param MASS array to find
    * @param Num the number you want to find
    * @return the index of the element that was found (-1 not found)
    */
  def pre_find_x_recursion_1(MASS:Array[Int], Num:Int) : Int = {
    /**
      * Function to find the index of an element in an array (recursive)
      * @param MASS array to find
      * @param Num the number you want to find
      * @param X index
      * @return the index of the element that was found (-1 not found)
      */
    def find_x_recursion_1(MASS: Array[Int], Num: Int, X: Int, Temp: Array[Int]): Int = {
      if (X != MASS.length && MASS(X) != Num) {
        Temp(0) = find_x_recursion_1(MASS, Num, X + 1, Temp)
      }
      if (X != MASS.length && MASS(X) == Num) {
        Temp(0) = X
      }
      else if (X == MASS.length) {
        Temp(0) = -1
      }
      Temp(0)
    }
    find_x_recursion_1(MASS,Num ,0,Array(1,-1))
  }

  /**
    * A function which causes the search of extrema (tail recursive)
    * @param Begin begin of range
    * @param End end of range
    * @return Array ([0] - the maximum value [1] - the minimum value [2] - index of maximum value [3] - index of minimum value)
    */
  def pre_find_extremum_recursion_0(Begin : Int, End : Int): Array[Int] = {
    /**
      * function to search for extrema
      * @param Begin begin of range
      * @param End end of range
      * @param Temp Array ([0] - the maximum value [1] - the minimum value [2] - index of maximum value [3] - index of minimum value)
      * @return Temp
      */
    def find_extremum_recursion_0(Begin: Int, End: Int, Temp: Array[Int]): Array[Int] = {
      if (Begin > End) { //0 - большее 1 - меньшее
        Temp
      }
      else if (exponentiate(Begin) > Temp(0) || exponentiate(Begin) < Temp(1)) {
        if(exponentiate(Begin) > Temp(0)) {
          find_extremum_recursion_0(Begin + 1, End, Array(exponentiate(Begin),Temp(1),Begin,Temp(3)))
        }
        else if(exponentiate(Begin) < Temp(1)) {
          find_extremum_recursion_0(Begin + 1, End, Array(Temp(0),exponentiate(Begin),Temp(2),Begin))
        }
        else {
          find_extremum_recursion_0(Begin + 1, End, Array(exponentiate(Begin),exponentiate(Begin),Begin,Begin))
        }
      }
      else {
        find_extremum_recursion_0(Begin + 1, End, Temp)
      }
    }
    if(Begin > End && Begin >= 0 && End >= 0) {
      find_extremum_recursion_0(End + 1, Begin, Array(exponentiate(End),exponentiate(Begin),End,Begin))
    }
    else if (Begin == End && Begin >= 0 && End >= 0) {
      val temp = Array[Int](Begin, End, exponentiate(Begin), exponentiate(Begin))
      temp
    }
    else if(Begin < 0 || End < 0) {
      val temp = Array[Int](0, 0, 0, 0)
      temp
    }
    else
      find_extremum_recursion_0(Begin + 1, End,Array(exponentiate(Begin),exponentiate(Begin),Begin,Begin))
  }

  /**
    * A function which causes the search of extrema (recursive)
    * @param Begin begin of range
    * @param End end of range
    * @return Array ([0] - the maximum value [1] - the minimum value [2] - index of maximum value [3] - index of minimum value)
    */
  def pre_find_extremum_recursion_1(Begin: Int, End: Int): Array[Int] = {
    /**
      * function to search for extrema
      * @param Begin begin of range
      * @param End end of range
      * @param Temp Array ([0] - the maximum value [1] - the minimum value [2] - index of maximum value [3] - index of minimum value)
      * @return Temp
      */
    def find_extremum_recursion_1(Begin: Int, End: Int, Temp: Array[Int]): Array[Int] = {
      if (Begin == Temp(2)) {
        find_extremum_recursion_1(Begin + 1, End, Array(exponentiate(Begin), exponentiate(Begin), Begin, Begin))
      }
      if (Begin > End) { //0 - большее 1 - меньшее
        Temp
      }
      else if (exponentiate(Begin) > Temp(0) || exponentiate(Begin) < Temp(1)) {
        if (exponentiate(Begin) > Temp(0)) {
          find_extremum_recursion_1(Begin + 1, End, Array(exponentiate(Begin), Temp(1), Begin, Temp(3)))
        }
        else if (exponentiate(Begin) < Temp(1)) {
          find_extremum_recursion_1(Begin + 1, End, Array(Temp(0), exponentiate(Begin), Temp(2), Begin))
        }
        else {
          find_extremum_recursion_1(Begin + 1, End, Array(exponentiate(Begin), exponentiate(Begin), Begin, Begin))
        }
      }
      else {
        find_extremum_recursion_1(Begin + 1, End, Temp)
      }
    }
    if(Begin > End && Begin >= 0 && End >= 0) {
      find_extremum_recursion_1(End, Begin, Array(0, 0, Begin, End))
    }
    else if (Begin == End && Begin >= 0 && End >= 0) {
      val temp = Array[Int](Begin, End, exponentiate(Begin), exponentiate(Begin))
      temp
    }
    else if(Begin < 0 || End < 0) {
      val temp = Array[Int](0, 0, 0, 0)
      temp
    }
    else
      find_extremum_recursion_1(Begin, End, Array(0, 0, Begin, End))
  }

  /**
    * Main function
    * @param args default parametrs
    */
  def main(args: Array[String]): Unit = {
    print("Enter size of mas : ")
    val SIZE_OF_MAS=scala.io.StdIn.readInt()
    val MASS : Array[Int] = new Array[Int](SIZE_OF_MAS)

    scanf_mass(MASS)
    print_mass(MASS)

    val NUMBER_FOR_SEARCH : Int = enter_num()

    print("\nAnswer (-1 = not found) " + find_x(MASS,NUMBER_FOR_SEARCH))
    print("\nAnswer (-1 = not found) " + pre_find_x_recursion_0(MASS,NUMBER_FOR_SEARCH))
    print("\nAnswer (-1 = not found) " + pre_find_x_recursion_1(MASS,NUMBER_FOR_SEARCH))

    //---------------------------------------------------------------------------------------

    val BEGIN : Int = enter_begin()
    val END : Int = enter_end()
    val PRINT = pre_find_extremum_recursion_0(BEGIN,END)
    print("\nAnswer " + PRINT(0))
    print("\nAnswer " + PRINT(1))
    print("\nAnswer " + PRINT(2))
    print("\nAnswer " + PRINT(3) + "\n------------------------")
    val PRINT1 = pre_find_extremum_recursion_1(BEGIN,END)
    print("\nAnswer " + PRINT1(0))
    print("\nAnswer " + PRINT1(1))
    print("\nAnswer " + PRINT1(2))
    print("\nAnswer " + PRINT1(3))
  }
}