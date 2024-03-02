package com.laigeoffer.projectaihub.workflow.listener;

import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.laigeoffer.projectaihub.common.enums.OAMessageStatusEnum;
import com.laigeoffer.projectaihub.common.utils.OAUtils;
import com.laigeoffer.projectaihub.workflow.domain.WfTaskMessageDeal;
import com.laigeoffer.projectaihub.workflow.mapper.ListenerMapper;
import com.laigeoffer.projectaihub.workflow.mapper.WfCopyMapper;
import com.laigeoffer.projectaihub.workflow.mapper.WfTaskMessageDealMapper;
import com.laigeoffer.projectaihub.oa.utils.RocketMqUtils;
import org.flowable.engine.delegate.event.AbstractFlowableEngineEventListener;
import org.flowable.engine.delegate.event.FlowableCancelledEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 流程结束全局监听
 *
 * @author canghe*/
@Component
public class GlobalProcesstCancelListener extends AbstractFlowableEngineEventListener {

    @Autowired
    ListenerMapper listenerMapper;

    @Autowired
    WfCopyMapper wfCopyMapper;

    @Autowired
    private WfTaskMessageDealMapper wfTaskMessageDealMapper;



    private boolean isCancelled = false;

    @Override
    protected void processCancelled(FlowableCancelledEvent event)  {
        LogFactory.get().info("任务取消！！！！------------------------Start---------------------->");
        // 取消申请将所有未处理的消息变成已处理
        LambdaQueryWrapper<WfTaskMessageDeal> lqw = new LambdaQueryWrapper<>();
        lqw.eq(WfTaskMessageDeal::getInstanceId, event.getProcessInstanceId());
        List<WfTaskMessageDeal> wfTaskMessageDeals = wfTaskMessageDealMapper.selectList(lqw);
        wfTaskMessageDeals.forEach(a -> {
            RocketMqUtils.cleanMessage(a.getTaskId() + "_" + a.getAssignee());
            OAUtils.restfulCall2(OAUtils.ALTER_MESSAGE_API, OAUtils.mapToStr(OAUtils.alterCustomMessageSingle(a.getTaskId() + "_" + a.getAssignee(), OAMessageStatusEnum.DEAL.getStatus(), wfCopyMapper.selectUserById(Long.valueOf(a.getAssignee())).getUserName())), OAUtils.ALTER_MESSAGE_API);
        });
        wfTaskMessageDealMapper.delete(lqw);

        LogFactory.get().info("任务取消！！！！------------------------End---------------------->");


    }

}
