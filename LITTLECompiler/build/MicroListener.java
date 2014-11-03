// Generated from Micro.g4 by ANTLR 4.1

	import java.io.*;
	import java.util.*;
	import java.lang.*;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MicroParser}.
 */
public interface MicroListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MicroParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(@NotNull MicroParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(@NotNull MicroParser.Stmt_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(@NotNull MicroParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(@NotNull MicroParser.Assign_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(@NotNull MicroParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(@NotNull MicroParser.Read_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(@NotNull MicroParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(@NotNull MicroParser.Call_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(@NotNull MicroParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(@NotNull MicroParser.AddopContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull MicroParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull MicroParser.PrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(@NotNull MicroParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(@NotNull MicroParser.Else_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#string_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterString_decl_list(@NotNull MicroParser.String_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#string_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitString_decl_list(@NotNull MicroParser.String_decl_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(@NotNull MicroParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(@NotNull MicroParser.Pgm_bodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(@NotNull MicroParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(@NotNull MicroParser.Postfix_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#do_while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDo_while_stmt(@NotNull MicroParser.Do_while_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#do_while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDo_while_stmt(@NotNull MicroParser.Do_while_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(@NotNull MicroParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(@NotNull MicroParser.Var_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(@NotNull MicroParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(@NotNull MicroParser.Id_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#var_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_list(@NotNull MicroParser.Var_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#var_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_list(@NotNull MicroParser.Var_decl_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(@NotNull MicroParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(@NotNull MicroParser.Assign_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(@NotNull MicroParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(@NotNull MicroParser.Func_declarationsContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#func_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl_tail(@NotNull MicroParser.Func_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#func_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl_tail(@NotNull MicroParser.Func_decl_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(@NotNull MicroParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(@NotNull MicroParser.Func_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull MicroParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull MicroParser.StrContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(@NotNull MicroParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(@NotNull MicroParser.Param_decl_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull MicroParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull MicroParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(@NotNull MicroParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(@NotNull MicroParser.Return_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#stmt_tail}.
	 * @param ctx the parse tree
	 */
	void enterStmt_tail(@NotNull MicroParser.Stmt_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#stmt_tail}.
	 * @param ctx the parse tree
	 */
	void exitStmt_tail(@NotNull MicroParser.Stmt_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(@NotNull MicroParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(@NotNull MicroParser.Param_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(@NotNull MicroParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(@NotNull MicroParser.Expr_list_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(@NotNull MicroParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(@NotNull MicroParser.MulopContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(@NotNull MicroParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(@NotNull MicroParser.Func_bodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull MicroParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull MicroParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(@NotNull MicroParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(@NotNull MicroParser.Any_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(@NotNull MicroParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(@NotNull MicroParser.CondContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#cond1}.
	 * @param ctx the parse tree
	 */
	void enterCond1(@NotNull MicroParser.Cond1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#cond1}.
	 * @param ctx the parse tree
	 */
	void exitCond1(@NotNull MicroParser.Cond1Context ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull MicroParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull MicroParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#cond2}.
	 * @param ctx the parse tree
	 */
	void enterCond2(@NotNull MicroParser.Cond2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#cond2}.
	 * @param ctx the parse tree
	 */
	void exitCond2(@NotNull MicroParser.Cond2Context ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#cond3}.
	 * @param ctx the parse tree
	 */
	void enterCond3(@NotNull MicroParser.Cond3Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#cond3}.
	 * @param ctx the parse tree
	 */
	void exitCond3(@NotNull MicroParser.Cond3Context ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(@NotNull MicroParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(@NotNull MicroParser.Var_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(@NotNull MicroParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(@NotNull MicroParser.Base_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull MicroParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull MicroParser.DeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#string_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterString_decl_tail(@NotNull MicroParser.String_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#string_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitString_decl_tail(@NotNull MicroParser.String_decl_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(@NotNull MicroParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(@NotNull MicroParser.String_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(@NotNull MicroParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(@NotNull MicroParser.Id_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull MicroParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull MicroParser.StmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull MicroParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull MicroParser.FactorContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(@NotNull MicroParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(@NotNull MicroParser.CompopContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(@NotNull MicroParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(@NotNull MicroParser.Param_decl_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(@NotNull MicroParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(@NotNull MicroParser.Write_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#var_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_tail(@NotNull MicroParser.Var_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#var_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_tail(@NotNull MicroParser.Var_decl_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#expr_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_tail(@NotNull MicroParser.Expr_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expr_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_tail(@NotNull MicroParser.Expr_tailContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(@NotNull MicroParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(@NotNull MicroParser.If_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link MicroParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(@NotNull MicroParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(@NotNull MicroParser.Expr_listContext ctx);
}