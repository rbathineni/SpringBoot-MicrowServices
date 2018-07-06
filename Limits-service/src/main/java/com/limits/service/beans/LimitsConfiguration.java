package com.limits.service.beans;

public class LimitsConfiguration {
	
	int minimum;
	int maximum;
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public LimitsConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	@Override
	public String toString() {
		return String.format("LimitsConfiguration [minimum=%s, maximum=%s]", minimum, maximum);
	}
	

}
