import java.util.Scanner;

/*
 * 
 * �Ի����˶���ϵͳ
 * 
 * */
public class ChlmOne {
	public static void main(String[] args) {
// ******** һ������Ϣ  ��Ҫ���� ÿ����������Ϣ
		String[] names = new String[4];  //����������
		String[] dishes = new String[4]; // ��ѡ��Ʒ
		int[] times = new int[4]; // �Ͳ�ʱ��  Ҫ�� ��10 ��8
		String[] address = new String[4]; //�Ͳ͵�ַ
		int[] status = new int[4]; //����״̬ 0����Ԥ�� 1�������
		double[] sumprices = new double[4]; //�ܽ��
		
		// �������е�ÿ������ Ĭ����Ϣ
		names[0] = "����";
		dishes[0] = "������ 2��";
		times[0] = 12;
		address[0] = "ʯ��ׯ";
		status[0]= 0;
		sumprices[0] = 76;
		
		names[1] = "�ϸ�";
		dishes[1] = "������˿ 3��";
		times[1] = 12;
		address[1] = "ʯ��ׯ";
		status[1]= 1;
		sumprices[1] = 54;
		// ��  ��ѡ��Ĳ�Ʒ��Ϣ 
		String[] dishesname = new String[]{"������","������˿","ʱ���߲�"};  //��ѡ���Ʒ
		double[] prices = new double[]{ 38.0 , 18.0 , 10.0}; //��Ʒ����
		int[] praisenum = new int[3];    // ��Ʒ������ 

/*
 * *************** ��  	������ 
		ѭ����do while�� // ��������ж�
		ѭ�������� 1�� ��ʾ���˵�    2�� ��ʾ�û����빦��   3����ʾ����0 ����ѭ��
		ѭ������ �� ����0��
		
		���û��������ʾ������صĲ�����switch��
*/
		Scanner input = new Scanner(System.in);
		System.out.print("��ӭʹ��\" �Ի����˶���ϵͳ\""+"\n");
		int num = -1;// ѭ������
//		1�� ��ʾ���˵�
		do{
			System.out.println("**********************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("**********************************");
//			2�� ��ʾ�û����빦��
			System.out.print("��ѡ��");
			int choose = input.nextInt();  // ��¼�û��Ĺ��ܱ��
			boolean isAdd = false;  // ��¼�Ƿ���Զ���
			switch( choose ){
			case 1:
// *********************��	1����Ҫ����
				System.out.println("*****��Ҫ����*****");
				//1 ��ȡ��Ʒ��Ϣ
				for(int i=0; i<names.length;i++){
					// �ҵ�һ����λ�� ������Ӷ�����Ϣ
					if(names[i] == null){
						isAdd = true;  //�ñ�ʾλ ���Զ��� �ҵ���һ���յ�λ��
						// ִ�в������
						// a ��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0; j<dishesname.length;j++){
							String price = prices[j]+"Ԫ"; // ��ȡ�����еĵ��� prices[]
							String praise = praisenum[j]+"��"; // ����ĵ����� praise[]
							System.out.println((j+1)+"\t"+dishesname[j]+"\t"+price+"\t"+praise);
						}
						
						// ������ѡ��Ʒ����Լ�����
						System.out.print("��������ѡ��Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.print("��ѡ������������");
						int number = input.nextInt();
						String dishess = dishesname[chooseDish-1] + number+"��";//��ȡ����
						
//						b ���붩��������
						System.out.print("���붩����������");
						String name = input.next();
						
//						c ���붩��ʱ��
						
						System.out.print("����(10~20)��֮�ڶ��ͣ�");
						int time = input.nextInt();
						while(time<10 || time>20){
							System.out.print("�Բ��������������������10~20��֮���������");
							time = input.nextInt();
						}
						
//						d �����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String addres = input.next();
						
//						e ����ͷ�    				// ��Ʒ�۸�		//��Ʒ����
						double sumprice = prices[chooseDish-1] * number;
						// �Ͳͷѣ����ͷѴ���50Ԫʱ ��6Ԫ�Ͳͷ�
						double deilCharge = (sumprice>=50)?0:6;
						
						// ��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("�㶨���ǣ�"+dishess);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ��"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+addres);
						System.out.println("�ͷѣ���"+sumprice+"Ԫ");
						System.out.println("�ܽ���"+(sumprice+deilCharge)+"Ԫ");
						
						names[i] = name;
						dishes[i] = dishess;
						times[i] = time;
						address[i] = addres;
						sumprices[i] = (sumprice+deilCharge);
						break;
					}
				}
				if(isAdd == false){
					System.out.println("�Բ�����Ĳ͵�������");
				}
				break;
			case 2:
				//2���鿴�ʹ�"
					System.out.println("*****�鿴�ʹ�******");
					System.out.println("���\t"+"״̬\t"+"������\t"+"�Ͳ�ʱ��\t"+"�Ͳ͵�ַ\t"+"�ܽ��\t"+"��ѡ��Ʒ��Ϣ\t");
				for(int i=0; i<names.length;i++){
					if(names[i] != null){
						String time = times[i]+"��";
						String sumprice = sumprices[i]+"Ԫ";
						String statu = status[i] == 0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+statu+"\t"+names[i]+"\t"+time+"\t"+address[i]+"\t"+sumprice+"\t"+dishes[i]);
					}
				}
				break;
			case 3:
				//3��ǩ�ն���
				System.out.println("******ǩ�ն���******");
				System.out.print("������Ҫǩ�յĶ�����ţ�");
				int order = input.nextInt();
				boolean FF = false;
				for(int i=0; i<names.length;i++){
//					1 �ҵ� ״̬������� ������ǩ��
					if(names[i] != null && status[i] ==1 && order == (i+1)){
						System.out.println("�Բ�����Ķ����Ѿ����ǩ�գ������ٴ�ǩ��");
						FF = true;
						break;
//						2 �ҵ�״̬���Ѿ�Ԥ�� ��ʾ����ǣ��
					}else if(names[i] != null && status[i] ==0 && order == (i+1)){
						status[i] = 1;
						System.out.println("����ǩ�ճɹ�");
						FF = true;
						break;
					}
				}
//				3 �����ж� ���û���������� ��ʾû���ҵ�
				if( FF == false){
					System.out.println("�Բ��𣬴˶���������");
				}
				break;
			case 4:
				//4��ɾ������
//				1 ����Ҫɾ���Ķ������
				System.out.println("******ɾ������******");
				System.out.print("��ѡ����Ҫɾ���Ķ�����ţ�");
//				2ѭ��������������
				int deleteid = input.nextInt();
				int deleteids = -1; // ����һ��������ȡɾ���±�
				boolean AA = false;  // ��ʶλ
				for(int i=0 ;i<names.length;i++){
//					�������  1 �ҵ����� ��ǩ�� ִ��ɾ������
					if(names[i] !=null && status[i] == 1 && deleteid == i+1 ){
						deleteids = i;
						AA = true;
						break;
					}
					if(names[i] !=null && status[i] == 0 && deleteid == i+1 ){
//						2 �����
						AA = true;
						System.out.println("�Բ��𣬴˶���δ��ǩ�գ�����ɾ��");
						break;
					}
				}
				
//				3�����
//				3 �����ж� ���û���������� ��ʾû���ҵ�
				if( AA == false){
					System.out.println("�Բ��𣬴�ɾ��������Ų�����");
				}
				
				if(deleteids != -1){
					
					for(int i=deleteids+1; i<names.length-1;i++){
						names[i-1] = names[i];
						dishes[i-1] = dishes[i];
						times[i-1] = times[i];
						address[i-1] = address[i];
						status[i-1] = status[i];
					}
					names[names.length-1] = null;
					dishes[names.length-1] = null;
					times[names.length-1] = 0;
					address[names.length-1] = null;
					status[names.length-1] = 0;
					System.out.println("����ɾ���ɹ�");
				}
				
				break;
			case 5:
				//5����Ҫ����
				System.out.println("******��Ҫ����******");
			
				
				// ѭ����Ʒ��Ϣ
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0; j<dishesname.length;j++){
					String price = prices[j]+"Ԫ"; // ��ȡ�����еĵ��� prices[]
					String praise = praisenum[j]+"��"; // ����ĵ����� praise[]
					System.out.println((j+1)+"\t"+dishesname[j]+"\t"+price+"\t"+praise);
				}
				// ��ȡ����Ĳ�Ʒ�������
				System.out.print("�������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishesid = input.nextInt();
				// �Ի�ȡ�Ĳ�Ʒ������+1;
				praisenum[dishesid-1] ++;
				// ��ʾ
				System.out.println("���޳ɹ�");
				System.out.println(dishesname[dishesid-1]+praisenum[dishesid-1]+"��");
				break;
			case 6:
				//6���˳�ϵͳ
				break;
			default:
					break;
			}
			
// **************** ��  �˳�ϵͳ
			//  �˳�ϵͳ
			if( choose<1 || choose>5){
				break;
			}else{
//				3����ʾ����0 ����ѭ��
				System.out.print("����0���أ�");
				num = input.nextInt();
			}
//			
			
		}while( num == 0);
		// ���û���ʾ
		System.out.print("ллʹ�ã���ӭ�´ι��٣�");
	}
}
