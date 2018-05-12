package ws.junit.selfcode;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClassWrapper {

	private Class<?> _class;

	private Map<String, List<? extends Annotation>> fieldName2AnnotationLst = new HashMap<String, List<? extends Annotation>>();

	private Map<String, List<? extends Annotation>> methodName2AnnotationLst = new HashMap<String, List<? extends Annotation>>();

	public void init(Class<?> _class) {
		this._class = _class;
		scanClass();
	}

	private void scanClass() {
		Method[] methods = this._class.getDeclaredMethods();
		for (Method oMethod : methods) {
			String methodName = oMethod.getName();
			List<Annotation> mAnnotations = new ArrayList<Annotation>();
			methodName2AnnotationLst.put(methodName, mAnnotations);
			Annotation[] annotations = oMethod.getAnnotations();
			for (Annotation oAnnotation : annotations) {
				mAnnotations.add(oAnnotation);
			}
		}
		Field[] fields = this._class.getDeclaredFields();
		for (Field oField : fields) {
			String fieldName = oField.getName();
			List<Annotation> fAnnotations = new ArrayList<Annotation>();
			fieldName2AnnotationLst.put(fieldName, fAnnotations);
			Annotation[] annotations = oField.getAnnotations();
			for (Annotation oAnnotaion : annotations) {
				fAnnotations.add(oAnnotaion);
			}
		}
	}

}
