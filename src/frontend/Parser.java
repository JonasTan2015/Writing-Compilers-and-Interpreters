package frontend;

import intermediate.ICode;
import intermediate.SymTab;

/**
 * Created by abbiewade on 6/2/17.
 *
 *   A language dependent framework class. This abstract parser class will be
 *   implemented by language-specific subclasses.
 *
 *   pp16 WCI
 *
 */
public abstract class Parser {

    protected static SymTab symTab; // generated Symbol Table

    static{
        symTab = null;
    }

    protected Scanner scanner; // scanner used with this parser
    protected ICode iCode; //intermediate code generated with this parser

    /**
     * Constructor
     * @param scanner this scanner to be used with this parser
     */
    public Parser(Scanner scanner){
        this.scanner = scanner;
        this.iCode = null;
    }

    /**
     * Parse a source program and generate the intermediate code and the
     * symbol table. To be implemented by a language-specific parser subclass.
     *
     * @throws Exception if an error occured
     */
    public abstract void parse()
        throws Exception;

    /**
     * Return the number of syntax errors found by the parser.
     * To be implemented by a language-specific parser subclass.
     *
     * @return the error count
     */
    public abstract int getErrorCount();

    /**
     * Call the scanner's currentToken() method.
     * @return the current token
     */
    public Token currentToken(){
        return scanner.currentToken();
    }

    /**
     * Call the scanner's nextToken() method.
     * @return the next token
     */
    public Token currentToken()
        throws Exception
    {
        return scanner.nextToken();
    }

}
