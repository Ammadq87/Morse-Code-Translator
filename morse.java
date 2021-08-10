
public class morse {
    
    // Default Variables
    private String phrase;
    private String translated_phrase = "";

    public morse(){
        // Default Constructor
    }

    public morse(String phrase){
        this.phrase = phrase;
    }

    // Checks wether entered phrase is valid, returns true if phrase is valid
    public boolean validPhrase(){
        if (this.phrase.charAt(0) == '.' || this.phrase.charAt(0) == '-'){
			return true;
		}

        else if ((this.phrase.charAt(0) <= 'z' && this.phrase.charAt(0) >= 'A') || this.phrase.charAt(0) == ' ')
            return true;

        else
            return false;
    }

    // Returns what type of phrase was entered, returns true if phrase is in morse code
    public boolean whatType(){
        boolean flag = true; 
        // False -> Original Phrase is in English
        // True -> Original Phrase is in Morse-Code
        if (validPhrase()){
            if (this.phrase.charAt(0) == '.' || this.phrase.charAt(0) == '-')
                flag = true;

            else if ((this.phrase.charAt(0) <= 'z' && this.phrase.charAt(0) >= 'A') || this.phrase.charAt(0) == ' ')
                flag = false;
        }

        return flag;
    }

	// Automatically translates the phrase entered using methods in this class
	public String insantTranslate(){
		if (validPhrase()){
			if (whatType()){
				this.phrase = this.phrase+" ";
				translateToEnglish();
			}

			else{
				EnglishToMorse();
			}
		}

		return toString();
	}

    // Outputs final results of the translation
    public String toString(){
        // return "Original Phrase: "+this.phrase+"\nTranslated Phrase: "+this.translated_phrase+"\n";
		return this.translated_phrase;
	}

    // Converts Morse-Code into English
    public void translateToEnglish () {
		String finalWord = "";
		String word = "";
		int spc = 0;

        if (whatType()){
            for (int i=0; i<this.phrase.length(); i++) {

                if (i == 0 && this.phrase.charAt(i) == ' ')
                    spc = 0;

                else if (this.phrase.charAt(i) == ' ') {
                    finalWord = this.phrase.substring(spc, i);
                    word = dictionary(finalWord, word);
                    spc = i+1;
			    }
		    }
		    this.translated_phrase = word;
        }
	}

    // English letters used for translation
	private String dictionary (String finalWord, String word) {
		if (finalWord.equals("/"))
			word += " "; 
		else if (finalWord.equals(".-"))
			word += "A";
		else if (finalWord.equals("-..."))
			word += "B";
		else if (finalWord.equals("-.-."))
			word += "C";
		else if (finalWord.equals("-.."))
			word += "D";
		else if (finalWord.equals("."))
			word += "E";
		else if (finalWord.equals("..-."))
			word += "F"; 
		else if (finalWord.equals("--."))
			word += "G";
		else if (finalWord.equals("...."))
			word += "H";
		else if (finalWord.equals(".."))
			word += "I";
		else if (finalWord.equals(".---"))
			word += "J";
		else if (finalWord.equals("-.-"))
			word += "K";
		else if (finalWord.equals(".-.."))
			word += "L"; 
		else if (finalWord.equals("--"))
			word += "M";
		else if (finalWord.equals("-."))
			word += "N";
		else if (finalWord.equals("---"))
			word += "O";
		else if (finalWord.equals(".--."))
			word += "P";
		else if (finalWord.equals("--.-"))
			word += "Q";
		else if (finalWord.equals(".-."))
			word += "R"; 
		else if (finalWord.equals("..."))
			word += "S"; 
		else if (finalWord.equals("-"))
			word += "T"; 
		else if (finalWord.equals("..-"))
			word += "U"; 
		else if (finalWord.equals("...-"))
			word += "V"; 
		else if (finalWord.equals(".--"))
			word += "W"; 
		else if (finalWord.equals("-..-"))
			word += "X"; 
		else if (finalWord.equals("-.--"))
			word += "Y"; 
		else if (finalWord.equals("--.."))
			word += "Z"; 
		//		System.out.println("word -> "+word+"\nfinalWord -> "+finalWord);
		return word;
	}

    //English to Morse-code plus dictionary
	public void EnglishToMorse() {
		for(int i=0; i<this.phrase.length(); i++) {
			char a = this.phrase.charAt(i);
			if (a == ' ')
				this.translated_phrase +="/ ";
			else if (a == 'A' || a == 'a')
				this.translated_phrase +=".- ";
			else if (a == 'B' || a == 'b')
				this.translated_phrase +="-... ";
			else if (a == 'C' || a == 'c')
				this.translated_phrase +="-.-. ";
			else if (a == 'D' || a == 'd')
				this.translated_phrase +="-.. ";
			else if (a == 'E' || a == 'e')
				this.translated_phrase +=". ";
			else if (a == 'F' || a == 'f')
				this.translated_phrase +="..-. ";
			else if (a == 'G' || a == 'g')
				this.translated_phrase +="--. ";
			else if (a == 'H' || a == 'h')
				this.translated_phrase +=".... ";
			else if (a == 'I' || a == 'i')
				this.translated_phrase +=".. ";
			else if (a == 'J' || a == 'j')
				this.translated_phrase +=".--- ";
			else if (a == 'K' || a == 'k')
				this.translated_phrase +="-.- ";
			else if (a == 'L' || a == 'l')
				this.translated_phrase +=".-.. ";
			else if (a == 'M' || a == 'm')
				this.translated_phrase +="-- ";
			else if (a == 'N' || a == 'n')
				this.translated_phrase +="-. ";
			else if (a == 'O' || a == 'o')
				this.translated_phrase +="--- ";
			else if (a == 'P' || a == 'p')
				this.translated_phrase +=".--. ";
			else if (a == 'Q' || a == 'q')
				this.translated_phrase +="--.- ";
			else if (a == 'R' || a == 'r')
				this.translated_phrase +=".-. ";
			else if (a == 'S' || a == 's')
				this.translated_phrase +="... ";
			else if (a == 'T' || a == 't')
				this.translated_phrase +="- ";
			else if (a == 'U' || a == 'u')
				this.translated_phrase +="..- ";
			else if (a == 'V' || a == 'v')
				this.translated_phrase +="...- ";
			else if (a == 'W' || a == 'w')
				this.translated_phrase +=".-- ";
			else if (a == 'X' || a == 'x')
				this.translated_phrase +="-..- ";
			else if (a == 'Y' || a == 'y')
				this.translated_phrase +="-.-- ";
			else if (a == 'Z' || a == 'z')
				this.translated_phrase +="--.. ";
		}
	}

    public String getTranslated_Phrase(){
        return this.translated_phrase;
    }

    public String getOriginal_Phrase(){
        return this.phrase;
    }

}
