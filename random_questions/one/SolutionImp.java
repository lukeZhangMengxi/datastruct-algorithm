package random_questions.one;

import java.util.PriorityQueue;

public class SolutionImp implements Solution {

    private int[] studentGrades;

    @Override
    public void init(int N, int[] nums) {
        this.studentGrades = new int[N];
        for (int i=0; i<N; i++) {
            this.studentGrades[i] = nums[i];
        }
    }

    @Override
    public int queryMaxGrade(int startStudentId, int endStudentId) {
        if (startStudentId > endStudentId) {
            int tmp = startStudentId;
            startStudentId = endStudentId;
            endStudentId = tmp;
        }

        PriorityQueue<Integer> grades = new PriorityQueue<>(
            endStudentId - startStudentId +1,
            (a, b) -> b - a
        );
        for (int i=startStudentId-1; i<endStudentId; i++) {
            grades.add(studentGrades[i]);
        }
        return grades.peek();
    }

    @Override
    public void updateGrade(int studentId, int grade) {
        this.studentGrades[studentId-1] = grade;
    }
    
}
