package com.learning.converter;

public interface IDTO <T> {
    default T toDTO(Object entity) {return null;}
}
