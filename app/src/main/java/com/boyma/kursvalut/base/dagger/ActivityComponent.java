package com.boyma.kursvalut.base.dagger;

public interface ActivityComponent<A> {
    void inject(A activity);
}