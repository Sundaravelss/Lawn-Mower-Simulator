import java.util.logging.Logger
import services.Mower
import config.AppConfig.inputFile
import models.{Grid, Orientation, Position}
import utils.{FileInputReader, InputReader}

import scala.collection.mutable.ListBuffer

object MowItNowSimulator {

  val logger: Logger = Logger.getLogger(getClass.getName)

  /**
   * Runs the lawn mower simulation based on the provided input.
   *
   * @param inputReader an instance of InputReader to read input data either from File or String
   * @return all mowers with their final positions and final orientation
   */
  def runMowers(inputReader: InputReader): ListBuffer[Mower] = {
    val iterator = inputReader.readInput()

    // Read lawn dimensions
    val lawnDimensions = iterator.next().split(" ")
    val maxGrid = Grid(lawnDimensions(0).toInt, lawnDimensions(1).toInt)

    // List to hold all mowers
    val mowers = scala.collection.mutable.ListBuffer[Mower]()

    // Read mowers and their commands
    while (iterator.hasNext) {
      // Read mower initial position and orientation
      val origin = iterator.next().split(" ")
      val initialPosition = Position(origin(0).toInt, origin(1).toInt)
      val initialOrientation = Orientation.withName(origin(2))
      val mower = new Mower(initialPosition, initialOrientation)

      // Read mower commands
      val commands = iterator.next()
      logger.info(s"Commands: $commands")
      // Execute the commands
      mower.executeCommands(commands, maxGrid)

      // Add mower to the list
      mowers += mower
    }

    // Print final positions and orientation of mowers
    mowers.foreach(mower => println(mower.toString))
    mowers
  }

  def main(args: Array[String]): Unit = {
    val inputReader = new FileInputReader(inputFile)
    try{
      runMowers(inputReader)
    }
    finally{
      inputReader.close()
    }
  }
}
