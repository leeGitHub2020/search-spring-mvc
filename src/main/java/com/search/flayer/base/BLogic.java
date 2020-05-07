package com.search.flayer.base;

public interface BLogic<I, O> {
    O execute(I input) throws Exception;
}
