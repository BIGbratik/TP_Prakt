import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
					int num;
					System.out.print("Введите целое положительное число от 0 до 999: ");
					num=in.nextInt();
					
					numToLang(num);
					break;
					
				//Практическое задание 5.8
				case 8:
					String str = new String();
					in.nextLine();
					System.out.print("Введите строку для хеширования: ");
					str=in.nextLine();
					
					getSHA256Hash(str);
					break;
					
				//Практическое задание 5.9
				case 9:
					String title = new String();
					
					in.nextLine();
					System.out.print("Введите строку из Игры Престолов - ");
					title=in.nextLine();
					correctTitle(title);
					break;
					
				//Практическое задание 5.10
				case 10:
					int hex;
					System.out.print("Введите число дял создания гексогональной решётки: ");
					hex=in.nextInt();
					
					hexLaticce(hex);
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

	//Метод производящий валидацию карты по средствал сравнения длины номера и теста Луна
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

	//Метод преобразующий введённое число в его словесный аналог на английском и русском языках
	public static void numToLang(int num)
	{
		String rus = new String();
		String eng = new String();
		
		rus="";
		eng="";
		
		if (num/100!=0)
		{
			switch (num/100) 
			{
				case 1:
					rus+="сто ";
					eng+="one hundred ";
					break;
				case 2:
					rus+="двести ";
					eng+="two hundred ";
					break;
				case 3:
					rus+="триста ";
					eng+="three hundred ";
					break;
				case 4:
					rus+="четыреста ";
					eng+="four hundred ";
					break;
				case 5:
					rus+="пятьсот ";
					eng+="five hundred ";
					break;
				case 6:
					rus+="шестьсот ";
					eng+="six hundred ";
					break;
				case 7:
					rus+="семьсот ";
					eng+="seven hundred ";
					break;
				case 8:
					rus+="восемьсот ";
					eng+="eight hundred ";
					break;
				case 9:
					rus+="девятьсот ";
					eng+="nine hundred ";
					break;
			}
		}
		switch ((num/10)%10) 
		{
			case 2:
				rus+="двадцать ";
				eng+="twenty ";
				break;
			case 3:
				rus+="тридцать ";
				eng+="thirty ";
				break;
			case 4:
				rus+="сорок ";
				eng+="forty ";
				break;
			case 5:
				rus+="пятьдесят ";
				eng+="fifty ";
				break;
			case 6:
				rus+="шестьдесят ";
				eng+="sixty ";
				break;
			case 7:
				rus+="семьдесят ";
				eng+="seventy ";
				break;
			case 8:
				rus+="восемьдесят ";
				eng+="eighty ";
				break;
			case 9:
				rus+="девяносто ";
				eng+="ninety ";
				break;
		}
		
		switch (num %10) 
		{
			case 0:
				if ((num/10)%10==1)
				{
					rus+="десять";
					eng+="ten";
				}
				else if (num==0)
				{
					rus+="ноль";
					eng+="zero";
				}
				break;
			case 1:
				if ((num/10)%10==1)
				{
					rus+="одинадцать";
					eng+="eleven";
				}
				else
				{
					rus+="один";
					eng+="one";
				}
				break;
			case 2:
				if ((num/10)%10==1)
				{
					rus+="двенадцать";
					eng+="twelve";
				}
				else
				{
					rus+="два";
					eng+="two";
				}
				break;
			case 3:
				if ((num/10)%10==1)
				{
					rus+="тринадцать";
					eng+="thiteen";
				}
				else
				{
					rus+="три";
					eng+="three";
				}
				break;
			case 4:
				if ((num/10)%10==1)
				{
					rus+="четырнадцать";
					eng+="fourteen";
				}
				else
				{
					rus+="четыре";
					eng+="four";
				}
				break;
			case 5:
				if ((num/10)%10==1)
				{
					rus+="пятнадцать";
					eng+="fifteen";
				}
				else
				{
					rus+="пять";
					eng+="five";
				}
				break;
			case 6:
				if ((num/10)%10==1)
				{
					rus+="шестнадцать";
					eng+="sixteen";
				}
				else
				{
					rus+="шесть";
					eng+="six";
				}
				break;
			case 7:
				if ((num/10)%10==1)
				{
					rus+="семнадцать";
					eng+="seventeen";
				}
				else
				{
					rus+="семь";
					eng+="seven";
				}
				break;
			case 8:
				if ((num/10)%10==1)
				{
					rus+="восемнадцать";
					eng+="eighteen";
				}
				else
				{
					rus+="восемь";
					eng+="eight";
				}
				break;
			case 9:
				if ((num/10)%10==1)
				{
					rus+="девятнадцать";
					eng+="nineteen";
				}
				else
				{
					rus+="девять ";
					eng+="nine ";
				}
				break;
		}
		System.out.println("Название числа по русски - "+rus+"\nНазвание числа по английски - "+eng);
	}

	//Метод хеширования сообщения методом SHA256
	public static void getSHA256Hash(String str)
	{
		byte[] byt=null;
		try
		{
			MessageDigest msg = MessageDigest.getInstance("SHA-256");
			byt=msg.digest(str.getBytes(StandardCharsets.UTF_8));
		}
		catch (Exception ex)
		{
			System.out.println("Уууупс, что-то пошло не так при хешировании");
		}
		
		BigInteger num = new BigInteger (1,byt);
		StringBuilder res = new StringBuilder(num.toString(16));
		while (res.length()<32)
		{
			res.insert(0,'0');
		}
		
		System.out.println(res);
	}

	/*Метод преобоазования тайтла из игры престолов таким образом, 
	 * что каждое слов кроме предлгогов должно начинаться с большой буквы, а далее идти строчные. 
	 * Предлоги полностью в строчном регистре*/
	public static void correctTitle(String str)
	{
		str=str.toLowerCase();
		String[] mas = str.split(" ");
		String res=new String();
		for (int i=0;i<mas.length;i++)
		{
			if (!(mas[i].contentEquals("and") || mas[i].contentEquals("of")
					|| mas[i].contentEquals("the") || mas[i].contentEquals("in")))
			{
				mas[i]=mas[i].substring(0,1).toUpperCase()+mas[i].substring(1);
			}
			res+=mas[i]+" ";
		}
		System.out.println("Скорректированная строка: "+res);
	}

	//Метод, строящий, при возможности, гексогональную рештки с введённым кол-м эл-в
	public static void hexLaticce(int num)
	{
		int countLines = 1;
		boolean isHex=true;
		while(3 * countLines * (countLines - 1) + 1 != num)
		{
			if (3 * countLines * (countLines - 1) + 1 > num)
			{
				System.out.println("По введённому числу невозможно построить решётку!!!");
				isHex=false;
				break;
			}
			countLines++;
		}
		if (isHex)
		{
			int lines = countLines * 2 - 1;
			String res = "";
			for (int i = 0; i < lines / 2; i++)
			{
				for (int j = 0; j < countLines - i; j++)
					res += " ";
				for (int cell = 0; cell < countLines + i; cell++)
					res += "o ";
				for (int j = 0; j < countLines - i -1; j++)
					res += " ";
				res += "\n";
			}
			for (int i = lines / 2; i < lines; i++)
			{
				for (int j = 0; j < countLines - (lines - i) + 1; j++)
					res += " ";
				for (int cell = 0; cell < countLines + (lines - i) - 1; cell++)
					res += "o ";
				for (int j = 0; j < countLines - (lines - i); j++)
					res += " ";
				res += "\n";
			}
			System.out.println(res);
		}
	}
}
