package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtil {
    public static Iterator<Object[]> readCsvFile(String path) throws IOException {
        List<Object[]> dataArray = new ArrayList<>();
        String file = FileUtil.class.getResource(path).getFile();
        Reader in = new FileReader(file);
//        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        for (CSVRecord record : records) {
            List<Object> list = new ArrayList<>();

            Iterator<String> it = record.iterator();
            while (it.hasNext()){
                list.add(it.next());

            }
            Object[] objects = list.toArray();
            dataArray.add(objects);


        }
        return dataArray.iterator();
    }

    public static void main(String[] args)throws IOException{
        readCsvFile("/searchkeys.csv");
    }



}
