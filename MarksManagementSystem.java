import java.io.*;
import java.io.IOException;
class IAmarks
      	{      
	int rollno; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  public static void cls() throws IOException,InterruptedException
		{
		  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}

public void addRecords() throws IOException
	     {  	
	         try
		{	
		 cls(); 
			System.out.println("ADD STUDENTS NEW RECORDS");
			System.out.println("****************************************************");
   		 	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("IAmarks.txt",true)));
    		                  String name, sem;
 			int n, rollno;
			int m1=0,m2=0,m3=0,total=0;
                              	                  String s,temp=null;
 			boolean b= false;
			boolean addMore=false;
			do
			  {
			     System.out.print("Enter RollNumber               : ");
  			     rollno = Integer.parseInt(br.readLine());
			     BufferedReader file = new BufferedReader(new FileReader("IAmarks.txt"));
 			     String filedata;
			     while((filedata = file.readLine()) != null)
  	        		       {
			         if(filedata.startsWith(String.valueOf(rollno).toString()))   
			            {
                                                                    System.out.println("Data Exist with same Rollno");
			                b=true;
			                break;
 			             }
                         		       }
	      		 file.close();
                     		 if(b!=true)
                                    	    {
		      	     System.out.print("Enter name                     : ");
			     name = br.readLine();
			     pw.println(rollno);
			     pw.println(name);
			     System.out.print("Marks obtained in 1st Internal :");
 		 	     m1=Integer.parseInt(br.readLine());
   			     System.out.print("Marks obtained in 2nd Internal :"); 
   			     m2=Integer.parseInt(br.readLine());
   			     System.out.print("Marks obtained in 3rd Internal :");
  		 	     m3=Integer.parseInt(br.readLine());
   			     total=(m1+m2+m3);
			      pw.println(m1);
			      pw.println(m2);
			      pw.println(m3);
   			      pw.println(total);
			      System.out.println("\nRecords added succesfully \n\ndo you want to add more records?(y/n):");
			      s=br.readLine();
			      if(s.equalsIgnoreCase("y"))
			         {
			           cls(); 
			           System.out.println("****************************************************");
			           addMore=true;
			           System.out.println();
			         }
			     else
		                          { 
			          cls(); 
			          System.out.println("****************************************************");
		                            addMore=false;
			        }
			  }   
			}
		 while(addMore);
		 pw.close();
		 showMenu();
                 }
		catch(InterruptedException i)
		{ }
         }



public void readRecords() throws IOException 
 	  {
	      try
		{
	  	BufferedReader file= new BufferedReader(new FileReader("IAmarks.txt"));
		 int i=1;
		 String r;
		 while((r=file.readLine())!=null)
			{
			System.out.println("S.No :"+(i++));
			System.out.println("****************************************************");
		                  System.out.print("\nRegister Number : " +r);
  			     System.out.print("\nStudent Name    : "+file.readLine());
			//System.out.print("\n sem: "+file.readLine());
 			   System.out.print("\n1st IA marks    : "+file.readLine());
		                  System.out.print("\n2nd IA marks    : "+file.readLine());
			   System.out.print("\n3rd IA marks    : "+file.readLine());
			   System.out.println("\nTotal marks     : "+file.readLine());
			System.out.println("****************************************************");
			System.out.println();}
                                    file.close();
		            showMenu();
                           }
                                       
                               	  catch(FileNotFoundException e)
                                          {
                                              System.out.println("\nERROR : File not Found !!!");
                                          }
 }



