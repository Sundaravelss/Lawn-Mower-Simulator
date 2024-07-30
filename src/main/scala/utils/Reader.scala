package utils
import scala.io.Source

/**
 * Trait for reading input data.
 */
trait InputReader {
  def readInput(): Iterator[String]
  def close(): Unit
}

/**
 * Class for reading input data from a file.
 *
 * @param filePath the path to the input file
 */
class FileInputReader(filePath: String) extends InputReader {

  private val source = Source.fromFile(filePath)

  override def readInput(): Iterator[String] = {
    source.getLines()
  }

  override def close(): Unit = {
    source.close()
  }
}

/**
 * Class for reading input data from a string.
 *
 * @param input the input string
 */
class StringInputReader(input: String) extends InputReader {

  private val source = Source.fromString(input)

  override def readInput(): Iterator[String] = {
    source.getLines()
  }

  override def close(): Unit = {
    source.close()
  }
}
