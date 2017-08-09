import java.util.HashMap;
import java.util.Map;

public class StockMarket {
	static String b="Buy";
	static String s="Sell";
	public static void main(String[] args) {    

	    //Creating map     
	    Map<Integer,StockExample> map=new HashMap<Integer,StockExample>();
	    Map<String,Integer> stockinitialize=new HashMap<String,Integer>();
	    //Creating StockExample Objects    
	    StockExample s1=new StockExample(1,b,"ABC",10,0,"");    
	    StockExample s2=new StockExample(2,s,"XYZ",15,0,"");    
	    StockExample s3=new StockExample(3,s,"ABC",13,0,"");
	    StockExample s4=new StockExample(4,b,"XYZ",10,0,"");
	    StockExample s5=new StockExample(5,b,"XYZ",8,0,"");
	   
	    //Adding to map   
	    map.put(1,s1);  
	    map.put(2,s2);  
	    map.put(3,s3);
	    map.put(4,s4);
	    map.put(5,s5);
	    stockexchange(map,stockinitialize);
	    printstock(map,stockinitialize);
	    
	}
	//merging the two hashmaps and printing the final output
	public static void printstock(Map<Integer, StockExample> map, Map<String, Integer> stockinitialize)
	{
		System.out.println("Output:");
	    for(Map.Entry<Integer, StockExample> enty:map.entrySet()){    
	        int key=enty.getKey(); 
	        StockExample val=enty.getValue(); 
	        if(val.side.equalsIgnoreCase(s))
	        {
	        	String c=val.company;
	        	int q=val.squantity;
	        	for(Map.Entry<String, Integer> e:stockinitialize.entrySet()){  
	        		String cmpny=e.getKey();
	        		if(c.equalsIgnoreCase(cmpny)){
	        			val.fquantity=e.getValue();
	        			if(e.getValue()>0)
	        				val.state="OPEN";
	        			else
	        				val.state="CLOSED";
	        		}
	        	}
	        }
	        
	        System.out.println(+val.stockid +" "+ val.side +" " +val.company +" "+ val.squantity+" "+val.fquantity+" "+val.state);
	    }

		
	}
	
	public static void stockexchange(Map<Integer, StockExample> map, Map<String, Integer> stockinitialize){
		System.out.println("Input:");
		  //Traversing map  
		    for(Map.Entry<Integer, StockExample> entry:map.entrySet()){    
		        int key=entry.getKey(); 
		        StockExample val=entry.getValue(); 
		        //initializing the stock with sell side
		        if(val.side.equalsIgnoreCase(s)){
		        	stockinitialize.put(val.company, val.squantity);
		        } 	
		          
		        System.out.println(val.stockid +" "+ val.side +" " +val.company +" "+ val.squantity);   
		    }
		    
		    for(Map.Entry<Integer, StockExample> ety:map.entrySet()){    
		        int key=ety.getKey(); 
		        StockExample val=ety.getValue(); 
		        //initializing the stock with sell side
		        if(val.side.equalsIgnoreCase(b))
		        {
		        	String c=val.company;
		        	int q=val.squantity;
		        	for(Map.Entry<String, Integer> e:stockinitialize.entrySet()){  
		        		String cmpny=e.getKey();
		        		if(c.equalsIgnoreCase(cmpny)){
		        			int qty=e.getValue();
		        			//changing stock values according to stocks
		        			if(q==qty || q<qty)
		        			{
		        				val.fquantity=0;
		        				val.state="CLOSED";
		        				stockinitialize.replace(cmpny, qty-q);
		        			}
		        				
		        			else
		        			{
		        				val.fquantity=q-qty;
		        				val.state="OPEN";
		        				stockinitialize.replace(cmpny, 0);
		        			}
		        				
		        		}
		        		
		        		
		        	}
		        }
		        
		        
		    }
	}

}
