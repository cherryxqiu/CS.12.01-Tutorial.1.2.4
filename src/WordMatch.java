public class WordMatch {
    private String word;
    public WordMatch (String word) {
        this.word = word;
    }

    public int scoreGuess (String guess) {
        int guessLength = guess.length();
        int guessLengthSquare = guessLength * guessLength;
        if (guessLength > word.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        if (guessLength == 0) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }

        int occurrences = 0;

        for (int i = 0; i < word.length()- guessLength+1; i++) {
            System.out.println(occurrences);
            if(word.substring(i,(i+guessLength)).equals(guess)) {
                occurrences++;

            }



        }

        int score = occurrences*guessLengthSquare;
        return score;


    }

    public String findBetterGuess (String guess1, String guess2) {
        int score1 = scoreGuess(guess1);
        int score2 = scoreGuess(guess2);
        if (score1 > score2) {
            return guess1;
        }
        else if (score2 > score1) {
            return guess2;
        }
        else {
            int alphabeticallyGreater = guess1.compareTo(guess2);
            if (alphabeticallyGreater>0) {
                return guess1;
            }
            return guess2;

        }

    }


}