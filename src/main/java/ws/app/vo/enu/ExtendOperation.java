package ws.app.vo.enu;

public enum ExtendOperation implements Operation {

	Exp {

		@Override
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	},
	Remainder {
		@Override
		public double apply(double x, double y) {
			return x % y;
		}
	}

}
