// Generated from .\src\TheLang.g by ANTLR 4.5.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TheLangParser}.
 */
public interface TheLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TheLangParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(TheLangParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(TheLangParser.AexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#aexpr1}.
	 * @param ctx the parse tree
	 */
	void enterAexpr1(TheLangParser.Aexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#aexpr1}.
	 * @param ctx the parse tree
	 */
	void exitAexpr1(TheLangParser.Aexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#aexpr2}.
	 * @param ctx the parse tree
	 */
	void enterAexpr2(TheLangParser.Aexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#aexpr2}.
	 * @param ctx the parse tree
	 */
	void exitAexpr2(TheLangParser.Aexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#aexpr3}.
	 * @param ctx the parse tree
	 */
	void enterAexpr3(TheLangParser.Aexpr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#aexpr3}.
	 * @param ctx the parse tree
	 */
	void exitAexpr3(TheLangParser.Aexpr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterBexpr(TheLangParser.BexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitBexpr(TheLangParser.BexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#bexpr1}.
	 * @param ctx the parse tree
	 */
	void enterBexpr1(TheLangParser.Bexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#bexpr1}.
	 * @param ctx the parse tree
	 */
	void exitBexpr1(TheLangParser.Bexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#bexpr2}.
	 * @param ctx the parse tree
	 */
	void enterBexpr2(TheLangParser.Bexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#bexpr2}.
	 * @param ctx the parse tree
	 */
	void exitBexpr2(TheLangParser.Bexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOpr(TheLangParser.OprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOpr(TheLangParser.OprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(TheLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(TheLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#level}.
	 * @param ctx the parse tree
	 */
	void enterLevel(TheLangParser.LevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#level}.
	 * @param ctx the parse tree
	 */
	void exitLevel(TheLangParser.LevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(TheLangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(TheLangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(TheLangParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(TheLangParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#skipStmt}.
	 * @param ctx the parse tree
	 */
	void enterSkipStmt(TheLangParser.SkipStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#skipStmt}.
	 * @param ctx the parse tree
	 */
	void exitSkipStmt(TheLangParser.SkipStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(TheLangParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(TheLangParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(TheLangParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(TheLangParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TheLangParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TheLangParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(TheLangParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(TheLangParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TheLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TheLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TheLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TheLangParser.ProgramContext ctx);
}