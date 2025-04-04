package com.mpanov.diploma.data.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException(Class<?> entityClass, String field, String value) {
      super(
              "%s with %s='%s' already exists".formatted(
                      entityClass.getSimpleName(), field, value
              )
      );
    }
}
