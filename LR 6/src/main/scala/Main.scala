package main.scala

import scala.annotation.tailrec
import scala.collection.mutable.MutableList


//19.Разделить коллекцию на две. В первой должны быть только положительные элементы,
//а во второй только отрицательные.
//9. Подсчитать среднее значение элементов в List[Double].
//2. Из списка строк сгенерировать список символов этих строк.
//IN: List("1", "2-3", "4 5")
//OUT: List("1", "2", "-", "3", "4", " ", "5")

/**
  * Main Object
  * @version 1.0
  * @author GudveN
  */
object Main {

  implicit def arrayToList[A](a: Array[A]) = a.toList

  def prefunc1(temp: Array[Double]) : MutableList[MutableList[Double]] = {
    def function1(numbers: MutableList[Double]): MutableList[MutableList[Double]] = {
      val positive = new MutableList[Double]
      val negative = new MutableList[Double]
      for (x <- numbers.indices) {
        if (numbers(x) > 0)
          positive += numbers(x)
        else if (numbers(x) < 0)
          negative += numbers(x)
        else {
          positive += numbers(x)
          negative += numbers(x)
        }
      }
      val answer = MutableList(positive, negative)
      answer
    }
    val tempList = new MutableList[Double]
    for(x <- temp.indices)
      tempList += temp(x)
    function1(tempList)
  }

  def prefunc2(temp: Array[Double]) : Double = {
    def function2(mass: List[Double]): Double = {
      val answer = mass.fold(0.0)(_ + _) / mass.length
      answer
    }
    val tempList = arrayToList(temp)
    if(tempList.isEmpty == false)
      function2(tempList)
    else
      0
  }

  def prefunc3(temp: Array[String]): List[Char] = {
    def function3(mass: List[String]): List[Char] = {
      val test = mass.flatMap { x => x }
      test
    }
    val templist = arrayToList(temp)
    function3(templist)
  }
}