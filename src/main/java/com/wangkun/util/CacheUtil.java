package com.wangkun.util;

import com.wangkun.domain.Dept;

import java.util.ArrayList;
import java.util.List;

public class CacheUtil {
    private static List<Dept> CACHE_DEPT = new ArrayList<>();

    public static void setCacheDept(List<Dept> list){
        CACHE_DEPT.clear();
        CACHE_DEPT.addAll(list);
    }

    public static List<Dept> getCacheDept() {
        return CACHE_DEPT;
    }
}
