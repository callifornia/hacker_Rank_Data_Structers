package Arrays
import scala.io.StdIn
import scala.util.Try
object A1 {

  def readSize(): Option[Int] = {
    print("Enter array size: ")
    Try(StdIn.readInt()).toOption
  }

  def readArray(): Option[Array[Int]] = {
    print("Enter arrays elements: ")
    Try(StdIn.readLine()).toOption
      .filter(_.nonEmpty)
      .map(inputAsString => {
        inputAsString.split(" ").map(_.toInt)
      })
  }

  def makeRevertedArrayBySize(arraySize: Option[Int],
                              arraysElements: Option[Array[Int]]): Option[Array[Int]] = {

    for {
      size <- arraySize
      elements <- arraysElements
    } yield elements.take(size).reverse
  }

  def main(args: Array[String]): Unit = {
    val arraySize = readSize()
    val arrayNumbers = readArray()
    val result = makeRevertedArrayBySize(arraySize, arrayNumbers)
      .map(_.mkString(", "))
      .getOrElse("Array is empty")

    println(result)
  }
}
