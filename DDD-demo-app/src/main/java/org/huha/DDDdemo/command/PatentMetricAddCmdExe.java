package org.huha.DDDdemo.command;

import com.alibaba.cola.dto.Response;
import org.huha.DDDdemo.domain.metrics.techinfluence.AuthorType;
import org.huha.DDDdemo.domain.metrics.techinfluence.InfluenceMetric;
import org.huha.DDDdemo.domain.metrics.techinfluence.PatentMetric;
import org.huha.DDDdemo.domain.metrics.techinfluence.PatentMetricItem;
import org.huha.DDDdemo.domain.user.UserProfile;
import org.huha.DDDdemo.dto.PatentMetricAddCmd;
import org.huha.DDDdemo.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PatentMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PatentMetricAddCmdExe{

    @Resource
    private MetricGateway metricGateway;

    public Response execute(PatentMetricAddCmd cmd) {
        PatentMetricItem patentMetricItem = new PatentMetricItem();
        BeanUtils.copyProperties(cmd.getPatentMetricCO(), patentMetricItem);
        patentMetricItem.setSubMetric(new PatentMetric(new InfluenceMetric(new UserProfile(cmd.getPatentMetricCO().getOwnerId()))));
        patentMetricItem.setAuthorType(AuthorType.valueOf(cmd.getPatentMetricCO().getAuthorType()));
        metricGateway.save(patentMetricItem);
        return Response.buildSuccess();
    }
}