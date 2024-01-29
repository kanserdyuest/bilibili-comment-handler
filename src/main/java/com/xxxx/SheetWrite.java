package com.xxxx;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.xxxx.hanlder.VideoHandler;
import com.xxxx.pojo.AreaInfo;
import com.xxxx.pojo.CommentInfo;
import com.xxxx.pojo.VideoInfo;
import org.dom4j.DocumentException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @Author ShaoXikai
 * @Date 2024-01-29
 */
public class SheetWrite {
    public static void main(String[] args) throws DocumentException {
        List<VideoInfo> videoList = VideoHandler.getVideoForArea(AreaInfo.DongHua);
        String fileName = "C:\\Users\\Jar\\Desktop\\excel\\弹幕数据222.xlsx";

        try (ExcelWriter excelWriter = EasyExcel.write(fileName).build()) {
            excelWriter.write(videoList, EasyExcel.writerSheet(0, "动画分区视频排行前百").head(VideoInfo.class).build());
            int sheetNo = 1;
            for (VideoInfo video : videoList) {
                WriteSheet writeSheet = EasyExcel.writerSheet(sheetNo, video.getBvId()).head(CommentInfo.class).build();
                List<CommentInfo> commentList = VideoHandler.getCommentForCid(video.getViCid());
                excelWriter.write(commentList, writeSheet);
                sheetNo++;
            }
        }
    }
}
