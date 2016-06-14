import java.awt.Color;

public class Colors {
	   private static final Color orange = new Color(255,204,153);
	   private static final Color red = new Color(51,153,255);
	   private static final Color green = new Color(153,255,255);
	   private static final Color pink = new Color(255,102,178);
	   private static final Color yellow = new Color(236,236,122);
	   private static final Color blue = new Color(246,74,85);
	   private static final Color lightblue = new Color(122, 230, 122);
	   private static final Color brown = new Color(204, 102, 0);	  		   
	   
	   public static final Color[][] colors = new Color[][] {		   
	   { orange, blue, lightblue, pink, yellow, red, green, brown}, 
	   { red, orange, pink, green, blue, yellow, brown, lightblue}, 
	   { green, pink, orange, red, lightblue, brown, yellow, blue}, 
	   { pink, lightblue, blue, orange, brown, green, red, yellow }, 
	   { yellow, red, green, brown, orange, blue, lightblue, pink }, 
	   {blue, yellow, brown, lightblue, red, orange, pink, green }, 
	   { lightblue, brown, yellow, blue, green, pink, orange, red },
	   { brown, green, red, yellow, pink, lightblue, blue, orange }
	   };
}