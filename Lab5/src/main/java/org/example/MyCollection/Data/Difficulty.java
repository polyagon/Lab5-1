package org.example.MyCollection.Data;

public enum Difficulty {
    VERY_EASY(1),
    HARD(2),
    VERY_HARD(3),
    IMPOSSIBLE(4);

    private final int priority;

    Difficulty(int priority) {
        this.priority = priority;
    }

    public boolean hasGreaterPriority(Difficulty other) {
        return this.priority > other.priority;
    }

    public boolean hasLessPriority(Difficulty other) {
        return this.priority < other.priority;
    }

}
