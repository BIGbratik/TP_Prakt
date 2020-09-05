//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;


public class Prakt1_6 
{
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
				double div_d, div_r, rem;
				System.out.println("\nВведите делимое и делитель (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\nДелимое - ");
				div_d=in.nextDouble();
				System.out.println("\nДелитель - ");
				div_r=in.nextDouble();
				rem=remOfDiv(div_d,div_r);
				System.out.printf("\nОстаток от деления - %f",rem);
				break;
		
			//Практическое задание 1.2
			case 2:
				double foot, height, area;
				System.out.println("\nВведите значения основания и высоты (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\nОснование - ");
				foot=in.nextDouble();
				System.out.println("\nВысота - ");
				height=in.nextDouble();
				area=areaTriang(foot,height);
				System.out.println("\nПлощадь треугольника - " + area);
				break;
			default:
				System.out.println("Задания, номер которого вы ввели, не существует");
		}
	}
	
	//Функция, выводящая остаток от деления параметров
	public static double remOfDiv (double divined, double divider)
	{
		double rem;
		rem=divined%divider;
		return rem;
	}
	
	//Функция, выводящая площадь треугольника (по высоте и основанию)
	public static double areaTriang (double footing, double height)
	{
		double area;
		area=(footing*height)/2;
		return area;
	}
}
