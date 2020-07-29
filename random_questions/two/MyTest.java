package random_questions.two;

import org.junit.Test;

public class MyTest {

    @Test
    public void simpleTestCase() {
        Solution m = new SolutionImpl();

        m.storeError("E:\\V1R2\\product\\fpgadrive.caaaaa 1325");
        m.storeError("E:\\V1R2\\product\\fpgadrive.caaaaa 1325");
        m.storeError("E:\\XXXX\\product\\fpgadrive.caaaaa 1325");
        m.storeError("E:\\XXXX\\product\\aaaaaaaafpgadrive.caaaaa 1325");

        assert(m.showResult().compareTo("fpgadrive.caaaaa 1325 1 fpgadrive.caaaaa 1325 3") == 0);

    }

    @Test
    public void firstError() {
        Solution m = new SolutionImpl();

        String[] inputs = "e:\\1\\aa3.txt 3 e:\\3\\aa1.txt 2 e:\\2\\aa2.txt 3 e:\\3\\aa1.txt 1 e:\\1\\aa1.txt 3 e:\\3\\aa1.txt 2 e:\\1\\aa3.txt 3 e:\\2\\aa3.txt 2 e:\\1\\aa1.txt 2 e:\\3\\aa3.txt 2 e:\\1\\aa2.txt 2 e:\\1\\aa3.txt 1 e:\\1\\aa3.txt 1 e:\\2\\aa3.txt 2 e:\\1\\aa2.txt 1 e:\\3\\aa1.txt 2 e:\\1\\aa1.txt 3 e:\\2\\aa1.txt 1 e:\\3\\aa3.txt 2 e:\\1\\aa1.txt 1 e:\\2\\aa2.txt 2 e:\\3\\aa3.txt 2 e:\\1\\aa2.txt 1 e:\\1\\aa3.txt 2 e:\\1\\aa3.txt 3 e:\\1\\aa2.txt 3 e:\\3\\aa1.txt 3 e:\\2\\aa2.txt 2 e:\\1\\aa1.txt 1 e:\\2\\aa3.txt 1 e:\\3\\aa1.txt 1 e:\\2\\aa1.txt 3 e:\\3\\aa3.txt 2 e:\\1\\aa3.txt 3 e:\\2\\aa3.txt 3 e:\\1\\aa2.txt 3 e:\\2\\aa2.txt 1 e:\\1\\aa3.txt 1 e:\\1\\aa3.txt 1 e:\\3\\aa3.txt 3 e:\\3\\aa3.txt 2 e:\\1\\aa2.txt 3 e:\\1\\aa2.txt 3 e:\\1\\aa2.txt 3 e:\\1\\aa1.txt 1 e:\\2\\aa3.txt 1 e:\\3\\aa3.txt 1 e:\\2\\aa3.txt 2 e:\\3\\aa1.txt 3 e:\\2\\aa2.txt 2 e:\\2\\aa2.txt 2 e:\\2\\aa3.txt 1 e:\\1\\aa3.txt 3 e:\\3\\aa1.txt 2 e:\\3\\aa2.txt 2 e:\\1\\aa2.txt 1 e:\\2\\aa2.txt 1 e:\\2\\aa1.txt 2 e:\\2\\aa2.txt 1 e:\\1\\aa2.txt 1 e:\\2\\aa3.txt 1 e:\\2\\aa2.txt 1 e:\\2\\aa1.txt 2 e:\\3\\aa2.txt 3 e:\\3\\aa1.txt 3 e:\\2\\aa2.txt 3 e:\\2\\aa3.txt 1 e:\\3\\aa3.txt 2 e:\\2\\aa3.txt 1 e:\\1\\aa1.txt 2 e:\\3\\aa3.txt 1 e:\\3\\aa1.txt 1 e:\\2\\aa2.txt 3 e:\\3\\aa3.txt 2 e:\\2\\aa1.txt 3 e:\\1\\aa3.txt 3 e:\\3\\aa2.txt 1 e:\\2\\aa1.txt 3 e:\\1\\aa3.txt 3 e:\\2\\aa2.txt 2 e:\\1\\aa1.txt 2 e:\\3\\aa1.txt 1 e:\\1\\aa3.txt 1 e:\\3\\aa1.txt 2 e:\\1\\aa1.txt 2 e:\\1\\aa1.txt 3 e:\\3\\aa1.txt 1 e:\\3\\aa1.txt 1 e:\\2\\aa3.txt 3 e:\\2\\aa2.txt 1 e:\\2\\aa1.txt 2 e:\\2\\aa2.txt 1 e:\\3\\aa2.txt 3 e:\\1\\aa2.txt 1 e:\\3\\aa2.txt 2 e:\\2\\aa1.txt 1 e:\\2\\aa3.txt 3 e:\\1\\aa1.txt 2 e:\\1\\aa1.txt 1 e:\\1\\aa1.txt 2".split(" ");

        for (int i=0; i<inputs.length-1; i+=2) {
            m.storeError(inputs[i] + " " + inputs[i+1]);
        }

        assert(m.showResult().compareTo("aa1.txt 2 14 aa3.txt 1 13 aa1.txt 1 12 aa2.txt 1 12 aa3.txt 3 11 aa3.txt 2 11 aa2.txt 3 10 aa1.txt 3 9") == 0);

    }

}
