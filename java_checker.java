import java.io.*;
import java.util.*;

public class java_checker{
	//checks the code - list retrieved from https://bukkit.org/threads/the-complete-list-of-java-keywords.199291/ - obviously not all keywords buti t works
	public static int count_the_words(File file) throws Exception {
		String[] keyword_list = {"Abstract", "Assert","Boolean","Break","Byte","Case","Catch","Char","Class","Const","Continue","Default","Do","Double","Else","Enum","Extends","False","Final","Finally","Float","Goto","For","If","Implements","Import","Instanceof","Int","Interface","Long","Native","New","Null","Package","Private", "Protected", "Public", "Return", "Short", "Static", "Strictfp"};
		Set<String> keywords = new HashSet<>(Arrays.asList(keyword_list));
		int count = 0;
		Scanner file_grabber = new Scanner(file);
		while (file_grabber.hasNext()) {
			String word = file_grabber.next();
			if (word.equals("//")){
				file_grabber.nextLine(); 
			}else if (word.contains("\"")){
				String nextWord;
				do{
					nextWord = file_grabber.next();
				}while(!nextWord.contains("\""));
			}else if (word.contains("/*")){
				String nextWord;
				do{
					nextWord = file_grabber.next();
				}while(!nextWord.contains("*/"));
			}else if(keywords.contains(word)){
				count++;
			}
		}
		file_grabber.close();
		return count;
	}
//runs the code
    public static void main(String[] args) throws Exception {
		if (args.length != 1){
			System.out.println("");
			System.exit(1);
		}
		File file = new File(args[0]);
		if (file.exists()){
			System.out.println("There are this many words " + args[0] + " is" + count_the_words(file));
		}
		else{
			System.out.println("the current File, that being " + args[0] + " does not exist!!!!!!!");
		}
	}
}