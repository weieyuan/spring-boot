package com.wei.junit.source_study;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOne {

	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}

	@Test
	public void test1() {
		System.out.println("test1");
		int a = 5;
		int b = 10;
		Assert.assertEquals(16, a + b);
	}

	@Test
	public void test2() {
		System.out.println("test2");
	}

}
