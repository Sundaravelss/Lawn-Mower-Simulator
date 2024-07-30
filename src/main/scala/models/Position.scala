package models

/**
 * Class representing the position of the mower.
 *
 * @param x           the x-coordinate of mower
 * @param y           the y-coordinate of mower
 */
case class Position(var x: Int, var y: Int) {
  /**
   * Changes the position of the mower
   *
   * @param newX       change to the new x-coordinate
   * @param newY       change to the new y-coordinate
   */
  def move(newX: Int, newY: Int): Unit = {
    x = newX
    y = newY
  }
}
