
import java.util.*;

public class quizPlateform {

    static class InvalidQuizSubmissionException extends Exception {

        public InvalidQuizSubmissionException(String message) {
            super(message);
        }
    }

    private String[] correctAnswers;
    private List<Integer> userScores = new ArrayList<>();

    public quizPlateform(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int compareAnswers(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch.");
        }
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        userScores.add(score);
        return score;
    }

    public String getGrade(int score) {
        double percent = (score * 100.0) / correctAnswers.length;
        if (percent >= 90) {
            return "A"; 
        }else if (percent >= 80) {
            return "B"; 
        }else if (percent >= 70) {
            return "C"; 
        }else if (percent >= 60) {
            return "D"; 
        }else {
            return "F";
        }
    }

    public List<Integer> getUserScores() {
        return userScores;
    }
}