package com.xxxx.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;


/**
 * @Author ShaoXikai
 * @Date 2024-02-06
 */
public class WordTest {
    public static void main(String[] args) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String sentences = "北京京天威科技发展有限公司大庆车务段的装车数量";
        List<String> strings = segmenter.sentenceProcess(sentences);
        strings.forEach(System.out::println);
    }
}
