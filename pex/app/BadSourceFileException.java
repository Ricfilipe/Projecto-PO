package pex.app;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for representing an invalid index for placing an expression.
 */
@SuppressWarnings("nls")
public class BadSourceFileException extends InvalidOperation {
  
  /** Serial number for serialization. */
  
  /** Invalid index */
  String _fileName;

  /**
   * @param position
   */
  public BadSourceFileException(String fileName) {
    _fileName = fileName;
  }
  
  /**
   * @return the position
   */
  public String getFileName() {
    return _fileName;
  }

  /** @see pt.tecnico.po.ui.DialogException#getMessage() */
  @Override
  public String getMessage() {
    return _fileName;
  }
}