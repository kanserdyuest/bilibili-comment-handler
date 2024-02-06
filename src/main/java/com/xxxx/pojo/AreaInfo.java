package com.xxxx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author ShaoXikai
 * @Date 2024-01-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaInfo {
    public static final String QuanZhan = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=0&type=all";
    public static final String GuoChuangXiangGuan = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=168&type=all";
    public static final String DongHua = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=1&type=all";
    public static final String YinYUe = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=3&type=all";
    public static final String WuDao = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=129&type=all";
    public static final String YouXi = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=4&type=all";
    public static final String ZhiShi = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=36&type=all";
    public static final String KeJi = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=188&type=all";
    public static final String YunDong = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=234&type=all";
    public static final String QiChe = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=223&type=all";
    public static final String ShengHuo = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=160&type=all";
    public static final String MeiShi = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=211&type=all";
    public static final String DongWuQuan = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=217&type=all";
    public static final String GuiChu = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=119&type=all";
    public static final String ShiShang = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=155&type=all";
    public static final String YuLe = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=5&type=all";
    public static final String YingShi = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=181&type=all";

    private String area;
    private String url;

    public static List<AreaInfo> getAreaInfoList() {
        List<AreaInfo> list = new ArrayList<>();
        list.add(new AreaInfo("全站", QuanZhan));
        list.add(new AreaInfo("国创相关", GuoChuangXiangGuan));
        list.add(new AreaInfo("音乐", YinYUe));
        list.add(new AreaInfo("舞蹈", WuDao));
        list.add(new AreaInfo("游戏", YouXi));
        list.add(new AreaInfo("知识", ZhiShi));
        list.add(new AreaInfo("科技", KeJi));
        list.add(new AreaInfo("运动", YunDong));
        list.add(new AreaInfo("汽车", QiChe));
        list.add(new AreaInfo("生活", ShengHuo));
        list.add(new AreaInfo("美食", MeiShi));
        list.add(new AreaInfo("动物圈", DongWuQuan));
        list.add(new AreaInfo("鬼畜", GuiChu));
        list.add(new AreaInfo("时尚", ShiShang));
        list.add(new AreaInfo("娱乐", YuLe));
        list.add(new AreaInfo("影视", YingShi));
        list.add(new AreaInfo("动画", DongHua));
        return list;
    }


}
