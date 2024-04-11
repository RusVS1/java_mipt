package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    private final List<String> keywords;
    private final Label label;

    public KeywordAnalyzer(List<String> keywords, Label label) {
        if (keywords == null || keywords.isEmpty()) {
            throw new IllegalArgumentException("Keywords not null or empty");
        }
        this.keywords = keywords;
        this.label = label;
    }

    public List<String> getKeywords() {
        return this.keywords;
    }
}
