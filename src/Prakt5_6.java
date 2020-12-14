import java.util.Scanner;

public class Prakt5_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice=0;
		while (choice!=-1)
		{
			System.out.println("\n Введите номер задания (от 1 до 10), которое хотите выполнить -");
			choice=in.nextInt();
			switch (choice)
			{
				//Практическое задание 5.1
				case 1:
					break;
			
				//Практическое задание 5.2
				case 2:
					break;
					
				//Практическое задание 5.3
				case 3:
					break;
					
				//Практическое задание 5.4
				case 4:
					break;
					
				//Практическое задание 5.5
				case 5:
					break;
				
				//Практическое задание 5.6
				case 6:
					break;
					
				//Практическое задание 5.7
				case 7:
					break;
					
				//Практическое задание 5.8
				case 8:
					break;
					
				//Практическое задание 5.9
				case 9:
					break;
					
				//Практическое задание 5.10
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

}
