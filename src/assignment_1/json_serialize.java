package assignment_1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class json_serialize {

    ArrayList<student_record> students = new ArrayList<>();
    long sttime, entime;
    double total_time, file_size;

    void serialize(File f2) throws IOException {
        file_size = f2.length() * 8;
        try (FileReader fr = new FileReader(f2)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                student_record tmp;
                tmp = new student_record();
                tmp.convert(s);
                students.add(tmp);
            }
            Gson obj = new Gson();
            sttime = System.nanoTime();
            String lol = obj.toJson(students);          // serialization of the object
            entime = System.nanoTime();
            total_time = (entime - sttime) / 1e6;
            try (PrintWriter out = new PrintWriter("result.json")) {
                out.println(lol);
            }
        }
    }
}
