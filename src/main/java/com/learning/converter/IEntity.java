package com.learning.converter;

public interface IEntity<T> {
    default T toEntity(Object dto) {return null;}
}
