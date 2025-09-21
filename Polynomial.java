import java.io.*;
public class Polynomial{

    double [] x;
    
    public Polynomial(){
    
	x = new double []{0};
	
    }
    public Polynomial(double [] input){
    
	x = (double[]) input.clone();
	
    }
    public Polynomial add(Polynomial express2){
	
	int size;
    
	if (express2.x.length > x.length){
	    size = x.length;
	    for(int i = 0; i < size; i++){
		express2.x[i] = express2.x[i] + x[i];
	    }
	}
	else{
	    size = express2.x.length;
	    for(int i = 0; i < size; i++){
		x[i] = express2.x[i] + x[i];
	    }
	}
	
	if (express2.x.length > x.length){
	    return express2;
	}
	express2.x = x;
	return express2;
    }
    public double evaluate(double xval){
	
	double sum = 0;
	
	for(int i = 0; i < x.length; i++){
	    sum += x[i]*(Math.pow(xval, i));
	}
	return sum;
    }
    public boolean hasRoot(double xroot){
	if (this.evaluate(xroot) == 0){
	    return true;
	}
	return false;
    }
    public static void main (String args[]){
	
	
    }
}
