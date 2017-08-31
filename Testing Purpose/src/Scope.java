
public class Scope {

	static int x = 0;
	public static void main (String[] arg) {
		
		int x = 2;
		String [] names = {"Fred", "Jim" , "Shelia"};
		x = x - 1;
		
		names [x]  = names [x] +".";
		
		for (int i = 0; i < names.length; i++)
			System.out.println(names[Scope.x]);
	}
}
