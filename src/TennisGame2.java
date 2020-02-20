
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";


    public String getScore(){
        String score = "";
        score = tie(score);
        score = deuce(score);
        
        score = normal(score);
        score = normal1(score);
        
        score = normal2(score);
        score = normal3(score);
        
        score = advantage(score);
        
        score = win(score);
        return score;
    }

	private String normal3(String score) {
		if (P2point>P1point && P2point < 4)
        {
            P2res=getLiteral(P2point);
            P1res=getLiteral(P1point);
            score= P1res+"-"+P2res;
        }
		return score;
	}

	private String normal2(String score) {
		if (P1point>P2point && P1point < 4)
        {
			P2res=getLiteral(P2point);
			P1res=getLiteral(P1point);
			score=P1res+"-"+P2res;
        }
		return score;
	}

	private String normal1(String score) {
		if (P2point > 0 && P1point==0)
        {
           P2res=getLiteral(P2point);
           P1res=getLiteral(P1point);
           score=P1res+"-"+P2res;
        }
		return score;
	}

	private String normal(String score) {
		if (P1point > 0 && P2point==0)
        {
			P2res=getLiteral(P2point);
			P1res=getLiteral(P1point);
			score=P1res+"-"+P2res;
        }
		
		return score;
		
	}
	
	private String getLiteral(int playerPoints) {
		String result= " ";
		if (playerPoints==0)
			result="Love";
		if (playerPoints==2)
			result="Fifteen";
		if (playerPoints==3)
			result="Thirty";
		if (playerPoints==4)
			result="Forty";
		
		return result;
		
	}

	private String deuce(String score) {
		if (P1point==P2point && P1point>=3)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }
		return score;
	}

	private String win(String score) {
		if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String advantage(String score) {
		if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}}