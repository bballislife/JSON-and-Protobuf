package assignment_1;

import java.io.*;

public class main_class {

    /**
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /* Things to do
            3) serialize and deserialize the object using google protobuf
         */
        double json_ser_time, json_deser_time, json_ser_rate, json_deser_rate;
        double proto_ser_time, proto_deser_time, proto_ser_rate, proto_deser_rate;
        String fl1, fl2;
        fl1 = args[0];
        fl2 = args[1];
        File file_name = new File(args[2]);
        json_serialize js;
        js = new json_serialize();
        json_deserialize jd;
        jd = new json_deserialize();
        proto_serialize ps;
        ps = new proto_serialize();
        proto_deserialize pd;
        pd = new proto_deserialize();
        //serializing json
        if (fl2.equals("-j")) {
            if (fl1.equals("-s")) {
                js.serialize(file_name);
                json_ser_time = js.total_time;
                json_ser_rate = js.file_size / js.total_time;

                System.out.println("Json Serialization : " + json_ser_time + " " + json_ser_rate);
            }
            if (fl1.equals("-d")) {
                jd.deserialize(file_name);
                json_deser_time = jd.total_time;
                json_deser_rate = jd.file_size / jd.total_time;
                System.out.println("Json Deserialization : " + json_deser_time + " " + json_deser_rate);
            }
        } //serializing protobuf
        else if (fl2.equals("-p")) {
            if (fl1.equals("-s") || fl1.equals("-t")) {
                ps.serialize(file_name);
                proto_ser_time = ps.total_time;
                proto_ser_rate = ps.file_size / ps.total_time;
                System.out.println("Protobuf Serialization : " + proto_ser_time + " " + proto_ser_rate);
            }
            if (fl1.equals("-d") || fl1.equals("-t")) {
                pd.deserialize(file_name);
                proto_deser_time = pd.total_time;
                proto_deser_rate = pd.file_size / pd.total_time;
                System.out.println("Protobuf Deserialization : " + proto_deser_time + " " + proto_deser_rate);
            }
        }
    }
}
