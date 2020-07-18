package com.learningjavaspringboot.pair;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import java.io.Serializable;

@Data
public class Pair<A, B> implements Cloneable, Serializable {

    private static final long serialVersionUID = -519917833389344916L;

    private A first;
    private B second;

    public Pair() {}

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

    @JsonSetter
    public void setKey(A key) {
        this.first = key;
    }

    @JsonSetter
    public void setValue(B value) {
        this.second = value;
    }

}