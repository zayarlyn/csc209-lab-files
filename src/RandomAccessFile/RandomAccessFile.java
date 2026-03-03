import java.io.*;
import java.util.*;

class Record {
    int id;
    String name;

    Record(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class RacReader {

    static Record readRecordAt(RandomAccessFile file, long pos) throws IOException {
        file.seek(pos);
        int id = file.readInt();
        String name = file.readUTF();
        return new Record(id, name);
    }

    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("data.dat", "r");

            Vector<Long> pointers = new Vector<>();

            while (file.getFilePointer() < file.length()) {
                long pos = file.getFilePointer();
                pointers.add(pos);

                file.readInt();
                file.readUTF();
            }

            Collections.sort(pointers, new Comparator<Long>() {
                @Override
                public int compare(Long p1, Long p2) {
                    try {
                        Record r1 = readRecordAt(file, p1);
                        Record r2 = readRecordAt(file, p2);
                        return Integer.compare(r1.id, r2.id); // sort by ID
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            System.out.println("Records in sorted order:");
            for (Long pos : pointers) {
                Record r = readRecordAt(file, pos);
                System.out.println(r.id + " " + r.name);
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
