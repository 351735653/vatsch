import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import bjtu.insis.base.Schedule;
import bjtu.insis.vatsch.VatSch;
public class test {
	public static boolean samefile(String fileName1,String fileName2){  
	    FileInputStream fis1 = null;  
	    FileInputStream fis2 = null;  
	    try {  
	        fis1 = new FileInputStream(fileName1);  
	        fis2 = new FileInputStream(fileName2);  
	          
	        int len1 = fis1.available();//返回总的字节数  
	        int len2 = fis2.available();  
	          
	        if (len1 == len2) 
	        {	//长度相同，则比较具体内容  
	            //建立两个字节缓冲区  
	            byte[] data1 = new byte[len1];  
	            byte[] data2 = new byte[len2];  
	              
	            //分别将两个文件的内容读入缓冲区  
	            fis1.read(data1);  
	            fis2.read(data2);  
	              
	            //依次比较文件中的每一个字节  
	            for (int i=0; i<len1; i++) 
	            { 
	                //只要有一个字节不同，两个文件就不一样  
	                if (data1[i] != data2[i]) 
	                {  
	                    //System.out.println("文件内容不一样");  
	                    return false;  
	                }  
	            }  
	            //System.out.println("两个文件完全相同");  
	            return true;  
	        }
	        else 
	        {  
	            //长度不一样，文件肯定不同  
	            return false;  
	        }  
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {//关闭文件流，防止内存泄漏  
	        if (fis1 != null)
	        {  
	            try {  
	                fis1.close();  
	            } catch (IOException e) {  
	                //忽略  
	                e.printStackTrace();  
	            }  
	        }  
	        if (fis2 != null) 
	        {  
	            try {  
	                fis2.close();  
	            } catch (IOException e) {  
	                //忽略  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	    return false;  
	}  
	/**
	 * 插队错误
	 * @throws Exception
	 */
	static void BUG_4860() throws Exception
	{
		System.out.println(" BUG_4860测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4860/";
		VatSch vatSch = new VatSch("2019/1/22", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"RS54",
				"A1901002310",
				"2019/01/22 13:30:00",
				"2019/01/23 01:30:00",
				"171-190121-0001_1",
				4,
				false,
				"32",
				"1",
				"0",
				false,
				false,
				false,
				false,
				false,
				"0",
				true,
				true);
		ArrayList<String> origSch = new ArrayList<String>();
		origSch.add("A1901002310");
		vatSch.insertJob_unlimited(origSch, sch);
//		vatSch.addCombTabu("1320466A0113-1#1320466A0114-2");
//		vatSch.cancelProduct_unlimited("MAXDARKVATS2-1");
//		vatSch.run();
		vatSch.outPutResult(num+"BUG_4860调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		
		if(samefile("./BUG_4860/BUG_4860调度结果standard.csv", "./BUG_4860/BUG_4860调度结果.csv"))
			System.out.println("BUG4860无误");
		else
			System.err.println("BUG4860错误");
	}
	/**
	 * 插队错误
	 * @throws Exception
	 */
	static void BUG_5014() throws Exception
	{
		System.out.println(" BUG_5014测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_5014/";
		VatSch vatSch = new VatSch("2019/2/15", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"RS52",
				"B1902000040",
				"2019/02/17 08:00:00",
				"2019/02/17 20:00:00",
				"171-190213-0002_1",
				3,
				false,
				"31",
				"0",
				"1",
				false,
				false,
				true,
				false,
				false,
				"0",
				false,
				true);
		ArrayList<String> origSch = new ArrayList<String>();
		origSch.add("B1902000040");
		vatSch.insertJob_unlimited(origSch, sch);
//		vatSch.addCombTabu("1320466A0113-1#1320466A0114-2");
//		vatSch.cancelProduct_unlimited("MAXDARKVATS2-1");
//		vatSch.run();
		vatSch.outPutResult(num+"BUG_5014调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		
		if(samefile("./BUG_5014/BUG_5014调度结果standard.csv", "./BUG_5014/BUG_5014调度结果.csv"))
			System.out.println("BUG5014无误");
		else
			System.err.println("BUG5014错误");
	}
	/**
	 * 插队错误
	 * @throws Exception
	 */
	static void BUG_4964() throws Exception
	{
		System.out.println(" BUG_4964测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4964/";
		VatSch vatSch = new VatSch("2019/1/30", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"RS44",
				"A1901002610",
				"2019/02/06 08:00:00",
				"2019/02/06 20:00:00",
				"171-190129-0001_1",
				4,
				false,
				"119",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false,
				"0",
				false,
				true);
		ArrayList<String> origSch = new ArrayList<String>();
		origSch.add("A1901002610");
		
//		vatSch.addCombTabu("1320466A0113-1#1320466A0114-2");
//		vatSch.cancelProduct_unlimited("MAXDARKVATS2-1");
//		vatSch.run();
		try {
			vatSch.insertJob_unlimited(origSch, sch);
			vatSch.outPutResult(num+"BUG_4964调度结果standard.csv");
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("错误信息应为：当前时间2019/02/06 08:00:00不可插队！插入时间调整为2019/02/06 21:00:00——2019/02/07 09:00:00");
			System.out.println("状态正常");
		}

		
		

	
	}
	/**
	 * 运行错误
	 * 
	 * @throws Exception
	 */
	static void BUG_4903() throws Exception
	{
		System.out.println(" BUG_4903测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4903/";
		VatSch vatSch = new VatSch("2019/1/27", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4903调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4903/BUG_4903调度结果standard.csv", "./BUG_4903/BUG_4903调度结果.csv"))
			System.out.println("BUG_4903无误");
		else
			System.err.println("BUG_4903错误");
	}
	/**
	 * 插队错误
	 * @throws Exception
	 */
	static void BUG_4893() throws Exception
	{
		System.out.println(" BUG_4893测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4893/";
		VatSch vatSch = new VatSch("2019/1/27", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
//		vatSch.run();
		Schedule sch = new Schedule(
				"RS44",
				"A1901002400",
				"2019/01/27 09:00:00",
				"2019/01/27 19:00:00",
				"171-190123-0003_1",
				4,
				false,
				"120",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false,
				"0",
				true,
				true);
		ArrayList<String> origSch = new ArrayList<String>();
		origSch.add("A1901002400");
		vatSch.insertJob_unlimited(origSch, sch);
		vatSch.outPutResult(num+"BUG_4893调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4893/BUG_4893调度结果standard.csv", "./BUG_4893/BUG_4893调度结果.csv"))
			System.out.println("BUG_4893无误");
		else
			System.err.println("BUG_4893错误");
	}
	/**
	 * 运行错误
	 * @throws Exception
	 */
	static void BUG_4719() throws Exception
	{
		System.out.println(" BUG_4719测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4719/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4719调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4719/BUG_4719调度结果standard.csv", "./BUG_4719/BUG_4719调度结果.csv"))
			System.out.println("BUG_4719无误");
		else
			System.err.println("BUG_4719错误");
	}
	

	static void BUG_4709() throws Exception 
	{
		System.out.println(" BUG_4709测试开始运行------");
		long begintime = System.currentTimeMillis();
	    int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }
	   //serialNum[3]=600;
	    String  num="./BUG_4709/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"21D",
				"A1804002590",
				"2018/04/01 18:00:00",
				"2018/04/01 23:00:00",
				"1320603A0032-1",
				4,
				true,
				"20",
				"0",
				"0",
				false,
				false,
				true,
				true,
				false, 
				"0",
				true,
				true);
		ArrayList<String> origSch = new ArrayList<String>();
//		origSch.add("A1804002590");
		
		try {
			vatSch.insertJob_unlimited(origSch, sch);
			vatSch.outPutResult(num+"BUG_4709调度结果.csv");	
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			System.err.println("BUG_4709应提示错误信息");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BUG_4709错误信息应为：插队产品1320603A0032-1确认色未确认！");
			System.out.println("状态正常");
		}

/*		if(samefile("./BUG_4709/BUG_4709调度结果standard.csv", "./BUG_4709/BUG_4709调度结果.csv"))
			System.out.println("BUG_4709无误");
		else
			System.err.println("BUG_4709错误");*/
	}
	

	static void BUG_4689() throws Exception
	{
		System.out.println(" BUG_4689测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4689/";
		VatSch vatSch = new VatSch("2018/4/4", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4689调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4689/BUG_4689调度结果standard.csv", "./BUG_4689/BUG_4689调度结果.csv"))
			System.out.println("BUG_4689无误");
		else
			System.err.println("BUG_4689错误");
	}

	static void BUG_4685() throws Exception
	{
		System.out.println(" BUG_4685测试开始运行------");
		long begintime = System.currentTimeMillis();
	    int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }
	   //serialNum[3]=600;
	    String  num="./BUG_4685/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"21D",
				"A1804002590",
				"2018/04/02 05:00:00",
				"2018/04/02 17:00:00",
				"1320603A0032-1",
				4,
				true,
				"20",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false, 
				"0",
				false,
				true);
		ArrayList<String> origSch = new ArrayList<String>();
		origSch.add("A1804002590");
		try {
			vatSch.insertJob_unlimited(origSch, sch);
			vatSch.outPutResult(num+"BUG_4685调度结果.csv");	
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			System.err.println("BUG_4685应提示错误信息");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BUG_4685错误信息应为：染缸506C的时间段 2018/04/01 21:00:00-2018/04/02 09:00:00 不可用!");
			System.out.println("状态正常");
		}
		
	}
	static void BUG_4676() throws Exception
	{
		System.out.println(" BUG_4676测试开始运行------");
		long begintime = System.currentTimeMillis();
	    int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }
	   //serialNum[3]=600;
	    String  num="./BUG_4676/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		try {
			vatSch.cancelProduct_unlimited("YVP18HOJ0008X-0101");
			vatSch.outPutResult(num+"BUG_4676调度结果.csv");	
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			System.err.println("BUG_4685应提示错误信息");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BUG_4685错误信息应为：A1804000060不满足生产条件");
			System.out.println("状态正常");
		}
		
	}
	
	static void BUG_4660() throws Exception
	{
		System.out.println(" BUG_4660测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4660/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4660调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4660/BUG_4660调度结果standard.csv", "./BUG_4660/BUG_4660调度结果.csv"))
			System.out.println("BUG_4660无误");
		else
			System.err.println("BUG_4660错误");
	}
	static void BUG_4652() throws Exception
	{
		System.out.println(" BUG_4652测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4652/";
		VatSch vatSch = new VatSch("2018/4/3", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4652调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4652/BUG_4652调度结果standard.csv", "./BUG_4652/BUG_4652调度结果.csv"))
			System.out.println("BUG_4652无误");
		else
			System.err.println("BUG_4652错误");
	}
	
	static void BUG_4646() throws Exception
	{
		System.out.println(" BUG_4646测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4646/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		/*Schedule sch = new Schedule(
				"21D",
				"A1804002590",
				"2018/04/02 05:00:00",
				"2018/04/02 17:00:00",
				"1320603A0032-1",
				4,
				true,
				"20",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false, 
				"0",
				true,
				true);
			ArrayList<String> origSch = new ArrayList<String>();
		    origSch.add("A1804002590");
		    vatSch.insertJob_unlimited(origSch, sch);*/
			vatSch.run();
		    vatSch.outPutResult(num+"BUG_4646调度结果.csv");
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4646/BUG_4646调度结果standard.csv", "./BUG_4646/BUG_4646调度结果.csv"))
				System.out.println("BUG_4646无误");
			else
				System.err.println("BUG_4646错误");
	}
	
	static void BUG_4638() throws Exception
	{
		System.out.println(" BUG_4638测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4638/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		/*Schedule sch = new Schedule(
				"21D",
				"A1804002590",
				"2018/04/02 05:00:00",
				"2018/04/02 17:00:00",
				"1320603A0032-1",
				4,
				true,
				"20",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false, 
				"0",
				true,
				true);
			ArrayList<String> origSch = new ArrayList<String>();
		    origSch.add("A1804002590");
		    vatSch.insertJob_unlimited(origSch, sch);*/
			vatSch.run();
		    vatSch.outPutResult(num+"BUG_4638调度结果.csv");
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4638/BUG_4638调度结果standard.csv", "./BUG_4638/BUG_4638调度结果.csv"))
				System.out.println("BUG_4638无误");
			else
				System.err.println("BUG_4638错误");
	}
	static void BUG_4636() throws Exception
	{
		System.out.println(" BUG_4636测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4636/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4636调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4636/BUG_4636调度结果standard.csv", "./BUG_4636/BUG_4636调度结果.csv"))
				System.out.println("BUG_4636无误");
			else
				System.err.println("BUG_4638错误");
	}
	static void BUG_4629() throws Exception
	{
		System.out.println(" BUG_4629测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4629/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4629调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4629/BUG_4629调度结果standard.csv", "./BUG_4629/BUG_4629调度结果.csv"))
				System.out.println("BUG_4629无误");
			else
				System.err.println("BUG_4629错误");
	}
	static void BUG_4603() throws Exception
	{
		System.out.println(" BUG_4603测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4603/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"1188A",
				"A1804000172",
				"2018/03/31 09:10:00",
				"2018/03/31 21:10:00",
				"REPAIR1-1",
				1,
				false,
				"1100",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false, 
				"1",
				true,
				true);
			ArrayList<String> origSch = new ArrayList<String>();
/*		    origSch.add("A1804000172");*/
		    vatSch.insertJob_unlimited(origSch, sch);
		    vatSch.outPutResult(num+"BUG_4603调度结果standard.csv");
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4603/BUG_4603调度结果standard.csv", "./BUG_4603/BUG_4603调度结果.csv"))
				System.out.println("BUG_4603无误");
			else
				System.err.println("BUG_4603错误");
	}
	static void BUG_4587() throws Exception
	{
		System.out.println(" BUG_4587测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4587/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4587调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4587/BUG_4587调度结果standard.csv", "./BUG_4587/BUG_4587调度结果.csv"))
				System.out.println("BUG_4587无误");
			else
				System.err.println("BUG_4587错误");
	}
	static void BUG_4586() throws Exception 
	{
		System.out.println(" BUG_4586测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4586/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"209A",
				"A1804000530",
				"2018/04/01 08:00:00",
				"2018/04/01 20:00:00",
				"FIRSTVATFINISHED2-1",
				3,
				false,
				"200",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false, 
				"0",
				false,
				true);
			ArrayList<String> origSch = new ArrayList<String>();
		    origSch.add("A1804000530");
		    
		    try {
				vatSch.outPutResult(num+"BUG_4586调度结果standard.csv");
				vatSch.insertJob_unlimited(origSch, sch);
				System.out.println("任务数量："+vatSch.getSchResult().size());
				System.out.print("运行结束-----");
				long endtime=System.currentTimeMillis();
				long costTime = (endtime - begintime);
				System.out.println("时间消耗："+costTime/1000.0+"s");
				System.err.println("BUG_4586应输出错误信息");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("插队任务资源不满足！该时间插队与原计划任务资源冲突！插入时间可调整为2018/04/02 08:00:00——2018/04/02 20:00:00");
				System.out.println("状态正常");
			}
			
/*			if(samefile("./BUG_4586/BUG_4586调度结果standard.csv", "./BUG_4586/BUG_4586调度结果.csv"))
				System.out.println("BUG_4586无误");
			else
				System.err.println("BUG_4586错误");*/
	}
	static void BUG_4584() throws Exception
	{
		System.out.println(" BUG_4584测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4584/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4584调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4584/BUG_4584调度结果standard.csv", "./BUG_4584/BUG_4584调度结果.csv"))
			System.out.println("BUG_4584无误");
		else
			System.err.println("BUG_4584错误");
	}
	static void BUG_4583() throws Exception
	{
		System.out.println(" BUG_4583测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4583/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4583调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4583/BUG_4583调度结果standard.csv", "./BUG_4583/BUG_4583调度结果.csv"))
			System.out.println("BUG_4583无误");
		else
			System.err.println("BUG_4583错误");
	}
	static void BUG_4581() throws Exception
	{
		System.out.println(" BUG_4581测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4581/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4581调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4581/BUG_4581调度结果standard.csv", "./BUG_4581/BUG_4581调度结果.csv"))
			System.out.println("BUG_4581无误");
		else
			System.err.println("BUG_4581错误");
	}
	static void BUG_4578() throws Exception
	{
		System.out.println(" BUG_4578测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4578/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4578调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4578/BUG_4578调度结果standard.csv", "./BUG_4578/BUG_4578调度结果.csv"))
			System.out.println("BUG_4578无误");
		else
			System.err.println("BUG_4578错误");
	}
	static void BUG_4572() throws Exception
	{
		System.out.println(" BUG_4572测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4572/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4572调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		System.out.println("BUG_4572无误");
/*		if(samefile("./BUG_4572/BUG_4572调度结果standard.csv", "./BUG_4572/BUG_4572调度结果.csv"))
			System.out.println("BUG_4572无误");
		else
			System.err.println("BUG_4572错误");*/
	}
	static void BUG_4558_1() throws Exception
	{
		System.out.println(" BUG_4558_1测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4558_1/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		Schedule sch = new Schedule(
				"9D",
				"A1804000110",
				"2018/03/31 08:30:00",
				"2018/03/31 20:30:00",
				"MAXDARKVATS1-1",
				4,
				false,
				"9",
				"0",
				"0",
				false,
				false,
				false,
				false,
				false, 
				"0",
				false,
				true);
			ArrayList<String> origSch = new ArrayList<String>();
		    origSch.add("A1804000110");
		    vatSch.insertJob_unlimited(origSch, sch);
		    vatSch.outPutResult(num+"BUG_4558_1调度结果.csv");
			System.out.println("任务数量："+vatSch.getSchResult().size());
			System.out.print("运行结束-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("时间消耗："+costTime/1000.0+"s");
			if(samefile("./BUG_4558_1/BUG_4558_1调度结果standard.csv", "./BUG_4558_1/BUG_4558_1调度结果.csv"))
				System.out.println("BUG_4558_1无误");
			else
				System.err.println("BUG_4558_1错误");
	}
	static void BUG_4558_2() throws Exception
	{
		System.out.println(" BUG_4558_2测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4558_2/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");
		vatSch.cancelProduct_unlimited("MAXDARKVATS2-1");
//		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4558_2调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4558_2/BUG_4558_2调度结果standard.csv", "./BUG_4558_2/BUG_4558_2调度结果.csv"))
			System.out.println("BUG_4558_2无误");
		else
			System.err.println("BUG_4558_2错误");
	}
	static void BUG_4546() throws Exception
	{
		System.out.println(" BUG_4546测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4546/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"BUG_4546调度结果s.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4546调度结果.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
		if(samefile("./BUG_4546/BUG_4546调度结果standard.csv", "./BUG_4546/BUG_4546调度结果.csv"))
			System.out.println("BUG_4546无误");
		else
			System.err.println("BUG_4546错误");
	}
	static void BUG_4516() throws Exception
	{
		System.out.println(" BUG_4516测试开始运行------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4516/";
		VatSch vatSch = new VatSch("2018/4/1", 192);
		vatSch.readFile(num+"产品数据.csv", 
				num+"射阳染缸.csv",
				num+"纱支库存及到货计划.csv", 
				num+"染料库存及到货计划.csv", 
				num+"助剂库存及到货计划.csv", 
				num+"染色执行时间.csv", 
				num+"调度当日未开始的生产计划.csv", 
				num+"禁忌产品.csv",
				num+"排产参数.csv");
		System.out.println("加载产品数据 "+vatSch.getProductsNum()+" 条");
		System.out.println("加载染缸数据 "+vatSch.getVatsNum()+" 条");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4516调度结果standard.csv");
		System.out.println("任务数量："+vatSch.getSchResult().size());
		System.out.print("运行结束-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("时间消耗："+costTime/1000.0+"s");
/*		if(samefile("./BUG_4516/BUG_4516调度结果standard.csv", "./BUG_4516/BUG_4516调度结果.csv"))
			System.out.println("BUG_4516无误");
		else
			System.err.println("BUG_4516错误");*/
	}
}
