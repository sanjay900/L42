// Generated from L42.g4 by ANTLR 4.7.2
package is.L42.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link L42Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface L42Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link L42Parser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(L42Parser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#m}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM(L42Parser.MContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(L42Parser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(L42Parser.DocContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#csP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCsP(L42Parser.CsPContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(L42Parser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#tLocal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTLocal(L42Parser.TLocalContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#eAtomic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEAtomic(L42Parser.EAtomicContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#voidE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidE(L42Parser.VoidEContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(L42Parser.EContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#fCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFCall(L42Parser.FCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#oR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(L42Parser.ORContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(L42Parser.ParContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(L42Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#d}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitD(L42Parser.DContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#dX}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDX(L42Parser.DXContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#k}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitK(L42Parser.KContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#whoops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhoops(L42Parser.WhoopsContext ctx);
	/**
	 * Visit a parse tree produced by {@link L42Parser#nudeE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNudeE(L42Parser.NudeEContext ctx);
}