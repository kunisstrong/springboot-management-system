package com.wangkun.domain;

import lombok.Data;

@Data
public class Region {
    private int id;
    private String regionName;
    private int parent_id;
}
