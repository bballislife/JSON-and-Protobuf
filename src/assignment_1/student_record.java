package assignment_1;

import java.util.ArrayList;

public class student_record {

    String Name;
    String RollNo;
    ArrayList<course_detail> CourseMarks = new ArrayList<>();

    // this function converts the given string to the object
    void convert(String s) {
        String[] in = s.split("[,:]");
        Name = in[0];
        RollNo = in[1];
        int sz;
        sz = in.length;
        for (int i = 2; i < sz; i += 2) {
            course_detail tmp;
            tmp = new course_detail();
            tmp.CourseName = in[i];
            tmp.CourseScore = in[i + 1];
            CourseMarks.add(tmp);
        }
    }
}
