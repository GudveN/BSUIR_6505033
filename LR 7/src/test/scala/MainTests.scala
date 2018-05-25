import java.lang

import main.scala.Main
import main.scala.Main.{Feather, PenClass, Pencil}

import scala.collection._
import org.scalatest._

class MainTests extends FlatSpec with Matchers {

  it should "func1 checking for correctness" in {
    val TempString : String = "dsf423vcbcvaADFXVDEWR"
    val TestString = new StringBuilder
    TestString ++= "DsF423vCBCvAADFxvDEwr"
    Main.func1(TempString) should be (TestString)
  }

  it should "func1 checking for empty string" in {
    val TempString : String = ""
    val TestString = new StringBuilder
    TestString ++= ""
    Main.func1(TempString) should be (TestString)
  }

  val OBJ1 = new Pencil("Penclil")
  val OBJ2 = new PenClass("PenClass")
  val OBJ3 = new Feather("Feather")

  it should "func2 checking for correctness with other data" in {
    val TestString = new StringBuilder
    TestString ++= "ERROR"
    Main.func2(123, "Penclil") should be (TestString)
  }

  it should "func2 checking for correctness Pencil OBJECT true" in {
    val TestString = new StringBuilder
    TestString ++= "TRUE Pencil"
    Main.func2(OBJ1, "Penclil") should be (TestString)
  }

  it should "func2 checking for correctness Pencil OBJECT false" in {
    val TestString = new StringBuilder
    TestString ++= "FALSE Pencil"
    Main.func2(OBJ1, "Penclil_FAIL") should be (TestString)
  }

  it should "func2 checking for correctness PenClass OBJECT true" in {
    val TestString = new StringBuilder
    TestString ++= "TRUE Pen"
    Main.func2(OBJ2, "PenClass") should be (TestString)
  }

  it should "func2 checking for correctness PenClass OBJECT false" in {
    val TestString = new StringBuilder
    TestString ++= "FALSE Pen"
    Main.func2(OBJ2, "PenClass_FAIL") should be (TestString)
  }

  it should "func2 checking for correctness Feather OBJECT true" in {
    val TestString = new StringBuilder
    TestString ++= "TRUE Feather"
    Main.func2(OBJ3, "Feather") should be (TestString)
  }

  it should "func2 checking for correctness Feather OBJECT false" in {
    val TestString = new StringBuilder
    TestString ++= "FALSE Feather"
    Main.func2(OBJ3, "Feather_FAIL") should be (TestString)
  }

}
