import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void writeEmployeesToCSV(List<Employee> employees, String file) throws IOException
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            bw.write("id,name,salary,position,department,hourly_rate\n");
            for(Employee emp : employees)
            {
                int id=emp.getId();
                String name=emp.getName();
                String department=emp.getDepartment();
                String position=emp.getPosition();
                double salary=emp.getSalary();
                double hourly_rate=emp.getHourly_rate();


                bw.write(String.format("%d,%s,%f,%s,%s,%f\n",id,name,salary,position,department,hourly_rate));
            }
        }
    }

}
