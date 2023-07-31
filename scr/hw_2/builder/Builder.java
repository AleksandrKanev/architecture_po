package hw_2.builder;
// В данном примере рассматривается паттерн Строитель. EmployeeBuilder объединяет в себе класс конкретного сторителя и
// распорядителя(директора). При добавлении строителей необходимо вывести в отдельный класс директора и с помощью
// интерфейса строителя реализацию определить в конкретных строителях.
class Employee {

    private String name;
    private String company;


    private  Employee(EmployeeBuilder employeeBuilder){
        name = employeeBuilder.name;
        company = employeeBuilder.company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }
    static class EmployeeBuilder{
        private final String name;
        private  String company;

        public EmployeeBuilder(String name) {
            this.name = name;
        }
        public EmployeeBuilder setCompany(String company) {
            this.company = company;
            return this;
        }
        Employee build(){
            return  new Employee(this);
        }


    }

}

class Main{
    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder("Alex").setCompany("Apple").build();
        System.out.println(employee.getCompany());
    }
}
