package grade;

public class BasicEvaluation implements GradeEvaluation {

	@Override
	public String getGrade(int point) {

		String grade;
		
		if(point <= 100 && point >= 90) {
			grade = "A";
		}
		else if(point <= 89 && point >= 80) {
			grade = "B";
		}
		else if(point <= 79 && point >= 70) {
			grade = "C";
		}
		else if(point <= 69 && point >= 55) {
			grade = "D";
		}
		else {
			grade = "F";
		}
		return grade;
	}

	
}
