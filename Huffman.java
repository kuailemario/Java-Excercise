package b;
import java.util.Scanner;
public class Huffman {
	public static void main(String[] args)
	{
		Memory[] Memory1 = new Memory[26]; //�洢��
		int memory = 0; //��¼�洢�����м�����Դ�ַ�
		Tree[] Tree1 = new Tree[26]; //������
		int tree = 0; //��¼�������ַ�����
		Handle[] Handle1 = new Handle[26]; //������
		int handle = 0; //��¼���������м����ַ�
		
		//[1]����һ���ַ�����Ϊ��Դ������ʹ�á���д��ĸ����Ϊ��Դ��Сд��ĸ���ںϲ��·��š�
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		System.out.println("������һ���ɴ�д��ĸ��ɵ��ַ������س������С�");
		String origin = input.next();
		int total = origin.length(); //��ȡ�ַ����ܳ��ȣ���Ϊ�ܸ���
		
		//[2]����Դ�źŷֽ⵽������
		for(int i=0;i<total;i++)
		{
			char temp = origin.charAt(i); //��ȡһ���ַ�
			boolean flag = false; //�ж��ַ��Ƿ����
			for(int j=0;j<handle;j++) 
			{
				if(Handle1[j].name == temp) //�Ѿ����ֹ�
				{
					Handle1[j].percentage++; //��ֱ�Ӽ�һ
					flag = true;
				}
			}
			if(flag == false)
			{
				Handle1[handle] = new Handle();
				Handle1[handle].name = temp;
				Handle1[handle].percentage++;
				handle++; //��¼�ַ�������Ȩֵ
			}
		}
		
		//[3]�ֽ���ϣ�����Դ���ż�¼���洢��
		for(int k=0; k<handle; k++)
		{
			Memory1[k] = new Memory();
			Memory1[k].name = Handle1[k].name;
			
		}
		memory = handle;
		//[4]��ʼ���ʺʹ���ѭ��
		char abc = 'a';
		while(total>0)
		{
			//[4.1]����Դ���Ű����ʵݼ�˳������,������ѡ������
			for(int i=0;i<handle-1;i++)
			{
				int max=0,location=0;
				for(int j=i;j<handle;j++)
				{ //�ҳ�i~handle��Ȩֵ����һ���ַ�
					if (Handle1[j].percentage>max)
					{
						max = Handle1[j].percentage;
						location = j;
					}
				}
				//�����ַ�����λ����
				Handle temp = new Handle();
				temp.name = Handle1[location].name;
				temp.percentage = Handle1[location].percentage;
				Handle1[location].name = Handle1[i].name;
				Handle1[location].percentage = Handle1[i].percentage;
				Handle1[i].name = temp.name;
				Handle1[i].percentage = temp.percentage;
			}
			//[4.2]��������С�ĸ��ʼ���������Ϊ�·��ŵĸ���
			if(Handle1[0].percentage == total)break; //��ֹ��Դֻ��һ������
			else
			{   
				//���м���ż�¼��������
				Tree1[tree] = new Tree();
				Tree1[tree].father = abc;
				Tree1[tree].lchild = Handle1[handle-2].name;
				Tree1[tree].rchild = Handle1[handle-1].name;
				//�ϲ������������
				Handle1[handle-2].name = abc;
				Handle1[handle-2].percentage += Handle1[handle-1].percentage;
				//��ֵ�������
				handle--;	tree++;		abc++;
			}
			if(Handle1[0].percentage == total)break;
		}
		//ȫ��������ɺ󣬴�����ֻʣ��һ�����������ݴ洢�ڱ�������

		//[5]Ѱ�Ҵ�ÿһ��Դ���ŵ�����Ϊ1����·������¼��·���ϵ�1��0
		for(int i=0;i<memory;i++)
		{
			char search = Memory1[i].name;
			while(memory>0)
			{  //��ʼ��Ҷ�ӻ��ݵ����ڵ�
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
				{ //�Ѿ������ڵ㣬�����1����0�����С�
					System.out.println(Memory1[i].name +"   "+ Memory1[i].sequence);
					break;
				}
			}
		}
	}
}

class Handle //����������ÿһ����Ȩֵ���д���
{   char name='0'; //�洢��Դ���ź��·���
	int percentage=0; //����ռ��
}
class Memory  //�洢���洢������ɵ�����
{	char name; //�洢��Դ����
	String sequence=""; } //�洢��Դ����
class Tree //���������洢ÿһ��������Ů
{    char father,lchild,rchild; }
