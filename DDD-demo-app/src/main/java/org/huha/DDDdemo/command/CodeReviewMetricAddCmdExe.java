package org.huha.DDDdemo.command;

import com.alibaba.cola.dto.Response;
import org.huha.DDDdemo.domain.metrics.techcontribution.CodeReviewMetric;
import org.huha.DDDdemo.domain.metrics.techcontribution.CodeReviewMetricItem;
import org.huha.DDDdemo.domain.metrics.techcontribution.ContributionMetric;
import org.huha.DDDdemo.domain.user.UserProfile;
import org.huha.DDDdemo.dto.CodeReviewMetricAddCmd;
import org.huha.DDDdemo.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CodeReviewMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:14 AM
 */
@Component
public class CodeReviewMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(CodeReviewMetricAddCmd cmd) {
        CodeReviewMetricItem codeReviewMetricItem = new CodeReviewMetricItem();
        BeanUtils.copyProperties(cmd, codeReviewMetricItem);
        codeReviewMetricItem.setSubMetric(new CodeReviewMetric(new ContributionMetric(new UserProfile(cmd.getOwnerId()))));
        metricGateway.save(codeReviewMetricItem);
        return Response.buildSuccess();
    }
}