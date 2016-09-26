package assignment_1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class json_deserialize {

    student_record[] st;
    long sttime, entime;
    double file_size, total_time;

    void deserialize(File f1) throws FileNotFoundException, IOException {
        file_size = f1.length() * 8;
        try (FileReader fr = new FileReader(f1)) {
            BufferedReader br = new BufferedReader(fr);
            sttime = System.nanoTime();
            st = new Gson().fromJson(br, student_record[].class);
            entime = System.nanoTime();
        }
        // deserialization of the object using json

        try (FileWriter fw = new FileWriter("output_json.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            for (student_record i : st) {
                String tmp;
                tmp = i.Name + ',' + i.RollNo;
                tmp = i.CourseMarks.stream().map((j) -> (':' + j.CourseName + ',' + j.CourseScore)).reduce(tmp, String::concat);
                out.println(tmp);
            }
        }
        total_time = (entime - sttime) / 1e6;
    }
}
