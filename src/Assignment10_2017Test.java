/*
 * Student Name: Ciaran Winnan
 * Student number: 2940836
 *
 *
 **/
/*
For this assignment the class Coin is given. You are required to complete the methods
for the Purse class and then complete the class Assignment10_2017Test by writing JUnit 
test methods that check all of its methods.*/

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
public class Assignment10_2017Test{
  //create a Purse instance and write asserts that test its methods. 
  Purse purse;
  public Assignment10_2017Test(){
    purse = new Purse();
    purse.add(Arrays.asList(Coin.TWENTY, Coin.FIVE, Coin.TWO, Coin.TWENTY));
    
  }
  
  @Test
  public void testAdd(){
  	Coin addCoin = Coin.TWO; 
  	purse.add(addCoin);
  	assertEqauls(purse,Coin.TWENTY, Coin.FIVE, Coin.TWO, Coin.TWENTY, Coin.TWO);
  }
  
  /*@Test
  public void testAddList(){
  	List<Coin> tmp = new ArrayList<>(Arrays.asList(Coin.TWENTY, Coin.FIVE, Coin.TWO, Coin.TWENTY, COIN.TWO));
  	assertEqauls(purse, tmp);
  }*/
  
  
}

class Purse{
	private ArrayList<Coin> purse;
	
	Purse(){
		purse = new ArrayList<>();
	}
	
	public void add(Coin c){
		//add coin to purse
		purse.add(c);
	}
	
	public void add(List<Coin> coins){
		//add a fist of coins to the purse
		purse.addAll(coins);
	}
	public boolean contains(Coin c){
		//check if coin is in the purse
		return purse.contains(c);
	}
	public boolean remove(Coin c){
		//remove a single coin from purse if it is in the purse
		return purse.remove(c);
	}
	public boolean removeAll(Coin c){
		//remove all coin c from purse if it is in the purse
		Iterator<Coin> iterator = purse.iterator();
        while (iterator.hasNext()) {
        	purse.remove(c);
        }
        return true;
	}
	public int freq(Coin c){
		//calculate the frequency of c in the purse
		int count = 0;
        for(Coin temp : purse){
        	if(temp.equals(c)){
        		count++;
        	}
        }
        return count;
	}
	public int value(Coin c){
		//calculate the total value of c in the purse
		int coinTotal = 0;
		for(Coin temp : purse){
			if(temp.equals(c)){
				coinTotal = coinTotal + temp.value();
			}
		}
		return coinTotal;
	}
	public int sum(){
		//calculate the sum of money in the purse
		int purseSum = 0;
		for(Coin temp : purse){
			purseSum = purseSum + temp.value();
		}
		return purseSum;
	}
	public String getSum(){
		//return a string representation of the sum in euros
    	// e.g. 2.65
    	int purseSum = 0;
    	for(Coin temp : purse){
    		purseSum = purseSum + temp.value();
    	}
    	return purseSum+" Euros";
	}
	public String toString(){
		//string representation of all coins in purse
		String sumPurseString = "";
		for(Coin temp : purse){
			sumPurseString = sumPurseString + temp.toString()+"\n"; 
		}
		return sumPurseString;
	}
}

enum Coin{
	ONE,TWO,FIVE,TEN,TWENTY,FIFTY,ONEEURO,TWOEURO;
	public String toString(){
	  String lst[] = {"1 Cent","2 Cent","5 Cent","10 Cent","20 Cent","50 Cent","1 Euro","2 Euro"};
		return lst[this.ordinal()];
	}
	public int value(){
		int val[] ={1,2,5,10,20,50,100,200};
		return val[this.ordinal()];
	}
	public int add(Coin c){
		return (this.value()+ c.value());
	}
	public int add(int x){ //add sum of money in cents to this coin
	 if(x >= 0) return x + this.value();
	 else return this.value();
	}
}