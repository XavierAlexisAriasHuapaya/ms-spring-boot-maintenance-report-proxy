package dev.arias.huapaya.ms_maintenance_report_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsMaintenanceReportProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMaintenanceReportProxyApplication.class, args);
	}

}
