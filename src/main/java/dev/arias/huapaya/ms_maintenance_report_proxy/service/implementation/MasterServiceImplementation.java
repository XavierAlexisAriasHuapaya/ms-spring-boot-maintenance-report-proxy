package dev.arias.huapaya.ms_maintenance_report_proxy.service.implementation;

import java.util.Map;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;

import dev.arias.huapaya.ms_maintenance_report_proxy.persistence.repository.FallbackRepository;
import dev.arias.huapaya.ms_maintenance_report_proxy.persistence.repository.MasterRepository;
import dev.arias.huapaya.ms_maintenance_report_proxy.service.interfaces.MasterService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MasterServiceImplementation implements MasterService{
    
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    private final MasterRepository masterRepository;

    private final FallbackRepository fallbackRepository;

    @Override
    public Map<String, Object> findAll() {
        var circuitBreaker = this.circuitBreakerFactory.create("master-circuitbreaker");
        return circuitBreaker.run(() -> this.masterRepository.findAll(),
                throwable -> this.fallbackRepository.getFallback());
    }
    
}
