package com.journaldev.design.chain0freponsibility;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	// 分配
	void dispense(Currency cur);
}