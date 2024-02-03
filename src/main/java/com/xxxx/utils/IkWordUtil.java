package com.xxxx.utils;

import lombok.extern.slf4j.Slf4j;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ShaoXikai
 * @Date 2024-02-03
 */
@Slf4j
public class IkWordUtil {
    public static List<String> getWordToList(String word) {
        log.info("执行分词==>");
        List<String> list = new ArrayList<>();
        try (StringReader reader = new StringReader(word)) {

            IKSegmenter segmenter = new IKSegmenter(reader, true);
            Lexeme lexeme;
            while ((lexeme = segmenter.next()) != null) {
                list.add(lexeme.getLexemeText());
                // System.out.println(lexeme.getLexemeText());
            }
        } catch (IOException e) {
            log.info("分词发生错误，请检查堆栈。");
            throw new RuntimeException(e);
        }
        return list;
    }
}
