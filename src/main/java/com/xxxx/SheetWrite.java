package com.xxxx;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.xxxx.hanlder.CommentWordHandler;
import com.xxxx.hanlder.VideoHandler;
import com.xxxx.pojo.AreaInfo;
import com.xxxx.pojo.CommentInfo;
import com.xxxx.pojo.KeyWordInfo;
import com.xxxx.pojo.VideoInfo;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author ShaoXikai
 * @Date 2024-01-29
 */
@Slf4j
public class SheetWrite {
    public static void main(String[] args) throws DocumentException {
        // List<VideoInfo> videoList = VideoHandler.getVideoForArea(AreaInfo.DongHua);
        long stime = System.currentTimeMillis();
        List<AreaInfo> areaList = AreaInfo.getAreaInfoList();
        for (AreaInfo area : areaList) {
            String fileName = "C:\\Users\\Jar\\Desktop\\excel\\弹幕数据" + area.getArea() + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx";
            List<VideoInfo> videoList = VideoHandler.getVideoForArea(area.getUrl());
            try (ExcelWriter excelWriter = EasyExcel.write(fileName).build()) {
                excelWriter.write(videoList, EasyExcel.writerSheet(0, area.getArea() + "视频排行前百").head(VideoInfo.class).build());
                int sheetNo = 1;
                for (VideoInfo video : videoList) {
                    // 写入视频弹幕sheet
                    WriteSheet writeCommentSheet = EasyExcel.writerSheet(sheetNo, video.getBvId()).head(CommentInfo.class).build();
                    List<CommentInfo> commentList = VideoHandler.getCommentForCid(video.getViCid());
                    excelWriter.write(commentList, writeCommentSheet);
                    // 写入关键词统计sheet
                    WriteSheet writeCommentCountSheet = EasyExcel.writerSheet(sheetNo + 1, video.getBvId() + "-统计").head(KeyWordInfo.class).build();
                    List<KeyWordInfo> commentWordCountList = CommentWordHandler.getCommentWordList(commentList);
                    excelWriter.write(commentWordCountList, writeCommentCountSheet);
                    sheetNo = sheetNo + 2;
                }
            }
        }
        log.info("处理完成!消耗时间：{}秒", (System.currentTimeMillis() - stime) / 1000);
    }
}
