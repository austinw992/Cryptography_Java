import java.util.*;

public class encrypt {
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	
	encrypt(){
		
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		
		newKey();
		ask_question();
		
	}
	
	private void ask_question(){
		
		while(true) {
			System.out.println("What would you like to do?");
			System.out.println("(N)ewkey, \n (G)etkey, \n (E)ncrypt, \n (D)ecrypt, \n (Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			case'N':
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
				System.out.println("INVALID");
			
			}
		}
		
	}
	
	private void newKey() {
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i = 32; i < 127; i++) {
			
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("new key is created");
	}
	
	private void getKey() {
		
		System.out.println("Key: ");
		for(Character x : list) {
			System.out.print(x);
		}
		
		System.out.println("SHuffled Key: ");
		for (Character x: shuffledList) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	private void encrypt() {
		System.out.println("Enter the message to be encrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (letters [i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted: ");
		for (char x : letters) {
			System.out.print(x);;
		}
		System.out.println();
	}
	
	private void decrypt() {
		System.out.println("Enter the message to be decrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < shuffledList.size(); j++) {
				if (letters [i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted: ");
		for (char x : letters) {
			System.out.print(x);;
		}
		System.out.println();
		
	}
	
	private void quit() {
		
		System.out.println("Had fun Encrypting and Decrypting");
		System.exit(0);
		
	}
	
}
