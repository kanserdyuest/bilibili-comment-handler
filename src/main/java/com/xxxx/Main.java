package com.xxxx;

import com.alibaba.excel.EasyExcel;
import com.xxxx.hanlder.VideoHandler;
import com.xxxx.pojo.AreaInfo;
import com.xxxx.pojo.CommentInfo;
import com.xxxx.pojo.VideoInfo;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author ShaoXikai
 * @Date 2024-01-28
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws DocumentException, IOException {
        List<VideoInfo> videoList = VideoHandler.getVideoForArea(AreaInfo.DongHua);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Jar\\Desktop\\excel\\弹幕数据.xlsx");
        EasyExcel.write(outputStream, VideoInfo.class).sheet(0, "动画分区视频排行前百").doWrite(videoList);
        int sheetNo = 1;
        for (VideoInfo videoInfo : videoList) {
            List<CommentInfo> commentList = VideoHandler.getCommentForCid(videoInfo.getViCid());
            FileOutputStream os = new FileOutputStream("C:\\Users\\Jar\\Desktop\\excel\\" + videoInfo.getBvId() + ".xlsx");
            EasyExcel.write(os, CommentInfo.class).sheet(sheetNo, videoInfo.getBvId()).doWrite(commentList);
        }
    }
}