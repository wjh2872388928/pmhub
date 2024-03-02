package com.laigeoffer.projectaihub.project.service.project;

import com.alibaba.fastjson2.JSON;
import com.laigeoffer.projectaihub.common.utils.SecurityUtils;
import com.laigeoffer.projectaihub.project.mapper.ProjectMapper;
import com.laigeoffer.projectaihub.project.domain.vo.project.ProjectReqVO;
import com.laigeoffer.projectaihub.project.domain.vo.project.ProjectResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author canghe
 * @date 2023-01-09 11:47
 */
@Slf4j
@Service("queryMyProjectExecutor")
public class QueryMyProjectExecutor extends QueryAbstractExecutor {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectResVO> query(ProjectReqVO projectReqVO) {
        log.info("查询我的项目入参:{}", JSON.toJSONString(projectReqVO));
        return projectMapper.selectMyProjectList(projectReqVO, SecurityUtils.getUserId());
    }
}
