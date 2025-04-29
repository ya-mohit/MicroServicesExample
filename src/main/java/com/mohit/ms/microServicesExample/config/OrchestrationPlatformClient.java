package com.mohit.ms.microServicesExample.config;

import org.springframework.stereotype.Component;

@Component
public class OrchestrationPlatformClient {

	public int getCurrentInstanceCount() {
		// Interact with Orchestration Clients like Kubernetes to fetch Instance Counts
		return 0;
	}

	public void scaleToInstanceCount(int newInstances) {
		// Interact with Orchestration Clients like Kubernetes to increase instances
		
	}

}
