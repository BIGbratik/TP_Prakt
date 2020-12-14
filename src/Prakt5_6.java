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
					int chc = 0;
					System.out.print("Что необходимо выполнить (1 - декодировать; 2 - закодировать) ? - ");
					chc=in.nextInt();
					in.nextLine();
					
					switch (chc)
					{
						case 1:
							String code = new String();
							System.out.print("Введите массив-шифр целых чисел через пробел: ");
							code=in.nextLine();
							Decrypt(code);
							break;
						case 2:
							String phrase = new String();
							System.out.print("Введите фразу для зашифровывания: ");
							phrase = in.nextLine();
							Encrypt(phrase);
							break;
						default:
							System.out.println("Введённый номер действия не соответствует запрашиваемому!!!");
							break;
					}
					break;
			
				//Практическое задание 5.2
				case 2:
					String figure = new String();
					String start = new String();
					String finish = new String();
					
					in.nextLine();
					System.out.print("Введите название фигуры: ");
					figure = in.nextLine();
					System.out.print("Введите старотовую пазицию: ");
					start=in.nextLine();
					System.out.print("Введите позицию назначения: ");
					finish=in.nextLine();
					
					canMove(figure,start,finish);
					break;
					
				//Практическое задание 5.3
				case 3:
					String wordBefore = new String();
					String wordRes=new String();
					
					in.nextLine();
					System.out.print("Введите слово: ");
					wordBefore=in.nextLine();
					System.out.print("Введите желаемое слово: ");
					wordRes=in.nextLine();
					
					canComplete(wordBefore,wordRes);
					break;
					
				//Практическое задание 5.4
				case 4:
					String arrayNum = new String();
					in.nextLine();
					System.out.print("Введите целых чисел через пробел: ");
					arrayNum=in.nextLine();
					
					sumDigProd(arrayNum);
					break;
					
				//Практическое задание 5.5
				case 5:
					String wordStr = new String();
					in.nextLine();
					System.out.print("Введите строку слов разделённых пробелом: ");
					wordStr=in.nextLine();
					
					sameVowelGroup(wordStr);
					break;
				
				//Практическое задание 5.6
				case 6:
					String cardNumber = new String();
					in.nextLine();
					System.out.print("Введите номер карты: ");
					cardNumber=in.nextLine();
					validateCard(cardNumber);
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
	
	//Метод расшифровки сообщения, исходя из массива-шифра
	public static void Decrypt(String mas)
	{
		String[] shifr = mas.split(" ");
		
		int firstChr = Integer.parseInt(shifr[0]);
		
		String phrase = new String();
		phrase=""+((char)firstChr);
		
		if (shifr.length>1)
		{
			for (int i=1; i<shifr.length;i++)
			{
				firstChr=firstChr+Integer.parseInt(shifr[i]);
				phrase+=(char)(firstChr);
			}
		}
		System.out.print("Расшифрованная фраза: "+phrase);
	}
	
	//Метод шифровки сообщения
	public static void Encrypt(String msg)
	{
		String shifr = new String();
		shifr="";
		shifr+=(int)msg.charAt(0)+" ";
		int firstChr=(int)msg.charAt(0);
		int i=1;
		while(i<msg.length())
		{
			shifr+=(((int)msg.charAt(i))-firstChr)+" ";
			firstChr=(int)msg.charAt(i);
			i++;
		}
		System.out.println("Шифр введённого сообщения: "+shifr);	
	}

	//Метод определения возможности хода шахматной фигуры
	public static void canMove(String figure, String start, String finish)
	{
		figure=figure.toLowerCase();
		start=start.toUpperCase();
		finish=finish.toUpperCase();
		int wordStart="ABCDEFGH".indexOf(start.charAt(0));
		int wordFinish="ABCDEFGH".indexOf(finish.charAt(0));
		int numStart=(int)start.charAt(1);
		int numFinish=(int)finish.charAt(1);
		
		switch(figure)
		{
			case "пешка":
				System.out.println(Math.abs(numFinish-numStart)==1);
				break;
			case "конь":
				System.out.println(((Math.abs(wordFinish-wordStart)==2)&&(Math.abs(numFinish-numStart)==1))
						||((Math.abs(wordFinish-wordStart)==1)&&(Math.abs(numFinish-numStart)==2)));
				break;
			case "слон":
				System.out.println((Math.abs(wordFinish-wordStart)==(Math.abs(numFinish-numStart))));
				break;
			case "ладья":
				System.out.println((wordStart==wordFinish)||(numStart==numFinish));
				break;
			case "ферзь":
				System.out.println((wordStart==wordFinish)||(numStart==numFinish)
						||(Math.abs(wordFinish-wordStart)==(Math.abs(numFinish-numFinish))));
				break;
			case "королева":
				System.out.println((wordStart==wordFinish)||(numStart==numFinish)
						||(Math.abs(wordFinish-wordStart)==(Math.abs(numFinish-numStart))));
				break;
			case "король":
				System.out.println((Math.abs(numFinish-numStart)==1)||(Math.abs(wordFinish-wordStart)==1));
				break;
			default:
				System.out.println("Введённое название фигуры не соответствует ни одному известному !!!");
				break;
		}
	}

	//Метод проверки возможности составления второго слова из первого путём только добавления символов
	public static void canComplete(String word, String res)
	{
		int wordSimil=0;
		int resSimil=0;
		
		while((wordSimil<word.length())&&(resSimil<res.length()))
		{
			if (word.charAt(wordSimil)==res.charAt(resSimil))
			{
				wordSimil++;
				resSimil++;
			}
			else
				resSimil++;
		}
		System.out.println(wordSimil==word.length());
	}

	//Метод, который скалдывает числа и за тем умножает цифры до тех пор, пока не получится число из однйо цифры
	public static void sumDigProd(String str)
	{
		String[] strMas=str.split(" ");
		int sum=0;
		int resTemp;
		int res;
		for (int i=0;i<strMas.length;i++)
		{
			sum+=Integer.parseInt(strMas[i]);
		}
		while(sum>9)
		{
			resTemp=sum;
			res=1;
			while(resTemp>0)
			{
				res=res*(resTemp%10);
				resTemp=resTemp/10;
			}
			sum=res;
		}
		System.out.println("Результат: "+sum);
	}

	//Метод сравнивающий первое слово с остальными на предмет наличия в других словах тех же глассных, что и в первом
	public static void sameVowelGroup(String str)
	{
		String[] wordMas=str.split(" ");
		String res = new String();
		res=""+wordMas[0]+" ";
		String vowelWord="";
		String vowelMas="";
		
		boolean triger=true;
		
		for (int i=0; i<wordMas[0].length();i++) 
		{
			if (("AEYUIO".contains(wordMas[0].substring(i,i+1).toUpperCase()))
					&&(!vowelWord.contains(wordMas[0].substring(i,i+1).toUpperCase())))
			{
				vowelWord+=wordMas[0].substring(i,i+1).toUpperCase();
			}
		}
		
		if (wordMas.length>1)
		{
			for (int j=1; j<wordMas.length;j++)
			{
				for (int k=0; k<wordMas[j].length();k++) 
				{
					if (("AEYUIO".contains(wordMas[j].substring(k,k+1).toUpperCase()))
							&&(!vowelMas.contains(wordMas[j].substring(k,k+1).toUpperCase())))
					{
						vowelMas+=wordMas[j].substring(k,k+1).toUpperCase();
					}
				}
				
				for (int l=0; l<vowelWord.length();l++)
				{
					if (!vowelMas.contains(vowelWord.substring(l,l+1)))
					{
						triger=false;
						break;
					}
				}

				if (triger)
					res+=wordMas[j]+" ";
				vowelMas="";
				triger=true;
			}
		}
		System.out.println("Результирующая строка слов: "+res);
	}

	//Метод валидации карты по средствал сравнения длины номера и теста Луна
	public static void validateCard(String num)
	{
		boolean res;

		int temp;
		int sum=0;
		if ((num.length()<14)&&(num.length()>19))
		{
			res=false;
		}
		else
		{
			int ctrl = Integer.parseInt(num.substring(num.length()-1,num.length()));
			num=num.substring(0,num.length()-1);
			System.out.println(num+" "+ctrl);
			
			for (int i=num.length()-1; i>=0;i--)
			{
				if (((num.length()-1)-(i-1))%2!=0)
				{
					temp=2*(int)num.charAt(i);
					if (temp>9)
						temp=temp/10+temp%10;
					sum+=temp;
				}
				else
					sum+=(int)num.charAt(i);
			}
			
			res=((10-(sum%10))==ctrl);
		}
		System.out.println("Результат: "+res);
	}
}
