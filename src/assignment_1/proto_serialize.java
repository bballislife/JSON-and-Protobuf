package assignment_1;

import com.example.assignment1.ResultProto.CourseMarks;
import com.example.assignment1.ResultProto.Result;
import com.example.assignment1.ResultProto.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class proto_serialize {

    double file_size, total_time;
    long sttime, entime;

    ArrayList<student_record> students = new ArrayList<>();

    void serialize(File f2) throws IOException {
        try (FileReader fr = new FileReader(f2)) {
            BufferedReader br = new BufferedReader(fr);
            String s;

            while ((s = br.readLine()) != null) {
                student_record tmp;
                tmp = new student_record();
                tmp.convert(s);
                students.add(tmp);
            }
        }

        Result.Builder res = Result.newBuilder();
        students.stream().forEach((i) -> {
            res.addStudent(add(i));
        });
        byte[] bt;
        sttime = System.nanoTime();
        bt = res.build().toByteArray();
        entime = System.nanoTime();
        total_time = (entime - sttime) / 1e6;
        file_size = f2.length() * 8;
        FileOutputStream f = new FileOutputStream(new File("result_protobuf"));
            f.write(bt);
    }

    static Student add(student_record st) {
        Student.Builder tmp = Student.newBuilder();
        tmp.setName(st.Name);
        int i = Integer.parseInt(st.RollNo);
        tmp.setRollNum(i);
        for (course_detail j : st.CourseMarks) {
            CourseMarks.Builder cs = CourseMarks.newBuilder();
            cs.setName(j.CourseName);
            int k = Integer.parseInt(j.CourseScore);
            cs.setScore(k);
            tmp.addMarks(cs);
        }
        return tmp.build();
    }

}
