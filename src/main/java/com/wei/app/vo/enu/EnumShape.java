package com.wei.app.vo.enu;

public enum EnumShape {
	Rectangle {
		@Override
		double area() {
			return 0;
		}
	};

	abstract double area();
}
