package org.huha.DDDdemo.command;

import com.alibaba.cola.dto.Response;
import org.huha.DDDdemo.domain.metrics.techinfluence.ATAMetric;
import org.huha.DDDdemo.domain.metrics.techinfluence.ATAMetricItem;
import org.huha.DDDdemo.domain.metrics.techinfluence.InfluenceMetric;
import org.huha.DDDdemo.domain.user.UserProfile;
import org.huha.DDDdemo.dto.ATAMetricAddCmd;
import org.huha.DDDdemo.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ATAMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-01 11:42 AM
 */
@Component
public class ATAMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(ATAMetricAddCmd cmd) {
        ATAMetricItem ataMetricItem = new ATAMetricItem();
        BeanUtils.copyProperties(cmd.getAtaMetricCO(), ataMetricItem);
        ataMetricItem.setSubMetric(new ATAMetric(new InfluenceMetric(new UserProfile(cmd.getAtaMetricCO().getOwnerId()))));
        metricGateway.save(ataMetricItem);
        return Response.buildSuccess();
    }
}
