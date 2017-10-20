public class Solving {
	public static void main(String args[]){
		double input1[]= {1,5,5,5};
		Solver solver1 = new Solver(input1);solver1.solve();solver1.print();
		double input2[]= {3,3,7,7};
		Solver solver2 = new Solver(input2);solver2.solve();solver2.print();
		double input3[]= {4,4,7,7};
		Solver solver3 = new Solver(input3);solver3.solve();solver3.print();
		double input4[]= {1,3,9,10};
		Solver solver4 = new Solver(input4);solver4.solve();solver4.print();
		double input5[]= {13,2,5,6};
		Solver solver5 = new Solver(input5);solver5.solve();solver5.print();
	}
}
