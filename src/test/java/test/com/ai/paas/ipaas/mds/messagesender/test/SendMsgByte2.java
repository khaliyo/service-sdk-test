package test.com.ai.paas.ipaas.mds.messagesender.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ai.paas.ipaas.mds.IMessageSender;

import test.com.ai.paas.ipaas.mds.messagesender.base.MessageSender;

public class SendMsgByte2  extends MessageSender{
	 private IMessageSender   iMessageSender;
	  @BeforeClass
		public void beforeClass() {
		       try {
		   iMessageSender=super.getClient();
			} catch (Exception e) {
				e.printStackTrace();  
			}
		 } 
	
	  /***
	   * 测试消息正常发送byte[] +key
	   * */
	  @Test(dataProvider="sendByteKey")
	  public void sendByteKey1(byte[] bytes,long pid,String key){
		  int i =0;
		  while(i<20){
		  iMessageSender.send(bytes, pid, key+i); //key+i;
		  i++;
		  }
	  }
	  @DataProvider(name="sendByteKey")
	  public Object[][] sendByteKey(){
		return new Object[][]{
				{"testfourstring-str02".getBytes(),10,"13520021687"}
		};
		  
	  }
	  /*****
	   * 测试Byte[] msg +key ,byte为空的情况     
	   * */
	  @Test(dataProvider="sendNullType3")
	  public void sendNullTypeTest4(byte[] msg,long pid,String key){
		  try{
			  iMessageSender.send(msg,pid,key);
		  }catch(Exception e){
			  System.out.println(e.getMessage());
			  Assert.assertEquals("The message is null!", e.getMessage()); 
		  }
	  }   
	  @DataProvider(name="sendNullType3")
	  public Object[][] sendNullType3(){
		  return new Object[][]{  
				   {"".getBytes(),2,"13520021687"} ,
				   {null,2,"13520021687"} 
				 
				    
				 
		  };    
	  }
	  /**
	   * 测试传入一条数据
	   * **/
	  @Test(dataProvider="sendByte2")  
	  public void sendByte2(byte[] bytes,long arg1,String key){
	  iMessageSender.send(bytes, arg1,key); //id+i
		 }
	  @DataProvider(name="sendByte2")    
	  public Object[][]sendByte2(){
		  return  new Object[][]{
				  {"testonestring-str02".getBytes(),-6,"13520021708"}  //正常测试Byte
		  };
	  }   
}
