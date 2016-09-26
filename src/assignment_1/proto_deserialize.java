package assignment_1;

import com.example.assignment1.ResultProto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class proto_deserialize {

    long sttime, entime;
    double total_time, file_size;

    void deserialize(File f1) throws FileNotFoundException, IOException {

        FileInputStream tmp = new FileInputStream(f1);
        sttime = System.nanoTime();
        ResultProto.Result pf = ResultProto.Result.parseFrom(tmp);
        entime = System.nanoTime();
        write(pf);
        file_size = f1.length() * 8;
        total_time = (entime - sttime) / 1e6;
    }

    static void write(ResultProto.Result pf) throws IOException {

        FileWriter fw = new FileWriter("output_protobuf.txt", true);
        try (BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
            pf.getStudentList().stream().forEach((ResultProto.Student st) -> {
                String s;
                s = st.getName() + ',' + st.getRollNum();
                s = st.getMarksList().stream().map((cm) -> (':' + cm.getName() + ',' + cm.getScore())).reduce(s, String::concat);
                out.println(s);
            });
        }
    }
}
