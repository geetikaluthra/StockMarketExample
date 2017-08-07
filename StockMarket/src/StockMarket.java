import java.util.HashMap;
import java.util.Map;

public class StockMarket {
	
	public static void main(String[] args) {    
	    //Creating map of Books    
		String b="Buy";
		String s="Sell";
	    Map<String,StockExample> map=new HashMap<String,StockExample>();    
	    //Creating Books    
	    StockExample s1=new StockExample(1,b,"ABC",10);    
	    StockExample s2=new StockExample(2,s,"XYZ",15);    
	    StockExample s3=new StockExample(3,s,"ABC",13);
	    StockExample s4=new StockExample(4,b,"XYZ",10);
	    StockExample s5=new StockExample(5,b,"XYZ",8);
	    
	    //Adding Books to map   
	    map.put(b,s1);  
	    map.put(s,s2);  
	    map.put(s,s3);
	    map.put(b,s4);
	    map.put(b,s5);
	      
	   
	}  

}
