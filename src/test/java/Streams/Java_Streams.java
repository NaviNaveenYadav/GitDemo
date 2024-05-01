package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java_Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Naveen");
		names.add("Anand");
		names.add("Vegeta");
		names.add("Ash");
		names.add("Goku");
		names.add("Abhi");
		names.add("Beerus");
		names.add("Whis");
		names.add("Piccolo");
		names.add("Broly");
				
		
		//Count the number of names starting with Letter 'A' in that list
		int count = 0;
		for(int i=0;i<names.size();i++) {
			String name = names.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println("Using for Loop method - Total number of names starting with letter \"A\" is "+count);
		
		
		//UsingStreams - Count the number of names starting with Letter 'A' in that list
		
		//There is no life for the Intermediate (Filter) operation if there is No terminal operation (Methods - count)
		//Terminal operation (Methos) will only execute if intermediate operations return true
		long cnt = names.stream().filter(S -> S.startsWith("A")).count();
		System.out.println("Using Streams - Total number of names starting with letter \"A\" is " +cnt);
		
		
		//Print all the names of Array List
//		Stream.of("Naveen","Navi","Vegeta","Kakarott").forEach(S -> System.out.println(S));
		
		//Print the names which are more than 4 characters in it
//		names.stream().filter(s->s.length()>4).forEach(S->System.out.println(S));
		
		//using the Limit method, will limit the count of results of the filtered ones
//		names.stream().filter(s->s.length()>4).limit(1).forEach(S->System.out.println(S));
		
		
		//Print the names of length>5 with Upper case
//		Stream.of("Naveen","Navi","Ash","Na","Vegeta","Kakarott","Mani Kanta","Rishi varun").filter(S->S.length()>5)
//					.map(S->S.toUpperCase()).forEach(S->System.out.println(S));
		 
		//Print the names having >3 characters and sort it
//		Stream.of("Naveen","Rishi","Varun","Navi","Vegeta","Mani","Ajay","Ashi","Kakarott").filter(S->S.length()>3)
//					.sorted().map(s->s.toUpperCase()).forEach(S->System.out.println(S));
		
		
		List<String> list1 = Arrays.asList("Naveen","Rishi","Varun","Navi","Mani","Ajay","Ashi");
		List<String> list2 = Arrays.asList("Vegeta","Goku","Beerus","Whis","Gohan","Champa","Vados");
		
		Stream<String> lst = Stream.concat(list1.stream(), list2.stream());
//		lst.sorted().forEach(S->System.out.println(S));
		
//		boolean flag = lst.anyMatch(S->S.equalsIgnoreCase("Naveen"));
//		System.out.println(flag);
		
//		boolean flag1 = lst.anyMatch(S->S.equalsIgnoreCase("Prince"));
//		System.out.println(flag1);
		
		
//		Convert the Streams back to their original or any other data type
		
		List<String> myList = Stream.of("Vegeta","Goku","Beerus","Whis","Gohan","Champa","Vados").sorted().map(S->S.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(myList);
		
		//Print the unique numbers and sort the numbers
		List<Integer> numbers = Arrays.asList(6,7,5,4,3,3,3,3,3,5,5,4,4,7,7,7,1,0,0,0,0,9,9,6,5,4,3,2,1,8,1,12,67);
		
		List<Integer> unique = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(unique);
		
	}

}
