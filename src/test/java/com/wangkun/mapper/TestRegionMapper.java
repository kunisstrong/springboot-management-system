package com.wangkun.mapper;

import com.wangkun.domain.Region;
import org.assertj.core.error.ShouldBeToday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestRegionMapper {
    @Autowired
    private RegionMapper regionMapper;

    @Test
    public void testGetAllRegionName() {
        int id = regionMapper.getIdByRegionName("哈尔");
        List<Region> allRegionByRegionId = regionMapper.getAllRegionByRegionId(id);
        for (Region item : allRegionByRegionId) {
            System.out.println(item);
        }
    }

}
