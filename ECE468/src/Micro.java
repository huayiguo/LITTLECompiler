import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Micro {
    public static void main(String[] args) throws Exception {
        MicroLexer lexer = new MicroLexer(new ANTLRFileStream(args[0]));
        TokenStream tokens = new CommonTokenStream(lexer);
		MicroParser Myparser = new MicroParser(tokens);
		Myparser.setErrorHandler(new ThrowError());
		Myparser.program();
	   // System.out.println("Accepted");
    }
    
}
class ThrowError extends DefaultErrorStrategy{
        public void reportError(Parser re, RecognitionException e){
            System.out.println("Not Accepted");
            System.exit(0); 
        }
        protected void reportUnwantedToken(Parser re)
        {
        System.out.println("Not Accepted");
        System.exit(0); 
        }
}



