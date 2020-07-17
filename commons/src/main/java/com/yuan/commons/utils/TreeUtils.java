package com.yuan.commons.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by yuanlai
 * @Date 2020/3/10 1:00 下午
 * @Description: TODO
 * @Version 1.0
 */
public class TreeUtils {
    public static void main(String[] args) {
        List<Organization> list = new ArrayList<>();
        list.add(new Organization(1, 0, "顶层组织"));
        list.add(new Organization(2, 1, "杭州佐创智能科技有限公司"));
        list.add(new Organization(3, 1, "杭州电子科技大学"));
        list.add(new Organization(6, 3, "杭州电子科技大学xxxx研究院"));
        list.add(new Organization(7, 1, "测试组织"));

        JSONArray result = listToTree(list, "id", "pid", "children");
        System.out.println(JSON.toJSONString(result));
    }


    public static JSONArray listToTree(List list, String idStr, String pidStr, String childrenStr) {
        JSONArray arr = JSONArray.parseArray(JSON.toJSONString(list));
        JSONArray r = new JSONArray();
        JSONObject hash = new JSONObject();
        //将数组转为Object的形式，key为数组中的id
        arr.forEach(x -> {
            JSONObject json = (JSONObject) x;
            hash.put(json.getString(idStr), json);
        });
        //遍历结果集
        arr.forEach(x -> {
            //单条记录
            JSONObject aVal = (JSONObject) x;
            //在hash中取出key为单条记录中pid的值
            JSONObject hashValueParent = (JSONObject) hash.get(aVal.get(pidStr).toString());
            //如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
            if (hashValueParent != null) {
                //检查是否有child属性
                if (hashValueParent.get(childrenStr) != null) {
                    //已经存在子节点
                    JSONArray children = (JSONArray) hashValueParent.get(childrenStr);
                    children.add(aVal);
                    hashValueParent.put(childrenStr, children);
                } else {
                    //创建一个子节点
                    JSONArray children = new JSONArray();
                    children.add(aVal);
                    hashValueParent.put(childrenStr, children);
                }
            } else {
                r.add(aVal);
            }
        });
        return r;
    }

    @Data
    @AllArgsConstructor
    private static class Organization {
        private Integer id;
        private Integer pid;
        private String name;
    }
}
