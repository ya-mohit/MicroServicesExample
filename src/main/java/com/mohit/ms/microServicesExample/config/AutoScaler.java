package com.mohit.ms.microServicesExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoScaler {
    @Value("${autoscaler.cpu.threshold.high}")
    private double cpuThresholdHigh;

    @Value("${autoscaler.cpu.threshold.low}")
    private double cpuThresholdLow;

    @Value("${autoscaler.instance.min}")
    private int minInstances;

    @Value("${autoscaler.instance.max}")
    private int maxInstances;

    @Autowired
    private OrchestrationPlatformClient orchestrationClient;

    @Autowired
    private MetricsCollector metricsCollector;

    @Scheduled(fixedRate = 60000)
    public void autoScale() {
        double cpuUsage = metricsCollector.getAverageCpuUsage();
        int currentInstances = orchestrationClient.getCurrentInstanceCount();

        if (cpuUsage > cpuThresholdHigh && currentInstances < maxInstances) {
            int newInstances = Math.min(currentInstances + 1, maxInstances);
            orchestrationClient.scaleToInstanceCount(newInstances);
            System.out.println("Scaling up to " + newInstances + " instances due to high CPU usage.");
        } else if (cpuUsage < cpuThresholdLow && currentInstances > minInstances) {
            int newInstances = Math.max(currentInstances - 1, minInstances);
            orchestrationClient.scaleToInstanceCount(newInstances);
            System.out.println("Scaling down to " + newInstances + " instances due to low CPU usage.");
        }
    }
}