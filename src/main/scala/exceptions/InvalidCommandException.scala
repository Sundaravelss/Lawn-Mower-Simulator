package exceptions

/**
 * Exception thrown when an invalid command is encountered.
 *
 * @param command the invalid command
 */
case class InvalidCommandException(command: String) extends Exception(s"Invalid instruction provided: $command")
