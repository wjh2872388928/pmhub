package com.laigeoffer.projectaihub.project.service.task;

import com.laigeoffer.projectaihub.common.enums.LogTypeEnum;
import com.laigeoffer.projectaihub.project.domain.vo.project.log.ProjectLogVO;
import com.laigeoffer.projectaihub.project.mapper.ProjectLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author canghe
 * @date 2023-01-09 16:33
 */
@Service("queryDeliverableLogExecutor")
public class QueryDeliverableLogExecutor extends QueryLogAbstractExecutor {
    @Autowired
    private ProjectLogMapper projectLogMapper;
    @Override
    public List<ProjectLogVO> query(String taskId) {
        List<ProjectLogVO> list = projectLogMapper.queryDeliverableLog(taskId);
        list.forEach(projectLogVO -> projectLogVO.setLogTypeName(LogTypeEnum.getStatusNameByStatus(projectLogVO.getLogType())));
        return list;
    }
}
