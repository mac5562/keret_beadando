package com.beadando.model;

public enum Rate {
    AR(6),BR(12),CR(16),DR(18);
    Rate(int value) {
        this.value = value;
    }

    private int value;

    public String toString() {
        return Integer.toString(value);
    }
};
