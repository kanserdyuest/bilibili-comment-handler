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
 * @Date 2024-02-03
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@HeadRowHeight(30)  // 表头行高
@ContentRowHeight(15)  // 内容行高
@ColumnWidth(18)  // 列宽
@ContentFontStyle(fontHeightInPoints = 12) // 字体大小
public class KeyWordInfo {
    // 关键词
    @ExcelProperty("关键词")
    private String keyWordValue;
    // 出现次数
    @ExcelProperty("出现次数")
    private Integer num;
}
