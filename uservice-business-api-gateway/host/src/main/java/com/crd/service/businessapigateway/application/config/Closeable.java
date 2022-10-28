package com.crd.service.businessapigateway.application.config;

import java.util.function.Consumer;

import lombok.Value;
import lombok.experimental.Accessors;

/** 
 * Simple wrapper for non-closeable beans, managed by DI.
 * Allows to close beans whrn ApplicationClonext is closing.
 */
public interface Closeable {
  
  static <T> Of<T> of(T item, Consumer<T> onClose)  {
    return new Of<>(item, onClose);
  }

  /** The wrapper. */
  @Value
  @Accessors(fluent = true)
  class Of<T> implements AutoCloseable {
    private T item;
    private Consumer<T> onClose;

    @Override
    public void close() throws Exception {
      onClose.accept(item);
    }
  }
}
