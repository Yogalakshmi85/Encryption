package encrypt;

import java.util.*;

public class encryptionProcess {
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffList;
	private char character;
	private char[] letters;
	public String encodedmes;
	private char[] secretletters;
	
	encryptionProcess(){
		scanner=new Scanner(System.in);
		random=new Random();
		list= new ArrayList();
		shuffList = new ArrayList();
		
		ask();
	}
	
	private void ask() {
		while(true) {
			
			System.out.println("*********************************************");
			System.out.println("What do you want to do!?");
			System.out.println("N for new key geration");
			System.out.println("G for Get key");
			System.out.println("E for encrypt");
			System.out.println("D for decrypt");
			System.out.println("*********************************************");
		
			char res=Character.toUpperCase(scanner.nextLine().charAt(0));
		
			switch (res){
			case 'N': 
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Invalid response...");		
			}
		}
	}
	
	private void newKey() {
		character=' ';
		list.clear();
		shuffList.clear();
		
		for(int i=32;i<127;i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffList = new ArrayList(list);
		Collections.shuffle(shuffList);
		System.out.println("A new key has been generated!!!!!");
		
	}
	private void getKey() {
		System.out.println("Key generated:");
		for(char x : list) {
			System.out.print(x);
		}
		
		System.out.println();
		for(char x : shuffList) {
			System.out.print(x);
		}
		System.out.println();
	}
	
	private void encrypt() {
		System.out.println("Enter a message to encode:");
		String mess = scanner.nextLine();
		letters=mess.toCharArray();
		
		for(int i=0;i<letters.length;i++) {
			for(int j=0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i]=shuffList.get(j);
					break;
					
				}
			}
		}
		
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
		encodedmes=new String(letters);
	}
	
	private void decrypt() {
		secretletters=encodedmes.toCharArray();
		
		for(int i=0;i<secretletters.length;i++) {
			for(int j=0;j<shuffList.size();j++) {
				if(secretletters[i]==shuffList.get(j)) {
					secretletters[i]=list.get(j);
					break;
				}
			}
		}
		for(char x : secretletters) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void quit() {
		System.out.println("Thankyou for coming....");
		System.exit(0);
	}

}
