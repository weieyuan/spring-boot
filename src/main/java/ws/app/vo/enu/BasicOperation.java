package ws.app.vo.enu;

public enum BasicOperation implements Operation {

	Plus {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	Minus {
		@Override
		public double apply(double x, double y) {
			return x - y;
		}
	},
	Times {

		@Override
		public double apply(double x, double y) {
			return x * y;
		}

	},
	Divide {

		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	}
}
