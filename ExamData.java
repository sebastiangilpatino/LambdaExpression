package LmbdaHW;

public class ExamData {
	private String studentName;
	private double testScore;

	public ExamData(String name, double score) {
		this.studentName = name;
		this.testScore = score;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the testScore
	 */
	public double getTestScore() {
		return testScore;
	}

	/**
	 * @param testScore the testScore to set
	 */
	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}

}
