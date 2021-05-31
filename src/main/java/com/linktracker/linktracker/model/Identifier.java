package com.linktracker.linktracker.model;

public class Identifier {
    private static Integer nextId = 0;

    public static Integer getNextId() {
        nextId += 1;
        return nextId;
    }

}
