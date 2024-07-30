package services

import java.util.logging.{Level, Logger}
import exceptions.InvalidCommandException
import models.Orientation.*
import models.{Grid, Orientation, Position}
import utils.Helper.checkWithinBounds

/**
 * Class representing a Mower with its position and orientation.
 *
 * @param position    initial position of the mower
 * @param orientation initial orientation of the mower
 */
class Mower(var position: Position, var orientation: Orientation) {

  val logger: Logger = Logger.getLogger(getClass.getName)

  /**
   * Rotates the mower to the left without moving
   */
  private def gauche(): Unit = {
    orientation = orientation match {
      case N => W
      case E => N
      case S => E
      case W => S
    }
    logger.info(s"Turned left. New orientation: $orientation")
  }

  /**
   * Rotates the mower to the right without moving
   */
  private def droit(): Unit = {
    orientation = orientation match {
      case N => E
      case E => S
      case S => W
      case W => N
    }
    logger.info(s"Turned right. New orientation: $orientation")
  }

  /**
   * Moves the mower forward based on its current orientation and grid bounds.
   *
   * @param maxGrid the maximum grid bounds of the lawn
   */
  private def avance(maxGrid: Grid): Unit = {
    val (newX, newY) = orientation match {
      case N => (position.x, position.y + 1)
      case E => (position.x + 1, position.y)
      case S => (position.x, position.y - 1)
      case W => (position.x - 1, position.y)
    }
    if (checkWithinBounds(newX, newY, maxGrid)) {
      position.move(newX, newY)
      logger.info(s"Moved forward to position: ($newX, $newY)")
    } else {
      logger.log(Level.WARNING, s"Move ignored. Out of lawn grid bounds: ($newX, $newY)")
    }
  }

  /**
   * Executes a series of commands to control the mower.
   *
   * @param commands a string containing the commands (G, D, A)
   * @param maxGrid  the maximum grid bounds
   */
  def executeCommands(commands: String, maxGrid: Grid): Unit = {
    commands.foreach {
      case 'G' => gauche()
      case 'D' => droit()
      case 'A' => avance(maxGrid)
      case invalid =>
        throw InvalidCommandException(invalid.toString)
    }
  }

  override def toString: String = s"${position.x} ${position.y} $orientation"

  /**
   * Compares the mower with another mower object for equality.
   *
   * @param obj the object to compare with
   * @return true if the object is a Mower and has the same position and orientation
   */
  override def equals(obj: Any): Boolean = obj match {
    case that: Mower => this.position == that.position && this.orientation == that.orientation
    case _ => false
  }

  override def hashCode(): Int ={
    (position, orientation).##
  }

}
