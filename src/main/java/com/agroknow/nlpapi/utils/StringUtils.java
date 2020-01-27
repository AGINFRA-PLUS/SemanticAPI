package com.agroknow.nlpapi.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static List<String> ngrams(int n, String str) throws Exception {
        List<String> ngrams = new ArrayList<>();
        Analyzer analyzer = new StandardAnalyzer();

        TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(str));
        ShingleFilter theFilter = new ShingleFilter(tokenStream);
        theFilter.setMaxShingleSize(n);
        theFilter.setOutputUnigrams(true);

        CharTermAttribute charTermAttribute = theFilter.addAttribute(CharTermAttribute.class);
        theFilter.reset();

        while (theFilter.incrementToken()) {
            if (!charTermAttribute.toString().contains("_")) {
                ngrams.add(charTermAttribute.toString());
            }
        }

        theFilter.end();
        theFilter.close();
        return ngrams;
    }

    private static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append(i > start ? " " : "").append(words[i]);
        return sb.toString();
    }

}
