package com.wei.junit.decorate;

import java.util.List;

public class RunBefore extends Statement {

	private Statement next;

	private List<Method> befores;

	public RunBefore(List<Method> befores, Statement next) {
		this.befores = befores;
		this.next = next;
	}

	@Override
	public void evaluate() {
		this.befores.forEach((oMethod) -> oMethod.doSth());
		this.next.evaluate();
	}

}
