package com.lucas.enumtest;

public enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L");

    private String abbr;

    Size(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}
