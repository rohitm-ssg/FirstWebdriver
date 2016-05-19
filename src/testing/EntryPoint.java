package testing;

import com.beust.testng.TestNG;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 TestNG testng = new TestNG();
	     Class[] classes = new Class[]{AjaxAutoSuggest.class,Cache.class,NewTest.class};
	     testng.setTestClasses(classes);
	     testng.run();
		
	}

}
