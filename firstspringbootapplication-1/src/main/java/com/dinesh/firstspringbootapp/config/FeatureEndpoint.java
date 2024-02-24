package com.dinesh.firstspringbootapp.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;



@Component
@Endpoint(id="features")
public class FeatureEndpoint 
{
	private final Map<String, Feature> featureMap=new ConcurrentHashMap<>();
	
	public FeatureEndpoint() 
	{
		featureMap.put("Department", new Feature(true));
		featureMap.put("User", new Feature(false));
		featureMap.put("Authentication", new Feature(false));
	}
	
	@ReadOperation
	public Map<String, Feature> features()
	{
		return featureMap;
	}
	
	@ReadOperation
	public Feature feature(@Selector String featureName)
	{
		return featureMap.get(featureName);
	}
	
	private static class Feature
	{

		private boolean isEnabled;
		
		/**
		 * @return the isEnabled
		 */
		public boolean isEnabled() {
			return isEnabled;
		}

		/**
		 * @param isEnabled the isEnabled to set
		 */
		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}

		public Feature(boolean isEnabled) {
			super();
			this.isEnabled = isEnabled;
		}

		public Feature() {
			super();
		}

		@Override
		public String toString() {
			return "Feature [isEnabled=" + isEnabled + "]";
		}
	}
}
