// Generated from L42.g4 by ANTLR 4.7.2
package is.L42.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class L42Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, CastOp=8, Uop=9, 
		OP0=10, OP1=11, OP2=12, OP3=13, OpUpdate=14, Mdf=15, VoidKW=16, VarKw=17, 
		Info=18, CatchKw=19, InterfaceKw=20, IfKw=21, ElseKw=22, WhileKw=23, ForKw=24, 
		InKw=25, LoopKw=26, Throw=27, WhoopsKw=28, MethodKw=29, DotDotDot=30, 
		Slash=31, PathSel=32, ReuseURL=33, NativeURL=34, StringSingle=35, Number=36, 
		MUniqueNum=37, MHash=38, X=39, SlashX=40, CsP=41, ClassSep=42, UnderScore=43, 
		OR=44, ORNS=45, Doc=46, BlockComment=47, LineComment=48, Whitespace=49;
	public static final int
		RULE_slash = 0, RULE_pathSel = 1, RULE_string = 2, RULE_x = 3, RULE_slashX = 4, 
		RULE_m = 5, RULE_doc = 6, RULE_csP = 7, RULE_t = 8, RULE_tLocal = 9, RULE_eAtomic = 10, 
		RULE_fullL = 11, RULE_fullM = 12, RULE_fullF = 13, RULE_fullMi = 14, RULE_fullMWT = 15, 
		RULE_fullNC = 16, RULE_header = 17, RULE_info = 18, RULE_fullMH = 19, 
		RULE_mOp = 20, RULE_voidE = 21, RULE_ePostfix = 22, RULE_fCall = 23, RULE_squareCall = 24, 
		RULE_cast = 25, RULE_oR = 26, RULE_par = 27, RULE_block = 28, RULE_d = 29, 
		RULE_dX = 30, RULE_k = 31, RULE_whoops = 32, RULE_eBinary0 = 33, RULE_eBinary1 = 34, 
		RULE_eBinary2 = 35, RULE_eBinary3 = 36, RULE_sIf = 37, RULE_match = 38, 
		RULE_sWhile = 39, RULE_sFor = 40, RULE_sLoop = 41, RULE_sThrow = 42, RULE_sUpdate = 43, 
		RULE_e = 44, RULE_nudeE = 45, RULE_nudeP = 46, RULE_nudeCsP = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"slash", "pathSel", "string", "x", "slashX", "m", "doc", "csP", "t", 
			"tLocal", "eAtomic", "fullL", "fullM", "fullF", "fullMi", "fullMWT", 
			"fullNC", "header", "info", "fullMH", "mOp", "voidE", "ePostfix", "fCall", 
			"squareCall", "cast", "oR", "par", "block", "d", "dX", "k", "whoops", 
			"eBinary0", "eBinary1", "eBinary2", "eBinary3", "sIf", "match", "sWhile", 
			"sFor", "sLoop", "sThrow", "sUpdate", "e", "nudeE", "nudeP", "nudeCsP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "')'", "'='", "'['", "']'", "';'", "'<:'", null, 
			null, null, null, null, null, null, "'void'", "'var'", null, "'catch'", 
			"'interface'", "'if'", "'else'", "'while'", "'for'", "'in'", "'loop'", 
			null, "'whoops'", "'method'", "'...'", "'\\'", null, null, null, null, 
			null, null, null, null, null, null, "'.'", "'_'", null, "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "CastOp", "Uop", "OP0", 
			"OP1", "OP2", "OP3", "OpUpdate", "Mdf", "VoidKW", "VarKw", "Info", "CatchKw", 
			"InterfaceKw", "IfKw", "ElseKw", "WhileKw", "ForKw", "InKw", "LoopKw", 
			"Throw", "WhoopsKw", "MethodKw", "DotDotDot", "Slash", "PathSel", "ReuseURL", 
			"NativeURL", "StringSingle", "Number", "MUniqueNum", "MHash", "X", "SlashX", 
			"CsP", "ClassSep", "UnderScore", "OR", "ORNS", "Doc", "BlockComment", 
			"LineComment", "Whitespace"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "L42.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public L42Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SlashContext extends ParserRuleContext {
		public TerminalNode Slash() { return getToken(L42Parser.Slash, 0); }
		public SlashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlashContext slash() throws RecognitionException {
		SlashContext _localctx = new SlashContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_slash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(Slash);
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

	public static class PathSelContext extends ParserRuleContext {
		public TerminalNode PathSel() { return getToken(L42Parser.PathSel, 0); }
		public PathSelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathSel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterPathSel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitPathSel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitPathSel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathSelContext pathSel() throws RecognitionException {
		PathSelContext _localctx = new PathSelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pathSel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(PathSel);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode StringSingle() { return getToken(L42Parser.StringSingle, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(StringSingle);
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

	public static class XContext extends ParserRuleContext {
		public TerminalNode X() { return getToken(L42Parser.X, 0); }
		public XContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitX(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XContext x() throws RecognitionException {
		XContext _localctx = new XContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(X);
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

	public static class SlashXContext extends ParserRuleContext {
		public TerminalNode SlashX() { return getToken(L42Parser.SlashX, 0); }
		public SlashXContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slashX; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSlashX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSlashX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSlashX(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlashXContext slashX() throws RecognitionException {
		SlashXContext _localctx = new SlashXContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_slashX);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(SlashX);
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

	public static class MContext extends ParserRuleContext {
		public TerminalNode MUniqueNum() { return getToken(L42Parser.MUniqueNum, 0); }
		public TerminalNode MHash() { return getToken(L42Parser.MHash, 0); }
		public TerminalNode X() { return getToken(L42Parser.X, 0); }
		public TerminalNode VoidKW() { return getToken(L42Parser.VoidKW, 0); }
		public TerminalNode VarKw() { return getToken(L42Parser.VarKw, 0); }
		public TerminalNode CatchKw() { return getToken(L42Parser.CatchKw, 0); }
		public TerminalNode InterfaceKw() { return getToken(L42Parser.InterfaceKw, 0); }
		public TerminalNode IfKw() { return getToken(L42Parser.IfKw, 0); }
		public TerminalNode ElseKw() { return getToken(L42Parser.ElseKw, 0); }
		public TerminalNode WhileKw() { return getToken(L42Parser.WhileKw, 0); }
		public TerminalNode ForKw() { return getToken(L42Parser.ForKw, 0); }
		public TerminalNode InKw() { return getToken(L42Parser.InKw, 0); }
		public TerminalNode LoopKw() { return getToken(L42Parser.LoopKw, 0); }
		public TerminalNode Throw() { return getToken(L42Parser.Throw, 0); }
		public TerminalNode WhoopsKw() { return getToken(L42Parser.WhoopsKw, 0); }
		public TerminalNode MethodKw() { return getToken(L42Parser.MethodKw, 0); }
		public TerminalNode Mdf() { return getToken(L42Parser.Mdf, 0); }
		public MContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitM(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MContext m() throws RecognitionException {
		MContext _localctx = new MContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_m);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << VoidKW) | (1L << VarKw) | (1L << CatchKw) | (1L << InterfaceKw) | (1L << IfKw) | (1L << ElseKw) | (1L << WhileKw) | (1L << ForKw) | (1L << InKw) | (1L << LoopKw) | (1L << Throw) | (1L << WhoopsKw) | (1L << MethodKw) | (1L << MUniqueNum) | (1L << MHash) | (1L << X))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class DocContext extends ParserRuleContext {
		public TerminalNode Doc() { return getToken(L42Parser.Doc, 0); }
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitDoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_doc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(Doc);
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

	public static class CsPContext extends ParserRuleContext {
		public TerminalNode CsP() { return getToken(L42Parser.CsP, 0); }
		public CsPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterCsP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitCsP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitCsP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsPContext csP() throws RecognitionException {
		CsPContext _localctx = new CsPContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_csP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(CsP);
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

	public static class TContext extends ParserRuleContext {
		public CsPContext csP() {
			return getRuleContext(CsPContext.class,0);
		}
		public TerminalNode Mdf() { return getToken(L42Parser.Mdf, 0); }
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_t);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Mdf) {
				{
				setState(112);
				match(Mdf);
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Doc) {
				{
				{
				setState(115);
				doc();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			csP();
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

	public static class TLocalContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public TerminalNode Mdf() { return getToken(L42Parser.Mdf, 0); }
		public TLocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tLocal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterTLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitTLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitTLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TLocalContext tLocal() throws RecognitionException {
		TLocalContext _localctx = new TLocalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tLocal);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				t();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(Mdf);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class EAtomicContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public CsPContext csP() {
			return getRuleContext(CsPContext.class,0);
		}
		public VoidEContext voidE() {
			return getRuleContext(VoidEContext.class,0);
		}
		public FullLContext fullL() {
			return getRuleContext(FullLContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SlashContext slash() {
			return getRuleContext(SlashContext.class,0);
		}
		public PathSelContext pathSel() {
			return getRuleContext(PathSelContext.class,0);
		}
		public SlashXContext slashX() {
			return getRuleContext(SlashXContext.class,0);
		}
		public EAtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eAtomic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterEAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitEAtomic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitEAtomic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EAtomicContext eAtomic() throws RecognitionException {
		EAtomicContext _localctx = new EAtomicContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eAtomic);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				x();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				csP();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				voidE();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				fullL();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				slash();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				pathSel();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				slashX();
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

	public static class FullLContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode DotDotDot() { return getToken(L42Parser.DotDotDot, 0); }
		public TerminalNode ReuseURL() { return getToken(L42Parser.ReuseURL, 0); }
		public List<FullMContext> fullM() {
			return getRuleContexts(FullMContext.class);
		}
		public FullMContext fullM(int i) {
			return getRuleContext(FullMContext.class,i);
		}
		public InfoContext info() {
			return getRuleContext(InfoContext.class,0);
		}
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public FullLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullLContext fullL() throws RecognitionException {
		FullLContext _localctx = new FullLContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fullL);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__0);
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__4:
			case Mdf:
			case VarKw:
			case Info:
			case InterfaceKw:
			case MethodKw:
			case CsP:
			case Doc:
				{
				setState(139);
				header();
				}
				break;
			case DotDotDot:
				{
				setState(140);
				match(DotDotDot);
				}
				break;
			case ReuseURL:
				{
				setState(141);
				match(ReuseURL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					fullM();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Info) {
				{
				setState(150);
				info();
				}
			}

			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Doc) {
				{
				{
				setState(153);
				doc();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(T__1);
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

	public static class FullMContext extends ParserRuleContext {
		public FullFContext fullF() {
			return getRuleContext(FullFContext.class,0);
		}
		public FullMiContext fullMi() {
			return getRuleContext(FullMiContext.class,0);
		}
		public FullMWTContext fullMWT() {
			return getRuleContext(FullMWTContext.class,0);
		}
		public FullNCContext fullNC() {
			return getRuleContext(FullNCContext.class,0);
		}
		public FullMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullM(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullMContext fullM() throws RecognitionException {
		FullMContext _localctx = new FullMContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fullM);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				fullF();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				fullMi();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				fullMWT();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				fullNC();
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

	public static class FullFContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public TerminalNode VarKw() { return getToken(L42Parser.VarKw, 0); }
		public FullFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullFContext fullF() throws RecognitionException {
		FullFContext _localctx = new FullFContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fullF);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					doc();
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VarKw) {
				{
				setState(173);
				match(VarKw);
				}
			}

			setState(176);
			t();
			setState(177);
			x();
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

	public static class FullMiContext extends ParserRuleContext {
		public TerminalNode MethodKw() { return getToken(L42Parser.MethodKw, 0); }
		public MOpContext mOp() {
			return getRuleContext(MOpContext.class,0);
		}
		public ORContext oR() {
			return getRuleContext(ORContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public FullMiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullMi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullMi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullMi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullMi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullMiContext fullMi() throws RecognitionException {
		FullMiContext _localctx = new FullMiContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fullMi);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Doc) {
				{
				{
				setState(179);
				doc();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(MethodKw);
			setState(186);
			mOp();
			setState(187);
			oR();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==X) {
				{
				{
				setState(188);
				x();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(T__2);
			setState(195);
			match(T__3);
			setState(196);
			e();
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

	public static class FullMWTContext extends ParserRuleContext {
		public FullMHContext fullMH() {
			return getRuleContext(FullMHContext.class,0);
		}
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode NativeURL() { return getToken(L42Parser.NativeURL, 0); }
		public FullMWTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullMWT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullMWT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullMWT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullMWT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullMWTContext fullMWT() throws RecognitionException {
		FullMWTContext _localctx = new FullMWTContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fullMWT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Doc) {
				{
				{
				setState(198);
				doc();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			fullMH();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(205);
				match(T__3);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NativeURL) {
					{
					setState(206);
					match(NativeURL);
					}
				}

				setState(209);
				e();
				}
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

	public static class FullNCContext extends ParserRuleContext {
		public CsPContext csP() {
			return getRuleContext(CsPContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public FullNCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullNC; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullNC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullNC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullNC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullNCContext fullNC() throws RecognitionException {
		FullNCContext _localctx = new FullNCContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fullNC);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Doc) {
				{
				{
				setState(212);
				doc();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
			csP();
			setState(219);
			match(T__3);
			setState(220);
			e();
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

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode InterfaceKw() { return getToken(L42Parser.InterfaceKw, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==InterfaceKw) {
				{
				setState(222);
				match(InterfaceKw);
				}
			}

			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(225);
				match(T__4);
				setState(227); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(226);
					t();
					}
					}
					setState(229); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << CsP) | (1L << Doc))) != 0) );
				setState(231);
				match(T__5);
				}
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

	public static class InfoContext extends ParserRuleContext {
		public TerminalNode Info() { return getToken(L42Parser.Info, 0); }
		public InfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoContext info() throws RecognitionException {
		InfoContext _localctx = new InfoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(Info);
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

	public static class FullMHContext extends ParserRuleContext {
		public TerminalNode MethodKw() { return getToken(L42Parser.MethodKw, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public MOpContext mOp() {
			return getRuleContext(MOpContext.class,0);
		}
		public ORContext oR() {
			return getRuleContext(ORContext.class,0);
		}
		public TerminalNode Mdf() { return getToken(L42Parser.Mdf, 0); }
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public List<DocContext> doc() {
			return getRuleContexts(DocContext.class);
		}
		public DocContext doc(int i) {
			return getRuleContext(DocContext.class,i);
		}
		public FullMHContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullMH; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFullMH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFullMH(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFullMH(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullMHContext fullMH() throws RecognitionException {
		FullMHContext _localctx = new FullMHContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fullMH);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Mdf) {
				{
				setState(237);
				match(Mdf);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Doc) {
					{
					{
					setState(238);
					doc();
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(246);
			match(MethodKw);
			setState(247);
			t();
			setState(248);
			mOp();
			setState(249);
			oR();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << CsP) | (1L << Doc))) != 0)) {
				{
				{
				setState(250);
				t();
				setState(251);
				x();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
			match(T__2);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(259);
				match(T__4);
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(260);
					t();
					}
					}
					setState(263); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << CsP) | (1L << Doc))) != 0) );
				setState(265);
				match(T__5);
				}
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

	public static class MOpContext extends ParserRuleContext {
		public MContext m() {
			return getRuleContext(MContext.class,0);
		}
		public TerminalNode Uop() { return getToken(L42Parser.Uop, 0); }
		public TerminalNode OP0() { return getToken(L42Parser.OP0, 0); }
		public TerminalNode OP1() { return getToken(L42Parser.OP1, 0); }
		public TerminalNode OP2() { return getToken(L42Parser.OP2, 0); }
		public TerminalNode OP3() { return getToken(L42Parser.OP3, 0); }
		public TerminalNode Number() { return getToken(L42Parser.Number, 0); }
		public MOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterMOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitMOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitMOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MOpContext mOp() throws RecognitionException {
		MOpContext _localctx = new MOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_mOp);
		int _la;
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OR:
			case ORNS:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case Mdf:
			case VoidKW:
			case VarKw:
			case CatchKw:
			case InterfaceKw:
			case IfKw:
			case ElseKw:
			case WhileKw:
			case ForKw:
			case InKw:
			case LoopKw:
			case Throw:
			case WhoopsKw:
			case MethodKw:
			case MUniqueNum:
			case MHash:
			case X:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				m();
				}
				break;
			case Uop:
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				match(Uop);
				}
				break;
			case OP0:
			case OP1:
			case OP2:
			case OP3:
				enterOuterAlt(_localctx, 4);
				{
				setState(272);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP0) | (1L << OP1) | (1L << OP2) | (1L << OP3))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Number) {
					{
					setState(273);
					match(Number);
					}
				}

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

	public static class VoidEContext extends ParserRuleContext {
		public TerminalNode VoidKW() { return getToken(L42Parser.VoidKW, 0); }
		public VoidEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterVoidE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitVoidE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitVoidE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidEContext voidE() throws RecognitionException {
		VoidEContext _localctx = new VoidEContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_voidE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(VoidKW);
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

	public static class EPostfixContext extends ParserRuleContext {
		public EAtomicContext eAtomic() {
			return getRuleContext(EAtomicContext.class,0);
		}
		public List<FCallContext> fCall() {
			return getRuleContexts(FCallContext.class);
		}
		public FCallContext fCall(int i) {
			return getRuleContext(FCallContext.class,i);
		}
		public List<SquareCallContext> squareCall() {
			return getRuleContexts(SquareCallContext.class);
		}
		public SquareCallContext squareCall(int i) {
			return getRuleContext(SquareCallContext.class,i);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public List<CastContext> cast() {
			return getRuleContexts(CastContext.class);
		}
		public CastContext cast(int i) {
			return getRuleContext(CastContext.class,i);
		}
		public List<TerminalNode> Uop() { return getTokens(L42Parser.Uop); }
		public TerminalNode Uop(int i) {
			return getToken(L42Parser.Uop, i);
		}
		public List<TerminalNode> Number() { return getTokens(L42Parser.Number); }
		public TerminalNode Number(int i) {
			return getToken(L42Parser.Number, i);
		}
		public EPostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ePostfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterEPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitEPostfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitEPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EPostfixContext ePostfix() throws RecognitionException {
		EPostfixContext _localctx = new EPostfixContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ePostfix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Uop || _la==Number) {
				{
				{
				setState(280);
				_la = _input.LA(1);
				if ( !(_la==Uop || _la==Number) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(286);
			eAtomic();
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(287);
						fCall();
						}
						break;
					case 2:
						{
						setState(288);
						squareCall();
						}
						break;
					case 3:
						{
						setState(289);
						string();
						}
						break;
					case 4:
						{
						setState(290);
						cast();
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class FCallContext extends ParserRuleContext {
		public TerminalNode ORNS() { return getToken(L42Parser.ORNS, 0); }
		public ParContext par() {
			return getRuleContext(ParContext.class,0);
		}
		public TerminalNode ClassSep() { return getToken(L42Parser.ClassSep, 0); }
		public MContext m() {
			return getRuleContext(MContext.class,0);
		}
		public FCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterFCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitFCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitFCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FCallContext fCall() throws RecognitionException {
		FCallContext _localctx = new FCallContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ClassSep) {
				{
				setState(296);
				match(ClassSep);
				setState(297);
				m();
				}
			}

			setState(300);
			match(ORNS);
			setState(301);
			par();
			setState(302);
			match(T__2);
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

	public static class SquareCallContext extends ParserRuleContext {
		public List<ParContext> par() {
			return getRuleContexts(ParContext.class);
		}
		public ParContext par(int i) {
			return getRuleContext(ParContext.class,i);
		}
		public TerminalNode ClassSep() { return getToken(L42Parser.ClassSep, 0); }
		public MContext m() {
			return getRuleContext(MContext.class,0);
		}
		public SquareCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSquareCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSquareCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSquareCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareCallContext squareCall() throws RecognitionException {
		SquareCallContext _localctx = new SquareCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_squareCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ClassSep) {
				{
				setState(304);
				match(ClassSep);
				setState(305);
				m();
				}
			}

			setState(308);
			match(T__4);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(309);
					par();
					setState(310);
					match(T__6);
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(317);
			par();
			setState(318);
			match(T__5);
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

	public static class CastContext extends ParserRuleContext {
		public TerminalNode CastOp() { return getToken(L42Parser.CastOp, 0); }
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(CastOp);
			setState(321);
			t();
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

	public static class ORContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(L42Parser.OR, 0); }
		public TerminalNode ORNS() { return getToken(L42Parser.ORNS, 0); }
		public ORContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitOR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ORContext oR() throws RecognitionException {
		ORContext _localctx = new ORContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_oR);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==ORNS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ParContext extends ParserRuleContext {
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public ParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParContext par() throws RecognitionException {
		ParContext _localctx = new ParContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_par);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(325);
				e();
				}
				break;
			}
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==X) {
				{
				{
				setState(328);
				x();
				setState(329);
				match(T__3);
				setState(330);
				e();
				}
				}
				setState(336);
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

	public static class BlockContext extends ParserRuleContext {
		public ORContext oR() {
			return getRuleContext(ORContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public List<DContext> d() {
			return getRuleContexts(DContext.class);
		}
		public DContext d(int i) {
			return getRuleContext(DContext.class,i);
		}
		public List<KContext> k() {
			return getRuleContexts(KContext.class);
		}
		public KContext k(int i) {
			return getRuleContext(KContext.class,i);
		}
		public WhoopsContext whoops() {
			return getRuleContext(WhoopsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_block);
		int _la;
		try {
			int _alt;
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				oR();
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(338);
						d();
						}
						} 
					}
					setState(343);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(344);
				e();
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CatchKw) {
					{
					{
					setState(345);
					k();
					}
					}
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WhoopsKw) {
					{
					setState(351);
					whoops();
					}
				}

				setState(354);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				oR();
				setState(358); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(357);
						d();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(360); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CatchKw) {
					{
					{
					setState(362);
					k();
					}
					}
					setState(367);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WhoopsKw) {
					{
					setState(368);
					whoops();
					}
				}

				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(371);
						d();
						}
						} 
					}
					setState(376);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				setState(377);
				e();
				setState(378);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				match(T__0);
				setState(382); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(381);
					d();
					}
					}
					setState(384); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Uop) | (1L << Mdf) | (1L << VoidKW) | (1L << VarKw) | (1L << IfKw) | (1L << WhileKw) | (1L << ForKw) | (1L << LoopKw) | (1L << Throw) | (1L << Slash) | (1L << PathSel) | (1L << Number) | (1L << X) | (1L << SlashX) | (1L << CsP) | (1L << UnderScore) | (1L << OR) | (1L << ORNS) | (1L << Doc))) != 0) );
				setState(407);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CatchKw:
					{
					setState(387); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(386);
						k();
						}
						}
						setState(389); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CatchKw );
					setState(392);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WhoopsKw) {
						{
						setState(391);
						whoops();
						}
					}

					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Uop) | (1L << Mdf) | (1L << VoidKW) | (1L << VarKw) | (1L << IfKw) | (1L << WhileKw) | (1L << ForKw) | (1L << LoopKw) | (1L << Throw) | (1L << Slash) | (1L << PathSel) | (1L << Number) | (1L << X) | (1L << SlashX) | (1L << CsP) | (1L << UnderScore) | (1L << OR) | (1L << ORNS) | (1L << Doc))) != 0)) {
						{
						{
						setState(394);
						d();
						}
						}
						setState(399);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case WhoopsKw:
					{
					setState(400);
					whoops();
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Uop) | (1L << Mdf) | (1L << VoidKW) | (1L << VarKw) | (1L << IfKw) | (1L << WhileKw) | (1L << ForKw) | (1L << LoopKw) | (1L << Throw) | (1L << Slash) | (1L << PathSel) | (1L << Number) | (1L << X) | (1L << SlashX) | (1L << CsP) | (1L << UnderScore) | (1L << OR) | (1L << ORNS) | (1L << Doc))) != 0)) {
						{
						{
						setState(401);
						d();
						}
						}
						setState(406);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__1:
					break;
				default:
					break;
				}
				setState(409);
				match(T__1);
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

	public static class DContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public DXContext dX() {
			return getRuleContext(DXContext.class,0);
		}
		public DContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_d; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DContext d() throws RecognitionException {
		DContext _localctx = new DContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_d);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(413);
				dX();
				setState(414);
				match(T__3);
				}
				break;
			}
			setState(418);
			e();
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

	public static class DXContext extends ParserRuleContext {
		public List<TLocalContext> tLocal() {
			return getRuleContexts(TLocalContext.class);
		}
		public TLocalContext tLocal(int i) {
			return getRuleContext(TLocalContext.class,i);
		}
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public List<TerminalNode> VarKw() { return getTokens(L42Parser.VarKw); }
		public TerminalNode VarKw(int i) {
			return getToken(L42Parser.VarKw, i);
		}
		public TerminalNode UnderScore() { return getToken(L42Parser.UnderScore, 0); }
		public ORContext oR() {
			return getRuleContext(ORContext.class,0);
		}
		public DXContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dX; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterDX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitDX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitDX(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DXContext dX() throws RecognitionException {
		DXContext _localctx = new DXContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dX);
		int _la;
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VarKw) {
					{
					setState(420);
					match(VarKw);
					}
				}

				setState(423);
				tLocal();
				setState(424);
				x();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				tLocal();
				setState(427);
				match(UnderScore);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(429);
				tLocal();
				setState(430);
				oR();
				setState(437); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VarKw) {
						{
						setState(431);
						match(VarKw);
						}
					}

					setState(434);
					tLocal();
					setState(435);
					x();
					}
					}
					setState(439); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << VarKw) | (1L << X) | (1L << CsP) | (1L << Doc))) != 0) );
				setState(441);
				match(T__2);
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

	public static class KContext extends ParserRuleContext {
		public TerminalNode CatchKw() { return getToken(L42Parser.CatchKw, 0); }
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode Throw() { return getToken(L42Parser.Throw, 0); }
		public TerminalNode UnderScore() { return getToken(L42Parser.UnderScore, 0); }
		public KContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_k; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitK(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitK(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KContext k() throws RecognitionException {
		KContext _localctx = new KContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_k);
		int _la;
		try {
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				match(CatchKw);
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Throw) {
					{
					setState(446);
					match(Throw);
					}
				}

				setState(449);
				t();
				setState(450);
				x();
				setState(451);
				e();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				match(CatchKw);
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Throw) {
					{
					setState(454);
					match(Throw);
					}
				}

				setState(457);
				t();
				setState(458);
				match(UnderScore);
				setState(459);
				e();
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

	public static class WhoopsContext extends ParserRuleContext {
		public TerminalNode WhoopsKw() { return getToken(L42Parser.WhoopsKw, 0); }
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public WhoopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whoops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterWhoops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitWhoops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitWhoops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhoopsContext whoops() throws RecognitionException {
		WhoopsContext _localctx = new WhoopsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_whoops);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(WhoopsKw);
			setState(465); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(464);
					t();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(467); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class EBinary0Context extends ParserRuleContext {
		public List<EPostfixContext> ePostfix() {
			return getRuleContexts(EPostfixContext.class);
		}
		public EPostfixContext ePostfix(int i) {
			return getRuleContext(EPostfixContext.class,i);
		}
		public List<TerminalNode> OP0() { return getTokens(L42Parser.OP0); }
		public TerminalNode OP0(int i) {
			return getToken(L42Parser.OP0, i);
		}
		public EBinary0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eBinary0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterEBinary0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitEBinary0(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitEBinary0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EBinary0Context eBinary0() throws RecognitionException {
		EBinary0Context _localctx = new EBinary0Context(_ctx, getState());
		enterRule(_localctx, 66, RULE_eBinary0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			ePostfix();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP0) {
				{
				{
				setState(470);
				match(OP0);
				setState(471);
				ePostfix();
				}
				}
				setState(476);
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

	public static class EBinary1Context extends ParserRuleContext {
		public List<EBinary0Context> eBinary0() {
			return getRuleContexts(EBinary0Context.class);
		}
		public EBinary0Context eBinary0(int i) {
			return getRuleContext(EBinary0Context.class,i);
		}
		public List<TerminalNode> OP1() { return getTokens(L42Parser.OP1); }
		public TerminalNode OP1(int i) {
			return getToken(L42Parser.OP1, i);
		}
		public EBinary1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eBinary1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterEBinary1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitEBinary1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitEBinary1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EBinary1Context eBinary1() throws RecognitionException {
		EBinary1Context _localctx = new EBinary1Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_eBinary1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			eBinary0();
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP1) {
				{
				{
				setState(478);
				match(OP1);
				setState(479);
				eBinary0();
				}
				}
				setState(484);
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

	public static class EBinary2Context extends ParserRuleContext {
		public List<EBinary1Context> eBinary1() {
			return getRuleContexts(EBinary1Context.class);
		}
		public EBinary1Context eBinary1(int i) {
			return getRuleContext(EBinary1Context.class,i);
		}
		public List<TerminalNode> OP2() { return getTokens(L42Parser.OP2); }
		public TerminalNode OP2(int i) {
			return getToken(L42Parser.OP2, i);
		}
		public List<TerminalNode> InKw() { return getTokens(L42Parser.InKw); }
		public TerminalNode InKw(int i) {
			return getToken(L42Parser.InKw, i);
		}
		public EBinary2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eBinary2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterEBinary2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitEBinary2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitEBinary2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EBinary2Context eBinary2() throws RecognitionException {
		EBinary2Context _localctx = new EBinary2Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_eBinary2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			eBinary1();
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP2 || _la==InKw) {
				{
				{
				setState(486);
				_la = _input.LA(1);
				if ( !(_la==OP2 || _la==InKw) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(487);
				eBinary1();
				}
				}
				setState(492);
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

	public static class EBinary3Context extends ParserRuleContext {
		public List<EBinary2Context> eBinary2() {
			return getRuleContexts(EBinary2Context.class);
		}
		public EBinary2Context eBinary2(int i) {
			return getRuleContext(EBinary2Context.class,i);
		}
		public List<TerminalNode> OP3() { return getTokens(L42Parser.OP3); }
		public TerminalNode OP3(int i) {
			return getToken(L42Parser.OP3, i);
		}
		public EBinary3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eBinary3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterEBinary3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitEBinary3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitEBinary3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EBinary3Context eBinary3() throws RecognitionException {
		EBinary3Context _localctx = new EBinary3Context(_ctx, getState());
		enterRule(_localctx, 72, RULE_eBinary3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			eBinary2();
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP3) {
				{
				{
				setState(494);
				match(OP3);
				setState(495);
				eBinary2();
				}
				}
				setState(500);
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

	public static class SIfContext extends ParserRuleContext {
		public TerminalNode IfKw() { return getToken(L42Parser.IfKw, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode ElseKw() { return getToken(L42Parser.ElseKw, 0); }
		public List<MatchContext> match() {
			return getRuleContexts(MatchContext.class);
		}
		public MatchContext match(int i) {
			return getRuleContext(MatchContext.class,i);
		}
		public SIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SIfContext sIf() throws RecognitionException {
		SIfContext _localctx = new SIfContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_sIf);
		try {
			int _alt;
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				match(IfKw);
				setState(502);
				e();
				setState(503);
				e();
				setState(506);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(504);
					match(ElseKw);
					setState(505);
					e();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(508);
				match(IfKw);
				setState(510); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(509);
						match();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(512); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(514);
				e();
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

	public static class MatchContext extends ParserRuleContext {
		public List<TContext> t() {
			return getRuleContexts(TContext.class);
		}
		public TContext t(int i) {
			return getRuleContext(TContext.class,i);
		}
		public List<XContext> x() {
			return getRuleContexts(XContext.class);
		}
		public XContext x(int i) {
			return getRuleContext(XContext.class,i);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public ORContext oR() {
			return getRuleContext(ORContext.class,0);
		}
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_match);
		int _la;
		try {
			setState(542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(518);
				t();
				setState(519);
				x();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(521);
				t();
				setState(522);
				x();
				setState(523);
				match(T__3);
				setState(524);
				e();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << CsP) | (1L << Doc))) != 0)) {
					{
					setState(526);
					t();
					}
				}

				setState(529);
				oR();
				setState(534); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(531);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << CsP) | (1L << Doc))) != 0)) {
						{
						setState(530);
						t();
						}
					}

					setState(533);
					x();
					}
					}
					setState(536); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mdf) | (1L << X) | (1L << CsP) | (1L << Doc))) != 0) );
				setState(538);
				match(T__2);
				setState(539);
				match(T__3);
				setState(540);
				e();
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

	public static class SWhileContext extends ParserRuleContext {
		public TerminalNode WhileKw() { return getToken(L42Parser.WhileKw, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public SWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SWhileContext sWhile() throws RecognitionException {
		SWhileContext _localctx = new SWhileContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(WhileKw);
			setState(545);
			e();
			setState(546);
			e();
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

	public static class SForContext extends ParserRuleContext {
		public TerminalNode ForKw() { return getToken(L42Parser.ForKw, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public List<DXContext> dX() {
			return getRuleContexts(DXContext.class);
		}
		public DXContext dX(int i) {
			return getRuleContext(DXContext.class,i);
		}
		public List<TerminalNode> InKw() { return getTokens(L42Parser.InKw); }
		public TerminalNode InKw(int i) {
			return getToken(L42Parser.InKw, i);
		}
		public SForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SForContext sFor() throws RecognitionException {
		SForContext _localctx = new SForContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_sFor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(ForKw);
			setState(553); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(549);
					dX();
					setState(550);
					match(InKw);
					setState(551);
					e();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(555); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(557);
			e();
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

	public static class SLoopContext extends ParserRuleContext {
		public TerminalNode LoopKw() { return getToken(L42Parser.LoopKw, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public SLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SLoopContext sLoop() throws RecognitionException {
		SLoopContext _localctx = new SLoopContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_sLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(LoopKw);
			setState(560);
			e();
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

	public static class SThrowContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(L42Parser.Throw, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public SThrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sThrow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSThrow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSThrow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSThrow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SThrowContext sThrow() throws RecognitionException {
		SThrowContext _localctx = new SThrowContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_sThrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(Throw);
			setState(563);
			e();
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

	public static class SUpdateContext extends ParserRuleContext {
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public TerminalNode OpUpdate() { return getToken(L42Parser.OpUpdate, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public SUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterSUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitSUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitSUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SUpdateContext sUpdate() throws RecognitionException {
		SUpdateContext _localctx = new SUpdateContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_sUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			x();
			setState(566);
			match(OpUpdate);
			setState(567);
			e();
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

	public static class EContext extends ParserRuleContext {
		public SIfContext sIf() {
			return getRuleContext(SIfContext.class,0);
		}
		public SWhileContext sWhile() {
			return getRuleContext(SWhileContext.class,0);
		}
		public SForContext sFor() {
			return getRuleContext(SForContext.class,0);
		}
		public SLoopContext sLoop() {
			return getRuleContext(SLoopContext.class,0);
		}
		public SThrowContext sThrow() {
			return getRuleContext(SThrowContext.class,0);
		}
		public SUpdateContext sUpdate() {
			return getRuleContext(SUpdateContext.class,0);
		}
		public EBinary3Context eBinary3() {
			return getRuleContext(EBinary3Context.class,0);
		}
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EContext e() throws RecognitionException {
		EContext _localctx = new EContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_e);
		try {
			setState(576);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				sIf();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				sWhile();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(571);
				sFor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(572);
				sLoop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(573);
				sThrow();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(574);
				sUpdate();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(575);
				eBinary3();
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

	public static class NudeEContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode EOF() { return getToken(L42Parser.EOF, 0); }
		public NudeEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nudeE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterNudeE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitNudeE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitNudeE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NudeEContext nudeE() throws RecognitionException {
		NudeEContext _localctx = new NudeEContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nudeE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			e();
			setState(579);
			match(EOF);
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

	public static class NudePContext extends ParserRuleContext {
		public List<FullLContext> fullL() {
			return getRuleContexts(FullLContext.class);
		}
		public FullLContext fullL(int i) {
			return getRuleContext(FullLContext.class,i);
		}
		public TerminalNode EOF() { return getToken(L42Parser.EOF, 0); }
		public List<CsPContext> csP() {
			return getRuleContexts(CsPContext.class);
		}
		public CsPContext csP(int i) {
			return getRuleContext(CsPContext.class,i);
		}
		public NudePContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nudeP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterNudeP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitNudeP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitNudeP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NudePContext nudeP() throws RecognitionException {
		NudePContext _localctx = new NudePContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_nudeP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			fullL();
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==CsP) {
				{
				{
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CsP) {
					{
					setState(582);
					csP();
					setState(583);
					match(T__3);
					}
				}

				setState(587);
				fullL();
				}
				}
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(593);
			match(EOF);
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

	public static class NudeCsPContext extends ParserRuleContext {
		public CsPContext csP() {
			return getRuleContext(CsPContext.class,0);
		}
		public TerminalNode EOF() { return getToken(L42Parser.EOF, 0); }
		public NudeCsPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nudeCsP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).enterNudeCsP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof L42Listener ) ((L42Listener)listener).exitNudeCsP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof L42Visitor ) return ((L42Visitor<? extends T>)visitor).visitNudeCsP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NudeCsPContext nudeCsP() throws RecognitionException {
		NudeCsPContext _localctx = new NudeCsPContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_nudeCsP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			csP();
			setState(596);
			match(EOF);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0259\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\5\nt\n\n\3\n\7\nw\n\n\f\n\16"+
		"\nz\13\n\3\n\3\n\3\13\3\13\3\13\5\13\u0081\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u008b\n\f\3\r\3\r\3\r\3\r\5\r\u0091\n\r\3\r\7\r\u0094\n"+
		"\r\f\r\16\r\u0097\13\r\3\r\5\r\u009a\n\r\3\r\7\r\u009d\n\r\f\r\16\r\u00a0"+
		"\13\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u00a8\n\16\3\17\7\17\u00ab\n\17"+
		"\f\17\16\17\u00ae\13\17\3\17\5\17\u00b1\n\17\3\17\3\17\3\17\3\20\7\20"+
		"\u00b7\n\20\f\20\16\20\u00ba\13\20\3\20\3\20\3\20\3\20\7\20\u00c0\n\20"+
		"\f\20\16\20\u00c3\13\20\3\20\3\20\3\20\3\20\3\21\7\21\u00ca\n\21\f\21"+
		"\16\21\u00cd\13\21\3\21\3\21\3\21\5\21\u00d2\n\21\3\21\5\21\u00d5\n\21"+
		"\3\22\7\22\u00d8\n\22\f\22\16\22\u00db\13\22\3\22\3\22\3\22\3\22\3\23"+
		"\5\23\u00e2\n\23\3\23\3\23\6\23\u00e6\n\23\r\23\16\23\u00e7\3\23\3\23"+
		"\5\23\u00ec\n\23\3\24\3\24\3\25\3\25\7\25\u00f2\n\25\f\25\16\25\u00f5"+
		"\13\25\5\25\u00f7\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0100\n"+
		"\25\f\25\16\25\u0103\13\25\3\25\3\25\3\25\6\25\u0108\n\25\r\25\16\25\u0109"+
		"\3\25\3\25\5\25\u010e\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u0115\n\26\5"+
		"\26\u0117\n\26\3\27\3\27\3\30\7\30\u011c\n\30\f\30\16\30\u011f\13\30\3"+
		"\30\3\30\3\30\3\30\3\30\7\30\u0126\n\30\f\30\16\30\u0129\13\30\3\31\3"+
		"\31\5\31\u012d\n\31\3\31\3\31\3\31\3\31\3\32\3\32\5\32\u0135\n\32\3\32"+
		"\3\32\3\32\3\32\7\32\u013b\n\32\f\32\16\32\u013e\13\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\35\5\35\u0149\n\35\3\35\3\35\3\35\3\35\7\35"+
		"\u014f\n\35\f\35\16\35\u0152\13\35\3\36\3\36\7\36\u0156\n\36\f\36\16\36"+
		"\u0159\13\36\3\36\3\36\7\36\u015d\n\36\f\36\16\36\u0160\13\36\3\36\5\36"+
		"\u0163\n\36\3\36\3\36\3\36\3\36\6\36\u0169\n\36\r\36\16\36\u016a\3\36"+
		"\7\36\u016e\n\36\f\36\16\36\u0171\13\36\3\36\5\36\u0174\n\36\3\36\7\36"+
		"\u0177\n\36\f\36\16\36\u017a\13\36\3\36\3\36\3\36\3\36\3\36\6\36\u0181"+
		"\n\36\r\36\16\36\u0182\3\36\6\36\u0186\n\36\r\36\16\36\u0187\3\36\5\36"+
		"\u018b\n\36\3\36\7\36\u018e\n\36\f\36\16\36\u0191\13\36\3\36\3\36\7\36"+
		"\u0195\n\36\f\36\16\36\u0198\13\36\5\36\u019a\n\36\3\36\3\36\5\36\u019e"+
		"\n\36\3\37\3\37\3\37\5\37\u01a3\n\37\3\37\3\37\3 \5 \u01a8\n \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \5 \u01b3\n \3 \3 \3 \6 \u01b8\n \r \16 \u01b9\3 \3"+
		" \5 \u01be\n \3!\3!\5!\u01c2\n!\3!\3!\3!\3!\3!\3!\5!\u01ca\n!\3!\3!\3"+
		"!\3!\5!\u01d0\n!\3\"\3\"\6\"\u01d4\n\"\r\"\16\"\u01d5\3#\3#\3#\7#\u01db"+
		"\n#\f#\16#\u01de\13#\3$\3$\3$\7$\u01e3\n$\f$\16$\u01e6\13$\3%\3%\3%\7"+
		"%\u01eb\n%\f%\16%\u01ee\13%\3&\3&\3&\7&\u01f3\n&\f&\16&\u01f6\13&\3\'"+
		"\3\'\3\'\3\'\3\'\5\'\u01fd\n\'\3\'\3\'\6\'\u0201\n\'\r\'\16\'\u0202\3"+
		"\'\3\'\5\'\u0207\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0212\n(\3(\3(\5(\u0216"+
		"\n(\3(\6(\u0219\n(\r(\16(\u021a\3(\3(\3(\3(\5(\u0221\n(\3)\3)\3)\3)\3"+
		"*\3*\3*\3*\3*\6*\u022c\n*\r*\16*\u022d\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3"+
		"-\3-\3.\3.\3.\3.\3.\3.\3.\5.\u0243\n.\3/\3/\3/\3\60\3\60\3\60\3\60\5\60"+
		"\u024c\n\60\3\60\7\60\u024f\n\60\f\60\16\60\u0252\13\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\u0157\2\62\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`\2\7\5\2\21\23\25\37\')\3\2\f"+
		"\17\4\2\13\13&&\3\2./\4\2\16\16\33\33\2\u0288\2b\3\2\2\2\4d\3\2\2\2\6"+
		"f\3\2\2\2\bh\3\2\2\2\nj\3\2\2\2\fl\3\2\2\2\16n\3\2\2\2\20p\3\2\2\2\22"+
		"s\3\2\2\2\24\u0080\3\2\2\2\26\u008a\3\2\2\2\30\u008c\3\2\2\2\32\u00a7"+
		"\3\2\2\2\34\u00ac\3\2\2\2\36\u00b8\3\2\2\2 \u00cb\3\2\2\2\"\u00d9\3\2"+
		"\2\2$\u00e1\3\2\2\2&\u00ed\3\2\2\2(\u00f6\3\2\2\2*\u0116\3\2\2\2,\u0118"+
		"\3\2\2\2.\u011d\3\2\2\2\60\u012c\3\2\2\2\62\u0134\3\2\2\2\64\u0142\3\2"+
		"\2\2\66\u0145\3\2\2\28\u0148\3\2\2\2:\u019d\3\2\2\2<\u01a2\3\2\2\2>\u01bd"+
		"\3\2\2\2@\u01cf\3\2\2\2B\u01d1\3\2\2\2D\u01d7\3\2\2\2F\u01df\3\2\2\2H"+
		"\u01e7\3\2\2\2J\u01ef\3\2\2\2L\u0206\3\2\2\2N\u0220\3\2\2\2P\u0222\3\2"+
		"\2\2R\u0226\3\2\2\2T\u0231\3\2\2\2V\u0234\3\2\2\2X\u0237\3\2\2\2Z\u0242"+
		"\3\2\2\2\\\u0244\3\2\2\2^\u0247\3\2\2\2`\u0255\3\2\2\2bc\7!\2\2c\3\3\2"+
		"\2\2de\7\"\2\2e\5\3\2\2\2fg\7%\2\2g\7\3\2\2\2hi\7)\2\2i\t\3\2\2\2jk\7"+
		"*\2\2k\13\3\2\2\2lm\t\2\2\2m\r\3\2\2\2no\7\60\2\2o\17\3\2\2\2pq\7+\2\2"+
		"q\21\3\2\2\2rt\7\21\2\2sr\3\2\2\2st\3\2\2\2tx\3\2\2\2uw\5\16\b\2vu\3\2"+
		"\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\5\20\t\2|\23"+
		"\3\2\2\2}\u0081\5\22\n\2~\u0081\7\21\2\2\177\u0081\3\2\2\2\u0080}\3\2"+
		"\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\25\3\2\2\2\u0082\u008b\5\b"+
		"\5\2\u0083\u008b\5\20\t\2\u0084\u008b\5,\27\2\u0085\u008b\5\30\r\2\u0086"+
		"\u008b\5:\36\2\u0087\u008b\5\2\2\2\u0088\u008b\5\4\3\2\u0089\u008b\5\n"+
		"\6\2\u008a\u0082\3\2\2\2\u008a\u0083\3\2\2\2\u008a\u0084\3\2\2\2\u008a"+
		"\u0085\3\2\2\2\u008a\u0086\3\2\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u0089\3\2\2\2\u008b\27\3\2\2\2\u008c\u0090\7\3\2\2\u008d\u0091"+
		"\5$\23\2\u008e\u0091\7 \2\2\u008f\u0091\7#\2\2\u0090\u008d\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u0095\3\2\2\2\u0092\u0094\5\32"+
		"\16\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\5&"+
		"\24\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009e\3\2\2\2\u009b"+
		"\u009d\5\16\b\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\7\4\2\2\u00a2\31\3\2\2\2\u00a3\u00a8\5\34\17\2\u00a4\u00a8\5\36"+
		"\20\2\u00a5\u00a8\5 \21\2\u00a6\u00a8\5\"\22\2\u00a7\u00a3\3\2\2\2\u00a7"+
		"\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\33\3\2\2"+
		"\2\u00a9\u00ab\5\16\b\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00af\u00b1\7\23\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\5\22\n\2\u00b3\u00b4\5\b\5\2\u00b4\35\3\2\2"+
		"\2\u00b5\u00b7\5\16\b\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00bc\7\37\2\2\u00bc\u00bd\5*\26\2\u00bd\u00c1\5\66\34\2\u00be"+
		"\u00c0\5\b\5\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c5\7\5\2\2\u00c5\u00c6\7\6\2\2\u00c6\u00c7\5Z.\2\u00c7\37\3\2\2\2"+
		"\u00c8\u00ca\5\16\b\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d4\5(\25\2\u00cf\u00d1\7\6\2\2\u00d0\u00d2\7$\2\2\u00d1\u00d0\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\5Z.\2\u00d4\u00cf"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5!\3\2\2\2\u00d6\u00d8\5\16\b\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\5\20\t\2\u00dd"+
		"\u00de\7\6\2\2\u00de\u00df\5Z.\2\u00df#\3\2\2\2\u00e0\u00e2\7\26\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00eb\3\2\2\2\u00e3\u00e5\7\7"+
		"\2\2\u00e4\u00e6\5\22\n\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\b"+
		"\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e3\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"%\3\2\2\2\u00ed\u00ee\7\24\2\2\u00ee\'\3\2\2\2\u00ef\u00f3\7\21\2\2\u00f0"+
		"\u00f2\5\16\b\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3"+
		"\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00ef\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\7\37"+
		"\2\2\u00f9\u00fa\5\22\n\2\u00fa\u00fb\5*\26\2\u00fb\u0101\5\66\34\2\u00fc"+
		"\u00fd\5\22\n\2\u00fd\u00fe\5\b\5\2\u00fe\u0100\3\2\2\2\u00ff\u00fc\3"+
		"\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u010d\7\5\2\2\u0105\u0107\7\7"+
		"\2\2\u0106\u0108\5\22\n\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\b"+
		"\2\2\u010c\u010e\3\2\2\2\u010d\u0105\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		")\3\2\2\2\u010f\u0117\3\2\2\2\u0110\u0117\5\f\7\2\u0111\u0117\7\13\2\2"+
		"\u0112\u0114\t\3\2\2\u0113\u0115\7&\2\2\u0114\u0113\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u010f\3\2\2\2\u0116\u0110\3\2\2\2\u0116"+
		"\u0111\3\2\2\2\u0116\u0112\3\2\2\2\u0117+\3\2\2\2\u0118\u0119\7\22\2\2"+
		"\u0119-\3\2\2\2\u011a\u011c\t\4\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3"+
		"\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0127\5\26\f\2\u0121\u0126\5\60\31\2\u0122\u0126"+
		"\5\62\32\2\u0123\u0126\5\6\4\2\u0124\u0126\5\64\33\2\u0125\u0121\3\2\2"+
		"\2\u0125\u0122\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0129"+
		"\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128/\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u012b\7,\2\2\u012b\u012d\5\f\7\2\u012c\u012a\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\7/\2\2\u012f"+
		"\u0130\58\35\2\u0130\u0131\7\5\2\2\u0131\61\3\2\2\2\u0132\u0133\7,\2\2"+
		"\u0133\u0135\5\f\7\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u013c\7\7\2\2\u0137\u0138\58\35\2\u0138\u0139\7\t\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0137\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0140\58\35\2\u0140\u0141\7\b\2\2\u0141\63\3\2\2\2\u0142\u0143\7\n\2"+
		"\2\u0143\u0144\5\22\n\2\u0144\65\3\2\2\2\u0145\u0146\t\5\2\2\u0146\67"+
		"\3\2\2\2\u0147\u0149\5Z.\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u0150\3\2\2\2\u014a\u014b\5\b\5\2\u014b\u014c\7\6\2\2\u014c\u014d\5Z"+
		".\2\u014d\u014f\3\2\2\2\u014e\u014a\3\2\2\2\u014f\u0152\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u01519\3\2\2\2\u0152\u0150\3\2\2\2"+
		"\u0153\u0157\5\66\34\2\u0154\u0156\5<\37\2\u0155\u0154\3\2\2\2\u0156\u0159"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015a\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015e\5Z.\2\u015b\u015d\5@!\2\u015c\u015b\3\2\2\2"+
		"\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0162"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0163\5B\"\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7\5\2\2\u0165\u019e\3\2"+
		"\2\2\u0166\u0168\5\66\34\2\u0167\u0169\5<\37\2\u0168\u0167\3\2\2\2\u0169"+
		"\u016a\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016f\3\2"+
		"\2\2\u016c\u016e\5@!\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0172"+
		"\u0174\5B\"\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0178\3\2"+
		"\2\2\u0175\u0177\5<\37\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2"+
		"\2\2\u017b\u017c\5Z.\2\u017c\u017d\7\5\2\2\u017d\u019e\3\2\2\2\u017e\u0180"+
		"\7\3\2\2\u017f\u0181\5<\37\2\u0180\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0199\3\2\2\2\u0184\u0186\5@"+
		"!\2\u0185\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u018b\5B\"\2\u018a\u0189\3\2"+
		"\2\2\u018a\u018b\3\2\2\2\u018b\u018f\3\2\2\2\u018c\u018e\5<\37\2\u018d"+
		"\u018c\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\u019a\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0196\5B\"\2\u0193"+
		"\u0195\5<\37\2\u0194\u0193\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2"+
		"\2\2\u0196\u0197\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0199"+
		"\u0185\3\2\2\2\u0199\u0192\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b\u019c\7\4\2\2\u019c\u019e\3\2\2\2\u019d\u0153\3\2\2\2\u019d"+
		"\u0166\3\2\2\2\u019d\u017e\3\2\2\2\u019e;\3\2\2\2\u019f\u01a0\5> \2\u01a0"+
		"\u01a1\7\6\2\2\u01a1\u01a3\3\2\2\2\u01a2\u019f\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\5Z.\2\u01a5=\3\2\2\2\u01a6\u01a8"+
		"\7\23\2\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2"+
		"\u01a9\u01aa\5\24\13\2\u01aa\u01ab\5\b\5\2\u01ab\u01be\3\2\2\2\u01ac\u01ad"+
		"\5\24\13\2\u01ad\u01ae\7-\2\2\u01ae\u01be\3\2\2\2\u01af\u01b0\5\24\13"+
		"\2\u01b0\u01b7\5\66\34\2\u01b1\u01b3\7\23\2\2\u01b2\u01b1\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\5\24\13\2\u01b5\u01b6\5"+
		"\b\5\2\u01b6\u01b8\3\2\2\2\u01b7\u01b2\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\7\5"+
		"\2\2\u01bc\u01be\3\2\2\2\u01bd\u01a7\3\2\2\2\u01bd\u01ac\3\2\2\2\u01bd"+
		"\u01af\3\2\2\2\u01be?\3\2\2\2\u01bf\u01c1\7\25\2\2\u01c0\u01c2\7\35\2"+
		"\2\u01c1\u01c0\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4"+
		"\5\22\n\2\u01c4\u01c5\5\b\5\2\u01c5\u01c6\5Z.\2\u01c6\u01d0\3\2\2\2\u01c7"+
		"\u01c9\7\25\2\2\u01c8\u01ca\7\35\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3"+
		"\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\5\22\n\2\u01cc\u01cd\7-\2\2\u01cd"+
		"\u01ce\5Z.\2\u01ce\u01d0\3\2\2\2\u01cf\u01bf\3\2\2\2\u01cf\u01c7\3\2\2"+
		"\2\u01d0A\3\2\2\2\u01d1\u01d3\7\36\2\2\u01d2\u01d4\5\22\n\2\u01d3\u01d2"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"C\3\2\2\2\u01d7\u01dc\5.\30\2\u01d8\u01d9\7\f\2\2\u01d9\u01db\5.\30\2"+
		"\u01da\u01d8\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd"+
		"\3\2\2\2\u01ddE\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e4\5D#\2\u01e0\u01e1"+
		"\7\r\2\2\u01e1\u01e3\5D#\2\u01e2\u01e0\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5G\3\2\2\2\u01e6\u01e4\3\2\2\2"+
		"\u01e7\u01ec\5F$\2\u01e8\u01e9\t\6\2\2\u01e9\u01eb\5F$\2\u01ea\u01e8\3"+
		"\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"I\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f4\5H%\2\u01f0\u01f1\7\17\2\2\u01f1"+
		"\u01f3\5H%\2\u01f2\u01f0\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2"+
		"\2\u01f4\u01f5\3\2\2\2\u01f5K\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f8"+
		"\7\27\2\2\u01f8\u01f9\5Z.\2\u01f9\u01fc\5Z.\2\u01fa\u01fb\7\30\2\2\u01fb"+
		"\u01fd\5Z.\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0207\3\2\2"+
		"\2\u01fe\u0200\7\27\2\2\u01ff\u0201\5N(\2\u0200\u01ff\3\2\2\2\u0201\u0202"+
		"\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0205\5Z.\2\u0205\u0207\3\2\2\2\u0206\u01f7\3\2\2\2\u0206\u01fe\3\2\2"+
		"\2\u0207M\3\2\2\2\u0208\u0209\5\22\n\2\u0209\u020a\5\b\5\2\u020a\u0221"+
		"\3\2\2\2\u020b\u020c\5\22\n\2\u020c\u020d\5\b\5\2\u020d\u020e\7\6\2\2"+
		"\u020e\u020f\5Z.\2\u020f\u0221\3\2\2\2\u0210\u0212\5\22\n\2\u0211\u0210"+
		"\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0218\5\66\34\2"+
		"\u0214\u0216\5\22\n\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217"+
		"\3\2\2\2\u0217\u0219\5\b\5\2\u0218\u0215\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021d\7\5"+
		"\2\2\u021d\u021e\7\6\2\2\u021e\u021f\5Z.\2\u021f\u0221\3\2\2\2\u0220\u0208"+
		"\3\2\2\2\u0220\u020b\3\2\2\2\u0220\u0211\3\2\2\2\u0221O\3\2\2\2\u0222"+
		"\u0223\7\31\2\2\u0223\u0224\5Z.\2\u0224\u0225\5Z.\2\u0225Q\3\2\2\2\u0226"+
		"\u022b\7\32\2\2\u0227\u0228\5> \2\u0228\u0229\7\33\2\2\u0229\u022a\5Z"+
		".\2\u022a\u022c\3\2\2\2\u022b\u0227\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\5Z"+
		".\2\u0230S\3\2\2\2\u0231\u0232\7\34\2\2\u0232\u0233\5Z.\2\u0233U\3\2\2"+
		"\2\u0234\u0235\7\35\2\2\u0235\u0236\5Z.\2\u0236W\3\2\2\2\u0237\u0238\5"+
		"\b\5\2\u0238\u0239\7\20\2\2\u0239\u023a\5Z.\2\u023aY\3\2\2\2\u023b\u0243"+
		"\5L\'\2\u023c\u0243\5P)\2\u023d\u0243\5R*\2\u023e\u0243\5T+\2\u023f\u0243"+
		"\5V,\2\u0240\u0243\5X-\2\u0241\u0243\5J&\2\u0242\u023b\3\2\2\2\u0242\u023c"+
		"\3\2\2\2\u0242\u023d\3\2\2\2\u0242\u023e\3\2\2\2\u0242\u023f\3\2\2\2\u0242"+
		"\u0240\3\2\2\2\u0242\u0241\3\2\2\2\u0243[\3\2\2\2\u0244\u0245\5Z.\2\u0245"+
		"\u0246\7\2\2\3\u0246]\3\2\2\2\u0247\u0250\5\30\r\2\u0248\u0249\5\20\t"+
		"\2\u0249\u024a\7\6\2\2\u024a\u024c\3\2\2\2\u024b\u0248\3\2\2\2\u024b\u024c"+
		"\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024f\5\30\r\2\u024e\u024b\3\2\2\2"+
		"\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0253"+
		"\3\2\2\2\u0252\u0250\3\2\2\2\u0253\u0254\7\2\2\3\u0254_\3\2\2\2\u0255"+
		"\u0256\5\20\t\2\u0256\u0257\7\2\2\3\u0257a\3\2\2\2Ksx\u0080\u008a\u0090"+
		"\u0095\u0099\u009e\u00a7\u00ac\u00b0\u00b8\u00c1\u00cb\u00d1\u00d4\u00d9"+
		"\u00e1\u00e7\u00eb\u00f3\u00f6\u0101\u0109\u010d\u0114\u0116\u011d\u0125"+
		"\u0127\u012c\u0134\u013c\u0148\u0150\u0157\u015e\u0162\u016a\u016f\u0173"+
		"\u0178\u0182\u0187\u018a\u018f\u0196\u0199\u019d\u01a2\u01a7\u01b2\u01b9"+
		"\u01bd\u01c1\u01c9\u01cf\u01d5\u01dc\u01e4\u01ec\u01f4\u01fc\u0202\u0206"+
		"\u0211\u0215\u021a\u0220\u022d\u0242\u024b\u0250";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}