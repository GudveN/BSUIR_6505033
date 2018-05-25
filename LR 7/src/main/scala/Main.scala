package main.scala

import scala.annotation.tailrec
import scala.collection.mutable.MutableList


//2. Для переданной строки все буквы первой половины алфавита сделать строчными, а
//второй половины прописными.

//3. Реализовать три класса, не имеющих общего предка: Feather(с методом douse),
//Pen(с методом removeCap) и Pencil(с методом sharpen). Реализовать функцию,
//получающую объект какого-либо из этих типов и вызвать у объекта имеющийся у
//него метод.

/**
  * Main Object
  * @version 1.0
  * @author GudveN
  */
object Main {

  //АНГЛ A-M БОЛЬШИЕ N-Z МАЛЕНЬКИЕ
  //РУСК А-П БОЛЬШИЕ Р-Я МАЛЕНЬКИЕ
  //
  def func1(temp: String) : StringBuilder   = {
    val answer = new StringBuilder
    for (x <- temp.indices) {
      temp(x) match {
        case ' ' => {
          answer += temp(x)
        }
        case _ if temp(x).isDigit => {
          answer += temp(x)
        }
        case _ => {
          if (temp(x).isLetter) {
            if (temp(x) >= 'a' && temp(x) <= 'm' || temp(x) >= 'а' && temp(x) <= 'п') {
              answer += temp(x).toUpper
            }
            else if (temp(x) >= 'N' && temp(x) <= 'Z' || temp(x) >= 'Р' && temp(x) <= 'Я') {
              answer += temp(x).toLower
            }
            else {
              answer += temp(x)
            }
          }
          else {
            answer += temp(x)
          }
        }
      }
    }
    answer
  }

  case class Feather(name: String) {
    def douse(temp : String) : Boolean = {
      if(name == temp) {
        true
      }
      else {
        false
      }
    }
  }

  case class PenClass(name: String) {
    def removeCap(temp : String) : Boolean = {
      if(name == temp) {
        true
      }
      else {
        false
      }
    }
  }

  case class Pencil(name: String) {
    def sharpen(temp : String) : Boolean = {
      if(name == temp) {
        true
      }
      else {
        false
      }
    }
  }


  def func2(a : Any, temp: String) : StringBuilder= {
    val answer = new StringBuilder
    answer ++= "FALSE"
    a match {
      case b : Feather => {
        if(b.douse(temp)) {
          answer.clear()
          answer ++= "TRUE"
        }
        answer ++= " Feather"
      }
      case c : PenClass => {
        if(c.removeCap(temp)) {
          answer.clear()
          answer ++= "TRUE"
        }
        answer ++= " Pen"
      }
      case d: Pencil => {
        if(d.sharpen(temp)) {
          answer.clear()
          answer ++= "TRUE"
        }
        answer ++= " Pencil"
      }
      case _ => {
        answer.clear()
        answer ++= "ERROR"
      }
    }
    answer
  }

  def main(args: Array[String]): Unit = {
    val abcd: String = "abcdASD34 fdAd12ZZz$#@ ADSz"
    val abcd1: String = "dsf423vcbcvaADFXVDEWR"
    println(func1(abcd1))
    println(abcd1)
    val OBJ1 = new Feather("Feather")
    val OBJ2 = new PenClass("Pen")
    val OBJ3 = new Pencil("Pencil")
    println(func2(OBJ1,"Feather"))
  }
}