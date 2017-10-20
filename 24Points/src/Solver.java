public class Solver {
	private double input[]= new double[4]; 
	
	private double numberorderlist[][]=new double[24][4];
	private int operatororderlist[][]= new int[64][3];
	
	private double resultlist[][][]= new double[3][24][64];
	private double resultnumberorder[][][]=new double[3][50][4];
	private int resultoperatororder[][][]=new int[3][50][3];
	
	private int ct0=0,ct1=0,ct2=0;
	
	private int m=0;//method type
	
	public Solver(double input[]){
		this.input=input.clone();
		int ct=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				for(int k=0;k<4;k++)
					for(int l=0;l<4;l++)
						if((j!=i) && (k!=i && k!=j) && (l!=i && l!=j && l!=k)){
							numberorderlist[ct][0]=input[i];
							numberorderlist[ct][1]=input[j];
							numberorderlist[ct][2]=input[k];
							numberorderlist[ct][3]=input[l];
							ct++;
						}
		ct=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				for(int k=0;k<4;k++){
					operatororderlist[ct][0]=i;
					operatororderlist[ct][1]=j;
					operatororderlist[ct][2]=k;
					ct++;
				}
	}
	
	public void printinput(){
		System.out.printf("%f%f%f%f",input[0],input[1],input[2],input[3]);
	}
	
	public void solve(){
		for(int i=0;i<24;i++)
			for (int j=0;j<64;j++){
				double x1x2 = operator(numberorderlist[i][0],numberorderlist[i][1],operatororderlist[j][0]);
				double x1x2x3 = operator(x1x2,numberorderlist[i][2],operatororderlist[j][1]);
				double x1x2x3x4 = operator(x1x2x3,numberorderlist[i][3],operatororderlist[j][2]);
				resultlist[0][i][j]=x1x2x3x4;
				
				double x3x4 = operator(numberorderlist[i][2],numberorderlist[i][3],operatororderlist[j][2]);
				double x1x2x3x4_22=operator(x1x2,x3x4,operatororderlist[j][1]);
				resultlist[1][i][j]=x1x2x3x4_22;
						
				double x3x1x2 = operator(numberorderlist[i][2],x1x2,operatororderlist[j][1]);
				double x3x1x2x4_31=operator(x3x1x2,numberorderlist[i][3],operatororderlist[j][2]);
				resultlist[2][i][j]=x3x1x2x4_31;
				
				if (x1x2x3x4==24){
					resultnumberorder[0][ct0] = numberorderlist[i];
					resultoperatororder[0][ct0] = operatororderlist[j];
					ct0++;
				}
				if (x1x2x3x4_22==24){
					resultnumberorder[1][ct1] = numberorderlist[i];
					resultoperatororder[1][ct1] = operatororderlist[j];
					ct1++;
				}
				if (x3x1x2x4_31==24){
					resultnumberorder[2][ct2] = numberorderlist[i];
					resultoperatororder[2][ct2] = operatororderlist[j];
					ct2++;
				}
			}
	}
	
	public void print(){
		m=0;
		for(int n=0;n<50;n++){
			if (resultnumberorder[m][n][0]==0&&resultnumberorder[m][n][1]==0)
				break;
			System.out.printf("((");
			System.out.printf("%d", (int)resultnumberorder[m][n][0]);
			print_opt(resultoperatororder[m][n][0]);
			System.out.printf("%d", (int)resultnumberorder[m][n][1]);
			System.out.printf(")");
			print_opt(resultoperatororder[m][n][1]);
			System.out.printf("%d", (int)resultnumberorder[m][n][2]);
			System.out.printf(")");
			print_opt(resultoperatororder[m][n][2]);
			System.out.printf("%d", (int)resultnumberorder[m][n][3]);
			System.out.printf("\t");
		}
		m=1;
		for(int n=0;n<50;n++){
			if (resultnumberorder[m][n][0]==0&&resultnumberorder[m][n][1]==0)
				break;
			System.out.printf("(");
			System.out.printf("%d", (int)resultnumberorder[m][n][0]);
			print_opt(resultoperatororder[m][n][0]);
			System.out.printf("%d", (int)resultnumberorder[m][n][1]);
			System.out.printf(")");
			print_opt(resultoperatororder[m][n][1]);
			System.out.printf("(");
			System.out.printf("%d", (int)resultnumberorder[m][n][2]);
			print_opt(resultoperatororder[m][n][2]);
			System.out.printf("%d", (int)resultnumberorder[m][n][3]);
			System.out.printf(")");
			System.out.printf("\t");
		}
		m=2;
		for(int n=0;n<50;n++){
			if (resultnumberorder[m][n][0]==0&&resultnumberorder[m][n][1]==0)
				break;
			System.out.printf("(");
			System.out.printf("%d", (int)resultnumberorder[m][n][2]);
			print_opt(resultoperatororder[m][n][1]);
			System.out.printf("(");
			System.out.printf("%d", (int)resultnumberorder[m][n][0]);
			print_opt(resultoperatororder[m][n][0]);
			System.out.printf("%d", (int)resultnumberorder[m][n][1]);
			System.out.printf("))");
			print_opt(resultoperatororder[m][n][2]);
			System.out.printf("%d", (int)resultnumberorder[m][n][3]);
			System.out.printf("\t");
		}
		System.out.printf("\n");
	}
	
	public double operator(double x1, double x2, int opt){
		double temp=0;
		switch(opt)
		{
		case 0:
			temp=x1+x2;
			break;
		case 1:
			temp=x1-x2;
			break;
		case 2:
			temp=x1*x2;
			break;
		case 3:
			temp=x1/x2;
			break;
		}
		return temp;
	}
	
	public void print_opt(int opt){
		switch(opt)
		{
			case 0:
				System.out.printf("+");
				break;
			case 1:
				System.out.printf("-");
				break;
			case 2:
				System.out.printf("*");
				break;
			case 3:
				System.out.printf("/");
				break;
		}
	}
	
}
