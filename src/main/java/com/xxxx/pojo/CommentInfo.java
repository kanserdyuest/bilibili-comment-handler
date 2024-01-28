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
public class CommentInfo {
    // <d p="533.67199707031,1,25,41194,1498943949,0,7edeebe9,3511616609">刀还是没有枪快</d>
    // 第一个参数是弹幕出现的时间以秒数为单位。
    @ExcelProperty("出现时间")
    private String inTime;
    // 第二个参数是弹幕的模式1..3 滚动弹幕 4底端弹幕 5顶端弹幕 6.逆向弹幕 7精准定位 8高级弹幕
    @ExcelProperty("弹幕类型")
    private Integer inType;
    // 第三个参数是字号， 12非常小,16特小,18小,25中,36大,45很大,64特别大
    @ExcelProperty("弹幕字号")
    private Integer inSize;
    // 第四个参数是字体的颜色以HTML颜色的十进制为准
    @ExcelProperty("16进制颜色")
    private Integer inColor;
    // 第五个参数是Unix格式的时间戳。基准时间为 1970-1-1 08:00:00
    @ExcelProperty("发送时间")
    private String inUpdateTime;
    // 第六个参数是弹幕池 0普通池 1字幕池 2特殊池【目前特殊池为高级弹幕专用】
    @ExcelProperty("弹幕池类型")
    private Integer inCommType;
    // 第七个参数是发送者的ID，用于“屏蔽此弹幕的发送者”功能
    @ExcelProperty("发送者ID")
    private String inOwnerId;
    // 第八个参数是弹幕在弹幕数据库中rowID 用于“历史弹幕”功能。
    @ExcelProperty("库中行ID")
    private String rowId;
    // 弹幕内容
    @ExcelProperty("弹幕内容")
    private String commentValue;
}
