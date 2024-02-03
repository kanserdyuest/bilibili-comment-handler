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
public class SheetWrite {
    public static void main(String[] args) throws DocumentException {
        List<VideoInfo> videoList = VideoHandler.getVideoForArea(AreaInfo.DongHua);
        String fileName = "C:\\Users\\Jar\\Desktop\\excel\\弹幕数据" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).build()) {
            excelWriter.write(videoList, EasyExcel.writerSheet(0, "生活区视频排行前百").head(VideoInfo.class).build());
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
}
