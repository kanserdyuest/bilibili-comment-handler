package com.xxxx.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ShaoXikai
 * @Date 2024-01-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@HeadRowHeight(30)  // 表头行高
@ContentRowHeight(15)  // 内容行高
@ColumnWidth(18)  // 列宽
@ContentFontStyle(fontHeightInPoints = 12) // 字体大小
public class VideoInfo {
    // bv号
    @ExcelProperty("bv号")
    private String bvId;
    // cid
    @ExcelProperty("cid")
    private String viCid;
    // 视频标题
    @ExcelProperty("视频标题")
    private String viTitle;
    // 发布时间
    @ExcelProperty("发布时间")
    private String viTime;
    // 播放量
    @ExcelProperty("播放量")
    private Integer viView;
    // 作者
    @ExcelProperty("作者")
    private String viOwner;
}
