package com.howard.gank_sc_hystrix.utils;

public class PersonContextHolder {
    private static final ThreadLocal<PersonContext> personContextThreadLocal = new ThreadLocal<>();

    public static final PersonContext getContext() {
        PersonContext personContext = personContextThreadLocal.get();
        if (personContext == null) {
            personContext = createEmptyContext();
            personContextThreadLocal.set(personContext);
        }
        return personContext;
    }

    private static final PersonContext createEmptyContext() {
        return new PersonContext();
    }


}
