package com.example.vita.assignment4part2;

public class Word {
    private int id;
    private String word;
    private String synonym;

    public Word() {
        id = -1;
        word = "";
        synonym = "";
    }


    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
