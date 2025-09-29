import java.io.*;
public class Polynomial{

    double [] x;
    int [] y;
    
    public Polynomial(){
    
	x = new double []{0};
	y = new int []{1};
	
    }
    public Polynomial(double [] input1, int [] input2){
    
	x = (double[]) input1.clone();
	y = (int[]) input2.clone();
	
    }
    public Polynomial(File file1) throws IOException{
	BufferedReader input = new BufferedReader(new FileReader(file1));
	String expression = input.readLine();
	
	expression = expression.replaceAll("-", "+-");
	
	if(expression.charAt(0) == '+'){
	    expression = expression.substring(1);
	}
	
	String [] expressionarray = expression.split("[+]");
	
	int expressionlength = expressionarray.length;
	
	double [] coeff = new double [expressionlength];
	int [] power = new int [expressionlength];
	
	String [] expressionterm;
	
	for (int i = 0; i < expressionlength; i++){
	    expressionterm = expressionarray[i].split("[x]");
	    if (expressionterm.length == 2){
		coeff[i] = Double.parseDouble(expressionterm[0]);
		power[i] = Integer.parseInt(expressionterm[1]);
	    }
	    else{
		coeff[i] = Double.parseDouble(expressionterm[0]);
		power[i] = 0;
	    }
	}
	
	x = (double[]) coeff.clone();
	y = (int[]) power.clone();
    }
    public Polynomial add(Polynomial express2){
    
	double [] x2 = (double[]) express2.x.clone();
    
	int size = express2.x.length + x.length;

	for(int i = 0; i < express2.x.length; i++){
	    for(int j = 0; j < x.length; j++){
		if (y[j] == express2.y[i]){
		    x[j] += x2[i];
		    x2[i] = 0;
		    size--;
		    break;
		}
	    }
	}
	double [] newx = new double [size];
	int [] newy = new int [size];
	for(int i = 0; i < x.length; i++){
	    newx[i] = x[i];
	    newy[i] = y[i];
	}
	
	int count = 0;
	
	for(int i = 0; i < x2.length; i++){
	    if(x2[i] != 0){
		newx[x.length + count] = x2[i];
		newy[x.length + count] = express2.y[i];
		count++;
	    }
	}

	Polynomial result = new Polynomial(newx, newy);

	return result;
    }
    public double evaluate(double xval){
	
	double sum = 0;
	
	for(int i = 0; i < x.length; i++){
	    sum += x[i]*(Math.pow(xval, y[i]));
	}
	return sum;
    }
    public boolean hasRoot(double xroot){
	if (this.evaluate(xroot) == 0){
	    return true;
	}
	return false;
    }
    public Polynomial multiply(Polynomial express2){
	Polynomial sumpoly = new Polynomial();
	double [] coeff = new double [x.length];
	int [] power = new int [x.length];
	for(int i = 0; i < express2.x.length; i++){
	    for(int j = 0; j < x.length; j++){
		coeff[j] = express2.x[i]*x[j];
		power[j] = express2.y[i]+y[j];
	    }
	    if(i == 0){
		sumpoly = new Polynomial(coeff, power);
	    }
	    else{
		sumpoly = sumpoly.add(new Polynomial(coeff, power));
	    }                       
	}
	return sumpoly;
    }
    public void saveToFile(String filename) throws IOException{
	String expression = "";
	
	File file1 = new File(filename + ".txt");
	
	file1.createNewFile();
	
	for (int i = 0;i < x.length; i++){
	    if (y[i] == 0){
		if (x[i] < 0){
		    expression = expression + (int)x[i] ;
		}
		else{
		    expression = expression + "+" + (int)x[i];
		}               
	    }
	    else if (y[i] == 1){
		 if (x[i] < 0){
		    expression = expression + (int)x[i] + "x";
		}
		else{
		    expression = expression + "+" + (int)x[i] + "x";
		}               
	    }
	    else{
		if (x[i] < 0){
		    expression = expression + (int)x[i] + "x" + y[i];
		}
		else{
		    expression = expression + "+" + (int)x[i] + "x" + y[i];
		} 
	    }
	}
	expression = expression.substring(1);
	FileWriter writer = new FileWriter(file1);
	writer.write(expression);
	writer.close();
    }
    public static void main (String args[]){
	
    }
}
