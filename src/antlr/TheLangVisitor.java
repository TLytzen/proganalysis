// Generated from .\src\TheLang.g by ANTLR 4.5.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TheLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TheLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TheLangParser#aexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr(TheLangParser.AexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#aexpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr1(TheLangParser.Aexpr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#aexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr2(TheLangParser.Aexpr2Context ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#aexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr3(TheLangParser.Aexpr3Context ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpr(TheLangParser.BexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#bexpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpr1(TheLangParser.Bexpr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#bexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpr2(TheLangParser.Bexpr2Context ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#opr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpr(TheLangParser.OprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(TheLangParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel(TheLangParser.LevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(TheLangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(TheLangParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#skipStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStmt(TheLangParser.SkipStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#readStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(TheLangParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#writeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(TheLangParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(TheLangParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(TheLangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TheLangParser.ProgramContext ctx);
}