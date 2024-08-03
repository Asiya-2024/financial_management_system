import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        try {
           List<Employee> employees = CSVReader.readEmployeesFromCSV("employees.csv");
           System.out.println(FinancialOperations.getHourlyRateSum(employees));
           Map<String,List<Employee>> result=FinancialOperations.getEmployeesByDepartment(employees);
           for(Map.Entry<String,List<Employee>> entry:result.entrySet()) {
               List<Employee> employeeList=entry.getValue();
               String department=entry.getKey();
                CSVWriter.writeEmployeesToCSV(employeeList, department + ".csv");
            }
       }
       catch (IOException e) {
            System.out.println(e.getMessage());
       }

    }
}
