package com.xxxx.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author ShaoXikai
 * @Date 2024-02-06
 */
@Slf4j
public class JiebaUtil {
    private static JiebaSegmenter segmenter = new JiebaSegmenter();

    public static List<String> getWordToList(String word) {
        // log.info("执行分词==>");
        return segmenter.sentenceProcess(word);
    }
}
