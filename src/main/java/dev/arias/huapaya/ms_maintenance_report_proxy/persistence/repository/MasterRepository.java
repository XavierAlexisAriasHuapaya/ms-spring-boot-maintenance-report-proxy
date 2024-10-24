package dev.arias.huapaya.ms_maintenance_report_proxy.persistence.repository;

import java.util.Map;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dev.arias.huapaya.ms_maintenance_report_proxy.configuration.bean.LoadBalancerConfiguration;

@FeignClient(name = "ms-maintenance-report")
@LoadBalancerClient(name = "ms-maintenance-report", configuration = LoadBalancerConfiguration.class)
public interface MasterRepository {

    @GetMapping(path = "/api/report/maintenance/master")
    public Map<String, Object> findAll();

}
