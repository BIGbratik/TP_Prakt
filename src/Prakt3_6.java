//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;

public class Prakt3_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.println("\n Введите номер задания (от 1 до 10), которое хотите выполнить -");
		choice=in.nextInt();
		
		switch (choice)
		{
			//Практическое задание 1.1
			case 1:
				break;
		
			//Практическое задание 1.2
			case 2:
				break;
				
			//Практическое задание 1.3
			case 3:
				break;
				
			//Практическое задание 1.4
			case 4:
				break;
				
			//Практическое задание 1.5
			case 5:
					break;
			
			//Практическое задание 1.6
			case 6:
				break;
				
			//Практическое задание 1.7
			case 7:
				break;
				
			//Практическое задание 1.8
			case 8:
				break;
				
			//Практическое задание 1.9
			case 9:
				break;
				
			//Практическое задание 1.10
			case 10:
				break;
					
			default:
				System.out.println(" Задания, номер которого вы ввели, не существует");
		}
	}
}