public void updateRecords() throws IOException 
	 {     
	       int fnd,rf,rollno=0,m1=0,m2=0,m3=0,total=0;
                         String name,sem;
	       System.out.print("Enter RollNumber for Updation: ");
  	       rollno = Integer.parseInt(br.readLine());
                         BufferedReader file = new BufferedReader(new FileReader("IAmarks.txt"));
	       PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("IAmarks1.txt",true)));
 	       String r;
	       while((r=file.readLine())!=null)
		{
		if(Integer.parseInt(r)==rollno)
			{	
			name=file.readLine();
			//sem=file.readLine();
 			m1=Integer.parseInt(file.readLine());
		                  m2=Integer.parseInt(file.readLine());
			m3=Integer.parseInt(file.readLine());
			total=Integer.parseInt(file.readLine());
		                  System.out.println("Register Number: " +r);
  			System.out.println("Name           : "+name);  
			//System.out.println("Semester       : "+sem);
 			System.out.print("1st IA marks   : "+m1+"\nUpdated marks  : ");
			m1=Integer.parseInt(br.readLine());
		                  System.out.print("2nd IA marks   : "+m2 +"\nUpdated marks  : ");
			m2=Integer.parseInt(br.readLine());
			System.out.print("3rd IA marks   : "+m3+"\nUpdated marks  : ");
			m3=Integer.parseInt(br.readLine());
			total = m1+m2+m3;
			System.out.print("Updated Total  : "+total);
			System.out.println();
			System.out.println("****************************************************");
			p.println(rollno);
			p.println(name);
			//p.println(sem); 
			p.println(m1);
			p.println(m2);
			p.println(m3);
			p.println(total);               
			}
			else
			{
			p.println(r);
			p.println(file.readLine());
			//p.println(file.readLine());
			p.println(file.readLine());
			p.println(file.readLine());
			p.println(file.readLine());
			p.println(file.readLine());
			}
			}
			p.close(); 
			file.close();
		 	PrintWriter fff = new PrintWriter(new BufferedWriter(new FileWriter("IAmarks.txt")));
			fff.close();
		                 PrintWriter f = new PrintWriter(new BufferedWriter(new FileWriter("IAmarks.txt")));
	 	                 BufferedReader fle= new BufferedReader(new FileReader("IAmarks1.txt"));
 		              String rr;
		              while((rr=fle.readLine())!=null)
			{
			name=fle.readLine();
 			m1=Integer.parseInt(fle.readLine());
		            m2=Integer.parseInt(fle.readLine());
			m3=Integer.parseInt(fle.readLine());
			total=Integer.parseInt(fle.readLine());
		             f.println(rr);
			f.println(name);
			//f.println(sem); 
			f.println(m1);
			f.println(m2);
			f.println(m3);
			f.println(total);
 			}
			f.close(); 
			fle.close();					
		 	PrintWriter ff = new PrintWriter(new BufferedWriter(new FileWriter("IAmarks1.txt")));
			ff.close();
			showMenu();
     			 }


public void displayFinalReport() throws IOException 
 	  {
	       try
 		{  
		  BufferedReader file= new BufferedReader(new FileReader("IAmarks.txt"));
		  int i=1;
		 String r;
		 while((r=file.readLine())!=null)
			{
			System.out.println("S.No :"+(i++));
			System.out.println("****************************************************");
		                  System.out.println("Register Number : "+r);
  			System.out.println("Student Name    : "+file.readLine());
			//System.out.println("\nsem    : "+file.readLine());
 			System.out.println("1st IA marks    : "+file.readLine());
		             	System.out.println("2nd IA marks    : "+file.readLine());
			System.out.println("3rd IA marks    : "+file.readLine());
			System.out.println("Total           : "+file.readLine());
			System.out.println("****************************************************");
			System.out.println();
			}
		file.close();
                                    showMenu();
                                        }
                                	     catch(FileNotFoundException e)
                                          {
                                              System.out.println("\nERROR : File not Found !!!");
                                          }
                     }
public void showMenu() throws IOException 
{
try{
 System.out.print("1 : Add New students Records \n2 : Display  the exist Records \n3 : Update the Records for changes \n4 : Finalized Records  \n5 : Exit \n****************************************************\n\n");
System.out.print("\nYour Choice : ");
int choice = Integer.parseInt(br.readLine());
 cls();
switch(choice)
{         
case 1:addRecords();
break;
case 2: readRecords();
break;
case 3: updateRecords();
break;
case 4:displayFinalReport();
break;
case 5: System.exit(1);
break;
default:
System.out.println("\nInvalid Choice !");
break;
 }
}
catch(InterruptedException i)
{}
}


public static void main(String args[]) throws IOException 
{
try
{
cls();
System.out.println("****************************************************");
System.out.println("STUDENTS MARKS MANAGEMENT SYSTEM");
System.out.println("****************************************************");
IAmarks call = new IAmarks();
call.showMenu();
}
catch(InterruptedException i)
{}
   }
     }
