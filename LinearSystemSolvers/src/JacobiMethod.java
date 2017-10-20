//precondition: strictly diagonally dominant!!!
public class JacobiMethod {
	private double A[][];
	private double b[];
	private int size;
	private double x[] = new double[10];
	private double x_[]= x.clone();
	private double D[] = new double[10];
	
	// constructor, import A b
	public JacobiMethod(double A[][], double b[]){
		this.A=A;
		this.b=b;
		this.size=A.length;
	}
	
	// solve linear system
	public void solve(){
		for(int i=0;i<size;i++){
			D[i]=A[i][i];
			A[i][i]=0;
		}
		double sum;
		while(true){
			sum = 0;
			for(int i=0;i<size;i++){
				x[i]=b[i];
				for(int j=0;j<size;j++){
					x[i]-= A[i][j]*x_[j];
				}
				x[i]/=D[i];
			}
			for(int i=0;i<size;i++){
				sum += (x[i]-x_[i])*(x[i]-x_[i]);
			}
			if (sum<1e-6)
				break;
			x_= x.clone();
		}
	}
	
	// print result
	public void print_x(){
		for(int i=0;i<size;i++){
			System.out.printf("%s\t\t",x[i]);
		}
		System.out.printf("\n");
	}
}

