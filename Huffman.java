package b;
import java.util.Scanner;
public class Huffman {
	public static void main(String[] args)
	{
		Memory[] Memory1 = new Memory[26]; //存储表
		int memory = 0; //记录存储表中有几个信源字符
		Tree[] Tree1 = new Tree[26]; //编码树
		int tree = 0; //记录编码树字符个数
		Handle[] Handle1 = new Handle[26]; //处理区
		int handle = 0; //记录处理区共有几个字符
		
		//[1]输入一串字符串作为信源。定义使用【大写字母】作为信源，小写字母用于合并新符号。
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		System.out.println("请输入一个由大写字母组成的字符串，回车键运行。");
		String origin = input.next();
		int total = origin.length(); //获取字符串总长度，作为总概率
		
		//[2]将信源信号分解到处理区
		for(int i=0;i<total;i++)
		{
			char temp = origin.charAt(i); //获取一个字符
			boolean flag = false; //判定字符是否出现
			for(int j=0;j<handle;j++) 
			{
				if(Handle1[j].name == temp) //已经出现过
				{
					Handle1[j].percentage++; //就直接加一
					flag = true;
				}
			}
			if(flag == false)
			{
				Handle1[handle] = new Handle();
				Handle1[handle].name = temp;
				Handle1[handle].percentage++;
				handle++; //记录字符，增加权值
			}
		}
		
		//[3]分解完毕，将信源符号记录到存储表
		for(int k=0; k<handle; k++)
		{
			Memory1[k] = new Memory();
			Memory1[k].name = Handle1[k].name;
			
		}
		memory = handle;
		//[4]开始概率和处理循环
		char abc = 'a';
		while(total>0)
		{
			//[4.1]将信源符号按概率递减顺序排列,这里用选择排序。
			for(int i=0;i<handle-1;i++)
			{
				int max=0,location=0;
				for(int j=i;j<handle;j++)
				{ //找出i~handle中权值最大的一个字符
					if (Handle1[j].percentage>max)
					{
						max = Handle1[j].percentage;
						location = j;
					}
				}
				//将该字符与首位交换
				Handle temp = new Handle();
				temp.name = Handle1[location].name;
				temp.percentage = Handle1[location].percentage;
				Handle1[location].name = Handle1[i].name;
				Handle1[location].percentage = Handle1[i].percentage;
				Handle1[i].name = temp.name;
				Handle1[i].percentage = temp.percentage;
			}
			//[4.2]把两个最小的概率加起来，作为新符号的概率
			if(Handle1[0].percentage == total)break; //防止信源只有一个符号
			else
			{   
				//将中间符号记录到编码树
				Tree1[tree] = new Tree();
				Tree1[tree].father = abc;
				Tree1[tree].lchild = Handle1[handle-2].name;
				Tree1[tree].rchild = Handle1[handle-1].name;
				//合并最后两个编码
				Handle1[handle-2].name = abc;
				Handle1[handle-2].percentage += Handle1[handle-1].percentage;
				//数值处理操作
				handle--;	tree++;		abc++;
			}
			if(Handle1[0].percentage == total)break;
		}
		//全部处理完成后，处理区只剩下一个树根，数据存储在编码树。

		//[5]寻找从每一信源符号到概率为1处的路径，记录下路径上的1和0
		for(int i=0;i<memory;i++)
		{
			char search = Memory1[i].name;
			while(memory>0)
			{  //开始从叶子回溯到根节点
				boolean flag = false;
				int location=0;
				for(int j=0;j<tree;j++)
				{
					if (Tree1[j].lchild == search)
					{
						flag = true;
						Memory1[i].sequence = "1" + Memory1[i].sequence;
						location = j;
					}
					else if (Tree1[j].rchild == search)
					{
						flag = true;
						Memory1[i].sequence = "0" + Memory1[i].sequence;
						location = j;
					}
				}
				if(flag == true)
				{ 	search =  Tree1[location].father; }
				else
				{ //已经到根节点，输出“1”“0”序列。
					System.out.println(Memory1[i].name +"   "+ Memory1[i].sequence);
					break;
				}
			}
		}
	}
}

class Handle //处理区，对每一步的权值进行处理
{   char name='0'; //存储信源符号和新符号
	int percentage=0; //符号占比
}
class Memory  //存储表，存储最后生成的序列
{	char name; //存储信源符号
	String sequence=""; } //存储信源序列
class Tree //编码树，存储每一个结点的子女
{    char father,lchild,rchild; }
