package utils

import models.Grid

/**
 * Helper object containing utility functions.
 */
object Helper {

  /**
   * Checks if the given coordinates are within the bounds of the lawn grid.
   *
   * @param x    the x-coordinate to check
   * @param y    the y-coordinate to check
   * @param maxGrid the maximum grid bounds
   * @return true if within bounds, false otherwise
   */
  def checkWithinBounds(x: Int, y: Int, maxGrid: Grid): Boolean = {
    x >= 0 && x <= maxGrid.x && y >= 0 && y <= maxGrid.y
  }
}
