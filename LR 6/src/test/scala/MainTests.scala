import main.scala.Main
import scala.collection.mutable.MutableList
import org.scalatest._

class MainTests extends FlatSpec with Matchers {

  it should "prefunc1 checking for correctness" in {
    val TempArray = Array[Double](1.0, 2.0, -1.0, -2.0, 0.0, 0.0)
    Main.prefunc1(TempArray) should be (MutableList(MutableList(1.0, 2.0, 0.0, 0.0), MutableList(-1.0, -2.0, 0.0, 0.0)))
  }

  it should "prefunc1 123 check for correctness with an empty list." in {
    val TempArray = Array[Double]()
    Main.prefunc1(TempArray) should be (MutableList(MutableList(), MutableList()))
  }

  it should "prefunc1 check for correctness with positive numbers." in {
    val TempArray = Array[Double](1.0, 2.0, 3.0)
    Main.prefunc1(TempArray) should be (MutableList(MutableList(1.0, 2.0, 3.0), MutableList()))
  }

  it should "prefunc1 check for correctness with negative numbers." in {
    val TempArray = Array[Double](-1.0, -2.0, -3.0)
    Main.prefunc1(TempArray) should be (MutableList(MutableList(), MutableList(-1.0, -2.0, -3.0)))
  }

  it should "prefunc1 check for correctness with zeros." in {
    val TempArray = Array[Double](0.0, 0.0, 0.0)
    Main.prefunc1(TempArray) should be (MutableList(MutableList(0.0, 0.0, 0.0), MutableList(0.0, 0.0, 0.0)))
  }

  it should "prefunc2 check for correctness." in {
    val TempArray = Array[Double](1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    Main.prefunc2(TempArray) should be (3.5)
  }

  it should "prefunc2 check for correctness with an empty list." in {
    val TempArray = Array[Double]()
    Main.prefunc2(TempArray) should be (0.0)
  }

  it should "prefunc3 checking for correctness." in {
    val TempArray = Array[String]("ab cd", " ", "gf h")
    Main.prefunc3(TempArray) should be (List[Char]('a','b',' ','c','d',' ','g','f',' ','h'))
  }
}
