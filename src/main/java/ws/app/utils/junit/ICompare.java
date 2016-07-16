package ws.app.utils.junit;

public interface ICompare<T> {

	boolean isEqual(T oReal, T oExpect);
	
}
