package com.wei.junit.source_study;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class JTest {

	public static void main(String[] args) {
		Result res = JUnitCore.runClasses(TestOne.class);
		int runCount = res.getRunCount();
		boolean bSuccess = res.wasSuccessful();
		System.out.printf("runCount:%s, success: %s", runCount, bSuccess);
	}

}
