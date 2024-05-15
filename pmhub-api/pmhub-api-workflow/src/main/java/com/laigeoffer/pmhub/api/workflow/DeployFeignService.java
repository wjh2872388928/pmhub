package com.laigeoffer.pmhub.api.workflow;

import com.laigeoffer.pmhub.api.workflow.factory.ProcessFeignFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.dto.ApprovalSetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author canghe
 * @description 流程部署服务
 * @create 2024-04-24-22:38
 */
@FeignClient(contextId = "deployFeignService", value = ServiceNameConstants.WORKFLOW_SERVICE, fallbackFactory = ProcessFeignFallbackFactory.class)
public interface DeployFeignService {

    /**
     * 更新审批设置
     * @param approvalSetDTO
     * @param type
     * @return
     */
    @PostMapping("/deploy/updateApprovalSet")
    R<?> updateApprovalSet(ApprovalSetDTO approvalSetDTO, String type);


    /**
     * 更新审批设置2
     * @param approvalSetDTO
     * @param type
     * @return
     */
    @PostMapping("/deploy/updateApprovalSet")
    R<?> updateApprovalSet2(ApprovalSetDTO approvalSetDTO, String type);


    /**
     * 查询流程部署关联表单信息
     * @param taskId
     * @return
     */
    @GetMapping("/selectList")
    R<?> selectList(List<String> taskId);

    /**
     * 添加&更新审批设置
     * @param extraId
     * @param type
     * @param approved
     * @param definitionId
     * @param deploymentId
     * @return
     */
    @PostMapping("/insertOrUpdateApprovalSet")
    R<?> insertOrUpdateApprovalSet(String extraId, String type, String approved, String definitionId, String deploymentId);


    /**
     * 添加审批设置
     * @return
     */
    @PostMapping("/insertApprovalSet")
    public R<?> insertApprovalSet();
}
