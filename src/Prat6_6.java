import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prat6_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice=0;
		while (choice!=-1)
		{
			System.out.print("\n Введите номер задания (от 1 до 10), которое хотите выполнить - ");
			choice=in.nextInt();
			switch (choice)
			{
				//Практическое задание 6.1
				case 1:
					int n;
					System.out.print("Введите кол-во элементов множества - ");
					n=in.nextInt();
					
					bell(n);
					break;
			
				//Практическое задание 6.2
				case 2:
					int choic;
					System.out.print("Что вы хотите сделать ? (1 - перевести слово; 2 - перевести предложение) - ");
					choic=in.nextInt();
					in.nextLine();
					switch(choic)
					{
						case 1:
							System.out.print("Введите слово - ");
							String word = in.nextLine();
							System.out.println(translateWord(word));
							break;
						case 2:
							System.out.print("Введите предложение - ");
							String str = in.nextLine();
							translateSentence(str);
							break;
						default:
							System.out.println("Ваш выбор не возможен в данной системе!!!");
							break;	
					}
					break;
					
				//Практическое задание 6.3
				case 3:
					break;
					
				//Практическое задание 6.4
				case 4:
					break;
					
				//Практическое задание 6.5
				case 5:
					break;
				
				//Практическое задание 6.6
				case 6:
					break;
					
				//Практическое задание 6.7
				case 7:
					break;
					
				//Практическое задание 6.8
				case 8:
					break;
					
				//Практическое задание 6.9
				case 9:
					break;
					
				//Практическое задание 6.10
				case 10:
					break;
				
				//Завершение программы
				case -1:
					System.out.println("Работа программы завершена");
					break;
						
				default:
					System.out.println(" Задания, номер которого вы ввели, не существует");
			}
		}
	}
	
	//Метод определяющий число Белла по заданному число эл-в множества
	public static void bell(int n)
	{
		int[][] matr = new int[n+1][n+1]; 
        matr[0][0] = 1; 
          
        for (int i=1; i <= n; i++) 
        { 
        	matr[i][0] = matr[i-1][i-1]; 
            for (int j=1; j<=i; j++) 
            	matr[i][j] = matr[i-1][j-1] + matr[i][j-1]; 
        } 
        System.out.println("Кол-во возможных подмножеств = "+matr[n][0]);
	}
	
	//Перевод слова с английского на свинский
	public static String translateWord(String word)
	{
		String wordRes="";
		boolean isUpper = false;
		if (Character.isUpperCase(word.charAt(0)))
			isUpper=true;
		word=word.toLowerCase();
		if ("aeyuio".contains(word.substring(0,1).toLowerCase()))
		{
			wordRes+=word+"yay";
		}
		else
		{
			int i=0;
			while (!"aeyuio".contains(word.substring(i,i+1).toLowerCase()))
				i++;
			wordRes+=word.substring(i)+word.substring(0,i)+"ay";
		}
		if (isUpper)
			wordRes=wordRes.substring(0,1).toUpperCase()+wordRes.substring(1);
		return wordRes;
	}
	
	//Метод перевода предложения с английского на свинский
	public static void translateSentence(String str)
	{
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(str);
		int index = 0;
		while (m.find())
		{
			String word = m.group();
			index = str.indexOf(word, index);
			str = str.substring(0, index) + str.substring(index).replaceFirst(word, translateWord(word));
		}
		System.out.println(str);
	}
}


