import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import utils.StringInputReader
import models.{Orientation, Position}
import services.Mower

import scala.collection.mutable.ListBuffer

class MowItNowSimulatorSpec extends AnyFlatSpec with Matchers {
  "The MowItNowSimulator" should "simulate the mowers correctly based on the input" in {
    val input =
      """5 5
        |1 2 N
        |GAGAGAGAA
        |3 3 E
        |AADAADADDA
        |""".stripMargin
    val inputReader = new StringInputReader(input)

    val simulator = MowItNowSimulator
    val actualMowers = simulator.runMowers(inputReader)

    val expectedMowers = ListBuffer[Mower](
      Mower(Position(1, 3), Orientation.N),
      Mower(Position(5, 1), Orientation.E)
    )

    actualMowers should be(expectedMowers)
  }
}
