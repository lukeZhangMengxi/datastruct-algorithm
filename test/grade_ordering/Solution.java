package test.grade_ordering;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

interface Solution {
    void insert(String name, int grade);
    List<String> show();    
}

class MySolution implements Solution {

    private class Student {
        String name;
        int grade;
        int id;

        Student(String n, int g, int i) {
            this.name = n;
            this.grade = g;
            this.id = i;
        }

        @Override
        public String toString() {
            return this.name + " " + this.grade;
        }
    }

    PriorityQueue<Student> q;
    int counter;

    MySolution(boolean isIncreasing) {
        q = new PriorityQueue<>((a, b) -> {
            if (a.grade != b.grade) return isIncreasing ? a.grade - b.grade : b.grade-a.grade;
            else return a.id - b.id;
        });
        counter = 0;
    }

    @Override
    public void insert(String name, int grade) {
        q.add(new Student(name, grade, counter++));
    }

    @Override
    @SuppressWarnings("serial")
    public List<String> show() {
        return new LinkedList<>() {{
            while (!q.isEmpty()) {
                this.add(q.poll().toString());
            }
        }};
    }

}
