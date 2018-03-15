package org.reyabreu.demo.exceptions;

import org.springframework.boot.ExitCodeGenerator;

public class FatalCommandLineException extends RuntimeException implements ExitCodeGenerator {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public FatalCommandLineException(String message, Throwable cause) {
    super(message, cause);
  }

  @Override
  public int getExitCode() {
    return 1;
  }

}
