import java.util.*;

public class Converter {
	
	public void generate()
	{
		HashMap<String, String> oct = new HashMap<String, String>();
        oct.put("000", "0");
        oct.put("001", "1");
        oct.put("010", "2");
        oct.put("011", "3");
        oct.put("100", "4");
        oct.put("101", "5");
        oct.put("110", "6");
        oct.put("111", "7");
        
        HashMap<String, String> hex = new HashMap<String, String>();
        hex.put("0", "0000");
        hex.put("1", "0001");
        hex.put("2", "0010");
        hex.put("3", "0011");
        hex.put("4", "0100");
        hex.put("5", "0101");
        hex.put("6", "0110");
        hex.put("7", "0111");
        hex.put("8", "1000");
        hex.put("9", "1001");
        hex.put("A", "1010");
        hex.put("B", "1011");
        hex.put("C", "1100");
        hex.put("D", "1101");
        hex.put("E", "1110");
        hex.put("F", "1111");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers to generate: ");
        int num = sc.nextInt();
        System.out.print("How many digits: ");
        int dig = sc.nextInt();
        sc.close();
        
        ArrayList<StringBuilder> arr = new ArrayList<StringBuilder>(); //to store all the hex numbers
        
        //the following loop creates hexadecimal numbers with Math.random()
        for(int i = 0; i< num; i++)
        {
        	StringBuilder sb = new StringBuilder(); //creates a string to build a hex number
        	
        	for(int j = 0; j< dig; j++) //for each digit
        	{
        		int n = (int) (Math.random()*16); //select a number randomly
        		if(j==0) //check the left-most digit
        		{
        			while(n==0) //keep generating random numbers if it is zero
        			{
        				n = (int) (Math.random()*16);
        			}
        		}
    			if(n==10)
    			{
    				sb.append("A");
    			}
    			else if(n==11)
    			{
    				sb.append("B");
    			}
    			else if(n==12)
    			{
    				sb.append("C");
    			}
    			else if(n==13)
    			{
    				sb.append("D");
    			}
    			else if(n==14)
    			{
    				sb.append("E");
    			}
    			else if(n==15)
    			{
    				sb.append("F");
    			}
    			else
    			{
    				sb.append(n);
    			}
        	}
        	System.out.println("Hexdecimal: "+sb);
        	arr.add(sb); //add the hex number to the ArrayList arr
        }
        
        //the following loop changes each hex number to binary number with HashMap hex
        for(StringBuilder s : arr) 
        {
        	System.out.println();
        	System.out.println("Hexdecimal: "+s);
        	
        	StringBuilder s2 = new StringBuilder(); //a new string to build binary number
        	for(int i = 0; i< s.length(); i++)
        	{
        		s2.append(hex.get(s.substring(i, i+1))); // converted into binary
        	}
        	
        	while(s2.substring(0,1).equals("0"))
        	{
        		s2.delete(0, 1); //omit leading zeros
        	}
        	
        	System.out.println("Binary: "+s2);
        	
        	
        	//to convert to octal, break the string into pieces of three
        	if(s2.length()%3==1)
        	{
        		s2.insert(0, "00");
        	}
        	else if(s2.length()%3==2)
        	{
        		s2.insert(0, "0");
        	}
        	
        	
        	StringBuilder s3 = new StringBuilder();
        	for(int i = 0; i<s2.length(); i=i+3)
        	{
        		s3.append(oct.get(s2.substring(i, i+3)));
        	}
        	while(s3.substring(0,1).equals("0"))
        	{
        		s3.delete(0, 1);
        	}
        	System.out.println("Octal: "+s3);
        }
        
	}
	
	
	
	public static void main(String[] args)
	{
		Converter cvt = new Converter();
		cvt.generate();
	}
}
