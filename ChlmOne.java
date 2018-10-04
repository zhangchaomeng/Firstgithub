import java.util.Scanner;

/*
 * 
 * 吃货联盟订餐系统
 * 
 * */
public class ChlmOne {
	public static void main(String[] args) {
// ******** 一订单信息  我要订餐 每条订单的信息
		String[] names = new String[4];  //订餐人姓名
		String[] dishes = new String[4]; // 所选菜品
		int[] times = new int[4]; // 送餐时间  要求 早10 晚8
		String[] address = new String[4]; //送餐地址
		int[] status = new int[4]; //订餐状态 0：已预订 1：已完成
		double[] sumprices = new double[4]; //总金额
		
		// 给订单中的每条数据 默认信息
		names[0] = "张孟";
		dishes[0] = "红烧鱼 2份";
		times[0] = 12;
		address[0] = "石家庄";
		status[0]= 0;
		sumprices[0] = 76;
		
		names[1] = "孟哥";
		dishes[1] = "鱼香肉丝 3份";
		times[1] = 12;
		address[1] = "石家庄";
		status[1]= 1;
		sumprices[1] = 54;
		// 二  供选择的餐品信息 
		String[] dishesname = new String[]{"红烧鱼","鱼香肉丝","时令蔬菜"};  //供选择餐品
		double[] prices = new double[]{ 38.0 , 18.0 , 10.0}; //餐品单价
		int[] praisenum = new int[3];    // 餐品点赞数 

/*
 * *************** 二  	整体框架 
		循环（do while） // 先输出在判断
		循环操作： 1： 显示主菜单    2： 提示用户输入功能   3：提示输入0 继续循环
		循环条件 ： 输入0；
		
		对用户输入的提示进行相关的操作（switch）
*/
		Scanner input = new Scanner(System.in);
		System.out.print("欢迎使用\" 吃货联盟订餐系统\""+"\n");
		int num = -1;// 循环条件
//		1： 显示主菜单
		do{
			System.out.println("**********************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("**********************************");
//			2： 提示用户输入功能
			System.out.print("请选择：");
			int choose = input.nextInt();  // 记录用户的功能编号
			boolean isAdd = false;  // 记录是否可以订餐
			switch( choose ){
			case 1:
// *********************四	1、我要订餐
				System.out.println("*****我要订餐*****");
				//1 获取餐品信息
				for(int i=0; i<names.length;i++){
					// 找到一个空位置 可以添加订单信息
					if(names[i] == null){
						isAdd = true;  //置表示位 可以订餐 找到了一个空的位置
						// 执行插入操作
						// a 显示所有可供选择的餐品信息
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for(int j=0; j<dishesname.length;j++){
							String price = prices[j]+"元"; // 获取数组中的单价 prices[]
							String praise = praisenum[j]+"赞"; // 数组的点赞数 praise[]
							System.out.println((j+1)+"\t"+dishesname[j]+"\t"+price+"\t"+praise);
						}
						
						// 输入所选餐品编号以及份数
						System.out.print("请输入所选餐品序号：");
						int chooseDish = input.nextInt();
						System.out.print("请选择锁定份数：");
						int number = input.nextInt();
						String dishess = dishesname[chooseDish-1] + number+"份";//获取菜名
						
//						b 输入订餐人姓名
						System.out.print("输入订餐人姓名：");
						String name = input.next();
						
//						c 输入订餐时间
						
						System.out.print("请在(10~20)点之内订餐：");
						int time = input.nextInt();
						while(time<10 || time>20){
							System.out.print("对不起，你的输入有误，请输入10~20的之间的整数：");
							time = input.nextInt();
						}
						
//						d 输入送餐地址
						System.out.print("请输入送餐地址：");
						String addres = input.next();
						
//						e 计算餐费    				// 餐品价格		//餐品份数
						double sumprice = prices[chooseDish-1] * number;
						// 送餐费，当餐费大于50元时 免6元送餐费
						double deilCharge = (sumprice>=50)?0:6;
						
						// 显示订单信息
						System.out.println("订餐成功！");
						System.out.println("你定的是："+dishess);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间"+time+"点");
						System.out.println("送餐地址！"+addres);
						System.out.println("餐费：！"+sumprice+"元");
						System.out.println("总金额：！"+(sumprice+deilCharge)+"元");
						
						names[i] = name;
						dishes[i] = dishess;
						times[i] = time;
						address[i] = addres;
						sumprices[i] = (sumprice+deilCharge);
						break;
					}
				}
				if(isAdd == false){
					System.out.println("对不起，你的餐单已满，");
				}
				break;
			case 2:
				//2、查看餐袋"
					System.out.println("*****查看餐袋******");
					System.out.println("序号\t"+"状态\t"+"订餐人\t"+"送餐时间\t"+"送餐地址\t"+"总金额\t"+"所选餐品信息\t");
				for(int i=0; i<names.length;i++){
					if(names[i] != null){
						String time = times[i]+"点";
						String sumprice = sumprices[i]+"元";
						String statu = status[i] == 0?"已预定":"已完成";
						System.out.println((i+1)+"\t"+statu+"\t"+names[i]+"\t"+time+"\t"+address[i]+"\t"+sumprice+"\t"+dishes[i]);
					}
				}
				break;
			case 3:
				//3、签收订单
				System.out.println("******签收订单******");
				System.out.print("请输入要签收的订单序号：");
				int order = input.nextInt();
				boolean FF = false;
				for(int i=0; i<names.length;i++){
//					1 找到 状态是已完成 不能再签收
					if(names[i] != null && status[i] ==1 && order == (i+1)){
						System.out.println("对不起，你的订单已经完成签收，不能再次签收");
						FF = true;
						break;
//						2 找到状态是已经预定 表示可以牵手
					}else if(names[i] != null && status[i] ==0 && order == (i+1)){
						status[i] = 1;
						System.out.println("订单签收成功");
						FF = true;
						break;
					}
				}
//				3 条件判断 如果没有这条订单 显示没有找到
				if( FF == false){
					System.out.println("对不起，此订单不存在");
				}
				break;
			case 4:
				//4、删除订单
//				1 输入要删除的订单序号
				System.out.println("******删除订单******");
				System.out.print("请选择你要删除的订单序号：");
//				2循环查找这条订单
				int deleteid = input.nextInt();
				int deleteids = -1; // 定义一个变量获取删除下标
				boolean AA = false;  // 标识位
				for(int i=0 ;i<names.length;i++){
//					三种情况  1 找到订单 已签收 执行删除操作
					if(names[i] !=null && status[i] == 1 && deleteid == i+1 ){
						deleteids = i;
						AA = true;
						break;
					}
					if(names[i] !=null && status[i] == 0 && deleteid == i+1 ){
//						2 中情况
						AA = true;
						System.out.println("对不起，此订单未被签收，不能删除");
						break;
					}
				}
				
//				3中情况
//				3 条件判断 如果没有这条订单 显示没有找到
				if( AA == false){
					System.out.println("对不起，此删除订单序号不存在");
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
					System.out.println("订单删除成功");
				}
				
				break;
			case 5:
				//5、我要点赞
				System.out.println("******我要点赞******");
			
				
				// 循环餐品信息
				System.out.println("序号\t餐品名\t单价\t点赞数");
				for(int j=0; j<dishesname.length;j++){
					String price = prices[j]+"元"; // 获取数组中的单价 prices[]
					String praise = praisenum[j]+"赞"; // 数组的点赞数 praise[]
					System.out.println((j+1)+"\t"+dishesname[j]+"\t"+price+"\t"+praise);
				}
				// 获取输入的餐品点赞序号
				System.out.print("请输出你要点赞的餐品序号：");
				int dishesid = input.nextInt();
				// 对获取的餐品点赞数+1;
				praisenum[dishesid-1] ++;
				// 显示
				System.out.println("点赞成功");
				System.out.println(dishesname[dishesid-1]+praisenum[dishesid-1]+"赞");
				break;
			case 6:
				//6、退出系统
				break;
			default:
					break;
			}
			
// **************** 三  退出系统
			//  退出系统
			if( choose<1 || choose>5){
				break;
			}else{
//				3：提示输入0 继续循环
				System.out.print("输入0返回：");
				num = input.nextInt();
			}
//			
			
		}while( num == 0);
		// 给用户提示
		System.out.print("谢谢使用，欢迎下次光临！");
	}
}
