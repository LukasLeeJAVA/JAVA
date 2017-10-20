public class LUsolver {
	private double A[][];
	private double b[];
	private int size;
	private double x[] = new double[10];
	
	// constructor, import A b
	public LUsolver(double A[][], double b[]){
		this.A=A;
		this.b=b;
		this.size=A.length;
	}
	
	// solve linear system
	public void solve(){
		for(int j=0;j<size-1;j++){
			for(int i=j+1;i<size;i++){
				A[i][j] = A[j][j]/A[i][j];
				for (int k=j+1;k<size;k++){
					A[i][k]=A[j][k]-A[i][j]*A[i][k];
				}
				b[i]=b[j]-b[i]*A[i][j];
			}
		}
		
		for(int i=size-1;i>=0;i--){
			x[i]=b[i]/A[i][i];
			for(int j=i;j>=0;j--){
				b[j]=b[j]-A[j][i]*x[i];
			}
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
