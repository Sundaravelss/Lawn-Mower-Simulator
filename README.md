# Lawn Mower Simulator

## Overview

Lawn Mower Simulator is an application that simulates the movement of multiple lawn mowers on a rectangular lawn grid. Each mower is given an initial position, orientation, and a set of commands to execute. The simulation calculates the final position and orientation of each mower after executing all commands.

## Running the Project

### Clone the repository:
```
git clone https://github.com/Sundaravelss/Lawn-Mower-Simulator.git
cd Lawn-Mower-Simulator
```

### Setup the project:
Ensure you have sbt installed.

### Run the simulation:
Place your input file in the src/main/resources directory and update the inputFile path in AppConfig.scala.
```
sbt run
```

### Run tests:
```
sbt test
```

### Dependencies
The project uses the following dependencies, specified in build.sbt:
```
libraryDependencies ++= Seq(
"org.scalatest" %% "scalatest" % "3.2.3" % Test)
```
