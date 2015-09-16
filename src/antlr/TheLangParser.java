// Generated from .\src\TheLang.g by ANTLR 4.5.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TheLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, ASSIGN=3, SEMI=4, GT=5, GE=6, LT=7, LE=8, EQ=9, NEQ=10, PLUS=11, 
		MINUS=12, MUL=13, DIV=14, NOT=15, LPAREN=16, RPAREN=17, LBRACE=18, RBRACE=19, 
		LBRACKET=20, RBRACKET=21, COLON=22, IF=23, THEN=24, ELSE=25, FI=26, WHILE=27, 
		DO=28, OD=29, SKIP=30, WRITE=31, READ=32, PROGRAM=33, END=34, TRUE=35, 
		FALSE=36, INT=37, LOW=38, HIGH=39, COMMENT=40, INTEGER=41, IDENTIFIER=42, 
		WS=43;
	public static final int
		RULE_aexpr = 0, RULE_aexpr1 = 1, RULE_aexpr2 = 2, RULE_aexpr3 = 3, RULE_bexpr = 4, 
		RULE_bexpr1 = 5, RULE_bexpr2 = 6, RULE_opr = 7, RULE_decl = 8, RULE_level = 9, 
		RULE_stmt = 10, RULE_assignStmt = 11, RULE_skipStmt = 12, RULE_readStmt = 13, 
		RULE_writeStmt = 14, RULE_ifStmt = 15, RULE_whileStmt = 16, RULE_program = 17;
	public static final String[] ruleNames = {
		"aexpr", "aexpr1", "aexpr2", "aexpr3", "bexpr", "bexpr1", "bexpr2", "opr", 
		"decl", "level", "stmt", "assignStmt", "skipStmt", "readStmt", "writeStmt", 
		"ifStmt", "whileStmt", "program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'&'", "'|'", "':='", "';'", "'>'", "'>='", "'<'", "'<='", "'='", 
		"'!='", "'+'", "'-'", "'*'", "'/'", "'!'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "':'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", 
		"'od'", "'skip'", "'write'", "'read'", "'program'", "'end'", "'true'", 
		"'false'", "'int'", "'low'", "'high'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "ASSIGN", "SEMI", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"PLUS", "MINUS", "MUL", "DIV", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LBRACKET", "RBRACKET", "COLON", "IF", "THEN", "ELSE", "FI", "WHILE", 
		"DO", "OD", "SKIP", "WRITE", "READ", "PROGRAM", "END", "TRUE", "FALSE", 
		"INT", "LOW", "HIGH", "COMMENT", "INTEGER", "IDENTIFIER", "WS"
	};
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
	public String getGrammarFileName() { return "TheLang.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TheLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AexprContext extends ParserRuleContext {
		public List<Aexpr1Context> aexpr1() {
			return getRuleContexts(Aexpr1Context.class);
		}
		public Aexpr1Context aexpr1(int i) {
			return getRuleContext(Aexpr1Context.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(TheLangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(TheLangParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TheLangParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(TheLangParser.MINUS, i);
		}
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitAexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		AexprContext _localctx = new AexprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			aexpr1();
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(41);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(37);
					match(PLUS);
					setState(38);
					aexpr1();
					}
					break;
				case MINUS:
					{
					setState(39);
					match(MINUS);
					setState(40);
					aexpr1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(45);
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

	public static class Aexpr1Context extends ParserRuleContext {
		public List<Aexpr2Context> aexpr2() {
			return getRuleContexts(Aexpr2Context.class);
		}
		public Aexpr2Context aexpr2(int i) {
			return getRuleContext(Aexpr2Context.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(TheLangParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(TheLangParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(TheLangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(TheLangParser.DIV, i);
		}
		public Aexpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitAexpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aexpr1Context aexpr1() throws RecognitionException {
		Aexpr1Context _localctx = new Aexpr1Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_aexpr1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			aexpr2();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				setState(51);
				switch (_input.LA(1)) {
				case MUL:
					{
					setState(47);
					match(MUL);
					setState(48);
					aexpr2();
					}
					break;
				case DIV:
					{
					setState(49);
					match(DIV);
					setState(50);
					aexpr2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55);
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

	public static class Aexpr2Context extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(TheLangParser.MINUS, 0); }
		public Aexpr3Context aexpr3() {
			return getRuleContext(Aexpr3Context.class,0);
		}
		public Aexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitAexpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aexpr2Context aexpr2() throws RecognitionException {
		Aexpr2Context _localctx = new Aexpr2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_aexpr2);
		try {
			setState(59);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(MINUS);
				setState(57);
				aexpr3();
				}
				break;
			case LPAREN:
			case INTEGER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				aexpr3();
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

	public static class Aexpr3Context extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(TheLangParser.INTEGER, 0); }
		public TerminalNode LPAREN() { return getToken(TheLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TheLangParser.RPAREN, 0); }
		public Aexpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAexpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAexpr3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitAexpr3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aexpr3Context aexpr3() throws RecognitionException {
		Aexpr3Context _localctx = new Aexpr3Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_aexpr3);
		int _la;
		try {
			setState(73);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(IDENTIFIER);
				setState(66);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(62);
					match(LBRACKET);
					setState(63);
					aexpr();
					setState(64);
					match(RBRACKET);
					}
				}

				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(INTEGER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(LPAREN);
				setState(70);
				aexpr();
				setState(71);
				match(RPAREN);
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

	public static class BexprContext extends ParserRuleContext {
		public List<Bexpr1Context> bexpr1() {
			return getRuleContexts(Bexpr1Context.class);
		}
		public Bexpr1Context bexpr1(int i) {
			return getRuleContext(Bexpr1Context.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(TheLangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(TheLangParser.OR, i);
		}
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitBexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitBexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		BexprContext _localctx = new BexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bexpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			bexpr1();
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					match(OR);
					setState(77);
					bexpr1();
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class Bexpr1Context extends ParserRuleContext {
		public List<Bexpr2Context> bexpr2() {
			return getRuleContexts(Bexpr2Context.class);
		}
		public Bexpr2Context bexpr2(int i) {
			return getRuleContext(Bexpr2Context.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(TheLangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TheLangParser.AND, i);
		}
		public Bexpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterBexpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitBexpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitBexpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bexpr1Context bexpr1() throws RecognitionException {
		Bexpr1Context _localctx = new Bexpr1Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_bexpr1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			bexpr2();
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(84);
					match(AND);
					setState(85);
					bexpr2();
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Bexpr2Context extends ParserRuleContext {
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public OprContext opr() {
			return getRuleContext(OprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(TheLangParser.NOT, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(TheLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TheLangParser.FALSE, 0); }
		public TerminalNode LPAREN() { return getToken(TheLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TheLangParser.RPAREN, 0); }
		public Bexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterBexpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitBexpr2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitBexpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bexpr2Context bexpr2() throws RecognitionException {
		Bexpr2Context _localctx = new Bexpr2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_bexpr2);
		try {
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				aexpr();
				setState(92);
				opr();
				setState(93);
				aexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(NOT);
				setState(96);
				bexpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				match(LPAREN);
				setState(100);
				bexpr();
				setState(101);
				match(RPAREN);
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

	public static class OprContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(TheLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(TheLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(TheLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(TheLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(TheLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(TheLangParser.NEQ, 0); }
		public OprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterOpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitOpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitOpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OprContext opr() throws RecognitionException {
		OprContext _localctx = new OprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_opr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TheLangParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(TheLangParser.INTEGER, 0); }
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if (_la==LOW || _la==HIGH) {
				{
				setState(107);
				level();
				}
			}

			setState(110);
			match(INT);
			setState(111);
			match(IDENTIFIER);
			setState(115);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(112);
				match(LBRACKET);
				setState(113);
				match(INTEGER);
				setState(114);
				match(RBRACKET);
				}
			}

			setState(117);
			match(SEMI);
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

	public static class LevelContext extends ParserRuleContext {
		public TerminalNode LOW() { return getToken(TheLangParser.LOW, 0); }
		public TerminalNode HIGH() { return getToken(TheLangParser.HIGH, 0); }
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitLevel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_level);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !(_la==LOW || _la==HIGH) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class StmtContext extends ParserRuleContext {
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public SkipStmtContext skipStmt() {
			return getRuleContext(SkipStmtContext.class,0);
		}
		public ReadStmtContext readStmt() {
			return getRuleContext(ReadStmtContext.class,0);
		}
		public WriteStmtContext writeStmt() {
			return getRuleContext(WriteStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				assignStmt();
				}
				break;
			case SKIP:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				skipStmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				readStmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				writeStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				ifStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				whileStmt();
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

	public static class AssignStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(TheLangParser.ASSIGN, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(IDENTIFIER);
			setState(134);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(130);
				match(LBRACKET);
				setState(131);
				aexpr();
				setState(132);
				match(RBRACKET);
				}
			}

			setState(136);
			match(ASSIGN);
			setState(137);
			aexpr();
			setState(138);
			match(SEMI);
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

	public static class SkipStmtContext extends ParserRuleContext {
		public TerminalNode SKIP() { return getToken(TheLangParser.SKIP, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public SkipStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterSkipStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitSkipStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitSkipStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipStmtContext skipStmt() throws RecognitionException {
		SkipStmtContext _localctx = new SkipStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_skipStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(SKIP);
			setState(141);
			match(SEMI);
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

	public static class ReadStmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(TheLangParser.READ, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheLangParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public TerminalNode LBRACKET() { return getToken(TheLangParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TheLangParser.RBRACKET, 0); }
		public ReadStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterReadStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitReadStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitReadStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStmtContext readStmt() throws RecognitionException {
		ReadStmtContext _localctx = new ReadStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_readStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(READ);
			setState(144);
			match(IDENTIFIER);
			setState(149);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(145);
				match(LBRACKET);
				setState(146);
				aexpr();
				setState(147);
				match(RBRACKET);
				}
			}

			setState(151);
			match(SEMI);
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

	public static class WriteStmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(TheLangParser.WRITE, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TheLangParser.SEMI, 0); }
		public WriteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterWriteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitWriteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitWriteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStmtContext writeStmt() throws RecognitionException {
		WriteStmtContext _localctx = new WriteStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(WRITE);
			setState(154);
			aexpr();
			setState(155);
			match(SEMI);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TheLangParser.IF, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TheLangParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(TheLangParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(TheLangParser.FI, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(IF);
			setState(158);
			bexpr();
			setState(159);
			match(THEN);
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				stmt();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(165);
			match(ELSE);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				stmt();
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(171);
			match(FI);
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(TheLangParser.WHILE, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode DO() { return getToken(TheLangParser.DO, 0); }
		public TerminalNode OD() { return getToken(TheLangParser.OD, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(WHILE);
			setState(174);
			bexpr();
			setState(175);
			match(DO);
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176);
				stmt();
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(181);
			match(OD);
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(TheLangParser.PROGRAM, 0); }
		public TerminalNode END() { return getToken(TheLangParser.END, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TheLangListener ) ((TheLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheLangVisitor ) return ((TheLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(PROGRAM);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << LOW) | (1L << HIGH))) != 0)) {
				{
				{
				setState(184);
				decl();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190);
				stmt();
				}
				}
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SKIP) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0) );
			setState(195);
			match(END);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00c8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\3\3\3\3\3\3\3"+
		"\3\3\7\3\66\n\3\f\3\16\39\13\3\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\5\5E\n\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\7\6Q\n\6\f\6\16\6"+
		"T\13\6\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\bj\n\b\3\t\3\t\3\n\5\no\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\nv\n\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0082\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u0098\n\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\6\21\u00a4\n\21\r\21\16\21\u00a5\3\21\3\21\6\21\u00aa"+
		"\n\21\r\21\16\21\u00ab\3\21\3\21\3\22\3\22\3\22\3\22\6\22\u00b4\n\22\r"+
		"\22\16\22\u00b5\3\22\3\22\3\23\3\23\7\23\u00bc\n\23\f\23\16\23\u00bf\13"+
		"\23\3\23\6\23\u00c2\n\23\r\23\16\23\u00c3\3\23\3\23\3\23\2\2\24\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\7\f\3\2()\u00d1\2&\3\2\2"+
		"\2\4\60\3\2\2\2\6=\3\2\2\2\bK\3\2\2\2\nM\3\2\2\2\fU\3\2\2\2\16i\3\2\2"+
		"\2\20k\3\2\2\2\22n\3\2\2\2\24y\3\2\2\2\26\u0081\3\2\2\2\30\u0083\3\2\2"+
		"\2\32\u008e\3\2\2\2\34\u0091\3\2\2\2\36\u009b\3\2\2\2 \u009f\3\2\2\2\""+
		"\u00af\3\2\2\2$\u00b9\3\2\2\2&-\5\4\3\2\'(\7\r\2\2(,\5\4\3\2)*\7\16\2"+
		"\2*,\5\4\3\2+\'\3\2\2\2+)\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\3\3\2"+
		"\2\2/-\3\2\2\2\60\67\5\6\4\2\61\62\7\17\2\2\62\66\5\6\4\2\63\64\7\20\2"+
		"\2\64\66\5\6\4\2\65\61\3\2\2\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2"+
		"\678\3\2\2\28\5\3\2\2\29\67\3\2\2\2:;\7\16\2\2;>\5\b\5\2<>\5\b\5\2=:\3"+
		"\2\2\2=<\3\2\2\2>\7\3\2\2\2?D\7,\2\2@A\7\26\2\2AB\5\2\2\2BC\7\27\2\2C"+
		"E\3\2\2\2D@\3\2\2\2DE\3\2\2\2EL\3\2\2\2FL\7+\2\2GH\7\22\2\2HI\5\2\2\2"+
		"IJ\7\23\2\2JL\3\2\2\2K?\3\2\2\2KF\3\2\2\2KG\3\2\2\2L\t\3\2\2\2MR\5\f\7"+
		"\2NO\7\4\2\2OQ\5\f\7\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\13\3\2"+
		"\2\2TR\3\2\2\2UZ\5\16\b\2VW\7\3\2\2WY\5\16\b\2XV\3\2\2\2Y\\\3\2\2\2ZX"+
		"\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2]^\5\2\2\2^_\5\20\t\2_`\5\2\2"+
		"\2`j\3\2\2\2ab\7\21\2\2bj\5\n\6\2cj\7%\2\2dj\7&\2\2ef\7\22\2\2fg\5\n\6"+
		"\2gh\7\23\2\2hj\3\2\2\2i]\3\2\2\2ia\3\2\2\2ic\3\2\2\2id\3\2\2\2ie\3\2"+
		"\2\2j\17\3\2\2\2kl\t\2\2\2l\21\3\2\2\2mo\5\24\13\2nm\3\2\2\2no\3\2\2\2"+
		"op\3\2\2\2pq\7\'\2\2qu\7,\2\2rs\7\26\2\2st\7+\2\2tv\7\27\2\2ur\3\2\2\2"+
		"uv\3\2\2\2vw\3\2\2\2wx\7\6\2\2x\23\3\2\2\2yz\t\3\2\2z\25\3\2\2\2{\u0082"+
		"\5\30\r\2|\u0082\5\32\16\2}\u0082\5\34\17\2~\u0082\5\36\20\2\177\u0082"+
		"\5 \21\2\u0080\u0082\5\"\22\2\u0081{\3\2\2\2\u0081|\3\2\2\2\u0081}\3\2"+
		"\2\2\u0081~\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\27\3\2"+
		"\2\2\u0083\u0088\7,\2\2\u0084\u0085\7\26\2\2\u0085\u0086\5\2\2\2\u0086"+
		"\u0087\7\27\2\2\u0087\u0089\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7\5\2\2\u008b\u008c\5\2\2\2\u008c"+
		"\u008d\7\6\2\2\u008d\31\3\2\2\2\u008e\u008f\7 \2\2\u008f\u0090\7\6\2\2"+
		"\u0090\33\3\2\2\2\u0091\u0092\7\"\2\2\u0092\u0097\7,\2\2\u0093\u0094\7"+
		"\26\2\2\u0094\u0095\5\2\2\2\u0095\u0096\7\27\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0093\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\6"+
		"\2\2\u009a\35\3\2\2\2\u009b\u009c\7!\2\2\u009c\u009d\5\2\2\2\u009d\u009e"+
		"\7\6\2\2\u009e\37\3\2\2\2\u009f\u00a0\7\31\2\2\u00a0\u00a1\5\n\6\2\u00a1"+
		"\u00a3\7\32\2\2\u00a2\u00a4\5\26\f\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a9\7\33\2\2\u00a8\u00aa\5\26\f\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\7\34\2\2\u00ae!\3\2\2\2\u00af\u00b0\7\35\2\2\u00b0\u00b1\5\n\6"+
		"\2\u00b1\u00b3\7\36\2\2\u00b2\u00b4\5\26\f\2\u00b3\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\7\37\2\2\u00b8#\3\2\2\2\u00b9\u00bd\7#\2\2\u00ba\u00bc"+
		"\5\22\n\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2"+
		"\5\26\f\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6%\3\2"+
		"\2\2\26+-\65\67=DKRZinu\u0081\u0088\u0097\u00a5\u00ab\u00b5\u00bd\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}