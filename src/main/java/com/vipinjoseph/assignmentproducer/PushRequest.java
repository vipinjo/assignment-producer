package com.vipinjoseph.assignmentproducer;

public class PushRequest {

	int valueOne;
    int valueTwo;
   
    public PushRequest() {
	}
	
	public PushRequest(int valueOne, int valueTwo) {
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	public int getValueOne() {
		return valueOne;
	}

	public void setValueOne(int valueOne) {
		this.valueOne = valueOne;
	}

	public int getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(int valueTwo) {
		this.valueTwo = valueTwo;
	}
	
	
}
