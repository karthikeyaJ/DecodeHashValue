import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DecryptEmail {

	public static void main(String[] args) {
		String str=new String("c832539b393b5416109e6a036828083df0da44745a03abd0c2c6cffb2108327cf64e15aa25c8534b8beb877be138b71bc9544c3d2026c2fd5a850f09fb300a989d57822bf798eb8c5cdb7a8c3ea4aac488fce95845044a55ae79cea656b3b9b0fa02781a93998b9016d75b59ce1ae5813e6b30564feae0414ca919a80e7ffdfbdf06f2ea5a07568b859e1c7a6270e0d178a57dcb10ee8775b195d125cb4bdb39423afbfd9ef8071cd28088a21b438e0dbe259f2442bd7efad44b663e21f88c2c75a9c19f3e638fa24917ab76b2d97f0bd0ae58d59a967efe1a16fa94bf9166f4a58215affc8fcb279e965d37bf77ab9383986501c2dcc3802f09229d3808e45462442f16efae436912f961aa61551bde30c3d9d0fec904d9fbe5cda04f80f4d482a945c08a71fb3d954772573e6f2349a3b6baba290cbc97e1f8b1ef8199360b09ffd0b9202826692e9a3a061caf4c8630b0cab9133bbfa9120d5b5affecfaa0c077bfaf97c8aa33d1d490559b2365048039220e693b059388affceba2e523eb0334ba6f4f60e60d426b0f41cd225e626c0509d6b5021b3469610f32111d6a567006adc065d3bbddb25c181a8c8e7ef1d68aa8ad8a8c90ddc69fc1dc0eddda90");
		String email=findEmail(str);
		System.out.println(email);
	}
	
	//Find Email function to decrypt
	public static String findEmail(String str) 
	{
		String myEmail=new String("vjangal@syr.edu");
		try{
		String hashEmail=new String(getHash(myEmail));
		int counter=0;
		// our secret key has alphanumeric keys and _.@+
		char[] alpha="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.@+".toCharArray();
		boolean flag=false;
        String relativeString="";
		for(int i=0;i<alpha.length;i++)
		{
			if(flag)
			{
				i=0;
				flag=false;
			}
          String charValueAtOne=new String(Character.toString(alpha[i]));
          charValueAtOne=relativeString+charValueAtOne;
		for(int j=0;j<alpha.length;j++)
		{
			String charValueAtTwo=new String(charValueAtOne);
			charValueAtTwo+=alpha[j];
			String hashString=new String(getHash(charValueAtTwo));
			
			String finalString=hashEmail+charValueAtTwo+hashString;
			String check1=getHash(finalString);
			String check2=str.substring(counter,counter+32);
			if(check1.equals(check2))
			{
				if(counter+32<str.length())
				counter+=32;
				relativeString=""+charValueAtTwo;
				flag=true;;
				break;
			}	
			
		}	
			
		}
		return relativeString;
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return str;
	}
	
	// convert the String into MD5 hash
	public static String getHash(String hash) throws NoSuchAlgorithmException
	{
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(hash.getBytes(),0,hash.length());
		byte b[]=md.digest();
		BigInteger bigInt = new BigInteger(1,b);
		String hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
	}
		return hashtext;
	}
}
