package com.xxxx.hanlder;

import com.xxxx.pojo.CommentInfo;
import com.xxxx.pojo.KeyWordInfo;
import com.xxxx.utils.IkWordUtil;
import com.xxxx.utils.JiebaUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Array;
import java.util.*;

/**
 * @Author ShaoXikai
 * @Date 2024-02-03
 */
@Slf4j
public class CommentWordHandler {
    public static List<KeyWordInfo> getCommentWordList(List<CommentInfo> commnetList) {
        ArrayList<KeyWordInfo> keyWordInfoList = new ArrayList<>();
        ArrayList<String> wordlist = new ArrayList<String>();
        for (CommentInfo comment : commnetList) {
            // wordlist.addAll(IkWordUtil.getWordToList(comment.getCommentValue()));
            wordlist.addAll(JiebaUtil.getWordToList(comment.getCommentValue()));
        }

        Set<String> st = new HashSet<>(wordlist);
        for (String s : st) {
            // log.info(s + ": " + Collections.frequency(wordlist, s));
            keyWordInfoList.add(new KeyWordInfo(s, Collections.frequency(wordlist, s)));
        }
        return keyWordInfoList;
    }

}
