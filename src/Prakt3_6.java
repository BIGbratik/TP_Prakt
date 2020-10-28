//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;

public class Prakt3_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.print("\n Введите номер задания (от 1 до 10), которое хотите выполнить - ");
		choice=in.nextInt();
		in.nextLine();
		
		switch (choice)
		{
			//Практическое задание 3.1
			case 1:
				int a,b,c;
				System.out.println("Введите значения A, B, C:");
				a=in.nextInt();
				b=in.nextInt();
				c=in.nextInt();
				in.nextLine();
				
				solutions(a,b,c);
				break;
		
			//Практическое задание 3.2
			case 2:
				String strZip;
				System.out.println("Введите строку:");
				strZip=in.nextLine();
				
				findZip(strZip);
				break;
				
			//Практическое задание 3.3
			case 3:
				int perfectNum;
				System.out.print("Введите ваше число: ");
				perfectNum=in.nextInt();
				in.nextLine();
				
				checkPerfect(perfectNum);
				break;
				
			//Практическое задание 3.4
			case 4:
				String strFlip;
				System.out.println("Введите вашу строку:");
				strFlip=in.nextLine();
				
				flipEndChars(strFlip);
				break;
				
			//Практическое задание 3.5
			case 5:
				String str16X;
				System.out.print("Введите выше 16-ричное число: ");
				str16X=in.nextLine();
				
				isValidHexCode(str16X);
				break;
			
			//Практическое задание 3.6
			case 6:
				String mas1, mas2;
				System.out.println("Введите первый массив (элементы отделять только ',' и без пробелов!!!)");
				mas1=in.nextLine();
				System.out.println("Введите второй массив (элементы отделять только ',' и без пробелов!!!)");
				mas2=in.nextLine();
				
				same(mas1, mas2);
				break;
				
			//Практическое задание 3.7
			case 7:
				int num;
				System.out.print("Введите ваше цело положительное число: ");
				num=in.nextInt();
				in.nextLine();
				
				isKaprekar(num);
				break;
				
			//Практическое задание 3.8
			case 8:
				String zeroOnes;
				System.out.println("Введите вашу строку нулей и единиц:");
				zeroOnes=in.nextLine();
				
				longestZero(zeroOnes);
				break;
				
			//Практическое задание 3.9
			case 9:
				int simp;
				System.out.print("Введите ваше число: ");
				simp=in.nextInt();
				in.nextLine();
				
				nextPrime(simp);
				break;
				
			//Практическое задание 3.10
			case 10:
				int A,B,C;
				System.out.println("Введите длины сторон:");
				A=in.nextInt();
				B=in.nextInt();
				C=in.nextInt();
				
				rightTriangle(A,B,C);
				break;
					
			default:
				System.out.println(" Задания, номер которого вы ввели, не существует");
		}
	}
	
	//Метод, определяющий сколько решений имеет квадратное уравнение, исходя из переданных коэффициентов
	public static void solutions(int a,int b,int c)
	{
		double disc;
		disc=Math.pow(b, 2) - 4 * a * c;
		if (disc > 0)
			System.out.println("Уравнение с данными коэффициентами имеет 2 решения");
		else if (disc == 0)
			System.out.println("Уравнение с данными коэффициентами имеет 1 решение");
		else
			System.out.println("Уравнение с данными коэффициентами не имеет  решений");
	}
	
	//Метод, определяющий второе вхождение подстроки "zip" в строку
	public static void findZip(String strZip)
	{
		int indexZip1, indexZip2;
		indexZip1=strZip.indexOf("zip");
		strZip=strZip.substring(indexZip1+3);
		indexZip2=strZip.indexOf("zip");
		if (indexZip2!=-1)
				System.out.println("Индекс второго вхождения 'zip' в указанной строке: "
						+(indexZip2+indexZip1+3+1));
		else
			System.out.println("Индекс второго вхождения 'zip' в указанной строке: "
					+indexZip2);
	}
	
	//Метод, определяющий явлется ли число совершенным
	public static void checkPerfect(int perfectNum)
	{
		int sum=0;
		for (int i = 1; i < perfectNum; i++)
		{
			if (perfectNum % i == 0)
				sum+=i;
		}
		System.out.println(" "+(sum==perfectNum));
	}

	//Метод, изменяющий первый и последний символы в строке
	public static void flipEndChars(String strFlip)
	{
		if (strFlip.length()>1)
		{
			if (strFlip.charAt(0)!=strFlip.charAt(strFlip.length()-1))
			{
				System.out.println("\n"+strFlip.charAt(strFlip.length()-1)
				+strFlip.substring(1, strFlip.length()-1)+strFlip.charAt(0));
			}
			else
			{
				System.out.println("\n Two's a pair!!!");
			}
		}
		else
		{
			System.out.println("\n Incompatible!!!");
		}
	}

	//Метод, который определяет является ли 16х код действительным
	public static void isValidHexCode(String str16X)
	{
		boolean isHex=true;
		if ((str16X.length()==7)&&(str16X.charAt(0)=='#'))
		{
			for (int i = 1; i<str16X.length();i++)
			{
				if (((int)str16X.charAt(i)<48)
					||(((int)str16X.charAt(i)>57)&&((int)str16X.charAt(i)<65))
					||(((int)str16X.charAt(i)>70)&&((int)str16X.charAt(i)<97))
					||((int)str16X.charAt(i)>102))
				{
					isHex=false;
					break;
				}
			}
		}
		else
		{
			isHex=false;
		}
		System.out.println(" "+isHex);
	}
	
	//Метод, сравнивающих кол-во уникальных элементов массива
	public static void same(String mas1, String mas2)
	{
		int uniq1 = 1;
		int uniq2 = 1;
		int povtor = 0;
		
		String[] Mas1=mas1.split(",");
		String[] Mas2=mas2.split(",");
		
		int n1 = Mas1.length;
		int n2 = Mas2.length;
		
		for (int i = 1; i < n1; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (Mas1[j].equals(Mas1[i]))
					povtor+=1;
			}
			if (povtor==0)
				uniq1+=1;
			povtor=0;
		}
		
		for (int i = 1; i < n2; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (Mas2[j].equals(Mas2[i]))
					povtor+=1;
			}
			if (povtor==0)
				uniq2+=1;
			povtor=0;
		}
		System.out.println(uniq1==uniq2);
	}

	//Метод, поределяющий явялется ли переданное число число Каприкара
	public static void isKaprekar(int num)
	{
		int numSqr=(int)Math.pow(num, 2);
		String str = Integer.toString(numSqr);
		int num1,num2,n;
		n=str.length();
		if (n%2==0)
		{
			num1 = Integer.parseInt(str.substring(0, n/2)); 
			num2 = Integer.parseInt(str.substring(n/2, n));
		}
		else if ((n%2==1)&&(n>1))
		{
			num1 = Integer.parseInt(str.substring(0, n/2)); 
			num2 = Integer.parseInt(str.substring(n/2, n));
		}
		else
		{
			num1 = 0;
			num2 = numSqr;
		}
		System.out.println(num1+" "+num2+" "+numSqr);
		System.out.println((num1+num2)==num);
	}

	//Метод, выводящий на экран самую длинную последовательность нулей из строки
	public static void longestZero(String zeroOnes)
	{
		int k=0;
		int kMax=0;
		int n = zeroOnes.length();
		for (int i = 0; i < n; i++)
		{
			if (zeroOnes.charAt(i)=='0')
			{
				if (k!=0)
				{
					k+=1;
				}
				else
				{
					k+=1;
				}	
			}
			else
			{
				if (k>kMax)
				{
					kMax=k;
				}
				k=0;
			}
		}
		if (kMax>0)
		{
			String str="";
			for (int i=0; i<kMax; i++)
				str=str +"0";
			System.out.println(str);
		}
		else
			System.out.println("В переданной строке нет нулей");
	}

	//Метод, выводящий ближайшее простое число к введённому
	public static void nextPrime(int simp)
	{
		int k=1;
		if (simp>1)
		{
			for (int i=2; i<simp; i++)
			{
				if (simp%i==0)
				{	
					k=0;
					break;
				}
			}	
		}
		if (k==1)
		{
			System.out.println("Ближайшее простое число: "+simp);
		}
		else
		{
			while (k!=1)
			{
				simp+=1;
				for (int j=2; j<simp; j++)
				{
					if (simp%j==0)
						break;
					else if (j==(simp-1))
						k+=1;
				}
			}
			System.out.println("Ближайшее простое число: "+simp);
		}
		
	}

	//Метод, првоерка на прямоугольность треугольника
	public static void rightTriangle(int A, int B, int C)
	{
		int gip=A;
		int a=B,b=C,c;
		if (a>gip)
		{
			c=gip;
			gip=a;
			a=c;
		}
		if (b>gip)
		{
			c=gip;
			gip=b;
			b=c;
		}
		System.out.println((Math.pow(a,2)+Math.pow(b,2))==Math.pow(gip, 2));
	}
}
