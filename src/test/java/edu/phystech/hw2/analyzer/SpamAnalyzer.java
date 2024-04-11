package edu.phystech.hw2.analyzer;

import java.util.List;

public class SpamAnalyzer extends KeywordAnalyzer {

    public SpamAnalyzer(List<String> keywords) {
        super(keywords, Label.SPAM);
    }

    @Override
    public Label processText(String text) {
        for (String bannedWord : this.getKeywords()) {
            if (text.contains(bannedWord)) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }
}
