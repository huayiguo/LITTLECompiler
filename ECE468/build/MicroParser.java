// Generated from Micro.g4 by ANTLR 4.1

	import java.io.*;
	import java.util.*;
	import java.lang.*;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'DO'", "'*'", "'-'", "'PROGRAM'", "'('", "'READ'", 
		"'<'", "'END'", "'!='", "'<='", "'ENDIF'", "'VOID'", "'STRING'", "'IF'", 
		"'TRUE'", "'FALSE'", "'WRITE'", "')'", "'+'", "'WHILE'", "'ELSIF'", "'='", 
		"';'", "'FUNCTION'", "'>'", "'FLOAT'", "':='", "'RETURN'", "'/'", "'BEGIN'", 
		"'>='", "'INT'", "KEYWORD", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"COMMENT", "IDENTIFIER", "OPERATOR", "WS"
	};
	public static final int
		RULE_program = 0, RULE_id = 1, RULE_pgm_body = 2, RULE_decl = 3, RULE_string_decl_list = 4, 
		RULE_string_decl = 5, RULE_string_decl_tail = 6, RULE_str = 7, RULE_var_decl_list = 8, 
		RULE_var_decl = 9, RULE_var_type = 10, RULE_any_type = 11, RULE_id_list = 12, 
		RULE_id_tail = 13, RULE_var_decl_tail = 14, RULE_param_decl_list = 15, 
		RULE_param_decl = 16, RULE_param_decl_tail = 17, RULE_func_declarations = 18, 
		RULE_func_decl = 19, RULE_func_decl_tail = 20, RULE_func_body = 21, RULE_stmt_list = 22, 
		RULE_stmt_tail = 23, RULE_stmt = 24, RULE_base_stmt = 25, RULE_assign_stmt = 26, 
		RULE_assign_expr = 27, RULE_read_stmt = 28, RULE_write_stmt = 29, RULE_return_stmt = 30, 
		RULE_expr = 31, RULE_expr_tail = 32, RULE_factor = 33, RULE_postfix_expr = 34, 
		RULE_call_expr = 35, RULE_expr_list = 36, RULE_expr_list_tail = 37, RULE_primary = 38, 
		RULE_addop = 39, RULE_mulop = 40, RULE_if_stmt = 41, RULE_else_part = 42, 
		RULE_cond1 = 43, RULE_cond2 = 44, RULE_cond3 = 45, RULE_cond = 46, RULE_compop = 47, 
		RULE_do_while_stmt = 48;
	public static final String[] ruleNames = {
		"program", "id", "pgm_body", "decl", "string_decl_list", "string_decl", 
		"string_decl_tail", "str", "var_decl_list", "var_decl", "var_type", "any_type", 
		"id_list", "id_tail", "var_decl_tail", "param_decl_list", "param_decl", 
		"param_decl_tail", "func_declarations", "func_decl", "func_decl_tail", 
		"func_body", "stmt_list", "stmt_tail", "stmt", "base_stmt", "assign_stmt", 
		"assign_expr", "read_stmt", "write_stmt", "return_stmt", "expr", "expr_tail", 
		"factor", "postfix_expr", "call_expr", "expr_list", "expr_list_tail", 
		"primary", "addop", "mulop", "if_stmt", "else_part", "cond1", "cond2", 
		"cond3", "cond", "compop", "do_while_stmt"
	};

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public MicroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Pgm_bodyContext pgm_body() {
			return getRuleContext(Pgm_bodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(98); match(5);
			scope_name="GLOBAL"; current_scope = NewScope(scope_name);
			setState(100); id();
			setState(101); match(31);
			setState(102); pgm_body();
			setState(103); match(9);
			Rearragne();Cfgcontruct();CFGupdate();PrintCFG();TinyGenerator();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pgm_bodyContext extends ParserRuleContext {
		public Func_declarationsContext func_declarations() {
			return getRuleContext(Func_declarationsContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Pgm_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pgm_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPgm_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPgm_body(this);
		}
	}

	public final Pgm_bodyContext pgm_body() throws RecognitionException {
		Pgm_bodyContext _localctx = new Pgm_bodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pgm_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); decl();
			setState(109); func_declarations();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String_decl_listContext string_decl_list(int i) {
			return getRuleContext(String_decl_listContext.class,i);
		}
		public List<Var_decl_listContext> var_decl_list() {
			return getRuleContexts(Var_decl_listContext.class);
		}
		public List<String_decl_listContext> string_decl_list() {
			return getRuleContexts(String_decl_listContext.class);
		}
		public Var_decl_listContext var_decl_list(int i) {
			return getRuleContext(Var_decl_listContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 14) | (1L << 27) | (1L << 33))) != 0)) {
				{
				setState(113);
				switch (_input.LA(1)) {
				case 14:
					{
					setState(111); string_decl_list();
					}
					break;
				case 27:
				case 33:
					{
					setState(112); var_decl_list();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_decl_listContext extends ParserRuleContext {
		public IdContext id;
		public StrContext str;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public String_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterString_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitString_decl_list(this);
		}
	}

	public final String_decl_listContext string_decl_list() throws RecognitionException {
		String_decl_listContext _localctx = new String_decl_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string_decl_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(118); match(14);
					setState(119); ((String_decl_listContext)_localctx).id = id();
					setState(120); match(28);
					setState(121); ((String_decl_listContext)_localctx).str = str();
					AddElement((((String_decl_listContext)_localctx).id!=null?_input.getText(((String_decl_listContext)_localctx).id.start,((String_decl_listContext)_localctx).id.stop):null), "STRING",(((String_decl_listContext)_localctx).str!=null?_input.getText(((String_decl_listContext)_localctx).str.start,((String_decl_listContext)_localctx).str.stop):null),current_scope);
					setState(123); match(24);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(127); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_declContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public String_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterString_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitString_decl(this);
		}
	}

	public final String_declContext string_decl() throws RecognitionException {
		String_declContext _localctx = new String_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_string_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==14) {
				{
				{
				setState(129); match(14);
				setState(130); id();
				setState(131); match(28);
				setState(132); str();
				setState(133); match(24);
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_decl_tailContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public String_decl_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_decl_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterString_decl_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitString_decl_tail(this);
		}
	}

	public final String_decl_tailContext string_decl_tail() throws RecognitionException {
		String_decl_tailContext _localctx = new String_decl_tailContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string_decl_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140); match(14);
				setState(141); id();
				setState(142); match(28);
				setState(143); str();
				setState(144); match(24);
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==14 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrContext extends ParserRuleContext {
		public TerminalNode STRINGLITERAL() { return getToken(MicroParser.STRINGLITERAL, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStr(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(STRINGLITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_decl_listContext extends ParserRuleContext {
		public IdContext id;
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Var_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_decl_list(this);
		}
	}

	public final Var_decl_listContext var_decl_list() throws RecognitionException {
		Var_decl_listContext _localctx = new Var_decl_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var_decl_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(176);
					switch (_input.LA(1)) {
					case 27:
						{
						{
						setState(152); match(27);
						setState(153); ((Var_decl_listContext)_localctx).id = id();
						AddElement((((Var_decl_listContext)_localctx).id!=null?_input.getText(((Var_decl_listContext)_localctx).id.start,((Var_decl_listContext)_localctx).id.stop):null), "FLOAT","dk",current_scope);
						setState(161);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==1) {
							{
							{
							setState(155); match(1);
							setState(156); ((Var_decl_listContext)_localctx).id = id();
							AddElement((((Var_decl_listContext)_localctx).id!=null?_input.getText(((Var_decl_listContext)_localctx).id.start,((Var_decl_listContext)_localctx).id.stop):null), "FLOAT","dk",current_scope);
							}
							}
							setState(163);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						break;
					case 33:
						{
						{
						setState(164); match(33);
						setState(165); ((Var_decl_listContext)_localctx).id = id();
						AddElement((((Var_decl_listContext)_localctx).id!=null?_input.getText(((Var_decl_listContext)_localctx).id.start,((Var_decl_listContext)_localctx).id.stop):null), "INT","dk",current_scope);
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==1) {
							{
							{
							setState(167); match(1);
							setState(168); ((Var_decl_listContext)_localctx).id = id();
							AddElement((((Var_decl_listContext)_localctx).id!=null?_input.getText(((Var_decl_listContext)_localctx).id.start,((Var_decl_listContext)_localctx).id.stop):null), "INT","dk",current_scope);
							}
							}
							setState(175);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(178); match(24);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(182); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			switch (_input.LA(1)) {
			case 27:
				{
				{
				setState(184); match(27);
				setState(185); id();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(186); match(1);
					setState(187); id();
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 33:
				{
				{
				setState(193); match(33);
				setState(194); id();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(195); match(1);
					setState(196); id();
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(202); match(24);
				}
				break;
			case EOF:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_typeContext extends ParserRuleContext {
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_type(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !(_la==27 || _la==33) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Any_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAny_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAny_type(this);
		}
	}

	public final Any_typeContext any_type() throws RecognitionException {
		Any_typeContext _localctx = new Any_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_any_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			switch (_input.LA(1)) {
			case 27:
			case 33:
				{
				setState(208); var_type();
				}
				break;
			case 13:
				{
				setState(209); match(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tailContext id_tail() {
			return getRuleContext(Id_tailContext.class,0);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_list(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_id_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); id();
			setState(213); id_tail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_tailContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Id_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_tail(this);
		}
	}

	public final Id_tailContext id_tail() throws RecognitionException {
		Id_tailContext _localctx = new Id_tailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_id_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(215); match(1);
				setState(216); id();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_decl_tailContext extends ParserRuleContext {
		public Id_listContext id_list(int i) {
			return getRuleContext(Id_listContext.class,i);
		}
		public List<Id_listContext> id_list() {
			return getRuleContexts(Id_listContext.class);
		}
		public Var_typeContext var_type(int i) {
			return getRuleContext(Var_typeContext.class,i);
		}
		public List<Var_typeContext> var_type() {
			return getRuleContexts(Var_typeContext.class);
		}
		public Var_decl_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_decl_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_decl_tail(this);
		}
	}

	public final Var_decl_tailContext var_decl_tail() throws RecognitionException {
		Var_decl_tailContext _localctx = new Var_decl_tailContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_var_decl_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(222); var_type();
				setState(223); id_list();
				setState(224); match(24);
				}
				}
				setState(228); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==27 || _la==33 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_listContext extends ParserRuleContext {
		public Param_decl_tailContext param_decl_tail() {
			return getRuleContext(Param_decl_tailContext.class,0);
		}
		public Param_declContext param_decl() {
			return getRuleContext(Param_declContext.class,0);
		}
		public Param_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl_list(this);
		}
	}

	public final Param_decl_listContext param_decl_list() throws RecognitionException {
		Param_decl_listContext _localctx = new Param_decl_listContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param_decl_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); param_decl();
			setState(231); param_decl_tail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_declContext extends ParserRuleContext {
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl(this);
		}
	}

	public final Param_declContext param_decl() throws RecognitionException {
		Param_declContext _localctx = new Param_declContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			switch (_input.LA(1)) {
			case 27:
				{
				{
				setState(233); match(27);
				setState(234); ((Param_declContext)_localctx).id = id();
				AddElement((((Param_declContext)_localctx).id!=null?_input.getText(((Param_declContext)_localctx).id.start,((Param_declContext)_localctx).id.stop):null), "FLOAT","dk",current_scope);current_function.InsertParameter((((Param_declContext)_localctx).id!=null?_input.getText(((Param_declContext)_localctx).id.start,((Param_declContext)_localctx).id.stop):null), "FLOAT","");
				}
				}
				break;
			case 33:
				{
				{
				setState(237); match(33);
				setState(238); ((Param_declContext)_localctx).id = id();
				String a = (((Param_declContext)_localctx).id!=null?_input.getText(((Param_declContext)_localctx).id.start,((Param_declContext)_localctx).id.stop):null);AddElement(a, "INT","dk",current_scope);current_function.InsertParameter(a,"INT"," ");
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_tailContext extends ParserRuleContext {
		public Param_declContext param_decl(int i) {
			return getRuleContext(Param_declContext.class,i);
		}
		public List<Param_declContext> param_decl() {
			return getRuleContexts(Param_declContext.class);
		}
		public Param_decl_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl_tail(this);
		}
	}

	public final Param_decl_tailContext param_decl_tail() throws RecognitionException {
		Param_decl_tailContext _localctx = new Param_decl_tailContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_param_decl_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(243); match(1);
				setState(244); param_decl();
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declarationsContext extends ParserRuleContext {
		public List<Func_declContext> func_decl() {
			return getRuleContexts(Func_declContext.class);
		}
		public Func_declContext func_decl(int i) {
			return getRuleContext(Func_declContext.class,i);
		}
		public Func_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_declarations(this);
		}
	}

	public final Func_declarationsContext func_declarations() throws RecognitionException {
		Func_declarationsContext _localctx = new Func_declarationsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_func_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(250); func_decl();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declContext extends ParserRuleContext {
		public Any_typeContext any_type;
		public IdContext id;
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Param_decl_listContext param_decl_list() {
			return getRuleContext(Param_decl_listContext.class,0);
		}
		public Any_typeContext any_type() {
			return getRuleContext(Any_typeContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_decl(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_func_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(25);
			setState(257); ((Func_declContext)_localctx).any_type = any_type();
			setState(258); ((Func_declContext)_localctx).id = id();
			scope_name=(((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null); current_scope = NewScope(scope_name);NewFunction((((Func_declContext)_localctx).any_type!=null?_input.getText(((Func_declContext)_localctx).any_type.start,((Func_declContext)_localctx).any_type.stop):null),(((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null));
			setState(260); match(6);
			setState(262);
			_la = _input.LA(1);
			if (_la==27 || _la==33) {
				{
				setState(261); param_decl_list();
				}
			}

			setState(264); match(19);
			setState(265); match(31);
			setState(266); func_body();
			setState(267); match(9);
			EndScope();current_function.tempregs=current_register;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_decl_tailContext extends ParserRuleContext {
		public List<Func_declContext> func_decl() {
			return getRuleContexts(Func_declContext.class);
		}
		public Func_declContext func_decl(int i) {
			return getRuleContext(Func_declContext.class,i);
		}
		public Func_decl_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_decl_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_decl_tail(this);
		}
	}

	public final Func_decl_tailContext func_decl_tail() throws RecognitionException {
		Func_decl_tailContext _localctx = new Func_decl_tailContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_func_decl_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==25) {
				{
				{
				setState(270); func_decl();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_bodyContext extends ParserRuleContext {
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_body(this);
		}
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); decl();
			setState(277); stmt_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt_list(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 7) | (1L << 15) | (1L << 18) | (1L << 29) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(279); stmt();
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_tailContext extends ParserRuleContext {
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Stmt_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt_tail(this);
		}
	}

	public final Stmt_tailContext stmt_tail() throws RecognitionException {
		Stmt_tailContext _localctx = new Stmt_tailContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stmt_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 7) | (1L << 15) | (1L << 18) | (1L << 29) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(285); stmt();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Do_while_stmtContext do_while_stmt() {
			return getRuleContext(Do_while_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_stmt);
		try {
			setState(294);
			switch (_input.LA(1)) {
			case 7:
			case 18:
			case 29:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(291); base_stmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 2);
				{
				setState(292); if_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 3);
				{
				setState(293); do_while_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_stmtContext extends ParserRuleContext {
		public Write_stmtContext write_stmt() {
			return getRuleContext(Write_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Base_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterBase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitBase_stmt(this);
		}
	}

	public final Base_stmtContext base_stmt() throws RecognitionException {
		Base_stmtContext _localctx = new Base_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_base_stmt);
		try {
			setState(300);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(296); assign_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 2);
				{
				setState(297); read_stmt();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 3);
				{
				setState(298); write_stmt();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 4);
				{
				setState(299); return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); assign_expr();
			setState(303); match(24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); ((Assign_exprContext)_localctx).id = id();
			current_element = Findelementbyname((((Assign_exprContext)_localctx).id!=null?_input.getText(((Assign_exprContext)_localctx).id.start,((Assign_exprContext)_localctx).id.stop):null));last_reg =current_register; 
			setState(307); match(28);
			setState(308); expr();
			Evaluate();oppfinished = 0;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_stmtContext extends ParserRuleContext {
		public Id_listContext id_list;
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitRead_stmt(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); match(7);
			setState(312); match(6);
			setState(313); ((Read_stmtContext)_localctx).id_list = id_list();
			ProcessReadWrite((((Read_stmtContext)_localctx).id_list!=null?_input.getText(((Read_stmtContext)_localctx).id_list.start,((Read_stmtContext)_localctx).id_list.stop):null),"READ");
			setState(315); match(19);
			setState(316); match(24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_stmtContext extends ParserRuleContext {
		public Id_listContext id_list;
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Write_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterWrite_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitWrite_stmt(this);
		}
	}

	public final Write_stmtContext write_stmt() throws RecognitionException {
		Write_stmtContext _localctx = new Write_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_write_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(18);
			setState(319); match(6);
			setState(320); ((Write_stmtContext)_localctx).id_list = id_list();
			ProcessReadWrite((((Write_stmtContext)_localctx).id_list!=null?_input.getText(((Write_stmtContext)_localctx).id_list.start,((Write_stmtContext)_localctx).id_list.stop):null),"WRITE");
			setState(322); match(19);
			setState(323); match(24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325); match(29);
			setState(326); ((Return_stmtContext)_localctx).expr = expr();
			setState(327); match(24);
			current_function.InsertReturn((((Return_stmtContext)_localctx).expr!=null?_input.getText(((Return_stmtContext)_localctx).expr.start,((Return_stmtContext)_localctx).expr.stop):null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AddopContext addop;
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public AddopContext addop(int i) {
			return getRuleContext(AddopContext.class,i);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public List<AddopContext> addop() {
			return getRuleContexts(AddopContext.class);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); factor();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==20) {
				{
				{
				setState(331); ((ExprContext)_localctx).addop = addop();
				setState(332); factor();
				if(current_element!=null){TypeTable.put(current_register,current_element.E_type); current_register++;String oldop = opstack.pop();CalcStep(opstack.pop(),(((ExprContext)_localctx).addop!=null?_input.getText(((ExprContext)_localctx).addop.start,((ExprContext)_localctx).addop.stop):null),oldop);oppfinished = 1;}
				}
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			CheckConstant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_tailContext extends ParserRuleContext {
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public AddopContext addop(int i) {
			return getRuleContext(AddopContext.class,i);
		}
		public List<AddopContext> addop() {
			return getRuleContexts(AddopContext.class);
		}
		public Expr_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_tail(this);
		}
	}

	public final Expr_tailContext expr_tail() throws RecognitionException {
		Expr_tailContext _localctx = new Expr_tailContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4 || _la==20) {
				{
				{
				setState(342); addop();
				setState(343); factor();
				}
				}
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public MulopContext mulop;
		public List<MulopContext> mulop() {
			return getRuleContexts(MulopContext.class);
		}
		public List<Postfix_exprContext> postfix_expr() {
			return getRuleContexts(Postfix_exprContext.class);
		}
		public Postfix_exprContext postfix_expr(int i) {
			return getRuleContext(Postfix_exprContext.class,i);
		}
		public MulopContext mulop(int i) {
			return getRuleContext(MulopContext.class,i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); postfix_expr();
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==30) {
				{
				{
				setState(351); ((FactorContext)_localctx).mulop = mulop();
				setState(352); postfix_expr();
				if(current_element!=null){TypeTable.put(current_register,current_element.E_type); current_register++;String opf = opstack.pop(); CalcInter(opstack.pop(),(((FactorContext)_localctx).mulop!=null?_input.getText(((FactorContext)_localctx).mulop.start,((FactorContext)_localctx).mulop.stop):null),opf);}
				}
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_exprContext extends ParserRuleContext {
		public PrimaryContext primary;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public Postfix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPostfix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPostfix_expr(this);
		}
	}

	public final Postfix_exprContext postfix_expr() throws RecognitionException {
		Postfix_exprContext _localctx = new Postfix_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_postfix_expr);
		try {
			setState(368);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360); ((Postfix_exprContext)_localctx).primary = primary();
				String op1 = (((Postfix_exprContext)_localctx).primary!=null?_input.getText(((Postfix_exprContext)_localctx).primary.start,((Postfix_exprContext)_localctx).primary.stop):null); opstack.push(op1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(363); call_expr();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(364); match(6);
				setState(365); expr();
				setState(366); match(19);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_exprContext extends ParserRuleContext {
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCall_expr(this);
		}
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_call_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); ((Call_exprContext)_localctx).id = id();
			AddOperation("PUSH","","","");
			setState(372); match(6);
			setState(374);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << INTLITERAL) | (1L << FLOATLITERAL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(373); expr_list();
				}
			}

			setState(376); match(19);
			if(oppfinished==1)opstack.pop();Functioncall((((Call_exprContext)_localctx).id!=null?_input.getText(((Call_exprContext)_localctx).id.start,((Call_exprContext)_localctx).id.stop):null));middlefunc=0;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_expr_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); expr();
			setState(380); expr_list_tail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_list_tailContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_list_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_list_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_list_tail(this);
		}
	}

	public final Expr_list_tailContext expr_list_tail() throws RecognitionException {
		Expr_list_tailContext _localctx = new Expr_list_tailContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_expr_list_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(382); match(1);
				AddOperation("PUSH",CString("T",current_register),"","");middlefunc=1;
				setState(384); expr();
				}
				}
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode FLOATLITERAL() { return getToken(MicroParser.FLOATLITERAL, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode INTLITERAL() { return getToken(MicroParser.INTLITERAL, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_primary);
		try {
			setState(393);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(390); id();
				}
				break;
			case INTLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(391); match(INTLITERAL);
				}
				break;
			case FLOATLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(392); match(FLOATLITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddopContext extends ParserRuleContext {
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAddop(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_la = _input.LA(1);
			if ( !(_la==4 || _la==20) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_la = _input.LA(1);
			if ( !(_la==3 || _la==30) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Cond1Context cond1() {
			return getRuleContext(Cond1Context.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Else_partContext else_part() {
			return getRuleContext(Else_partContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399); match(15);
			scope_name="BLOCK "+Integer.toString(current_count); current_count=current_count+1; current_scope = NewScope(scope_name);PutLabel();
			setState(401); match(6);
			setState(402); cond1();
			setState(403); match(19);
			setState(404); decl();
			setState(405); stmt_list();
			setState(406); else_part();
			setState(407); match(12);
			EndScope();AddENDIF();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_partContext extends ParserRuleContext {
		public Cond2Context cond2(int i) {
			return getRuleContext(Cond2Context.class,i);
		}
		public List<Stmt_listContext> stmt_list() {
			return getRuleContexts(Stmt_listContext.class);
		}
		public Else_partContext else_part(int i) {
			return getRuleContext(Else_partContext.class,i);
		}
		public List<Cond2Context> cond2() {
			return getRuleContexts(Cond2Context.class);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public Stmt_listContext stmt_list(int i) {
			return getRuleContext(Stmt_listContext.class,i);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<Else_partContext> else_part() {
			return getRuleContexts(Else_partContext.class);
		}
		public Else_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterElse_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitElse_part(this);
		}
	}

	public final Else_partContext else_part() throws RecognitionException {
		Else_partContext _localctx = new Else_partContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_else_part);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(410); match(22);
					scope_name="BLOCK "+Integer.toString(current_count); current_count=current_count+1; current_scope = NewScope(scope_name);PutLabelj();
					setState(412); match(6);
					setState(413); cond2();
					setState(414); match(19);
					setState(415); decl();
					setState(416); stmt_list();
					setState(417); else_part();
					EndScope();
					}
					} 
				}
				setState(424);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond1Context extends ParserRuleContext {
		public CompopContext compop;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Cond1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond1(this);
		}
	}

	public final Cond1Context cond1() throws RecognitionException {
		Cond1Context _localctx = new Cond1Context(_ctx, getState());
		enterRule(_localctx, 86, RULE_cond1);
		try {
			setState(435);
			switch (_input.LA(1)) {
			case 6:
			case INTLITERAL:
			case FLOATLITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(425); expr();
				Checkdone();
				setState(427); ((Cond1Context)_localctx).compop = compop();
				setState(428); expr();
				Checkdone();AddIF((((Cond1Context)_localctx).compop!=null?_input.getText(((Cond1Context)_localctx).compop.start,((Cond1Context)_localctx).compop.stop):null));
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(431); match(16);
				AddIF("TRUE");
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(433); match(17);
				AddIF("FALSE");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond2Context extends ParserRuleContext {
		public CompopContext compop;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Cond2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond2(this);
		}
	}

	public final Cond2Context cond2() throws RecognitionException {
		Cond2Context _localctx = new Cond2Context(_ctx, getState());
		enterRule(_localctx, 88, RULE_cond2);
		try {
			setState(447);
			switch (_input.LA(1)) {
			case 6:
			case INTLITERAL:
			case FLOATLITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(437); expr();
				Checkdone();
				setState(439); ((Cond2Context)_localctx).compop = compop();
				setState(440); expr();
				Checkdone();AddELSEIF((((Cond2Context)_localctx).compop!=null?_input.getText(((Cond2Context)_localctx).compop.start,((Cond2Context)_localctx).compop.stop):null));
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(443); match(16);
				AddELSEIF("TRUE");
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(445); match(17);
				AddELSEIF("FALSE");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond3Context extends ParserRuleContext {
		public CompopContext compop;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Cond3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond3(this);
		}
	}

	public final Cond3Context cond3() throws RecognitionException {
		Cond3Context _localctx = new Cond3Context(_ctx, getState());
		enterRule(_localctx, 90, RULE_cond3);
		try {
			setState(459);
			switch (_input.LA(1)) {
			case 6:
			case INTLITERAL:
			case FLOATLITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(449); expr();
				Checkdone();
				setState(451); ((Cond3Context)_localctx).compop = compop();
				setState(452); expr();
				Checkdone();Checkwhile((((Cond3Context)_localctx).compop!=null?_input.getText(((Cond3Context)_localctx).compop.start,((Cond3Context)_localctx).compop.stop):null));
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(455); match(16);
				Checkwhile("TRUE");
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(457); match(17);
				Checkwhile("FALSE");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_cond);
		try {
			setState(467);
			switch (_input.LA(1)) {
			case 6:
			case INTLITERAL:
			case FLOATLITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(461); expr();
				setState(462); compop();
				setState(463); expr();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 2);
				{
				setState(465); match(16);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(466); match(17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompopContext extends ParserRuleContext {
		public CompopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCompop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCompop(this);
		}
	}

	public final CompopContext compop() throws RecognitionException {
		CompopContext _localctx = new CompopContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_compop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 10) | (1L << 11) | (1L << 23) | (1L << 26) | (1L << 32))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_while_stmtContext extends ParserRuleContext {
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Cond3Context cond3() {
			return getRuleContext(Cond3Context.class,0);
		}
		public Do_while_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterDo_while_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitDo_while_stmt(this);
		}
	}

	public final Do_while_stmtContext do_while_stmt() throws RecognitionException {
		Do_while_stmtContext _localctx = new Do_while_stmtContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_do_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); match(2);
			scope_name="BLOCK "+Integer.toString(current_count); current_count=current_count+1; current_scope = NewScope(scope_name);AddDO();
			setState(473); decl();
			setState(474); stmt_list();
			setState(475); match(21);
			setState(476); match(6);
			setState(477); cond3();
			setState(478); match(19);
			EndScope();
			setState(480); match(24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3+\u01e5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\7\5t\n\5\f\5\16\5w\13\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u0080\n\6\r\6\16\6\u0081\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7\u008a\n\7\f\7\16\7\u008d\13\7\3\b\3\b\3\b\3\b\3\b\3\b\6\b"+
		"\u0095\n\b\r\b\16\b\u0096\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a2"+
		"\n\n\f\n\16\n\u00a5\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ae\n\n\f\n"+
		"\16\n\u00b1\13\n\5\n\u00b3\n\n\3\n\3\n\6\n\u00b7\n\n\r\n\16\n\u00b8\3"+
		"\13\3\13\3\13\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13\3\13\3\13\3"+
		"\13\3\13\7\13\u00c8\n\13\f\13\16\13\u00cb\13\13\3\13\3\13\5\13\u00cf\n"+
		"\13\3\f\3\f\3\r\3\r\5\r\u00d5\n\r\3\16\3\16\3\16\3\17\3\17\7\17\u00dc"+
		"\n\17\f\17\16\17\u00df\13\17\3\20\3\20\3\20\3\20\6\20\u00e5\n\20\r\20"+
		"\16\20\u00e6\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u00f4\n\22\3\23\3\23\7\23\u00f8\n\23\f\23\16\23\u00fb\13\23\3\24\7"+
		"\24\u00fe\n\24\f\24\16\24\u0101\13\24\3\25\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u0109\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\7\26\u0112\n\26\f\26"+
		"\16\26\u0115\13\26\3\27\3\27\3\27\3\30\7\30\u011b\n\30\f\30\16\30\u011e"+
		"\13\30\3\31\7\31\u0121\n\31\f\31\16\31\u0124\13\31\3\32\3\32\3\32\5\32"+
		"\u0129\n\32\3\33\3\33\3\33\3\33\5\33\u012f\n\33\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\7!\u0152\n!\f!\16"+
		"!\u0155\13!\3!\3!\3\"\3\"\3\"\7\"\u015c\n\"\f\"\16\"\u015f\13\"\3#\3#"+
		"\3#\3#\3#\7#\u0166\n#\f#\16#\u0169\13#\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0173"+
		"\n$\3%\3%\3%\3%\5%\u0179\n%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\7\'\u0184\n"+
		"\'\f\'\16\'\u0187\13\'\3(\3(\3(\5(\u018c\n(\3)\3)\3*\3*\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u01a7\n,\f,\16,\u01aa"+
		"\13,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01b6\n-\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\5.\u01c2\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u01ce\n/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\5\60\u01d6\n\60\3\61\3\61\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\2\63\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`b\2\6\4\2\35\35##"+
		"\4\2\6\6\26\26\4\2\5\5  \7\2\n\n\f\r\31\31\34\34\"\"\u01e1\2d\3\2\2\2"+
		"\4l\3\2\2\2\6n\3\2\2\2\bu\3\2\2\2\n\177\3\2\2\2\f\u008b\3\2\2\2\16\u0094"+
		"\3\2\2\2\20\u0098\3\2\2\2\22\u00b6\3\2\2\2\24\u00ce\3\2\2\2\26\u00d0\3"+
		"\2\2\2\30\u00d4\3\2\2\2\32\u00d6\3\2\2\2\34\u00dd\3\2\2\2\36\u00e4\3\2"+
		"\2\2 \u00e8\3\2\2\2\"\u00f3\3\2\2\2$\u00f9\3\2\2\2&\u00ff\3\2\2\2(\u0102"+
		"\3\2\2\2*\u0113\3\2\2\2,\u0116\3\2\2\2.\u011c\3\2\2\2\60\u0122\3\2\2\2"+
		"\62\u0128\3\2\2\2\64\u012e\3\2\2\2\66\u0130\3\2\2\28\u0133\3\2\2\2:\u0139"+
		"\3\2\2\2<\u0140\3\2\2\2>\u0147\3\2\2\2@\u014c\3\2\2\2B\u015d\3\2\2\2D"+
		"\u0160\3\2\2\2F\u0172\3\2\2\2H\u0174\3\2\2\2J\u017d\3\2\2\2L\u0185\3\2"+
		"\2\2N\u018b\3\2\2\2P\u018d\3\2\2\2R\u018f\3\2\2\2T\u0191\3\2\2\2V\u01a8"+
		"\3\2\2\2X\u01b5\3\2\2\2Z\u01c1\3\2\2\2\\\u01cd\3\2\2\2^\u01d5\3\2\2\2"+
		"`\u01d7\3\2\2\2b\u01d9\3\2\2\2de\7\7\2\2ef\b\2\1\2fg\5\4\3\2gh\7!\2\2"+
		"hi\5\6\4\2ij\7\13\2\2jk\b\2\1\2k\3\3\2\2\2lm\7)\2\2m\5\3\2\2\2no\5\b\5"+
		"\2op\5&\24\2p\7\3\2\2\2qt\5\n\6\2rt\5\22\n\2sq\3\2\2\2sr\3\2\2\2tw\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2v\t\3\2\2\2wu\3\2\2\2xy\7\20\2\2yz\5\4\3\2z{\7"+
		"\36\2\2{|\5\20\t\2|}\b\6\1\2}~\7\32\2\2~\u0080\3\2\2\2\177x\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\13\3\2\2\2"+
		"\u0083\u0084\7\20\2\2\u0084\u0085\5\4\3\2\u0085\u0086\7\36\2\2\u0086\u0087"+
		"\5\20\t\2\u0087\u0088\7\32\2\2\u0088\u008a\3\2\2\2\u0089\u0083\3\2\2\2"+
		"\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\r\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7\20\2\2\u008f\u0090\5\4\3\2\u0090"+
		"\u0091\7\36\2\2\u0091\u0092\5\20\t\2\u0092\u0093\7\32\2\2\u0093\u0095"+
		"\3\2\2\2\u0094\u008e\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\17\3\2\2\2\u0098\u0099\7\'\2\2\u0099\21\3\2\2\2\u009a"+
		"\u009b\7\35\2\2\u009b\u009c\5\4\3\2\u009c\u00a3\b\n\1\2\u009d\u009e\7"+
		"\3\2\2\u009e\u009f\5\4\3\2\u009f\u00a0\b\n\1\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009d\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00b3\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7"+
		"\u00a8\5\4\3\2\u00a8\u00af\b\n\1\2\u00a9\u00aa\7\3\2\2\u00aa\u00ab\5\4"+
		"\3\2\u00ab\u00ac\b\n\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b2\u009a\3\2\2\2\u00b2\u00a6\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\7\32\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\23\3\2\2\2\u00ba\u00bb\7\35\2\2\u00bb\u00c0\5\4\3\2\u00bc\u00bd\7\3\2"+
		"\2\u00bd\u00bf\5\4\3\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00cf\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c4\7#\2\2\u00c4\u00c9\5\4\3\2\u00c5\u00c6\7\3\2\2\u00c6\u00c8\5\4"+
		"\3\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\32"+
		"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00ba\3\2\2\2\u00ce\u00c3\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\25\3\2\2\2\u00d0\u00d1\t\2\2\2\u00d1\27\3\2\2\2\u00d2"+
		"\u00d5\5\26\f\2\u00d3\u00d5\7\17\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3"+
		"\2\2\2\u00d5\31\3\2\2\2\u00d6\u00d7\5\4\3\2\u00d7\u00d8\5\34\17\2\u00d8"+
		"\33\3\2\2\2\u00d9\u00da\7\3\2\2\u00da\u00dc\5\4\3\2\u00db\u00d9\3\2\2"+
		"\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\35"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\5\26\f\2\u00e1\u00e2\5\32\16"+
		"\2\u00e2\u00e3\7\32\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\37\3\2\2"+
		"\2\u00e8\u00e9\5\"\22\2\u00e9\u00ea\5$\23\2\u00ea!\3\2\2\2\u00eb\u00ec"+
		"\7\35\2\2\u00ec\u00ed\5\4\3\2\u00ed\u00ee\b\22\1\2\u00ee\u00f4\3\2\2\2"+
		"\u00ef\u00f0\7#\2\2\u00f0\u00f1\5\4\3\2\u00f1\u00f2\b\22\1\2\u00f2\u00f4"+
		"\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4#\3\2\2\2\u00f5"+
		"\u00f6\7\3\2\2\u00f6\u00f8\5\"\22\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3"+
		"\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa%\3\2\2\2\u00fb\u00f9"+
		"\3\2\2\2\u00fc\u00fe\5(\25\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\'\3\2\2\2\u0101\u00ff\3\2\2\2"+
		"\u0102\u0103\7\33\2\2\u0103\u0104\5\30\r\2\u0104\u0105\5\4\3\2\u0105\u0106"+
		"\b\25\1\2\u0106\u0108\7\b\2\2\u0107\u0109\5 \21\2\u0108\u0107\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\25\2\2\u010b\u010c"+
		"\7!\2\2\u010c\u010d\5,\27\2\u010d\u010e\7\13\2\2\u010e\u010f\b\25\1\2"+
		"\u010f)\3\2\2\2\u0110\u0112\5(\25\2\u0111\u0110\3\2\2\2\u0112\u0115\3"+
		"\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114+\3\2\2\2\u0115\u0113"+
		"\3\2\2\2\u0116\u0117\5\b\5\2\u0117\u0118\5.\30\2\u0118-\3\2\2\2\u0119"+
		"\u011b\5\62\32\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3"+
		"\2\2\2\u011c\u011d\3\2\2\2\u011d/\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0121"+
		"\5\62\32\2\u0120\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\61\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0129"+
		"\5\64\33\2\u0126\u0129\5T+\2\u0127\u0129\5b\62\2\u0128\u0125\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\63\3\2\2\2\u012a\u012f\5\66\34"+
		"\2\u012b\u012f\5:\36\2\u012c\u012f\5<\37\2\u012d\u012f\5> \2\u012e\u012a"+
		"\3\2\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\65\3\2\2\2\u0130\u0131\58\35\2\u0131\u0132\7\32\2\2\u0132\67\3\2\2\2"+
		"\u0133\u0134\5\4\3\2\u0134\u0135\b\35\1\2\u0135\u0136\7\36\2\2\u0136\u0137"+
		"\5@!\2\u0137\u0138\b\35\1\2\u01389\3\2\2\2\u0139\u013a\7\t\2\2\u013a\u013b"+
		"\7\b\2\2\u013b\u013c\5\32\16\2\u013c\u013d\b\36\1\2\u013d\u013e\7\25\2"+
		"\2\u013e\u013f\7\32\2\2\u013f;\3\2\2\2\u0140\u0141\7\24\2\2\u0141\u0142"+
		"\7\b\2\2\u0142\u0143\5\32\16\2\u0143\u0144\b\37\1\2\u0144\u0145\7\25\2"+
		"\2\u0145\u0146\7\32\2\2\u0146=\3\2\2\2\u0147\u0148\7\37\2\2\u0148\u0149"+
		"\5@!\2\u0149\u014a\7\32\2\2\u014a\u014b\b \1\2\u014b?\3\2\2\2\u014c\u0153"+
		"\5D#\2\u014d\u014e\5P)\2\u014e\u014f\5D#\2\u014f\u0150\b!\1\2\u0150\u0152"+
		"\3\2\2\2\u0151\u014d\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\b!"+
		"\1\2\u0157A\3\2\2\2\u0158\u0159\5P)\2\u0159\u015a\5D#\2\u015a\u015c\3"+
		"\2\2\2\u015b\u0158\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015eC\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0167\5F$\2\u0161"+
		"\u0162\5R*\2\u0162\u0163\5F$\2\u0163\u0164\b#\1\2\u0164\u0166\3\2\2\2"+
		"\u0165\u0161\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168E\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\5N(\2\u016b\u016c"+
		"\b$\1\2\u016c\u0173\3\2\2\2\u016d\u0173\5H%\2\u016e\u016f\7\b\2\2\u016f"+
		"\u0170\5@!\2\u0170\u0171\7\25\2\2\u0171\u0173\3\2\2\2\u0172\u016a\3\2"+
		"\2\2\u0172\u016d\3\2\2\2\u0172\u016e\3\2\2\2\u0173G\3\2\2\2\u0174\u0175"+
		"\5\4\3\2\u0175\u0176\b%\1\2\u0176\u0178\7\b\2\2\u0177\u0179\5J&\2\u0178"+
		"\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\7\25"+
		"\2\2\u017b\u017c\b%\1\2\u017cI\3\2\2\2\u017d\u017e\5@!\2\u017e\u017f\5"+
		"L\'\2\u017fK\3\2\2\2\u0180\u0181\7\3\2\2\u0181\u0182\b\'\1\2\u0182\u0184"+
		"\5@!\2\u0183\u0180\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186M\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u018c\5\4\3\2"+
		"\u0189\u018c\7%\2\2\u018a\u018c\7&\2\2\u018b\u0188\3\2\2\2\u018b\u0189"+
		"\3\2\2\2\u018b\u018a\3\2\2\2\u018cO\3\2\2\2\u018d\u018e\t\3\2\2\u018e"+
		"Q\3\2\2\2\u018f\u0190\t\4\2\2\u0190S\3\2\2\2\u0191\u0192\7\21\2\2\u0192"+
		"\u0193\b+\1\2\u0193\u0194\7\b\2\2\u0194\u0195\5X-\2\u0195\u0196\7\25\2"+
		"\2\u0196\u0197\5\b\5\2\u0197\u0198\5.\30\2\u0198\u0199\5V,\2\u0199\u019a"+
		"\7\16\2\2\u019a\u019b\b+\1\2\u019bU\3\2\2\2\u019c\u019d\7\30\2\2\u019d"+
		"\u019e\b,\1\2\u019e\u019f\7\b\2\2\u019f\u01a0\5Z.\2\u01a0\u01a1\7\25\2"+
		"\2\u01a1\u01a2\5\b\5\2\u01a2\u01a3\5.\30\2\u01a3\u01a4\5V,\2\u01a4\u01a5"+
		"\b,\1\2\u01a5\u01a7\3\2\2\2\u01a6\u019c\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8"+
		"\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9W\3\2\2\2\u01aa\u01a8\3\2\2\2"+
		"\u01ab\u01ac\5@!\2\u01ac\u01ad\b-\1\2\u01ad\u01ae\5`\61\2\u01ae\u01af"+
		"\5@!\2\u01af\u01b0\b-\1\2\u01b0\u01b6\3\2\2\2\u01b1\u01b2\7\22\2\2\u01b2"+
		"\u01b6\b-\1\2\u01b3\u01b4\7\23\2\2\u01b4\u01b6\b-\1\2\u01b5\u01ab\3\2"+
		"\2\2\u01b5\u01b1\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6Y\3\2\2\2\u01b7\u01b8"+
		"\5@!\2\u01b8\u01b9\b.\1\2\u01b9\u01ba\5`\61\2\u01ba\u01bb\5@!\2\u01bb"+
		"\u01bc\b.\1\2\u01bc\u01c2\3\2\2\2\u01bd\u01be\7\22\2\2\u01be\u01c2\b."+
		"\1\2\u01bf\u01c0\7\23\2\2\u01c0\u01c2\b.\1\2\u01c1\u01b7\3\2\2\2\u01c1"+
		"\u01bd\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2[\3\2\2\2\u01c3\u01c4\5@!\2\u01c4"+
		"\u01c5\b/\1\2\u01c5\u01c6\5`\61\2\u01c6\u01c7\5@!\2\u01c7\u01c8\b/\1\2"+
		"\u01c8\u01ce\3\2\2\2\u01c9\u01ca\7\22\2\2\u01ca\u01ce\b/\1\2\u01cb\u01cc"+
		"\7\23\2\2\u01cc\u01ce\b/\1\2\u01cd\u01c3\3\2\2\2\u01cd\u01c9\3\2\2\2\u01cd"+
		"\u01cb\3\2\2\2\u01ce]\3\2\2\2\u01cf\u01d0\5@!\2\u01d0\u01d1\5`\61\2\u01d1"+
		"\u01d2\5@!\2\u01d2\u01d6\3\2\2\2\u01d3\u01d6\7\22\2\2\u01d4\u01d6\7\23"+
		"\2\2\u01d5\u01cf\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6"+
		"_\3\2\2\2\u01d7\u01d8\t\5\2\2\u01d8a\3\2\2\2\u01d9\u01da\7\4\2\2\u01da"+
		"\u01db\b\62\1\2\u01db\u01dc\5\b\5\2\u01dc\u01dd\5.\30\2\u01dd\u01de\7"+
		"\27\2\2\u01de\u01df\7\b\2\2\u01df\u01e0\5\\/\2\u01e0\u01e1\7\25\2\2\u01e1"+
		"\u01e2\b\62\1\2\u01e2\u01e3\7\32\2\2\u01e3c\3\2\2\2&su\u0081\u008b\u0096"+
		"\u00a3\u00af\u00b2\u00b8\u00c0\u00c9\u00ce\u00d4\u00dd\u00e6\u00f3\u00f9"+
		"\u00ff\u0108\u0113\u011c\u0122\u0128\u012e\u0153\u015d\u0167\u0172\u0178"+
		"\u0185\u018b\u01a8\u01b5\u01c1\u01cd\u01d5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}