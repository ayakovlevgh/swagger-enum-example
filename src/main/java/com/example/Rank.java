package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.EnumSet;

public enum Rank {
    ONE(1),
    TWO(2),
    FIVE(5),
    SEVEN(7);

    private final int rank;

    @JsonCreator
    public static Rank fromString(final String string) {
        final int rank = Integer.parseInt(string);
        return EnumSet.allOf(Rank.class).stream()
                .filter(r -> r.rank == rank)
                .findFirst().orElse(null);
    }

    Rank(final int rank) {
        this.rank = rank;
    }

    @JsonValue
    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
