package org.huha.DDDdemo.command;

import com.alibaba.cola.dto.Response;
import org.huha.DDDdemo.domain.metrics.techcontribution.ContributionMetric;
import org.huha.DDDdemo.domain.metrics.techcontribution.MiscMetric;
import org.huha.DDDdemo.domain.metrics.techcontribution.MiscMetricItem;
import org.huha.DDDdemo.domain.user.UserProfile;
import org.huha.DDDdemo.dto.MiscMetricAddCmd;
import org.huha.DDDdemo.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MiscMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class MiscMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(MiscMetricAddCmd cmd) {
        MiscMetricItem miscMetricItem = new MiscMetricItem();
        BeanUtils.copyProperties(cmd.getMiscMetricCO(), miscMetricItem);
        miscMetricItem.setSubMetric(new MiscMetric(new ContributionMetric(new UserProfile(cmd.getMiscMetricCO().getOwnerId()))));
        metricGateway.save(miscMetricItem);
        return Response.buildSuccess();
    }
}