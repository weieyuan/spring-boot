package ws.app.vo.enu;

public class Test {

	public static void mian(String[] args) {
		calc(BasicOperation.class, 10, 60);
	}

	private static <T extends Enum<T> & Operation> void calc(Class<T> opSet, double x, double y) {
		for (Operation oEnum : opSet.getEnumConstants()) {
			System.out.println(oEnum.apply(x, y));
		}
	}
}
