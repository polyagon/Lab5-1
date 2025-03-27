package org.example.MyTools;

@FunctionalInterface
public interface Convert<T> {
    T convert(Class<T> type, String value) throws Exception;
}