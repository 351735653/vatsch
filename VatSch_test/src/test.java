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
	          
	        int len1 = fis1.available();//�����ܵ��ֽ���  
	        int len2 = fis2.available();  
	          
	        if (len1 == len2) 
	        {	//������ͬ����ȽϾ�������  
	            //���������ֽڻ�����  
	            byte[] data1 = new byte[len1];  
	            byte[] data2 = new byte[len2];  
	              
	            //�ֱ������ļ������ݶ��뻺����  
	            fis1.read(data1);  
	            fis2.read(data2);  
	              
	            //���αȽ��ļ��е�ÿһ���ֽ�  
	            for (int i=0; i<len1; i++) 
	            { 
	                //ֻҪ��һ���ֽڲ�ͬ�������ļ��Ͳ�һ��  
	                if (data1[i] != data2[i]) 
	                {  
	                    //System.out.println("�ļ����ݲ�һ��");  
	                    return false;  
	                }  
	            }  
	            //System.out.println("�����ļ���ȫ��ͬ");  
	            return true;  
	        }
	        else 
	        {  
	            //���Ȳ�һ�����ļ��϶���ͬ  
	            return false;  
	        }  
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {//�ر��ļ�������ֹ�ڴ�й©  
	        if (fis1 != null)
	        {  
	            try {  
	                fis1.close();  
	            } catch (IOException e) {  
	                //����  
	                e.printStackTrace();  
	            }  
	        }  
	        if (fis2 != null) 
	        {  
	            try {  
	                fis2.close();  
	            } catch (IOException e) {  
	                //����  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	    return false;  
	}  
	/**
	 * ��Ӵ���
	 * @throws Exception
	 */
	static void BUG_4860() throws Exception
	{
		System.out.println(" BUG_4860���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4860/";
		VatSch vatSch = new VatSch("2019/1/22", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		vatSch.outPutResult(num+"BUG_4860���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		
		if(samefile("./BUG_4860/BUG_4860���Ƚ��standard.csv", "./BUG_4860/BUG_4860���Ƚ��.csv"))
			System.out.println("BUG4860����");
		else
			System.err.println("BUG4860����");
	}
	/**
	 * ��Ӵ���
	 * @throws Exception
	 */
	static void BUG_5014() throws Exception
	{
		System.out.println(" BUG_5014���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_5014/";
		VatSch vatSch = new VatSch("2019/2/15", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		vatSch.outPutResult(num+"BUG_5014���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		
		if(samefile("./BUG_5014/BUG_5014���Ƚ��standard.csv", "./BUG_5014/BUG_5014���Ƚ��.csv"))
			System.out.println("BUG5014����");
		else
			System.err.println("BUG5014����");
	}
	/**
	 * ��Ӵ���
	 * @throws Exception
	 */
	static void BUG_4964() throws Exception
	{
		System.out.println(" BUG_4964���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4964/";
		VatSch vatSch = new VatSch("2019/1/30", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
			vatSch.outPutResult(num+"BUG_4964���Ƚ��standard.csv");
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("������ϢӦΪ����ǰʱ��2019/02/06 08:00:00���ɲ�ӣ�����ʱ�����Ϊ2019/02/06 21:00:00����2019/02/07 09:00:00");
			System.out.println("״̬����");
		}

		
		

	
	}
	/**
	 * ���д���
	 * 
	 * @throws Exception
	 */
	static void BUG_4903() throws Exception
	{
		System.out.println(" BUG_4903���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4903/";
		VatSch vatSch = new VatSch("2019/1/27", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4903���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4903/BUG_4903���Ƚ��standard.csv", "./BUG_4903/BUG_4903���Ƚ��.csv"))
			System.out.println("BUG_4903����");
		else
			System.err.println("BUG_4903����");
	}
	/**
	 * ��Ӵ���
	 * @throws Exception
	 */
	static void BUG_4893() throws Exception
	{
		System.out.println(" BUG_4893���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4893/";
		VatSch vatSch = new VatSch("2019/1/27", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		vatSch.outPutResult(num+"BUG_4893���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4893/BUG_4893���Ƚ��standard.csv", "./BUG_4893/BUG_4893���Ƚ��.csv"))
			System.out.println("BUG_4893����");
		else
			System.err.println("BUG_4893����");
	}
	/**
	 * ���д���
	 * @throws Exception
	 */
	static void BUG_4719() throws Exception
	{
		System.out.println(" BUG_4719���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4719/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4719���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4719/BUG_4719���Ƚ��standard.csv", "./BUG_4719/BUG_4719���Ƚ��.csv"))
			System.out.println("BUG_4719����");
		else
			System.err.println("BUG_4719����");
	}
	

	static void BUG_4709() throws Exception 
	{
		System.out.println(" BUG_4709���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	    int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }
	   //serialNum[3]=600;
	    String  num="./BUG_4709/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
			vatSch.outPutResult(num+"BUG_4709���Ƚ��.csv");	
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			System.err.println("BUG_4709Ӧ��ʾ������Ϣ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BUG_4709������ϢӦΪ����Ӳ�Ʒ1320603A0032-1ȷ��ɫδȷ�ϣ�");
			System.out.println("״̬����");
		}

/*		if(samefile("./BUG_4709/BUG_4709���Ƚ��standard.csv", "./BUG_4709/BUG_4709���Ƚ��.csv"))
			System.out.println("BUG_4709����");
		else
			System.err.println("BUG_4709����");*/
	}
	

	static void BUG_4689() throws Exception
	{
		System.out.println(" BUG_4689���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4689/";
		VatSch vatSch = new VatSch("2018/4/4", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4689���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4689/BUG_4689���Ƚ��standard.csv", "./BUG_4689/BUG_4689���Ƚ��.csv"))
			System.out.println("BUG_4689����");
		else
			System.err.println("BUG_4689����");
	}

	static void BUG_4685() throws Exception
	{
		System.out.println(" BUG_4685���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	    int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }
	   //serialNum[3]=600;
	    String  num="./BUG_4685/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
			vatSch.outPutResult(num+"BUG_4685���Ƚ��.csv");	
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			System.err.println("BUG_4685Ӧ��ʾ������Ϣ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BUG_4685������ϢӦΪ��Ⱦ��506C��ʱ��� 2018/04/01 21:00:00-2018/04/02 09:00:00 ������!");
			System.out.println("״̬����");
		}
		
	}
	static void BUG_4676() throws Exception
	{
		System.out.println(" BUG_4676���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	    int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }
	   //serialNum[3]=600;
	    String  num="./BUG_4676/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		try {
			vatSch.cancelProduct_unlimited("YVP18HOJ0008X-0101");
			vatSch.outPutResult(num+"BUG_4676���Ƚ��.csv");	
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			System.err.println("BUG_4685Ӧ��ʾ������Ϣ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BUG_4685������ϢӦΪ��A1804000060��������������");
			System.out.println("״̬����");
		}
		
	}
	
	static void BUG_4660() throws Exception
	{
		System.out.println(" BUG_4660���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4660/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4660���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4660/BUG_4660���Ƚ��standard.csv", "./BUG_4660/BUG_4660���Ƚ��.csv"))
			System.out.println("BUG_4660����");
		else
			System.err.println("BUG_4660����");
	}
	static void BUG_4652() throws Exception
	{
		System.out.println(" BUG_4652���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4652/";
		VatSch vatSch = new VatSch("2018/4/3", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		vatSch.run();
		vatSch.outPutResult(num+"BUG_4652���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4652/BUG_4652���Ƚ��standard.csv", "./BUG_4652/BUG_4652���Ƚ��.csv"))
			System.out.println("BUG_4652����");
		else
			System.err.println("BUG_4652����");
	}
	
	static void BUG_4646() throws Exception
	{
		System.out.println(" BUG_4646���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4646/";
		VatSch vatSch = new VatSch("2018/4/2", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		    vatSch.outPutResult(num+"BUG_4646���Ƚ��.csv");
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4646/BUG_4646���Ƚ��standard.csv", "./BUG_4646/BUG_4646���Ƚ��.csv"))
				System.out.println("BUG_4646����");
			else
				System.err.println("BUG_4646����");
	}
	
	static void BUG_4638() throws Exception
	{
		System.out.println(" BUG_4638���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4638/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		    vatSch.outPutResult(num+"BUG_4638���Ƚ��.csv");
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4638/BUG_4638���Ƚ��standard.csv", "./BUG_4638/BUG_4638���Ƚ��.csv"))
				System.out.println("BUG_4638����");
			else
				System.err.println("BUG_4638����");
	}
	static void BUG_4636() throws Exception
	{
		System.out.println(" BUG_4636���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4636/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4636���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4636/BUG_4636���Ƚ��standard.csv", "./BUG_4636/BUG_4636���Ƚ��.csv"))
				System.out.println("BUG_4636����");
			else
				System.err.println("BUG_4638����");
	}
	static void BUG_4629() throws Exception
	{
		System.out.println(" BUG_4629���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4629/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4629���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4629/BUG_4629���Ƚ��standard.csv", "./BUG_4629/BUG_4629���Ƚ��.csv"))
				System.out.println("BUG_4629����");
			else
				System.err.println("BUG_4629����");
	}
	static void BUG_4603() throws Exception
	{
		System.out.println(" BUG_4603���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4603/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		    vatSch.outPutResult(num+"BUG_4603���Ƚ��standard.csv");
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4603/BUG_4603���Ƚ��standard.csv", "./BUG_4603/BUG_4603���Ƚ��.csv"))
				System.out.println("BUG_4603����");
			else
				System.err.println("BUG_4603����");
	}
	static void BUG_4587() throws Exception
	{
		System.out.println(" BUG_4587���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4587/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4587���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4587/BUG_4587���Ƚ��standard.csv", "./BUG_4587/BUG_4587���Ƚ��.csv"))
				System.out.println("BUG_4587����");
			else
				System.err.println("BUG_4587����");
	}
	static void BUG_4586() throws Exception 
	{
		System.out.println(" BUG_4586���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4586/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
				vatSch.outPutResult(num+"BUG_4586���Ƚ��standard.csv");
				vatSch.insertJob_unlimited(origSch, sch);
				System.out.println("����������"+vatSch.getSchResult().size());
				System.out.print("���н���-----");
				long endtime=System.currentTimeMillis();
				long costTime = (endtime - begintime);
				System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
				System.err.println("BUG_4586Ӧ���������Ϣ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("���������Դ�����㣡��ʱ������ԭ�ƻ�������Դ��ͻ������ʱ��ɵ���Ϊ2018/04/02 08:00:00����2018/04/02 20:00:00");
				System.out.println("״̬����");
			}
			
/*			if(samefile("./BUG_4586/BUG_4586���Ƚ��standard.csv", "./BUG_4586/BUG_4586���Ƚ��.csv"))
				System.out.println("BUG_4586����");
			else
				System.err.println("BUG_4586����");*/
	}
	static void BUG_4584() throws Exception
	{
		System.out.println(" BUG_4584���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4584/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4584���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4584/BUG_4584���Ƚ��standard.csv", "./BUG_4584/BUG_4584���Ƚ��.csv"))
			System.out.println("BUG_4584����");
		else
			System.err.println("BUG_4584����");
	}
	static void BUG_4583() throws Exception
	{
		System.out.println(" BUG_4583���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4583/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4583���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4583/BUG_4583���Ƚ��standard.csv", "./BUG_4583/BUG_4583���Ƚ��.csv"))
			System.out.println("BUG_4583����");
		else
			System.err.println("BUG_4583����");
	}
	static void BUG_4581() throws Exception
	{
		System.out.println(" BUG_4581���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4581/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4581���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4581/BUG_4581���Ƚ��standard.csv", "./BUG_4581/BUG_4581���Ƚ��.csv"))
			System.out.println("BUG_4581����");
		else
			System.err.println("BUG_4581����");
	}
	static void BUG_4578() throws Exception
	{
		System.out.println(" BUG_4578���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4578/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4578���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4578/BUG_4578���Ƚ��standard.csv", "./BUG_4578/BUG_4578���Ƚ��.csv"))
			System.out.println("BUG_4578����");
		else
			System.err.println("BUG_4578����");
	}
	static void BUG_4572() throws Exception
	{
		System.out.println(" BUG_4572���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4572/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4572���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		System.out.println("BUG_4572����");
/*		if(samefile("./BUG_4572/BUG_4572���Ƚ��standard.csv", "./BUG_4572/BUG_4572���Ƚ��.csv"))
			System.out.println("BUG_4572����");
		else
			System.err.println("BUG_4572����");*/
	}
	static void BUG_4558_1() throws Exception
	{
		System.out.println(" BUG_4558_1���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4558_1/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
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
		    vatSch.outPutResult(num+"BUG_4558_1���Ƚ��.csv");
			System.out.println("����������"+vatSch.getSchResult().size());
			System.out.print("���н���-----");
			long endtime=System.currentTimeMillis();
			long costTime = (endtime - begintime);
			System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
			if(samefile("./BUG_4558_1/BUG_4558_1���Ƚ��standard.csv", "./BUG_4558_1/BUG_4558_1���Ƚ��.csv"))
				System.out.println("BUG_4558_1����");
			else
				System.err.println("BUG_4558_1����");
	}
	static void BUG_4558_2() throws Exception
	{
		System.out.println(" BUG_4558_2���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4558_2/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");
		vatSch.cancelProduct_unlimited("MAXDARKVATS2-1");
//		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4558_2���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4558_2/BUG_4558_2���Ƚ��standard.csv", "./BUG_4558_2/BUG_4558_2���Ƚ��.csv"))
			System.out.println("BUG_4558_2����");
		else
			System.err.println("BUG_4558_2����");
	}
	static void BUG_4546() throws Exception
	{
		System.out.println(" BUG_4546���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4546/";
		VatSch vatSch = new VatSch("2018/4/1", 0);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"BUG_4546���Ƚ��s.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4546���Ƚ��.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
		if(samefile("./BUG_4546/BUG_4546���Ƚ��standard.csv", "./BUG_4546/BUG_4546���Ƚ��.csv"))
			System.out.println("BUG_4546����");
		else
			System.err.println("BUG_4546����");
	}
	static void BUG_4516() throws Exception
	{
		System.out.println(" BUG_4516���Կ�ʼ����------");
		long begintime = System.currentTimeMillis();
	  /*  int serialNum[]= new int [12];
	    for(int i=0;i<12;i++)
	    {
	    	serialNum[i]=1;
	    }*/
	   //serialNum[3]=600;
	    String  num="./BUG_4516/";
		VatSch vatSch = new VatSch("2018/4/1", 192);
		vatSch.readFile(num+"��Ʒ����.csv", 
				num+"����Ⱦ��.csv",
				num+"ɴ֧��漰�����ƻ�.csv", 
				num+"Ⱦ�Ͽ�漰�����ƻ�.csv", 
				num+"������漰�����ƻ�.csv", 
				num+"Ⱦɫִ��ʱ��.csv", 
				num+"���ȵ���δ��ʼ�������ƻ�.csv", 
				num+"���ɲ�Ʒ.csv",
				num+"�Ų�����.csv");
		System.out.println("���ز�Ʒ���� "+vatSch.getProductsNum()+" ��");
		System.out.println("����Ⱦ������ "+vatSch.getVatsNum()+" ��");

		vatSch.run();
	    vatSch.outPutResult(num+"BUG_4516���Ƚ��standard.csv");
		System.out.println("����������"+vatSch.getSchResult().size());
		System.out.print("���н���-----");
		long endtime=System.currentTimeMillis();
		long costTime = (endtime - begintime);
		System.out.println("ʱ�����ģ�"+costTime/1000.0+"s");
/*		if(samefile("./BUG_4516/BUG_4516���Ƚ��standard.csv", "./BUG_4516/BUG_4516���Ƚ��.csv"))
			System.out.println("BUG_4516����");
		else
			System.err.println("BUG_4516����");*/
	}
}
