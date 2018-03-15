package org.reyabreu.demo.exceptions;

public class InvalidInputException extends ApplicationException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public InvalidInputException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidInputException(String message) {
    super(message);
  }

}
