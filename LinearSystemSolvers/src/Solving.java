public class Solving {
	public static void main(String args[]){
		double A[][] = {{1,2,3},{2,3,4},{3,4,6}};
		double b[] = {8,11,16};
		LUsolver solver = new LUsolver(A,b);
//		JacobiMethod solver=new JacobiMethod(A,b);
		solver.solve();
		solver.print_x();
	}
}
