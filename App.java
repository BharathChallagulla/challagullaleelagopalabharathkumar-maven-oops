package com.epam.maven_demo;

/*
Problem Statement:- 
Creating a new year gift which contains some sweets.
when we are creating a gift we will give number of chocolates and number of candies to be kept in that gift box.
when we instantiated the chocolates class we want to get the chocolates names in ascending or descending order.
when we instantiated the candies class we want to get the number of candies in the gift.
*/
import java.util.*;
//Sweets class is taken as parent class which creates a gift by instantiating Sweets class 
class Sweets
{
	static int no_of_chocolates;
	static int no_of_candies;
	public Sweets() {}
	//Overloads the Sweets class constructor
	public Sweets(int choco,int candi)
	{
		no_of_chocolates=choco;
		no_of_candies=candi;
	}

}
//Sorting the chocolates data according to chocolates names 
class Chocolates extends Sweets{
	
	String choco_names[] = new String[no_of_chocolates];
//	getting names of chocolates
	public void name_choco() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<no_of_chocolates;i++) {
			System.out.println("Enter Chocolate name:");
			choco_names[i] = sc.next();
		}
	}
	
//	sorting nams of chocolates
	public void sort_choco_names(String order) {
		String temp;
		for(int i=0; i<no_of_chocolates; i++)
        {
            for(int j=1; j<no_of_chocolates; j++)
            {
                if(choco_names[j-1].compareTo(choco_names[i])<0)
                {
                    temp = choco_names[j-1];
                    choco_names[j-1] = choco_names[i];
                    choco_names[i]=temp;
                }
            }
        }
		if(order.compareTo("a")<0) {
			for(int i=0;i<no_of_chocolates;i++)
			    System.out.println(choco_names[i]);
		}
		else {
			 for(int i=(no_of_chocolates-1);i>=0;i--)
				    System.out.println(choco_names[i]);
		}
	}
		
}
//Defining Candies class to return the no_of_candies and particular range
class Candies extends Sweets{
	public void count_candies(){
		if(no_of_candies<=50 && no_of_candies>0)
			System.out.println("No. of candies lies in between 1 and 50 " + no_of_candies);
		else if(no_of_candies<=100 && no_of_candies>50)
			System.out.println("No. of candies lies in between 50 and 100 " + no_of_candies);
		else
			System.out.println("No. of candies" + no_of_candies);
	}
}
//main class
public class App{	
	public static void main(String args[]){	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of Gifts:");
		int no_of_gifts = sc.nextInt();
		int nchoco,ncandy,i;
		for(i=0;i<no_of_gifts;i++) {
			System.out.println("Keeping chocos and candy into gift boxes");
			System.out.println("Enter no of chocos:");
			nchoco = sc.nextInt();
			System.out.println("Enter no of candies:");
			ncandy = sc.nextInt();
			Sweets s1 = new Sweets(nchoco,ncandy);
			while(true) {
				System.out.println("1.Total weight\n2.Sorting the Choclates\n3.No. of Candies\n4.Exit");
				int ch = sc.nextInt();
				if (ch == 1) {
					System.out.println(nchoco + ncandy);
				}
				else if(ch == 2) {
					Chocolates c=new Chocolates();
				    c.name_choco();
				    System.out.println("Enter 'a' for ascending order\n enter 'd' for descending order:");
				    String a=sc.next();
				    c.sort_choco_names(a);
				}
				else if(ch == 3) {
					if(ncandy == 0)
						System.out.println("zero candies");
					else {
						Candies cd = new Candies();
						cd.count_candies();
					}
				}
				else {
					break;
				}
				
			}
			System.out.println((i+1) + "nd Gift completed");
		}
		
		 
	}
}
