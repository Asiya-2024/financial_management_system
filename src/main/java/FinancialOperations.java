import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FinancialOperations {
    public static double getHourlyRateSum(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getHourly_rate).sum();
    }

    public static double sumDepartmentSalary(List<Employee> employees, String dept) {
        return employees.stream().filter(e -> (e.getDepartment().equalsIgnoreCase(dept))).mapToDouble(Employee::getSalary).sum();
    }

    public static double getAverageSalaryByDepartment(List<Employee> employees, String department) {
        return employees.stream().filter(e -> (e.getDepartment().equalsIgnoreCase(department))).mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public static double sumDepartmentHourlyRate(List<Employee> employees, String department) {
        return employees.stream().filter(e -> (e.getDepartment().equalsIgnoreCase(department))).mapToDouble(Employee::getHourly_rate).sum();
    }
    public static double getAverageHourlyRateByDepartment(List<Employee> employees, String department)
    {
        return employees.stream().filter(e -> (e.getDepartment().equalsIgnoreCase(department))).mapToDouble(Employee::getHourly_rate).average().orElse(0);
    }
    public static Map<String, Double> getTotalSalaryByDepartment(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));

    }
    public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }
    public static Map<String, Double> getTotalHourlyRateByDepartment(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getHourly_rate)));
    }
    public static Map<String, Double> getAverageHourlyRateByDepartment(List<Employee> employees)
    {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getHourly_rate)));
    }
   public static Map<String,List<Employee>> getEmployeesByDepartment(List<Employee> employees) throws IOException
   {
       return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));
   }
}