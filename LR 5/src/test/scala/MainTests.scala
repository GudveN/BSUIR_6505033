import main.scala.Main
import org.scalatest._

class MainTests extends FlatSpec with Matchers {

  //Сравниваем получаемое значение----------------------------------------------------

  it should "find_x equal pre_find_x_recursion_0" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    assert(Main.find_x(TempArray, 2) === Main.pre_find_x_recursion_0(TempArray, 2))
  }

  it should "find_x equal pre_find_x_recursion_1" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    assert(Main.find_x(TempArray, 2) === Main.pre_find_x_recursion_1(TempArray, 2))
  }

  it should "pre_find_x_recursion_1 equal pre_find_x_recursion_0" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    assert(Main.pre_find_x_recursion_1(TempArray, 2) === Main.pre_find_x_recursion_0(TempArray, 2))
  }

  //Сравниваем получаемое значение----------------------------------------------------

  it should "pre_find_extremum_recursion_0 equal pre_find_extremum_recursion_1" in {
    assert(Main.pre_find_extremum_recursion_0(0,10) === Main.pre_find_extremum_recursion_1(0,10))
  }

  //Проверка если не нашли----------------------------------------------------

  it should "If we didn't find the item in array (find_x)" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    Main.find_x(TempArray,10) should be (-1)
  }

  it should "If we didn't find the item in array (pre_find_x_recursion_0)" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    Main.pre_find_x_recursion_0(TempArray,10) should be (-1)
  }

  it should "If we didn't find the item in array (pre_find_x_recursion_1)" in {
    val TempArray = Array[Int] (1, 2, 3, 4, 5)
    Main.pre_find_x_recursion_1(TempArray,10) should be (-1)
  }

  //Проверка на пустой массив----------------------------------------------------

  it should "If the array is empty (find_x)" in {
    val TempArray = Array[Int] ()
    Main.find_x(TempArray,10) should be (-1)
  }

  it should "If the array is empty (pre_find_x_recursion_0)" in {
    val TempArray = Array[Int] ()
    Main.pre_find_x_recursion_0(TempArray,10) should be (-1)
  }

  it should "If the array is empty (pre_find_x_recursion_1)" in {
    val TempArray = Array[Int]()
    Main.pre_find_x_recursion_1(TempArray,10) should be (-1)
  }

  //Проверка на правильность----------------------------------------------------

  it should "The index of the element (find_x)" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    Main.find_x(TempArray,2) should be (1)
  }

  it should "The index of the element (pre_find_x_recursion_0)" in {
    val TempArray = Array[Int](1, 2, 3, 4, 5)
    Main.pre_find_x_recursion_0(TempArray,2) should be (1)
  }

  it should "The index of the element (pre_find_x_recursion_1)" in {
    val TempArray = Array[Int] (1, 2, 3, 4, 5)
    Main.pre_find_x_recursion_1(TempArray,2) should be (1)
  }

  //Проверка если несколько одинаковых значений----------------------------------------------------

  it should "If multiple items are the same (find_x)" in {
    val TempArray = Array[Int](1, 2, 2, 2, 2)
    Main.find_x(TempArray,2) should be (1)
  }

  it should "If multiple items are the same (pre_find_x_recursion_0)" in {
    val TempArray = Array[Int](1, 2, 2, 2, 2)
    Main.pre_find_x_recursion_0(TempArray,2) should be (1)
  }

  it should "If multiple items are the same (pre_find_x_recursion_1)" in {
    val TempArray = Array[Int](1, 2, 2, 2, 2)
    Main.pre_find_x_recursion_1(TempArray, 2) should be(1)
  }

  //Проверка на правильность работы-----------------------------------------------

  it should "Finding the extrema of a series (pre_find_extremum_recursion_0)" in {
    Main.pre_find_extremum_recursion_0(0,4) should be (Array[Int](16,-8,4,3))
  }

  it should "Finding the extrema of a series (pre_find_extremum_recursion_1)" in {
    Main.pre_find_extremum_recursion_1(0,4) should be (Array[Int](16,-8,4,3))
  }

  //Проверка на Begin > End-----------------------------------------------

  it should "If Begin > End (pre_find_extremum_recursion_0)" in {
    Main.pre_find_extremum_recursion_0(4,0) should be (Array[Int](16,-8,4,3))
  }

  it should "If Begin > End (pre_find_extremum_recursion_1)" in {
    Main.pre_find_extremum_recursion_1(4, 0) should be(Array[Int](16, -8, 4, 3))
  }

  //Проверка на Begin < 0 или End < 0 -----------------------------------------------

  it should "If Begin < 0 (pre_find_extremum_recursion_0)" in {
    Main.pre_find_extremum_recursion_0(-1,4) should be (Array[Int](0, 0, 0, 0))
  }

  it should "If End < 0 (pre_find_extremum_recursion_0)" in {
    Main.pre_find_extremum_recursion_0(0, -4) should be(Array[Int](0, 0, 0, 0))
  }

  it should "If Begin < 0 (pre_find_extremum_recursion_1)" in {
    Main.pre_find_extremum_recursion_1(-1,4) should be (Array[Int](0, 0, 0, 0))
  }

  it should "If End < 0 (pre_find_extremum_recursion_1)" in {
    Main.pre_find_extremum_recursion_1(0, -4) should be(Array[Int](0, 0, 0, 0))
  }
}
