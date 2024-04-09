package edu.phystech.hw2.analyzer;


import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final List<String> NEGATIVE_SMILES = List.of(":(", "=(", ":|");

    public NegativeTextAnalyzer() {
        super(NEGATIVE_SMILES, Label.NEGATIVE);
    }
    @Override
    public Label processText(String text) {
        for (String bannedWord : this.getKeywords()) {
            if ((text.indexOf(bannedWord) == 0 ||text.indexOf(bannedWord) == text.length() - 2) && text.indexOf(' ' + bannedWord) != -1) {
                return Label.NEGATIVE;
            }
            if (text.indexOf(' ' + bannedWord + ' ') != -1) {
                return Label.NEGATIVE;
            }
        }
        return Label.OK;
    }
}
