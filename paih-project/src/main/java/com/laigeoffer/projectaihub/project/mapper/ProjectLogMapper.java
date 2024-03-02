package com.laigeoffer.projectaihub.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laigeoffer.projectaihub.project.domain.ProjectLog;
import com.laigeoffer.projectaihub.project.domain.vo.project.log.ProjectLogVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author canghe
 * @date 2022-12-12 14:27
 */
public interface ProjectLogMapper extends BaseMapper<ProjectLog> {

    List<ProjectLogVO> queryLogList(@Param("projectId") String projectId);
    List<ProjectLogVO> queryAllLog(@Param("taskId") String taskId);
    List<ProjectLogVO> queryCommentLog(@Param("taskId") String taskId);
    List<ProjectLogVO> queryDeliverableLog(@Param("taskId") String taskId);
    List<ProjectLogVO> queryTrendsLog(@Param("taskId") String taskId);
}
