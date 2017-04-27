package com.feng.util;

import java.util.Collections;
import java.util.List;

/**
 * Created by feng on 2017/4/25.
 */
public class PageManager {

    public static <T> List<T> page(List<T> list, int currentPage, int countPage) {
        int total = list.size();

        int pageNumber = total / countPage; // 总个数除以每页包含的元素数， 得到总页数

        if (pageNumber < 0) {
            //总个数不够要分的页数
            return list;
        }

        if (currentPage > pageNumber) {
            return Collections.emptyList();
        }

        if (currentPage == pageNumber) {
            //最后一页
            return list.subList((currentPage - 1) * countPage, total);
        } else {
            return list.subList((currentPage - 1) * countPage, ((currentPage - 1) * countPage) + countPage);
        }
    }
}
