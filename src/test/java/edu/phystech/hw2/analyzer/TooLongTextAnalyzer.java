package edu.phystech.hw2.analyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {

    private final int maxLenght;

    public TooLongTextAnalyzer(int maxLenght) {
        this.maxLenght = maxLenght;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLenght) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}
