package test.fillingHills;

import java.util.Arrays;


public class App2 
{
	public static void main(String[] args){
		System.out.println(App2.waterCounter(new int[]{1,0,1,0,1,0,1}));
	}
	
	public static int waterCounter(int[] serie){
		 System.out.println("Start");
		 int fillCounter = 0;
		 if(serie == null || serie.length==0){
			 return fillCounter; 
		 }
		 
		 //popolo la mappa con i valori
		 int max = Arrays.stream(serie).max().getAsInt();
		 
		 int[][] mapArray = new int[max][serie.length];
		 for(int i=0; i<max; i++){
			 for(int a=0; a<serie.length;a++){
				 if(serie[a]>0){
					 mapArray[i][a]=1;
					 --serie[a];
				 }else{
					 mapArray[i][a]=0;
				 }
			 }
		 }
		 
		 //riempio la mappa
		 System.out.println("mappa con valori popolata");
		 
		 for(int i=0; i<max; i++){
			 int[] list= mapArray[i];
			 boolean foundedHill = false;
			 for(int a=0; a<list.length; a++){
				 if(list[a]==1){
					 foundedHill=true;
				 }else{
					 if(foundedHill){
						 for(int y=a; y<list.length; y++){
							 if(list[y]==1){
								 fillCounter++;
								 break;
							 }
						 }
					 }
				 }
			 }
		 }
		 
		 
		 return fillCounter;
		
	}
}
