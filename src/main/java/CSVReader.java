import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Employee> readEmployeesFromCSV(String file) throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
        List<Employee> employees = new ArrayList<Employee>();
        String line = null;
        br.readLine();
        while((line=br.readLine())!=null)
        {
            String[] tokens = line.split(",");
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(tokens[0]));
            employee.setName(tokens[1]);
            employee.setSalary(Double.parseDouble(tokens[2]));
            employee.setPosition(tokens[3]);
            employee.setDepartment(tokens[4]);
            employee.setHourly_rate(Double.parseDouble(tokens[5]));
            employees.add(employee);
        }
        return employees;
        }
    }
}
