package com.xxxx.hanlder;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xxxx.pojo.AreaInfo;
import com.xxxx.pojo.CommentInfo;
import com.xxxx.pojo.VideoInfo;
import com.xxxx.utils.JsoupUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Connection.Response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ShaoXikai
 * @Date 2024-01-28
 */
@Slf4j
public class VideoHandler {
    public static List<VideoInfo> getVideoForArea(String area) {
        Response resp = JsoupUtil.getResult(area);
        // log.info(resp.body());
        JSONObject root = JSONObject.parseObject(resp.body());
        JSONArray videoListJson = root.getJSONObject("data").getJSONArray("list");

        List<VideoInfo> videoList = new ArrayList<>();
        for (Object o : videoListJson) {
            JSONObject video = (JSONObject) o;
            String bvid = video.getString("bvid");
            String cid = video.getLong("cid").toString();
            String title = video.getString("title");
            String pubdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(video.getLong("pubdate") * 1000);
            Integer view = video.getJSONObject("stat").getInteger("view");
            String name = video.getJSONObject("owner").getString("name");

            videoList.add(
                    new VideoInfo(bvid, cid, title, pubdate, view, name
                    )
            );
        }
        return videoList;
    }

    public static List<CommentInfo> getCommentForCid(String cid) throws DocumentException {
        String url = "https://comment.bilibili.com/" + cid + ".xml";
        Response result = JsoupUtil.getResult(url);

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(result.bodyStream());
        Element rootElement = document.getRootElement();
        // System.out.println(rootElement.getName());
        Iterator<Element> iterator = rootElement.elementIterator("d");
        List<CommentInfo> commentInfoList = new ArrayList<>();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            // System.out.println(next.attribute("p").getValue());
            String p = next.attribute("p").getValue();
            String[] strings = p.split(",");
            String inTime = (int) (Double.parseDouble(strings[0]) / 60) + ":" + (int) (Double.parseDouble(strings[0]) % 60);
            Integer inType = Integer.valueOf(strings[1]);
            Integer inSize = Integer.valueOf(strings[2]);
            Integer inColor = Integer.valueOf(strings[3]);
            String inUpdateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.parseLong(strings[4]) * 1000);
            Integer inCommType = Integer.valueOf(strings[5]);
            String inOwnerId = strings[6];
            String rowId = strings[7];
            String commentValue = (String) next.getData();
            commentInfoList.add(new CommentInfo(inTime, inType, inSize, inColor, inUpdateTime, inCommType, inOwnerId, rowId, commentValue));
        }
        return commentInfoList;
    }
}
