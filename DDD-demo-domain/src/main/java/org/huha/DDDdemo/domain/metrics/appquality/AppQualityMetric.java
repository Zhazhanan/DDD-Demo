package org.huha.DDDdemo.domain.metrics.appquality;

import org.huha.DDDdemo.domain.metrics.MainMetric;
import org.huha.DDDdemo.domain.metrics.MainMetricType;
import org.huha.DDDdemo.domain.metrics.devquality.BugMetric;
import org.huha.DDDdemo.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
