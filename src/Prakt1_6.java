//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;


public class Prakt1_6 
{
	//Функция, выводящая остаток от деления параметров
	public static double RemOfDiv (double Divined, double Divider)
	{
		double Rem;
		Rem=Divined%Divider;
		return Rem;
	}
	
	//Функция, выводящая площадь треугольника (по высоте и основанию)
	public static double AreaTriang (double footing, double height)
	{
		double Area;
		Area=1/2*footing*height;
		return Area;
	}
	
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int choice;
		System.out.println("\nВведите номер задания (от 1 до 10), которое хотите выполнить -");
		choice=in.nextInt();
		switch (choice)
		{
			//Практическое задание 1.1
			case 1:
				double Div_d, Div_r, Rem;
				System.out.println("\nВведите делимое и делитель (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\nДелимое - ");
				Div_d=in.nextDouble();
				System.out.println("\nДелитель - ");
				Div_r=in.nextDouble();
				Rem=RemOfDiv(Div_d,Div_r);
				System.out.printf("\nОстаток от деления - %f",Rem);
				break;
		
			//Практическое задание 1.2
			case 2:
			default:
				System.out.println("Задания, номер которого вы ввели, не существует");
		}
		
	}
}
