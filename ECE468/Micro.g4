grammar Micro;
	
@header {
	import java.io.*;
	import java.util.*;
	import java.lang.*;

}

@members {
	public static
	  	Stack <Scope> stack = new Stack <Scope>();
	  	LinkedHashMap <String,Scope> SymbolTable = new LinkedHashMap <String,Scope>();
            LinkedHashMap <Integer,Operation> OperationTable = new LinkedHashMap <Integer,Operation>();
            LinkedHashMap <Integer,String> TypeTable = new LinkedHashMap <Integer,String>();
            LinkedHashMap <String,Function> Functiontable = new LinkedHashMap<String, Function>();
            LinkedHashMap <Integer,String> Ltype = new LinkedHashMap <Integer,String>();
	  	Stack <String> opstack = new Stack <String>();
            Function current_function = new Function("","");
            Stack <Integer> labelstack = new Stack <Integer>();
            Stack <Integer> blockstack = new Stack <Integer>();
            Stack <Integer> dostack = new Stack <Integer>();
	  	Scope current_scope;
	  	String scope_name;
            int current_label = 1;
	  	Element current_element = new Element("","","");
	  	int current_count = 1;
            int current_operation = 1;
	  	int current_register = 1;
            int next_label = 0;
            int last_reg = 0;
            int new_flag = 0;
            int funct_call = 0;
            int updateneeded = 0;
            //int current_use = 0;
            int current_IR = 0;
            int middlefunc =0;
            int oppfinished = 0;
            Function current_function_reg = new Function("","");
            LinkedHashMap <Integer,register_type> Allregisters = new LinkedHashMap <Integer,register_type>();



      class register_type{
            public 
                  int index;
                  String status;
                  String variable;
                  int recentuse;
            public register_type(int newindex){
                  index = newindex;
                  recentuse = 0;
                  status = "Free";
                  variable = " ";
            }

      }


      class intset{
            public 
                  int intcount;
                  LinkedHashMap<Integer,Integer> contents = new LinkedHashMap<Integer,Integer> ();
            public intset(){
                  intcount = 0;
            }
            public void Addint(int tobe){
                  this.contents.put(intcount,tobe);
                  this.intcount++;
            }
      }

      class stringset{
            public 
                  int intcount;
                  LinkedHashMap<Integer,String> contents = new LinkedHashMap<Integer,String>();
            public stringset(){
                  intcount = 0;
            }
            public void AddString(String tobe){
                  this.contents.put(intcount,tobe);
                  this.intcount++;
            }
      }

      /*
            This function gives definitions to CFG graphs and their componenets
      */

      class Cfgset{
            public 
                  LinkedHashMap <Integer,intset> Prede = new LinkedHashMap<Integer, intset>();
                  LinkedHashMap <Integer,intset> Succe = new LinkedHashMap<Integer, intset>();
                  LinkedHashMap <Integer,stringset> Gen = new LinkedHashMap<Integer, stringset>();
                  LinkedHashMap <Integer,stringset> Kill = new LinkedHashMap<Integer,stringset>();
                  LinkedHashMap <Integer,stringset> In = new LinkedHashMap<Integer,stringset>();
                  LinkedHashMap <Integer,stringset> Out = new LinkedHashMap<Integer,stringset>();
            public Cfgset(){
                  this.Prede = new LinkedHashMap<Integer, intset>();
                  this.Succe = new LinkedHashMap<Integer, intset>();
            }
           
      }

      /*
            This class defines the function class as it should be parsed into which contains the essential components 
            such arguments, variable declartions statements as well as method to modify the elements etc.
      */

      class Function{
            public
                  String F_type;
                  String F_name;
                  int IRcount;
                  int register_count;
                  int Pcount;
                  int Ecount;
                  int tempregs;
                  LinkedHashMap <Integer,Operation> IRs = new LinkedHashMap<Integer,Operation>();
                  LinkedHashMap <String,Element> Parameters = new LinkedHashMap<String,Element>();
                  Cfgset Cfgs = new Cfgset(); 

            public Function(String type, String name){
                  this.F_type = type;
                  this.F_name = name;
                  this.IRcount = 2;
                  this.Pcount = 0;
                  this.Ecount = 0;
                  this.tempregs =0;
            }
            public void InsertParameter(String name,String type,String value){
                  Element newelement = new Element(CString("$",Pcount+6),type,value);
                  this.Parameters.put(name,newelement);
                  this.Pcount++;
                  this.Ecount--;
            }
            public void InsertElement(Element newele){
                  String name = newele.E_name;
                  Element newelement = new Element(CString("$",-1-this.Ecount),newele.E_type,newele.E_value);
                  this.Parameters.put(name,newelement);
                  this.Ecount++;
            }   
            public void InsertOperation(Operation newoperation){
                  this.IRs.put(IRcount,newoperation);
                  IRcount++;
            } 

            //To insert return statement with the types and arguments

            public void InsertReturn(String variable){
               if(!Parameters.containsKey(variable)){
                  Operation newoperation = new Operation("STOREF",CString("T",current_register),CString("$",Pcount+6),"");
                  TypeTable.put(current_register,this.F_type);
                  current_register++;
                  Operation new3 = new Operation("RET","","","");
                  this.IRs.put(IRcount,newoperation);
                  IRcount++;
                  this.IRs.put(IRcount,new3);
                  IRcount++;
               }else{
                  Operation newoperation = new Operation("STOREF",Parameters.get(variable).E_name,CString("T",current_register),"");
                  Operation newop2 = new Operation("STOREF",CString("T",current_register),CString("$",Pcount+6),"");
                  TypeTable.put(current_register,this.F_type);
                  current_register++;
                  Operation new3 = new Operation("RET","","","");
                  this.IRs.put(IRcount,newoperation);
                  IRcount++;
                  this.IRs.put(IRcount,newop2);
                  IRcount++;
                  this.IRs.put(IRcount,new3);
                  IRcount++;
               }     
            }

            // This method prints the corresponding IR code to stdin.


            public void PrintIR(){
                  int i = 0;
                  System.out.println("Label "+this.F_name);
                  System.out.println("LINK "+CString("",this.Ecount+this.Pcount+this.tempregs));
              
          
                  List<String> keys = new ArrayList<String>(this.Parameters.keySet());
                  for(String key: keys){
                        Element b = Parameters.get(key);
                  }
                  for(i = 0;i<this.IRcount;i++){
                        Operation a = IRs.get(i);
                        System.out.println(a.operation+" "+a.op1+" "+a.op2+" "+a.op3);
                  }
                  System.out.println("RET");
                  System.out.println();

            }

            // This function replaces IR to assembly

            public void Replace(){
                  int i = 0;
                  for(i = 0;i<this.IRcount;i++){
                        Operation a = IRs.get(i);
                        List<String> keys = new ArrayList<String>(this.Parameters.keySet());
                        for(String key: keys){
                              Element b = Parameters.get(key);
                              if(a.op1.equals(key)){
                                    a.op1=b.E_name;
                              }
                              if(a.op2.equals(key)){
                                    a.op2=b.E_name;
                              }
                              if(a.op3.equals(key)){
                                    a.op3=b.E_name;
                              }
                        }     
                  }
            }


            public void Adjust(){
                  Operation newo = new Operation("LABEL",this.F_name,"","");
                  this.IRs.put(0,newo);
                  Operation new2o = new Operation("LINK",CString("",this.Ecount+this.tempregs),"","");
                  this.IRs.put(1,new2o);
                  Operation new3 = new Operation("RET","","","");
                  if(!this.IRs.get(this.IRcount-1).operation.equals("RET")){
                        this.InsertOperation(new3);
                  }
            }
            public void combin(){
                  int i = 0;
                  int k =0;
                  for(i = 1;i<this.IRcount;i++){
                        Operation a = IRs.get(i);
                        Operation b = IRs.get(i-1);
                        if(a.operation.equals("STOREI")|a.operation.equals("STOREF")){
                              if(b.operation.equals("STOREI")|b.operation.equals("STOREF")){
                                    if(b.op2.equals(a.op1)){
                                          if(b.op2.charAt(0)==('T')){
                                                b.op2=a.op2;
                                                //a.operation="null";
                                                for(k=i;k<this.IRcount-1;k++){
                                                      IRs.put(k,IRs.get(k+1));
                                                }
                                                IRs.remove(IRcount-1);
                                                IRcount--;
                                          }
                                    }
                              }
                        }
                  }    
            }
      }

      class Operation{
            public
                  String operation;
                  String op1;
                  String op2;
                  String op3;
                 
            public Operation(String theop, String theop1, String theop2, String theop3){
                  this.operation = theop;
                  this.op1 = theop1;
                  this.op2 = theop2;
                  this.op3 = theop3;
            }
      }

	class Element{
	  	public
	  	   	String E_type;
	  	   	String E_name;
	  	   	String E_value;
	  	public Element(String name, String type, String value){
	  	   	E_type = type;
	  	   	E_name = name;
	  	   	E_value = value;
	  	}
	}

	class Scope{
	  	public
	  		String scope_name;
	  		LinkedHashMap <String,Element> elements = new LinkedHashMap <String,Element>();
	  	public Scope(String name){
	  		scope_name = name;
	  	} 
	}


      public void NewFunction(String f_type, String name){
            current_function.tempregs = current_register;
            current_function = new Function(f_type,name);
            Functiontable.put(name,current_function);
            current_register=0;
      }

      public String CString(String a, int b){
            String h = String.valueOf(b);
            return a+h;
      }

      /*
            This methed checks if it is the end of a statement
      */

      public void Checkdone(){
            if(!opstack.empty()){
               try{
                        int a=Integer.parseInt(opstack.peek());                           
                  }catch (NumberFormatException e){
                        try{
                              float b=Float.parseFloat(opstack.peek());                                      
                        }catch (NumberFormatException x){
                              String current = opstack.peek();
                             // System.out.println(";;; "+current);
                              if(Findelementbyname(current)!=null){
                                    if(Findelementbyname(current).E_type.equals("INT")){
                              //          System.out.println(";"+"STOREI "+current+" \$T"+current_register);
                                          AddOperation("STOREI",current,CString("T",current_register),"dk"); 
                                          TypeTable.put(current_register,"INT"); 
                                          current_register++;
                                    }else if(Findelementbyname(current).E_type.equals("FLOAT")){
                              //          System.out.println(";"+"STOREF "+current+" \$T"+current_register);
                                          AddOperation("STOREF",current,CString("T",current_register),"dk");  
                                          TypeTable.put(current_register,"FLOAT"); 
                                          current_register++;
                                    }
                                    new_flag++;
                              }else{

                              }
                              
                        }
                  }
            }
      }

      /*
            Construct a new CFG graph
      */

      public void Cfgcontruct(){
            for(Iterator func = Functiontable.keySet().iterator();func.hasNext();){
                  Object hello = func.next();
                  Function newfunc = Functiontable.get(hello);
                  Cfgcfunction(newfunc);
            }
      }

      public void Cfgcfunction(Function newfuc){
            int lcv, newlcv;
            int precnt=0;
            int succnt=0;
            int IRcount = newfuc.IRcount;
            for(lcv=0;lcv<IRcount;lcv++){
                  //first part: predecessors; successor
                  succnt = 0;
                  //precnt = 0;
                  intset currentsuc = new intset();  
                  //intset currentpre = new intset();            
                  if(newfuc.IRs.get(lcv).operation.equals("JUMP")){
                        //unconditional jump
                        if(newfuc.IRs.get(lcv).op1.matches("LABEL[0-9]+")){
                              for(newlcv=0;newlcv<IRcount;newlcv++){
                                    if(newfuc.IRs.get(newlcv).operation.equals(newfuc.IRs.get(lcv).op1)){
                                          currentsuc.Addint(newlcv);
                                          if(newfuc.Cfgs.Prede.get(newlcv)==null){
                                              newfuc.Cfgs.Prede.put(newlcv,new intset());  
                                          }
                                          newfuc.Cfgs.Prede.get(newlcv).Addint(lcv);
                                          succnt++;
                                          break;
                                    }
                              } 
                        }     
                  }else if(newfuc.IRs.get(lcv).operation.equals("NE")|
                        newfuc.IRs.get(lcv).operation.equals("LE")|
                        newfuc.IRs.get(lcv).operation.equals("LT")|
                        newfuc.IRs.get(lcv).operation.equals("GT")|
                        newfuc.IRs.get(lcv).operation.equals("GE")|
                        newfuc.IRs.get(lcv).operation.equals("EQ")){
                        //conditional jump
                        for(newlcv=0;newlcv<IRcount;newlcv++){
                          //    System.out.println(newfuc.IRs.get(newlcv).op1);
                              if(newfuc.IRs.get(newlcv).op1.equals("label"+newfuc.IRs.get(lcv).op3)){
                                    currentsuc.Addint(newlcv);
                                    if(newfuc.Cfgs.Prede.get(newlcv)==null){
                                              newfuc.Cfgs.Prede.put(newlcv,new intset());  
                                    
                                    }
                                    newfuc.Cfgs.Prede.get(newlcv).Addint(lcv);
                                    succnt++;
                                    break;
                              }
                        }
                        currentsuc.Addint(lcv+1);
                    
                        if(newfuc.Cfgs.Prede.get(lcv+1)==null){
                              newfuc.Cfgs.Prede.put(lcv+1,new intset());  
                        }
                        newfuc.Cfgs.Prede.get(lcv+1).Addint(lcv);
                        succnt++; 
                  }else if(lcv!=IRcount-1){
                        currentsuc.Addint(lcv+1);
                        if(newfuc.Cfgs.Prede.get(lcv+1)==null){
                              newfuc.Cfgs.Prede.put(lcv+1,new intset());  
                        }
                        newfuc.Cfgs.Prede.get(lcv+1).Addint(lcv);
                        succnt++;
                     // System.out.println("What the fuck");
                  }
                  newfuc.Cfgs.Succe.put(lcv,currentsuc);

                  //second part: 4 sets
                  stringset currentgen = new stringset();
                  stringset currentkill = new stringset();
                  if(newfuc.IRs.get(lcv).operation.equals("PUSH")){
                        if(newfuc.IRs.get(lcv).op1!=""){
                              currentgen.AddString(newfuc.IRs.get(lcv).op1);
                              newfuc.Cfgs.Gen.put(lcv,currentgen);
                        }
                  }else if(newfuc.IRs.get(lcv).operation.equals("POP")){
                        if(newfuc.IRs.get(lcv).op1!=""){
                              currentkill.AddString(newfuc.IRs.get(lcv).op1);
                              newfuc.Cfgs.Kill.put(lcv,currentkill);
                        }
                  }else if(newfuc.IRs.get(lcv).operation.equals("WRITEF")|newfuc.IRs.get(lcv).operation.equals("WRITEI")|newfuc.IRs.get(lcv).operation.equals("WRITES")){
                        if(newfuc.IRs.get(lcv).op1!=""){
                              currentgen.AddString(newfuc.IRs.get(lcv).op1);
                              newfuc.Cfgs.Gen.put(lcv,currentgen);
                        }
                  }else if(newfuc.IRs.get(lcv).operation.equals("READI")|newfuc.IRs.get(lcv).operation.equals("READF")|newfuc.IRs.get(lcv).operation.equals("READS")){
                        if(newfuc.IRs.get(lcv).op1!=""){
                              currentkill.AddString(newfuc.IRs.get(lcv).op1);
                              newfuc.Cfgs.Kill.put(lcv,currentkill);
                        }
                  }else if(newfuc.IRs.get(lcv).operation.equals("STOREF")|newfuc.IRs.get(lcv).operation.equals("STOREI")){
                        currentgen.AddString(newfuc.IRs.get(lcv).op1);
                        currentkill.AddString(newfuc.IRs.get(lcv).op2);
                        newfuc.Cfgs.Gen.put(lcv,currentgen);
                        newfuc.Cfgs.Kill.put(lcv,currentkill);
                  }else if(newfuc.IRs.get(lcv).operation.equals("ADDF")|newfuc.IRs.get(lcv).operation.equals("ADDI")){
                        currentgen.AddString(newfuc.IRs.get(lcv).op1);
                        currentgen.AddString(newfuc.IRs.get(lcv).op2);
                        currentkill.AddString(newfuc.IRs.get(lcv).op3);
                        newfuc.Cfgs.Gen.put(lcv,currentgen);
                        newfuc.Cfgs.Kill.put(lcv,currentkill);
                  }else if(newfuc.IRs.get(lcv).operation.equals("DIVF")|newfuc.IRs.get(lcv).operation.equals("DIVI")){
                        currentgen.AddString(newfuc.IRs.get(lcv).op1);
                        currentgen.AddString(newfuc.IRs.get(lcv).op2);
                        currentkill.AddString(newfuc.IRs.get(lcv).op3);
                        newfuc.Cfgs.Gen.put(lcv,currentgen);
                        newfuc.Cfgs.Kill.put(lcv,currentkill);
                  }else if(newfuc.IRs.get(lcv).operation.equals("SUBF")|newfuc.IRs.get(lcv).operation.equals("SUBI")){
                        currentgen.AddString(newfuc.IRs.get(lcv).op1);
                        currentgen.AddString(newfuc.IRs.get(lcv).op2);
                        currentkill.AddString(newfuc.IRs.get(lcv).op3);
                        newfuc.Cfgs.Gen.put(lcv,currentgen);
                        newfuc.Cfgs.Kill.put(lcv,currentkill);
                  }else if(newfuc.IRs.get(lcv).operation.equals("RET")){
                        for(Iterator elem = SymbolTable.get("GLOBAL").elements.keySet().iterator();elem.hasNext();){
                              Object hello = elem.next();
                              Element newelem = SymbolTable.get("GLOBAL").elements.get(hello);
                              currentgen.AddString(newelem.E_name);
                              newfuc.Cfgs.Gen.put(lcv,currentgen);
                        }
                  }
            }
           // System.out.println("What the fuck!!");
      }

      public void CFGupdate(){
            for(Iterator func = Functiontable.keySet().iterator();func.hasNext();){
                  Object hello = func.next();
                  Function newfunc = Functiontable.get(hello);
                  CFGupdateFunc(newfunc);
            }
            if(updateneeded==1){
                  updateneeded = 0;
                  CFGupdate();
            }
      }

      public void CFGupdateFunc(Function newfunc){
            int IRcount = newfunc.IRcount;
            int lcv = 0;
            for(lcv=IRcount;lcv>0;lcv--){
                 // newfunc.IRs.get(k);
                  stringset oldout = newfunc.Cfgs.Out.get(lcv);
                  stringset newout = Outconstruct(lcv,newfunc);
                  if(oldout==null){
                        newfunc.Cfgs.Out.put(lcv,newout);
                        updateneeded =1;
                  }else if(oldout.intcount!=newout.intcount){
                        newfunc.Cfgs.Out.put(lcv,newout);
                        updateneeded =1;
                  }
            }
            for(lcv=IRcount;lcv>0;lcv--){
                  stringset oldin = newfunc.Cfgs.In.get(lcv);
                  stringset newin = Inconstruct(lcv,newfunc);
                  if(oldin==null){
                        newfunc.Cfgs.In.put(lcv,newin);
                        updateneeded = 1;
                  }else if(oldin.intcount!=newin.intcount){
                        newfunc.Cfgs.In.put(lcv,newin);
                        updateneeded =1;
                  }
            }
      }

      public stringset Outconstruct(int pos, Function current_Fun){
            stringset newout = new stringset();
            intset suc = current_Fun.Cfgs.Succe.get(pos);
            int lcv=0,j=0;
            if(suc!=null){
                  for(lcv=0;lcv<suc.intcount;lcv++){
                        stringset newin = current_Fun.Cfgs.In.get(suc.contents.get(lcv));
                        if(newin!=null){
                              for(j=0;j<newin.intcount;j++){
                                    if(!newout.contents.containsValue(newin.contents.get(j))){
                                          try{
                                                int a = Integer.parseInt(newin.contents.get(j));
                                          }catch(NumberFormatException e){
                                                newout.AddString(newin.contents.get(j));
                                          }
                                    }
                              }
                        }
                  }
            }
            return newout;
      }

      public stringset Inconstruct(int pos, Function current_Fun){
            stringset newin = new stringset();
            stringset currentgen = current_Fun.Cfgs.Gen.get(pos);
            stringset currentout = current_Fun.Cfgs.Out.get(pos);
            stringset currentkill = current_Fun.Cfgs.Kill.get(pos);
            int lcv = 0;
            if(currentgen!=null){
                  for(lcv=0;lcv<currentgen.intcount;lcv++){
                        if(!newin.contents.containsValue(currentgen.contents.get(lcv))){
                              try{
                                    int a = Integer.parseInt(currentgen.contents.get(lcv));
                              }catch(NumberFormatException e){
                                     newin.AddString(currentgen.contents.get(lcv));
                              }
                             
                        }
                  }
            }
            if(currentout!=null){
                  for(lcv=0;lcv<currentout.intcount;lcv++){
                        if(currentkill==null){
                              if(!newin.contents.containsValue(currentout.contents.get(lcv))){
                                    newin.AddString(currentout.contents.get(lcv));
                              } 
                        }else if(!currentkill.contents.containsValue(currentout.contents.get(lcv))){
                              if(!newin.contents.containsValue(currentout.contents.get(lcv))){
                                    try{
                                          int a = Integer.parseInt(currentout.contents.get(lcv));
                                    }catch(NumberFormatException e){
                                          newin.AddString(currentout.contents.get(lcv));
                                    }
                              }
                        }
                  }
            }
            return newin;
      }
      public void Usecount(int index){
            int i = 0;
            Allregisters.get(index).recentuse=-1;
            for(i=0;i<4;i++){
                  Allregisters.get(i).recentuse++;

            }
      }

      public int Ensure(String variable){
            int i=0;
            int exist = 0;
            int r_index = 0;
            for(i=0;i<4;i++){
                  register_type r = Allregisters.get(i);
                  if(r.variable.equals(variable)){
                        exist = 1;
                        r_index = i;
                        //System.out.println(";already there");
                        break;
                  }
            }

            if(exist == 1){
                  Usecount(r_index);
                  return r_index;
            }

            r_index = allocate(variable);
            Usecount(r_index);
            Genload(variable,r_index);
            return r_index;
      }

      public void free(int regindex){
            if(Allregisters.get(regindex).status.equals("Dirty")){
                  if(current_function_reg.Cfgs.Out.get(current_IR).contents.containsValue(Allregisters.get(regindex).variable)){
                        GenStore(regindex, Allregisters.get(regindex).variable);
                  }
            }
            Allregisters.get(regindex).status = "Free";
            //Allregisters.get(regindex).recentuse = 0;

      }

      public void GenStore(int regindex, String variable){
            if(variable.charAt(0)==('T')){
                  String b = variable.split("T")[1];
                  int a = Integer.parseInt(b);
                  int newdes = -1-current_function_reg.Ecount-a; //-1-this.Ecount
                  System.out.println("move "+CString("r",regindex)+" "+CString("$",newdes));
                  if(TypeTable.get(regindex)!=""){
                        Ltype.put(newdes,TypeTable.get(regindex));
                  }else{
                       
                  }
              
            }else{            
                  System.out.println("move "+CString("r",regindex)+" "+variable);
            }
      }
      public void PrintRegs(){
            int i = 0;
            System.out.print(";(");
            for(i=0;i<4;i++){
                  System.out.print(CString("r",i)+"->"+Allregisters.get(i).variable);
                  System.out.print(", ");
                  System.out.print(Allregisters.get(i).status);
                  System.out.print(Allregisters.get(i).recentuse+" ");

            }
            System.out.print(")\n");

      }

      public void Genload(String variable,int r_index){
            Allregisters.get(r_index).variable = variable;
            if(variable.charAt(0)==('T')){
                  String b = variable.split("T")[1];
                  int a = Integer.parseInt(b);
                  int newdes = -1-current_function_reg.Ecount-a;
                  System.out.println("move "+CString("$",newdes)+" "+CString("r",r_index));
            }else{
                 
                  System.out.println("move "+variable+" "+CString("r",r_index));
            }
      }

      public int allocate(String variable){
            int i;

            //find most distant use
            
            int LRU = -1;
            int r_index = -1;
            for(i=0;i<4;i++){
                  register_type r = Allregisters.get(i);
                  if(r.recentuse>LRU){
                        if(r.status.equals("Free")){
                              LRU = r.recentuse;
                              r_index = i;
                        }
                  }
            }
            if(r_index == -1){
                  for(i=0;i<4;i++){
                        register_type r = Allregisters.get(i);
                        if(r.recentuse>LRU){   
                              LRU = r.recentuse;
                              r_index = i;
                        }
                  }
            }
            free(r_index);
            Allregisters.get(r_index).variable = variable;
            return r_index;
      }

      public void PrintCFG(){
             int i,j,k;
             for(Iterator func = Functiontable.keySet().iterator();func.hasNext();){
                  Object hello = func.next();
                  Function newfunc = Functiontable.get(hello);
                  for(k=0;k<newfunc.IRcount;k++){
                        intset pre = newfunc.Cfgs.Prede.get(k);
                        intset suc = newfunc.Cfgs.Succe.get(k);
                        stringset gen = newfunc.Cfgs.Gen.get(k);
                        stringset kill = newfunc.Cfgs.Kill.get(k);
                        stringset in = newfunc.Cfgs.In.get(k);
                        stringset out = newfunc.Cfgs.Out.get(k);
                        System.out.println(";"+k+" "+newfunc.IRs.get(k).operation+" "+newfunc.IRs.get(k).op1+" "+newfunc.IRs.get(k).op2+" "+newfunc.IRs.get(k).op3);
                       /* if(pre!=null){
                              System.out.print(";Pre is ");
                              for(i=0;i<pre.intcount;i++){
                                    System.out.print(pre.contents.get(i)+",");
                              }
                        }
                        System.out.print(" || ");
                        if(suc!=null){
                          //    System.out.println("suc number "+suc.intcount);
                              System.out.print(";Suc is ");
                              for(j=0;j<suc.intcount;j++){
                                    System.out.print(suc.contents.get(j)+",");
                              }
                        }
                        System.out.print(" || ");
                        if(gen!=null){
                          //    System.out.println("suc number "+suc.intcount);
                              System.out.print(";Gen is ");
                              for(j=0;j<gen.intcount;j++){
                                    System.out.print(gen.contents.get(j)+",");
                              }
                        }
                        System.out.print(" || ");
                        if(kill!=null){
                          //    System.out.println("suc number "+suc.intcount);
                              System.out.print(";Kill is ");
                              for(j=0;j<kill.intcount;j++){
                                    System.out.print(kill.contents.get(j)+",");
                              }
                        }
                        System.out.print(" || ");
                        if(in!=null){
                          //    System.out.println("suc number "+suc.intcount);
                              System.out.print(";In is ");
                              for(j=0;j<in.intcount;j++){
                                    System.out.print(in.contents.get(j)+",");
                              }
                        }
                        System.out.print(" || ");
                        if(out!=null){
                          //    System.out.println("suc number "+suc.intcount);
                              System.out.print(";Out is ");
                              for(j=0;j<out.intcount;j++){
                                    System.out.print(out.contents.get(j)+",");
                              }
                        }*/
                        //System.out.println();
                  }
            }      

      }

      public void PutLabel(){
            if(!labelstack.empty()){
                 // System.out.println("nested if found");
                  blockstack.push(current_label);
                  current_label++;
            }
            AddOperation("LABEL",CString("label",current_label),"dk","dk");
          //  System.out.println(";LABEL "+"label"+current_label);
      }
      public void PutLabelj(){
            AddOperation("JUMP",CString("label",labelstack.peek()),"dk","dk");
        //    System.out.println(";JUMP "+"label"+labelstack.peek());
            if(next_label!=0){
                  AddOperation("LABEL",CString("label",next_label),"dk","dk");
            //      System.out.println(";LABEL "+"label"+next_label);
                  next_label=0;
            }else{
                  AddOperation("LABEL",CString("label",current_label),"dk","dk");
            //      System.out.println(";LABEL "+"label"+(current_label));
            }
      }
      public void AddIF(String cond){
          //  System.out.println("addnig a if");
          //  System.out.println("here");
            if(new_flag==2){
                  current_register--;
            }

            new_flag=0;
            current_label++;
            labelstack.push(current_label);
            current_label++;
            if(current_element!=null){
                  TypeTable.put(current_register,current_element.E_type);
            }
           //  System.out.println("what"); 
            if(cond.equals("TRUE")){
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
               //   System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  current_register++;
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
               //   System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  AddOperation("NE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
               //   System.out.println(";NE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                  current_register++;
                 // current_label++;
            }else if(cond.equals("FALSE")){
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
               //   System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  current_register++;
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
                //  System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  AddOperation("EQ",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
                //  System.out.println(";EQ "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                  current_register++;
                //  current_label++;
            }else if(cond.equals("=")){
                  AddOperation("NE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
                //  System.out.println(";NE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                //  current_label++;                 
            }else if(cond.equals("<")){
                  AddOperation("GE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
               //   System.out.println(";GE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
               //   current_label++;
            }else if(cond.equals(">")){
                  AddOperation("LE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
               //  System.out.println(";LE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
               //  current_label++; 
            }else if(cond.equals("!=")){
                  AddOperation("EQ",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
                //  System.out.println(";EQ "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                //  current_label++;          
            }else if(cond.equals("<=")){
                  AddOperation("GT",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
               //   System.out.println(";GT "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
               //   current_label++;
            }else if(cond.equals(">=")){
                  AddOperation("LT",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
               //   System.out.println(";LT "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
               //   current_label++;
            }
            
      }
      public void AddELSEIF(String cond){
            if(new_flag==2){
                  current_register--;
            }
            new_flag=0;
            current_label++;
            if(current_element!=null){
                  TypeTable.put(current_register,current_element.E_type); 
            }
            if(cond.equals("TRUE")){
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  current_register++;
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  AddOperation("NE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";NE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                  current_register++;
                  //current_label++;
            }else if(cond.equals("FALSE")){
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  current_register++;
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  AddOperation("EQ",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";EQ "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                  current_register++;
                 // current_label++;
            }else if(cond.equals("=")){
                  AddOperation("NE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";NE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                 // current_label++;                 
            }else if(cond.equals("<")){
                  AddOperation("GE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";GE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                 // current_label++;
            }else if(cond.equals(">")){
                  AddOperation("LE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
                  System.out.println(";LE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                //  current_label++; 
            }else if(cond.equals("!=")){
                  AddOperation("EQ",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";EQ "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                //  current_label++;          
            }else if(cond.equals("<=")){
                  AddOperation("GT",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";GT "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                //  current_label++;
            }else if(cond.equals(">=")){
                  AddOperation("LT",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";LT "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                 // current_label++;
            }
      }
      public void AddENDIF(){
            if(next_label!=0){
                  AddOperation("LABEL",CString("label",next_label),"dk","dk");
           //       System.out.println(";LABEL "+"label"+next_label);
                  next_label=0;
            }else{
               AddOperation("LABEL",CString("label",current_label),"dk","dk");
           //    System.out.println(";LABEL "+"label"+(current_label));
            }
            int endlabel = labelstack.pop();
            AddOperation("LABEL",CString("label",endlabel),"dk","dk");
            //System.out.println(";LABEL "+"label"+endlabel);
            if(!blockstack.empty()){
                 // System.out.println("this blockstack is "+blockstack.peek());
                  next_label = blockstack.pop();
            }
      }
      public void AddDO(){
            current_label++;
            dostack.push(current_label);
            AddOperation("LABEL",CString("label",current_label),"dk","dk");
            System.out.println(";LABEL "+"label"+current_label);
            
      }
      public void Checkwhile(String cond){
            if(new_flag==2){
                  current_register--;
            }
            new_flag=0;
            current_label++;
            TypeTable.put(current_register,current_element.E_type);
            if(cond.equals("TRUE")){
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  current_register++;
                  TypeTable.put(current_register,current_element.E_type);
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  AddOperation("NE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";NE "+CString("r",current_register-1)+" "+CString("r",current_register)+" label"+current_label);
                  current_register++;

            }else if(cond.equals("FALSE")){
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  current_register++;
                  TypeTable.put(current_register,current_element.E_type);
                  AddOperation("STOREI","1",CString("T",current_register),"dk");
            //      System.out.println(";STOREI "+"1 "+CString("T",current_register));
                  AddOperation("EQ",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";EQ "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
                  current_register++;
            }else if(cond.equals("!=")){
                  AddOperation("EQ",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";EQ "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);               
            }else if(cond.equals(">=")){
                  AddOperation("LT",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";LT "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
            }else if(cond.equals("<=")){
                  AddOperation("GT",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";GT "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
            }else if(cond.equals("=")){
                  AddOperation("NE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";NE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);         
            }else if(cond.equals(">")){
                  AddOperation("LE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";LE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
            }else if(cond.equals("<")){
                  AddOperation("GE",CString("T",current_register-1),CString("T",current_register), Integer.toString(current_label));
            //      System.out.println(";GE "+CString("T",current_register-1)+" "+CString("T",current_register)+" label"+current_label);
            }
            AddOperation("JUMP",CString("label",dostack.peek()),"dk","dk");
            //System.out.println(";JUMP "+"label"+dostack.peek());
            AddOperation("LABEL",CString("label",current_label),"dk","dk");
            //System.out.println(";LABEL "+"label"+current_label);
            current_label++;
      }

      public void AddOperation(String op, String op1,String op2,String op3){
            Operation newoperation = new Operation(op,op1,op2,op3);
            OperationTable.put(current_operation,newoperation);
            current_function.InsertOperation(newoperation);
            current_operation++;
      }

	public void AddElement(String name, String type, String value, Scope current_scope){
	  	Element newelement = new Element(name,type,value);
	  	if(current_scope.elements.containsKey(newelement.E_name)){
	  		 System.out.println(";"+"DECLARATION ERROR "+newelement.E_name);
	  		 System.exit(0);
	  	}else{
	  	   	 current_scope.elements.put(newelement.E_name,newelement);
                   if(!current_scope.scope_name.equals("GLOBAL")){
                        current_function.InsertElement(newelement);
                   }
	  	}
	}

	public Scope NewScope(String scopename){
	  	Scope current_scope = new Scope(scopename); 
	  	SymbolTable.put(current_scope.scope_name,current_scope);
	  	stack.push(current_scope);
	    	return current_scope;
	}

      public void EndScope(){
      	stack.pop();
      	current_scope = stack.peek();
      }

      public void ProcessReadWrite(String op1, String op){
      	String [] ops = op1.split(",");
      	List<String> oplist = Arrays.asList(ops);
      	Iterator <String> i = oplist.iterator();
            while(i.hasNext()){
                  String target = i.next();
                  Element newele = Findelementbyname(target);
                  if(newele.E_type.equals("INT")){
                //        System.out.println(";"+op+"I"+" "+target);
                        AddOperation(op+"I",target,"dk","dk");
                  }else if(newele.E_type.equals("FLOAT")){
                //        System.out.println(";"+op+"F"+" "+target);
                        AddOperation(op+"F",target,"dk","dk");
                  }else{
                //        System.out.println(";"+op+"S"+" "+target);
                        AddOperation(op+"S",target,"dk","dk");
                  }
            }
            //System.out.println(";;; "+current_element.E_name+" "+current_element.E_type);
      
      }

      public Element Findelementbyname(String name){
      	Scope thescope = current_scope;    
      	Element theElement = thescope.elements.get(name);
            if(theElement==null){
               theElement = (SymbolTable.get("GLOBAL").elements).get(name);
            }
            if(theElement==null){
                  if(!stack.isEmpty()){
                        Stack <Scope> tempstack = new Stack <Scope>();
                        while(theElement==null){
                      //      System.out.println("out");
                              Scope newscope = stack.pop();
                              tempstack.push(newscope);
                              theElement = newscope.elements.get(name);
                              if(stack.isEmpty()){
                                    break;
                              }
                        }
                        while(!tempstack.isEmpty()){
                      //      System.out.println("back");
                              Scope transfer = tempstack.pop();
                              stack.push(transfer);
                             
                        }
                        current_scope = stack.peek();
                        //stack.push(current_scope);
                  }
            }
      	return theElement;
      }

      public void CalcStep(String op1, String op, String op2){
      	if(current_element!=null){
      	  	if(op.equals("+")){
                        System.out.println(";"+current_element.E_type+" "+current_element.E_name);
      	  		if(current_element.E_type=="INT"){
                              AddOperation("ADDI",op1,op2,CString("T",current_register));
      	  		}else{
                              
                              AddOperation("ADDF",op1,op2,CString("T",current_register));
      	  		}
      	  	}else if(op.equals("-")){
                        System.out.println(";"+current_element.E_type+" "+current_element.E_name);
      	  		if(current_element.E_type=="INT"){
                              AddOperation("SUBI",op1,op2,CString("T",current_register));
      	  		}else{
                              AddOperation("SUBF",op1,op2,CString("T",current_register));
      	  		}
      	  	}
      	  	opstack.push("T"+current_register);
            }
      	  	
      }

      public void CalcInter(String op1,String op,String op2){
            if(current_element!=null){
            	if(op.equals("*")){
            	  		if(current_element.E_type=="INT"){
            	  	//		System.out.println(";"+"MULTI "+op1+" "+op2+" \$T"+current_register);
                                    AddOperation("MULTI",op1,op2,CString("T",current_register));
            	  		}else{
            	  	//		System.out.println(";"+"MULTF "+op1+" "+op2+" \$T"+current_register);
                                    AddOperation("MULTF",op1,op2,CString("T",current_register));
            	  		}
            	}else if(op.equals("/")){
            	  		if(current_element.E_type=="INT"){
            	  	//		System.out.println(";"+"DIVI "+op1+" "+op2+" \$T"+current_register);
                                    AddOperation("DIVI",op1,op2,CString("T",current_register));
            	  		}else{
            	  	//		System.out.println(";"+"DIVF "+op1+" "+op2+" \$T"+current_register);
                                    AddOperation("DIVF",op1,op2,CString("T",current_register));
            	  		}
            	}
            	opstack.push("T"+current_register);
      	}
      }

      public void Evaluate(){
            if(current_element!=null){
                  //System.out.println(";"+current_element.E_name);
      		if(current_element.E_type=="INT"){
      	           	System.out.println(";;;"+"STOREI "+"\$T"+current_register+" "+current_element.E_name);
                        AddOperation("STOREI",CString("T",current_register),current_element.E_name,"dk");
      		}else{
      			System.out.println(";;;"+"STOREF "+"r"+current_register+" "+current_element.E_name);
                        AddOperation("STOREF",CString("T",current_register),current_element.E_name,"dk");
      		}
                  TypeTable.put(current_register,current_element.E_type);
      		current_register++;
            }
      }

      public void CheckConstant(){
            if((funct_call==0)||(middlefunc==1)){
                  if(current_element!=null){
                      //  System.out.println(";here");
      	           if(!opstack.empty()){
                   //    System.out.println(opstack.peek());
      	          	      try{
                                          
      	          	     	int a=Integer.parseInt(opstack.peek());     				
      	          	//     	System.out.println(";"+"STOREI "+a+" \$T"+current_register);
                                          AddOperation("STOREI",String.valueOf(a),CString("T",current_register),"dk");
      	          	      }catch (NumberFormatException e){
      	          	     	      try{
      	          	     	     	float b=Float.parseFloat(opstack.peek());     						
      	          	//     	     	System.out.println(";"+"STOREF "+b+" \$T"+current_register);
                                                      AddOperation("STOREF",String.valueOf(b),CString("T",current_register),"dk");		
      	          	     	      }catch (NumberFormatException x){
                                                    //  System.out.println(current_element.E_type);
                                                    //  System.out.println("here");
      	          	     	     	if(last_reg==(current_register)||middlefunc==1){
                                                          
                                                            if(current_element.E_type.equals("INT")){
                                                                  String newstring = opstack.pop();
                                                //                  System.out.println(";"+"STOREI "+newstring+" \$T"+current_register);
                                                                  AddOperation("STOREI",newstring,CString("T",current_register),"dk");    
                                                            }else if(current_element.E_type.equals("FLOAT")) {
                                                                  String newstring = opstack.pop();
                                                  //                System.out.println(";"+"STOREF "+newstring+" \$T"+current_register);
                                                                  AddOperation("STOREF",newstring,CString("T",current_register),"dk"); 
                                                            }  
                                                      }
      	          	     	     }
      	          	      }
                        }
                  }
            }else{
                  funct_call=0;
            }
      }
    
      public void TinyGenerator(){
            register_type r0 = new register_type(0);
            register_type r1 = new register_type(1);
            register_type r2 = new register_type(2);
            register_type r3 = new register_type(3);
            Allregisters.put(0,r0);
            Allregisters.put(1,r1);
            Allregisters.put(2,r2);
            Allregisters.put(3,r3);

            //once a register is used, next put will be current_use+4,and then current_use ++; 

            Scope thescope = SymbolTable.get("GLOBAL");
            for (Iterator ele =  (thescope.elements).keySet().iterator();ele.hasNext();){
                  Object down_key= ele.next();
                  if((thescope.elements).get(down_key).E_type.equals("STRING")){
                        System.out.println("str "+(thescope.elements).get(down_key).E_name+" "+(thescope.elements).get(down_key).E_value);
                  }else{
                        System.out.println("var "+(thescope.elements).get(down_key).E_name);
                  }
            }
            System.out.println("push"); 
            System.out.println("push "+CString("r",0));
            System.out.println("push "+CString("r",1));
            System.out.println("push "+CString("r",2));
            System.out.println("push "+CString("r",3));
            System.out.println("jsr main");
            System.out.println("sys halt"); 
            int i,ra,rb,rc;
            Operation temp_op;
            for(Iterator func = Functiontable.keySet().iterator();func.hasNext();){
                  Object hello = func.next();
                  Function newfunc = Functiontable.get(hello);
                  current_function_reg = newfunc;
                  for (i=0;i<newfunc.IRcount;i++){
                        current_IR  = i;
                       // System.out.println();
                        temp_op= newfunc.IRs.get(i);
                      //  System.out.println(";"+i+" "+newfunc.IRs.get(i).operation+" "+newfunc.IRs.get(i).op1+" "+newfunc.IRs.get(i).op2+" "+newfunc.IRs.get(i).op3);
                        if((temp_op.operation).equals("STOREF")|(temp_op.operation).equals("STOREI")){
                              ra = 0;
                              int flag = 1;
                              int flagstar = 1;
                              try{
                                    int a = Integer.parseInt(temp_op.op1);
                              }catch(NumberFormatException e){
                                    try{
                                          float  b= Float.parseFloat(temp_op.op1);   
                                    }catch(NumberFormatException x){
                                          if(temp_op.op1.charAt(0)=='$'){
                                                flagstar = 0;
                                          }
                                          else{
                                                ra = Ensure(temp_op.op1);
                                                flag = 0;
                                          }
                                    }
                              }
                              if(temp_op.op2.charAt(0)=='$'){
                                    if(flag==0|flagstar==0){
                                          rb = Ensure(temp_op.op1);
                                          System.out.println("move "+CString("r",rb)+" "+temp_op.op2);
                                    }
                                    else 
                                          System.out.println("move "+temp_op.op1+" "+temp_op.op2);
                              }else{

                                    rc = allocate(temp_op.op2);
                                    if(flag==0)
                                          System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    else
                                          System.out.println("move "+temp_op.op1+" "+CString("r",rc));
                                    Allregisters.get(rc).status = "Dirty";
                                    Usecount(rc);
                              }
                              if((SymbolTable.get("GLOBAL").elements).get(temp_op.op2)!=null){
                                    int h;
                                    for(h=0;h<4;h++){
                                          register_type r = Allregisters.get(h);
                                          if(r.status.equals("Dirty")){
                                                GenStore(h,r.variable);
                                          }
                                          r.recentuse=h;
                                          r.variable ="";
                                          r.status ="Free";
                                    }
                              }
                              // if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                              //       free(ra);
                              // } 
                              // System.out.println("move "+CString("r",ra)+" "+CString("r",rc));     
                              // System.out.println("move "+temp_op.op1+" "+temp_op.op2);
                        }else if((temp_op.operation).equals("ADDI")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                                    free(ra);
                              }
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                                    free(rb);
                              }
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("addi "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("addi "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("addi "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                             // System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                             // System.out.println("addi "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("ADDF")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                                    free(ra);
                              }
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                                    free(rb);
                              }
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("addr "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("addr "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("addr "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                              //System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              //System.out.println("addr "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("SUBI")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                             
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("subi "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("subi "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("subi "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                                    free(ra);
                              }
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                                   free(rb);
                              }
                              //System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              //System.out.println("subi "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("SUBF")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                             // if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                             //       free(ra);
                             // }
                             // if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                             //       free(rb);
                             // }
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("subr "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("subr "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("subr "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                                    free(ra);
                              }
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                                   free(rb);
                              }
                              //System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              //System.out.println("subr "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("MULTI")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                                   free(ra);
                              }
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                                    free(rb);
                              }
                              rc = allocate(temp_op.op3);
                              //System.out.println(ra+" "+rb+" "+rc);
                              if(rc==ra){
                                    System.out.println("muli "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("muli "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("muli "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                              //System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              //System.out.println("muli "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("MULTF")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                                    free(ra);
                              }
                              if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                                    free(rb);
                              }
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("mulr "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("mulr "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("mulr "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                              // System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              // System.out.println("mulr "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("DIVI")){
                              ra = Ensure(temp_op.op1);
                              
                              rb = Ensure(temp_op.op2);
                              
                              //if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                              //      free(ra);
                              //}
                              //if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                              //      free(rb);
                              //}
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("divi "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){

                                    System.out.println("divi "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("divi "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              
                              Allregisters.get(rc).status = "Dirty";
                              //System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              //System.out.println("divi "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("DIVF")){
                              ra = Ensure(temp_op.op1);
                              rb = Ensure(temp_op.op2);
                              //if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                              //      free(ra);
                              //}
                              //if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op2)){
                              //      free(rb);
                              //}
                              rc = allocate(temp_op.op3);
                              if(rc==ra){
                                    System.out.println("divr "+CString("r",rb)+" "+CString("r",rc)); 
                              }else if(rc==rb){
                                    System.out.println("divr "+CString("r",ra)+" "+CString("r",rc)); 
                              }else{
                                    System.out.println("move "+CString("r",ra)+" "+CString("r",rc));
                                    System.out.println("divr "+CString("r",rb)+" "+CString("r",rc));
                              }
                              Usecount(rc);
                              Allregisters.get(rc).status = "Dirty";
                              //System.out.println("move "+temp_op.op1+" "+temp_op.op3);
                              //System.out.println("divr "+temp_op.op2+" "+temp_op.op3);
                        }else if((temp_op.operation).equals("WRITEI")){
                              if((SymbolTable.get("GLOBAL").elements).get(temp_op.op1)!=null)
                              System.out.println("sys writei "+temp_op.op1);
                              else {
                                    ra = Ensure(temp_op.op1);
                                    System.out.println("sys writei "+CString("r",ra)); 
                              }
                              //System.out.println("sys writei "+temp_op.op1);
                        }else if((temp_op.operation).equals("WRITEF")){
                              if((SymbolTable.get("GLOBAL").elements).get(temp_op.op1)!=null)
                              System.out.println("sys writer "+temp_op.op1);
                              else {
                                    ra = Ensure(temp_op.op1);
                                    System.out.println("sys writer "+CString("r",ra));
                              }
                              //System.out.println("sys writer "+temp_op.op1);
                        }else if((temp_op.operation).equals("WRITES")){
                              if((SymbolTable.get("GLOBAL").elements).get(temp_op.op1)!=null)
                              System.out.println("sys writes "+temp_op.op1);
                              else {
                                    ra = Ensure(temp_op.op1);
                                    System.out.println("sys writes "+CString("r",ra));
                              }
                              //System.out.println("sys writes "+temp_op.op1);
                        }else if((temp_op.operation).equals("READI")){
                              ra = Ensure(temp_op.op1);
                              System.out.println("sys readi "+CString("r",ra));
                              Allregisters.get(ra).status = "Dirty";
                              int h;
                              for(h=0;h<4;h++){
                                    register_type r = Allregisters.get(h);
                                    if(r.status.equals("Dirty")){
                                          GenStore(h,r.variable);
                                    }
                                    r.recentuse=h;
                                    r.variable ="";
                                    r.status ="Free";
                              }
                             // System.out.println("sys readi "+temp_op.op1);
                        }else if((temp_op.operation).equals("READF")){
                              ra = Ensure(temp_op.op1);
                              System.out.println("sys readr "+CString("r",ra));
                              Allregisters.get(ra).status = "Dirty";
                              int h;
                              for(h=0;h<4;h++){
                                    register_type r = Allregisters.get(h);
                                    if(r.status.equals("Dirty")){
                                          GenStore(h,r.variable);
                                    }
                                    r.recentuse=h;
                                    r.variable ="";
                                    r.status ="Free";
                              }
                              //System.out.println("sys readr "+temp_op.op1);
                        }else if((temp_op.operation).equals("NE")){
                              //System.out.println("case 1");
                              ra = Ensure(temp_op.op1);
                            //  if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                            //        free(ra);
                            //  }
                              rc = Ensure(temp_op.op2);
                              if(Findelementbyname(temp_op.op1)!=null){
                                    if(Findelementbyname(temp_op.op1).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op1).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else if(Findelementbyname(temp_op.op2)!=null){
                                    if(Findelementbyname(temp_op.op2).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op2).E_type.equals("INT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else{
                                    String newty = temp_op.op1.split("T")[1];
                                    String ty = TypeTable.get(Integer.parseInt(newty));
                                  //  System.out.println("ty is "+ty+" "+newty +" wrong");
                                    if(ty!=null){
                                          if(ty.equals("FLOAT")){
                                                System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                          }else if(ty.equals("INT")){
                                                System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                          }
                                    }
                              }
                              System.out.println("jne "+"label"+temp_op.op3);
                             // Allregisters.get(rc).status = "Dirty";
                        }else if((temp_op.operation).equals("GE")){
                            ////System.out.println("case 2");
                              ra = Ensure(temp_op.op1);
                            //  if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                            //        free(ra);
                            //  }
                              rc = Ensure(temp_op.op2);
                              if(Findelementbyname(temp_op.op1)!=null){
                                    if(Findelementbyname(temp_op.op1).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                         // System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op1).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                         // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else if(Findelementbyname(temp_op.op2)!=null){
                                    if(Findelementbyname(temp_op.op2).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                         // System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op2).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                         // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else{
                                    String newty = temp_op.op1.split("T")[1];
                                    String ty = TypeTable.get(Integer.parseInt(newty));
                                    //System.out.println("ty is "+ty);
                                    if(ty!=null){
                                          if(ty.equals("FLOAT")){
                                                System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                          }else if(ty.equals("INT")){
                                                System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                          }
                                    }
                              }
                            //  Allregisters.get(rc).status = "Dirty";
                              System.out.println("jge "+"label"+temp_op.op3);
                        }else if((temp_op.operation).equals("GT")){
                              //System.out.println("case 3");
                              ra = Ensure(temp_op.op1);
                           //   if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                           //         free(ra);
                           //   }
                              rc = Ensure(temp_op.op2);
                              if(Findelementbyname(temp_op.op1)!=null){
                                    if(Findelementbyname(temp_op.op1).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op1).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else if(Findelementbyname(temp_op.op2)!=null){
                                    if(Findelementbyname(temp_op.op2).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op2).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else{
                                    String newty = temp_op.op1.split("T")[1];
                                    String ty = TypeTable.get(Integer.parseInt(newty));
                                    //System.out.println("ty is "+ty);
                                    if(ty!=null){
                                          if(ty.equals("FLOAT")){
                                                System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                              //  System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                          }else if(ty.equals("INT")){
                                                System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                          }
                                    }
                              }
                             // Allregisters.get(rc).status = "Dirty";
                              System.out.println("jgt "+"label"+temp_op.op3);
                        }else if((temp_op.operation).equals("LT")){
                              //System.out.println("case 4");
                              ra = Ensure(temp_op.op1);
                          //    if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                          //          free(ra);
                          //    }
                              rc = Ensure(temp_op.op2);
                              if(Findelementbyname(temp_op.op1)!=null){
                                    if(Findelementbyname(temp_op.op1).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op1).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else if(Findelementbyname(temp_op.op2)!=null){
                                    if(Findelementbyname(temp_op.op2).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op2).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else{
                                    String newty = temp_op.op1.split("T")[1];
                                    String ty = TypeTable.get(Integer.parseInt(newty));
                                    //System.out.println("ty is "+ty);
                                    if(ty!=null){
                                          if(ty.equals("FLOAT")){
                                                System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                                //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                          }else if(ty.equals("INT")){   
                                                System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                          }
                                    }
                              }
                             // Allregisters.get(rc).status = "Dirty";
                              System.out.println("jlt "+"label"+temp_op.op3);
                        }else if((temp_op.operation).equals("LE")){
                              //System.out.println("case 5");
                              ra = Ensure(temp_op.op1);
                          //    if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                          //          free(ra);
                          //    }
                              rc = Ensure(temp_op.op2);
                              if(Findelementbyname(temp_op.op1)!=null){
                                    if(Findelementbyname(temp_op.op1).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op1).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else if(Findelementbyname(temp_op.op2)!=null){
                                    if(Findelementbyname(temp_op.op2).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op2).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else{
                                    String newty = temp_op.op1.split("T")[1];
                                    String ty = TypeTable.get(Integer.parseInt(newty));
                                    //System.out.println("ty is "+ty);
                                    if(ty!=null){
                                          if(ty.equals("FLOAT")){
                                                System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                                //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                          }else if(ty.equals("INT")){
                                                System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                                //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                          }
                                    }
                              }
                              //Allregisters.get(rc).status = "Dirty";
                              System.out.println("jle "+"label"+temp_op.op3);
                        }else if((temp_op.operation).equals("EQ")){
                              //System.out.println("case 6");
                              ra = Ensure(temp_op.op1);
                          //    if(!newfunc.Cfgs.Out.get(i).contents.containsValue(temp_op.op1)){
                          //          free(ra);
                          //    }
                              rc = Ensure(temp_op.op2);
                              if(Findelementbyname(temp_op.op1)!=null){
                                    if(Findelementbyname(temp_op.op1).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op1).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else if(Findelementbyname(temp_op.op2)!=null){
                                    if(Findelementbyname(temp_op.op2).E_type.equals("FLOAT")){
                                          System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                    }else if(Findelementbyname(temp_op.op2).E_type.equals("INT")){
                                          System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                          //System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                    }
                              }else{
                                    String newty = temp_op.op1.split("T")[1];
                                    String ty = TypeTable.get(Integer.parseInt(newty));
                                   // System.out.println("ty is "+ty);
                                    if(ty!=null){
                                          if(ty.equals("FLOAT")){
                                                System.out.println("cmpr "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpr "+temp_op.op1+" "+temp_op.op2);
                                          }else if(ty.equals("INT")){
                                                System.out.println("cmpi "+CString("r",ra)+" "+CString("r",rc));
                                               // System.out.println("cmpi "+temp_op.op1+" "+temp_op.op2);
                                          }
                                    }
                              }
                              //Allregisters.get(rc).status = "Dirty";
                              System.out.println("jeq "+"label"+temp_op.op3);
                        }else if((temp_op.operation).equals("LABEL")){
                              //System.out.println("");
                              int h;
                              for(h=0;h<4;h++){
                                    register_type r = Allregisters.get(h);
                                    if(r.status.equals("Dirty")){
                                          GenStore(h,r.variable);
                                    }
                                    r.recentuse=h;
                                    r.variable ="";
                                    r.status ="Free";
                              }
                              System.out.println("label "+temp_op.op1);
                        }else if((temp_op.operation).equals("JUMP")){
                              //System.out.println("case 8");
                              int h;
                              for(h=0;h<4;h++){
                                    register_type r = Allregisters.get(h);
                                    if(r.status.equals("Dirty")){
                                          GenStore(h,r.variable);
                                    }
                                    r.recentuse=h;
                                    r.status ="Free";
                              }
                              System.out.println("jmp "+temp_op.op1);
                        }else if((temp_op.operation).equals("POP")){
                              if(temp_op.op1.equals("")){
                                    System.out.println("pop ");
                              }else{
                                    ra = Ensure(temp_op.op1);
                                    System.out.println("pop "+CString("r",ra));
                              
                                    // System.out.println("here");
                                    Allregisters.get(ra).status = "Dirty";
                                    
                              }
                        }else if((temp_op.operation).equals("PUSH")){
                              if(temp_op.op1.equals("")){
                                    System.out.println("push ");
                              }else{
                                    ra = Ensure(temp_op.op1);
                                    System.out.println("push "+CString("r",ra));
                                    
                              }
                        }else if((temp_op.operation).equals("JSR")){
                              int h;
                              for(h=0;h<4;h++){
                                    register_type r = Allregisters.get(h);
                                    if(r.status.equals("Dirty")){
                                          GenStore(h,r.variable);
                                    }
                                    r.recentuse=h;
                                    r.variable ="";
                                    r.status ="Free";
                              }
                              System.out.println("push r3");
                              System.out.println("push r2");
                              System.out.println("push r1");
                              System.out.println("push r0");
                              System.out.println("jsr "+temp_op.op1); 
                              System.out.println("pop r0"); 
                              System.out.println("pop r1"); 
                              System.out.println("pop r2"); 
                              System.out.println("pop r3"); 
                        }else if((temp_op.operation).equals("RET")){
                              int h;
                              for(h=0;h<4;h++){
                                    register_type r = Allregisters.get(h);
                                    if(r.status.equals("Dirty")){
                                          GenStore(h,r.variable);
                                    }
                                    r.recentuse=h;
                                    r.variable ="";
                                    r.status ="Free";
                              }
                              System.out.println("unlnk");
                              System.out.println("ret");  
                        }else if((temp_op.operation).equals("LINK")){
                              System.out.println("link "+temp_op.op1);
                        }else{
                              System.out.println(";combined");
                        }
                        //PrintRegs();
                  } 
            }      
            System.out.println("end");
      }

	public void PrintTable(){
	  	LinkedHashMap <String,Element> temp_element = new LinkedHashMap <String,Element>();
	  	Scope temp_scope;
  		for (Iterator it =  SymbolTable.keySet().iterator();it.hasNext();){
    		      Object key = it.next();
    		      temp_scope= SymbolTable.get(key);
		    	//System.out.println(";"+"Symbol table "+temp_scope.scope_name);
		    	temp_element = temp_scope.elements;
		    	for (Iterator ele =  temp_element.keySet().iterator();ele.hasNext();){
		    		Object down_key= ele.next();
		    		if(temp_element.get(down_key).E_type=="STRING"){
		    	//		System.out.println(";"+"name "+temp_element.get(down_key).E_name+" type "+temp_element.get(down_key).E_type+"alue  "+temp_element.get(down_key).E_value);
		    		}else{
		    	//		System.out.println(";"+"name "+temp_element.get(down_key).E_name+" type "+temp_element.get(down_key).E_type);
		    		}
		    	}
   		}
	};


    

      public void Functioncall(String fname){
         // System.out.println("Current register is "+current_register); 
            AddOperation("PUSH",CString("T",current_register),"","");
            //AddOperation("PUSH",CString("T",0),"","");
            //AddOperation("PUSH",CString("T",1),"","");
            //AddOperation("PUSH",CString("T",2),"","");
            //AddOperation("PUSH",CString("T",3),"","");
            AddOperation("JSR",fname,"","");
            //AddOperation("POP",CString("T",3),"","");
            //AddOperation("POP",CString("T",2),"","");
            //AddOperation("POP",CString("T",1),"","");
            //AddOperation("POP",CString("T",0),"","");
            int i = 0;
            for(i=0;i<Functiontable.get(fname).Pcount;i++){
                  AddOperation("POP","","","");
            }
           
            if(!Functiontable.get(fname).F_type.equals("VOID")){
                 
                  if(Functiontable.get(fname).F_type.equals("INT")){
                        TypeTable.put(current_register,"INT");
                  }else{
                         TypeTable.put(current_register,"FLOAT");
                  }
                  current_register++;
                  AddOperation("POP",CString("T",current_register),"","");
                  opstack.push(CString("T",current_register));
            }else{
                  AddOperation("POP","","","");
            }
            funct_call=1;
           
      }

      public void Rearragne(){
            for (Iterator it =  Functiontable.keySet().iterator();it.hasNext();){
                  Object key = it.next();
                  Function newfoo = Functiontable.get(key);
                  newfoo.Adjust();
                  newfoo.Replace();
                  newfoo.combin();
            }
      }
      
      public void Printopstack(){
            if(!opstack.empty()){
                  System.out.println(opstack.peek());
            }
      }

      public void PrintType(){
            String ob;
            for (Iterator it =  TypeTable.keySet().iterator();it.hasNext();){
                  Object key = it.next();
                  ob= TypeTable.get(key);
                  System.out.println("it is "+key+" "+ob);
            }
      }
      public void PrintType2(){
            String ob;
            for (Iterator it =  Ltype.keySet().iterator();it.hasNext();){
                  Object key = it.next();
                  ob=  Ltype.get(key);
                  System.out.println("it is "+key+" "+ob);
            }
      }
}

/* Program */
program           : ('PROGRAM' {scope_name="GLOBAL"; current_scope = NewScope(scope_name);}id 'BEGIN' pgm_body 'END'{Rearragne();Cfgcontruct();CFGupdate();PrintCFG();TinyGenerator();}) ;   //
id                : IDENTIFIER ;
pgm_body          : decl func_declarations ;
decl		  	: (string_decl_list | var_decl_list )*;

/* Global String Declaration */
string_decl_list  : ('STRING' id ':=' str {AddElement($id.text, "STRING",$str.text,current_scope);}';')+;
string_decl       : ('STRING' id ':=' str ';')*;
string_decl_tail  : ('STRING' id ':=' str ';')+; 
str               : STRINGLITERAL;


/* Variable Declaration */
var_decl_list     : ((('FLOAT' id{AddElement($id.text, "FLOAT","dk",current_scope);}
					 (',' id{AddElement($id.text, "FLOAT","dk",current_scope);})*) 
				|      ('INT' id{AddElement($id.text, "INT","dk",current_scope);}
				 	 (',' id{AddElement($id.text, "INT","dk",current_scope);})*)) ';')+;   
var_decl          : ( ('FLOAT' id  (',' id)*) | ('INT' id (',' id)*) ';')?;
var_type	      : ('FLOAT' |'INT') ; 
any_type          : (var_type|'VOID') ;
id_list           : id id_tail ;
id_tail           : (',' id)*;
var_decl_tail     : (var_type id_list ';')+; 

/* Function Paramater List */
param_decl_list   : param_decl param_decl_tail;
param_decl        : (('FLOAT' id{AddElement($id.text, "FLOAT","dk",current_scope);current_function.InsertParameter($id.text, "FLOAT","");} ) | ('INT' id{String a = $id.text;AddElement(a, "INT","dk",current_scope);current_function.InsertParameter(a,"INT"," ");})) ;
param_decl_tail   : (',' param_decl)*; 


/* Function Declarations */
func_declarations : (func_decl)* ;
func_decl         : 'FUNCTION' any_type id{scope_name=$id.text; current_scope = NewScope(scope_name);NewFunction($any_type.text,$id.text);} '('(param_decl_list)?')' 'BEGIN' func_body 'END'{EndScope();current_function.tempregs=current_register;};
func_decl_tail    : (func_decl)*  ;
func_body         : decl stmt_list  ;

/* Statement List */
stmt_list         : (stmt)*  ;
stmt_tail         : (stmt)*  ;
stmt              : base_stmt | if_stmt | do_while_stmt ;
base_stmt         : assign_stmt | read_stmt | write_stmt | return_stmt ;

/* Basic Statements */
assign_stmt       : assign_expr ';' ;
assign_expr       : id{current_element = Findelementbyname($id.text);last_reg =current_register; } ':=' expr {Evaluate();oppfinished = 0;};
read_stmt         : 'READ' '(' id_list {ProcessReadWrite($id_list.text,"READ");} ')' ';' ;
write_stmt        : 'WRITE' '(' id_list {ProcessReadWrite($id_list.text,"WRITE");}')' ';' ;
return_stmt       : 'RETURN' expr ';'{current_function.InsertReturn($expr.text);} ;

/* Expressions */
expr 			: factor (addop factor{if(current_element!=null){TypeTable.put(current_register,current_element.E_type); current_register++;String oldop = opstack.pop();CalcStep(opstack.pop(),$addop.text,oldop);oppfinished = 1;}})*{CheckConstant();};
expr_tail         : (addop factor)* ;             // expr_tail)?;
factor 	      : postfix_expr (mulop postfix_expr{if(current_element!=null){TypeTable.put(current_register,current_element.E_type); current_register++;String opf = opstack.pop(); CalcInter(opstack.pop(),$mulop.text,opf);}})* ;
postfix_expr      : primary{String op1 = $primary.text; opstack.push(op1);}  | call_expr |'('expr')';
call_expr         : id{AddOperation("PUSH","","","");}'('(expr_list)? ')'{if(oppfinished==1)opstack.pop();Functioncall($id.text);middlefunc=0;} ;
expr_list         : expr expr_list_tail ;
expr_list_tail    : (','{AddOperation("PUSH",CString("T",current_register),"","");middlefunc=1;} expr)*;                  //(expr_list_tail)?;
primary           :  id | INTLITERAL | FLOATLITERAL ;
addop             : ('+'|'-') ;
mulop             : ('*'|'/') ;


/* Complex Statements and Condition */
if_stmt           : 'IF'{scope_name="BLOCK "+Integer.toString(current_count); current_count=current_count+1; current_scope = NewScope(scope_name);PutLabel();} '(' cond1 ')' decl stmt_list else_part 'ENDIF'{EndScope();AddENDIF();};
else_part         : ('ELSIF'{scope_name="BLOCK "+Integer.toString(current_count); current_count=current_count+1; current_scope = NewScope(scope_name);PutLabelj();} '(' cond2 ')' decl stmt_list else_part{EndScope();})*;
cond1             : expr{Checkdone();} compop expr{Checkdone();AddIF($compop.text);} | 'TRUE'{AddIF("TRUE");}  | 'FALSE'{AddIF("FALSE");} ;
cond2             : expr{Checkdone();} compop expr{Checkdone();AddELSEIF($compop.text);} | 'TRUE'{AddELSEIF("TRUE");}| 'FALSE'{AddELSEIF("FALSE");} ;
cond3             : expr{Checkdone();} compop expr{Checkdone();Checkwhile($compop.text);} | 'TRUE'{Checkwhile("TRUE");} | 'FALSE'{Checkwhile("FALSE");};
cond              : expr compop expr |'TRUE' | 'FALSE' ;
compop            : '<' | '>' | '=' | '!=' | '<=' | '>=' ;

do_while_stmt     : 'DO'{scope_name="BLOCK "+Integer.toString(current_count); current_count=current_count+1; current_scope = NewScope(scope_name);AddDO();} decl stmt_list 'WHILE' '(' cond3 ')'{EndScope();} ';';
	
KEYWORD : 'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSIF'|'ENDIF'|'DO'|'WHILE'|'CONTINUE'|'BREAK'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT'|'TRUE'|'FALSE';

INTLITERAL : DIGIT+;

FLOATLITERAL : DIGIT*'.'DIGIT+;

STRINGLITERAL : '"'.*?'"';

COMMENT : '--'(~[\n])* -> skip ;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]*;

OPERATOR : ':='|'+'|'-'|'*'|'/'|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>='|'=';

WS : [\t\r\n ]+ -> skip;

fragment

DIGIT : [0123456789];
