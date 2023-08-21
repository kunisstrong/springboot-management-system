package com.wangkun.mapper;

import com.wangkun.domain.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RegionMapper {

    int getIdByRegionName(@Param("regionName") String regionName);

    List<Region> getAllRegionByRegionId(@Param("regionId") int regionId);
}
