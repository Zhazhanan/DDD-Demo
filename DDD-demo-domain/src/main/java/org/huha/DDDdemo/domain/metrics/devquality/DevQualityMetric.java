package org.huha.DDDdemo.domain.metrics.devquality;

import org.huha.DDDdemo.domain.metrics.MainMetric;
import org.huha.DDDdemo.domain.metrics.MainMetricType;
import org.huha.DDDdemo.domain.user.UserProfile;
import lombok.Data;

@Data
public class DevQualityMetric extends MainMetric {

    private BugMetric bugMetric;

    public DevQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setDevQualityMetric(this);
        this.metricMainType = MainMetricType.DEV_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getDevQualityWeight();
    }
}
