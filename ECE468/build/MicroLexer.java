// Generated from Micro.g4 by ANTLR 4.1

	import java.io.*;
	import java.util.*;
	import java.lang.*;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__32=1, T__31=2, T__30=3, T__29=4, T__28=5, T__27=6, T__26=7, T__25=8, 
		T__24=9, T__23=10, T__22=11, T__21=12, T__20=13, T__19=14, T__18=15, T__17=16, 
		T__16=17, T__15=18, T__14=19, T__13=20, T__12=21, T__11=22, T__10=23, 
		T__9=24, T__8=25, T__7=26, T__6=27, T__5=28, T__4=29, T__3=30, T__2=31, 
		T__1=32, T__0=33, KEYWORD=34, INTLITERAL=35, FLOATLITERAL=36, STRINGLITERAL=37, 
		COMMENT=38, IDENTIFIER=39, OPERATOR=40, WS=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'DO'", "'*'", "'-'", "'PROGRAM'", "'('", "'READ'", "'<'", "'END'", 
		"'!='", "'<='", "'ENDIF'", "'VOID'", "'STRING'", "'IF'", "'TRUE'", "'FALSE'", 
		"'WRITE'", "')'", "'+'", "'WHILE'", "'ELSIF'", "'='", "';'", "'FUNCTION'", 
		"'>'", "'FLOAT'", "':='", "'RETURN'", "'/'", "'BEGIN'", "'>='", "'INT'", 
		"KEYWORD", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "IDENTIFIER", 
		"OPERATOR", "WS"
	};
	public static final String[] ruleNames = {
		"T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", 
		"T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", 
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"KEYWORD", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "IDENTIFIER", 
		"OPERATOR", "WS", "DIGIT"
	};


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
	                //  contents = new LinkedHashMap<Integer,Integer> ();
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
	            public void PrintIR(){
	                  int i = 0;
	                  System.out.println("Label "+this.F_name);
	                  System.out.println("LINK "+CString("",this.Ecount+this.Pcount+this.tempregs));
	              
	            //    System.out.println("This fucntion has "+this.Pcount+" parameters and"+CString("",Ecount)+" locals");
	                  List<String> keys = new ArrayList<String>(this.Parameters.keySet());
	                  for(String key: keys){
	                        Element b = Parameters.get(key);
	                     // System.out.println("key: "+key+" "+b.E_name+" "+b.E_type+" "+b.E_value);
	                  }
	                  for(i = 0;i<this.IRcount;i++){
	                        Operation a = IRs.get(i);
	                        System.out.println(a.operation+" "+a.op1+" "+a.op2+" "+a.op3);
	                  }
	                  System.out.println("RET");
	                  System.out.println();

	            }
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
	                 // System.out.println(this.F_name);
	                 // System.out.println("temp "+this.tempregs);
	                  Operation new2o = new Operation("LINK",CString("",this.Ecount+this.tempregs),"","");
	                  this.IRs.put(1,new2o);
	                  Operation new3 = new Operation("RET","","","");
	                  if(!this.IRs.get(this.IRcount-1).operation.equals("RET")){
	                        this.InsertOperation(new3);
	                       // this.IRcount++;
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
	                              //          System.out.println(";"+"STOREI "+current+" $T"+current_register);
	                                          AddOperation("STOREI",current,CString("T",current_register),"dk"); 
	                                          TypeTable.put(current_register,"INT"); 
	                                          current_register++;
	                                    }else if(Findelementbyname(current).E_type.equals("FLOAT")){
	                              //          System.out.println(";"+"STOREF "+current+" $T"+current_register);
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
	                //  PrintType2();
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
	            //System.out.println(";I am here");
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
	            	  	//		System.out.println(";"+"MULTI "+op1+" "+op2+" $T"+current_register);
	                                    AddOperation("MULTI",op1,op2,CString("T",current_register));
	            	  		}else{
	            	  	//		System.out.println(";"+"MULTF "+op1+" "+op2+" $T"+current_register);
	                                    AddOperation("MULTF",op1,op2,CString("T",current_register));
	            	  		}
	            	}else if(op.equals("/")){
	            	  		if(current_element.E_type=="INT"){
	            	  	//		System.out.println(";"+"DIVI "+op1+" "+op2+" $T"+current_register);
	                                    AddOperation("DIVI",op1,op2,CString("T",current_register));
	            	  		}else{
	            	  	//		System.out.println(";"+"DIVF "+op1+" "+op2+" $T"+current_register);
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
	      	           	System.out.println(";;;"+"STOREI "+"$T"+current_register+" "+current_element.E_name);
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
	      	          	//     	System.out.println(";"+"STOREI "+a+" $T"+current_register);
	                                          AddOperation("STOREI",String.valueOf(a),CString("T",current_register),"dk");
	      	          	      }catch (NumberFormatException e){
	      	          	     	      try{
	      	          	     	     	float b=Float.parseFloat(opstack.peek());     						
	      	          	//     	     	System.out.println(";"+"STOREF "+b+" $T"+current_register);
	                                                      AddOperation("STOREF",String.valueOf(b),CString("T",current_register),"dk");		
	      	          	     	      }catch (NumberFormatException x){
	                                                    //  System.out.println(current_element.E_type);
	                                                    //  System.out.println("here");
	      	          	     	     	if(last_reg==(current_register)||middlefunc==1){
	                                                          
	                                                            if(current_element.E_type.equals("INT")){
	                                                                  String newstring = opstack.pop();
	                                                //                  System.out.println(";"+"STOREI "+newstring+" $T"+current_register);
	                                                                  AddOperation("STOREI",newstring,CString("T",current_register),"dk");    
	                                                            }else if(current_element.E_type.equals("FLOAT")) {
	                                                                  String newstring = opstack.pop();
	                                                  //                System.out.println(";"+"STOREF "+newstring+" $T"+current_register);
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


	public MicroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 37: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 40: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2+\u0184\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\5#\u0141\n#\3$\6$\u0144\n$\r$\16$\u0145\3%\7%\u0149\n%\f%\16%\u014c"+
		"\13%\3%\3%\6%\u0150\n%\r%\16%\u0151\3&\3&\7&\u0156\n&\f&\16&\u0159\13"+
		"&\3&\3&\3\'\3\'\3\'\3\'\7\'\u0161\n\'\f\'\16\'\u0164\13\'\3\'\3\'\3(\3"+
		"(\7(\u016a\n(\f(\16(\u016d\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u017a"+
		"\n)\3*\6*\u017d\n*\r*\16*\u017e\3*\3*\3+\3+\3\u0157,\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1"+
		"K\'\1M(\2O)\1Q*\1S+\3U\2\1\3\2\t\3\2\f\f\4\2C\\c|\5\2\62;C\\c|\5\2,-/"+
		"/\61\61\6\2*+..=>@@\5\2\13\f\17\17\"\"\3\2\62;\u01a2\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3W\3\2\2\2\5Y\3\2\2"+
		"\2\7\\\3\2\2\2\t^\3\2\2\2\13`\3\2\2\2\rh\3\2\2\2\17j\3\2\2\2\21o\3\2\2"+
		"\2\23q\3\2\2\2\25u\3\2\2\2\27x\3\2\2\2\31{\3\2\2\2\33\u0081\3\2\2\2\35"+
		"\u0086\3\2\2\2\37\u008d\3\2\2\2!\u0090\3\2\2\2#\u0095\3\2\2\2%\u009b\3"+
		"\2\2\2\'\u00a1\3\2\2\2)\u00a3\3\2\2\2+\u00a5\3\2\2\2-\u00ab\3\2\2\2/\u00b1"+
		"\3\2\2\2\61\u00b3\3\2\2\2\63\u00b5\3\2\2\2\65\u00be\3\2\2\2\67\u00c0\3"+
		"\2\2\29\u00c6\3\2\2\2;\u00c9\3\2\2\2=\u00d0\3\2\2\2?\u00d2\3\2\2\2A\u00d8"+
		"\3\2\2\2C\u00db\3\2\2\2E\u0140\3\2\2\2G\u0143\3\2\2\2I\u014a\3\2\2\2K"+
		"\u0153\3\2\2\2M\u015c\3\2\2\2O\u0167\3\2\2\2Q\u0179\3\2\2\2S\u017c\3\2"+
		"\2\2U\u0182\3\2\2\2WX\7.\2\2X\4\3\2\2\2YZ\7F\2\2Z[\7Q\2\2[\6\3\2\2\2\\"+
		"]\7,\2\2]\b\3\2\2\2^_\7/\2\2_\n\3\2\2\2`a\7R\2\2ab\7T\2\2bc\7Q\2\2cd\7"+
		"I\2\2de\7T\2\2ef\7C\2\2fg\7O\2\2g\f\3\2\2\2hi\7*\2\2i\16\3\2\2\2jk\7T"+
		"\2\2kl\7G\2\2lm\7C\2\2mn\7F\2\2n\20\3\2\2\2op\7>\2\2p\22\3\2\2\2qr\7G"+
		"\2\2rs\7P\2\2st\7F\2\2t\24\3\2\2\2uv\7#\2\2vw\7?\2\2w\26\3\2\2\2xy\7>"+
		"\2\2yz\7?\2\2z\30\3\2\2\2{|\7G\2\2|}\7P\2\2}~\7F\2\2~\177\7K\2\2\177\u0080"+
		"\7H\2\2\u0080\32\3\2\2\2\u0081\u0082\7X\2\2\u0082\u0083\7Q\2\2\u0083\u0084"+
		"\7K\2\2\u0084\u0085\7F\2\2\u0085\34\3\2\2\2\u0086\u0087\7U\2\2\u0087\u0088"+
		"\7V\2\2\u0088\u0089\7T\2\2\u0089\u008a\7K\2\2\u008a\u008b\7P\2\2\u008b"+
		"\u008c\7I\2\2\u008c\36\3\2\2\2\u008d\u008e\7K\2\2\u008e\u008f\7H\2\2\u008f"+
		" \3\2\2\2\u0090\u0091\7V\2\2\u0091\u0092\7T\2\2\u0092\u0093\7W\2\2\u0093"+
		"\u0094\7G\2\2\u0094\"\3\2\2\2\u0095\u0096\7H\2\2\u0096\u0097\7C\2\2\u0097"+
		"\u0098\7N\2\2\u0098\u0099\7U\2\2\u0099\u009a\7G\2\2\u009a$\3\2\2\2\u009b"+
		"\u009c\7Y\2\2\u009c\u009d\7T\2\2\u009d\u009e\7K\2\2\u009e\u009f\7V\2\2"+
		"\u009f\u00a0\7G\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2(\3\2\2\2\u00a3"+
		"\u00a4\7-\2\2\u00a4*\3\2\2\2\u00a5\u00a6\7Y\2\2\u00a6\u00a7\7J\2\2\u00a7"+
		"\u00a8\7K\2\2\u00a8\u00a9\7N\2\2\u00a9\u00aa\7G\2\2\u00aa,\3\2\2\2\u00ab"+
		"\u00ac\7G\2\2\u00ac\u00ad\7N\2\2\u00ad\u00ae\7U\2\2\u00ae\u00af\7K\2\2"+
		"\u00af\u00b0\7H\2\2\u00b0.\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\60\3\2\2\2"+
		"\u00b3\u00b4\7=\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7H\2\2\u00b6\u00b7\7"+
		"W\2\2\u00b7\u00b8\7P\2\2\u00b8\u00b9\7E\2\2\u00b9\u00ba\7V\2\2\u00ba\u00bb"+
		"\7K\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7P\2\2\u00bd\64\3\2\2\2\u00be\u00bf"+
		"\7@\2\2\u00bf\66\3\2\2\2\u00c0\u00c1\7H\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3"+
		"\7Q\2\2\u00c3\u00c4\7C\2\2\u00c4\u00c5\7V\2\2\u00c58\3\2\2\2\u00c6\u00c7"+
		"\7<\2\2\u00c7\u00c8\7?\2\2\u00c8:\3\2\2\2\u00c9\u00ca\7T\2\2\u00ca\u00cb"+
		"\7G\2\2\u00cb\u00cc\7V\2\2\u00cc\u00cd\7W\2\2\u00cd\u00ce\7T\2\2\u00ce"+
		"\u00cf\7P\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7\61\2\2\u00d1>\3\2\2\2\u00d2"+
		"\u00d3\7D\2\2\u00d3\u00d4\7G\2\2\u00d4\u00d5\7I\2\2\u00d5\u00d6\7K\2\2"+
		"\u00d6\u00d7\7P\2\2\u00d7@\3\2\2\2\u00d8\u00d9\7@\2\2\u00d9\u00da\7?\2"+
		"\2\u00daB\3\2\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7P\2\2\u00dd\u00de\7"+
		"V\2\2\u00deD\3\2\2\2\u00df\u00e0\7R\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2"+
		"\7Q\2\2\u00e2\u00e3\7I\2\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7C\2\2\u00e5"+
		"\u0141\7O\2\2\u00e6\u00e7\7D\2\2\u00e7\u00e8\7G\2\2\u00e8\u00e9\7I\2\2"+
		"\u00e9\u00ea\7K\2\2\u00ea\u0141\7P\2\2\u00eb\u00ec\7G\2\2\u00ec\u00ed"+
		"\7P\2\2\u00ed\u0141\7F\2\2\u00ee\u00ef\7H\2\2\u00ef\u00f0\7W\2\2\u00f0"+
		"\u00f1\7P\2\2\u00f1\u00f2\7E\2\2\u00f2\u00f3\7V\2\2\u00f3\u00f4\7K\2\2"+
		"\u00f4\u00f5\7Q\2\2\u00f5\u0141\7P\2\2\u00f6\u00f7\7T\2\2\u00f7\u00f8"+
		"\7G\2\2\u00f8\u00f9\7C\2\2\u00f9\u0141\7F\2\2\u00fa\u00fb\7Y\2\2\u00fb"+
		"\u00fc\7T\2\2\u00fc\u00fd\7K\2\2\u00fd\u00fe\7V\2\2\u00fe\u0141\7G\2\2"+
		"\u00ff\u0100\7K\2\2\u0100\u0141\7H\2\2\u0101\u0102\7G\2\2\u0102\u0103"+
		"\7N\2\2\u0103\u0104\7U\2\2\u0104\u0105\7K\2\2\u0105\u0141\7H\2\2\u0106"+
		"\u0107\7G\2\2\u0107\u0108\7P\2\2\u0108\u0109\7F\2\2\u0109\u010a\7K\2\2"+
		"\u010a\u0141\7H\2\2\u010b\u010c\7F\2\2\u010c\u0141\7Q\2\2\u010d\u010e"+
		"\7Y\2\2\u010e\u010f\7J\2\2\u010f\u0110\7K\2\2\u0110\u0111\7N\2\2\u0111"+
		"\u0141\7G\2\2\u0112\u0113\7E\2\2\u0113\u0114\7Q\2\2\u0114\u0115\7P\2\2"+
		"\u0115\u0116\7V\2\2\u0116\u0117\7K\2\2\u0117\u0118\7P\2\2\u0118\u0119"+
		"\7W\2\2\u0119\u0141\7G\2\2\u011a\u011b\7D\2\2\u011b\u011c\7T\2\2\u011c"+
		"\u011d\7G\2\2\u011d\u011e\7C\2\2\u011e\u0141\7M\2\2\u011f\u0120\7T\2\2"+
		"\u0120\u0121\7G\2\2\u0121\u0122\7V\2\2\u0122\u0123\7W\2\2\u0123\u0124"+
		"\7T\2\2\u0124\u0141\7P\2\2\u0125\u0126\7K\2\2\u0126\u0127\7P\2\2\u0127"+
		"\u0141\7V\2\2\u0128\u0129\7X\2\2\u0129\u012a\7Q\2\2\u012a\u012b\7K\2\2"+
		"\u012b\u0141\7F\2\2\u012c\u012d\7U\2\2\u012d\u012e\7V\2\2\u012e\u012f"+
		"\7T\2\2\u012f\u0130\7K\2\2\u0130\u0131\7P\2\2\u0131\u0141\7I\2\2\u0132"+
		"\u0133\7H\2\2\u0133\u0134\7N\2\2\u0134\u0135\7Q\2\2\u0135\u0136\7C\2\2"+
		"\u0136\u0141\7V\2\2\u0137\u0138\7V\2\2\u0138\u0139\7T\2\2\u0139\u013a"+
		"\7W\2\2\u013a\u0141\7G\2\2\u013b\u013c\7H\2\2\u013c\u013d\7C\2\2\u013d"+
		"\u013e\7N\2\2\u013e\u013f\7U\2\2\u013f\u0141\7G\2\2\u0140\u00df\3\2\2"+
		"\2\u0140\u00e6\3\2\2\2\u0140\u00eb\3\2\2\2\u0140\u00ee\3\2\2\2\u0140\u00f6"+
		"\3\2\2\2\u0140\u00fa\3\2\2\2\u0140\u00ff\3\2\2\2\u0140\u0101\3\2\2\2\u0140"+
		"\u0106\3\2\2\2\u0140\u010b\3\2\2\2\u0140\u010d\3\2\2\2\u0140\u0112\3\2"+
		"\2\2\u0140\u011a\3\2\2\2\u0140\u011f\3\2\2\2\u0140\u0125\3\2\2\2\u0140"+
		"\u0128\3\2\2\2\u0140\u012c\3\2\2\2\u0140\u0132\3\2\2\2\u0140\u0137\3\2"+
		"\2\2\u0140\u013b\3\2\2\2\u0141F\3\2\2\2\u0142\u0144\5U+\2\u0143\u0142"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"H\3\2\2\2\u0147\u0149\5U+\2\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014d\u014f\7\60\2\2\u014e\u0150\5U+\2\u014f\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152J\3\2\2\2"+
		"\u0153\u0157\7$\2\2\u0154\u0156\13\2\2\2\u0155\u0154\3\2\2\2\u0156\u0159"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015a\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015b\7$\2\2\u015bL\3\2\2\2\u015c\u015d\7/\2\2\u015d"+
		"\u015e\7/\2\2\u015e\u0162\3\2\2\2\u015f\u0161\n\2\2\2\u0160\u015f\3\2"+
		"\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\b\'\2\2\u0166N\3\2\2\2"+
		"\u0167\u016b\t\3\2\2\u0168\u016a\t\4\2\2\u0169\u0168\3\2\2\2\u016a\u016d"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016cP\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016e\u016f\7<\2\2\u016f\u017a\7?\2\2\u0170\u017a\t\5\2"+
		"\2\u0171\u0172\7#\2\2\u0172\u017a\7?\2\2\u0173\u017a\t\6\2\2\u0174\u0175"+
		"\7>\2\2\u0175\u017a\7?\2\2\u0176\u0177\7@\2\2\u0177\u017a\7?\2\2\u0178"+
		"\u017a\7?\2\2\u0179\u016e\3\2\2\2\u0179\u0170\3\2\2\2\u0179\u0171\3\2"+
		"\2\2\u0179\u0173\3\2\2\2\u0179\u0174\3\2\2\2\u0179\u0176\3\2\2\2\u0179"+
		"\u0178\3\2\2\2\u017aR\3\2\2\2\u017b\u017d\t\7\2\2\u017c\u017b\3\2\2\2"+
		"\u017d\u017e\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0181\b*\3\2\u0181T\3\2\2\2\u0182\u0183\t\b\2\2\u0183V"+
		"\3\2\2\2\f\2\u0140\u0145\u014a\u0151\u0157\u0162\u016b\u0179\u017e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}