package ws.junit.decorate;

import java.util.List;

public class RunAfter extends Statement {

	private List<Method> afters;

	private Statement next;

	public RunAfter(List<Method> afters, Statement next) {
		this.afters = afters;
		this.next = next;
	}

	@Override
	public void evaluate() {
		this.next.evaluate();
		this.afters.forEach((oMethod) -> oMethod.doSth());
	}

}
