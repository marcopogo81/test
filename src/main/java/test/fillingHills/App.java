package test.fillingHills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
	public static int test(final int[] serie){
		 System.out.println("Start");
		 
//		 final int[] serie = {5,2,1,4,2,0,5};
//		 final int[] serie = {0,3,0,0,1,0,2};
		 
		 //popolo la mappa con i valori
		 int max = Arrays.stream(serie).max().getAsInt();
		 
		 LinkedHashMap<Integer,ArrayList<Boolean>> map = new LinkedHashMap<Integer,ArrayList<Boolean>>(max);
		 
		 for(int i=1; i<=max; i++){
			 
			 map.put(new Integer(i), new ArrayList<Boolean>(){
				 private static final long serialVersionUID = -2103364651682123902L;

			{
				 for(int a=0; a<serie.length;a++){
					 int numberOfSerie = serie[a];
					 if(numberOfSerie>0){
						 add(new Boolean(true));
						 --serie[a];
					 }else{
						 add(new Boolean(false));
					 }
				 }
			 }});
		 }
		 
		 //riempio la mappa
		 System.out.println("mappa con valori popolata");
		 
		 int fillCounter = 0;
		 Set<Integer> k = map.keySet();
		 for (Iterator<Integer> iterator = k.iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			
			ArrayList<Boolean> list = (ArrayList<Boolean>) map.get(key);
			boolean canFill = false;
			System.out.println("Ciclo l'arrayList "+ list.toString());
			for(int a=0; a<list.size(); a++){
				Boolean boolean1 = (Boolean) list.get(a);
				if(boolean1.booleanValue()){
					//è true nun fa un cazzo
					canFill=true;
				}else{
					
					if(canFill){
						System.out.println("canFill True");
						//controllo che nella lista ci sia un true dopo
						boolean hasAWall = false;
						
						for(int y=a; y<list.size(); y++){
							System.out.println("riciclo sulla lista clonata indice["+y+"]");
							Boolean boolean2 = (Boolean) list.get(y);
							if(boolean2.booleanValue()){
								System.out.println("hasAWall True in posizione "+y);
								hasAWall = true;
								break;
							}
						}
						
						if(hasAWall){
							fillCounter++;
							System.out.println("Incremento fillcounter a ["+fillCounter+"]");
						}
						
					}
					
				}
			}
		}
		 
		return fillCounter;
		
	}
}
