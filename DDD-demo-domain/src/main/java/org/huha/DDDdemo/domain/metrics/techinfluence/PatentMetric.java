package org.huha.DDDdemo.domain.metrics.techinfluence;

import org.huha.DDDdemo.domain.metrics.*;

/**
 * 技术专利指标
 * @author xueliang.sxl
 */
public class PatentMetric extends SubMetric {

    public PatentMetric(){
        this.subMetricType = SubMetricType.Patent;
    }

    public PatentMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.Patent;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
