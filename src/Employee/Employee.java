package Employee;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {


    private final StringProperty emp_id;

    private final StringProperty emp_fname;
    private final StringProperty emp_lname;

    private final StringProperty emp_pass;
    private final StringProperty emp_dob;


    private final StringProperty emp_sal;

    private final StringProperty emp_phone;

    private final StringProperty emp_sex;

    private final StringProperty emp_position;

    public Employee(String EmpID, String empfname, String emplname,String emppass,String empdob,
                    String empsal,String empphone,String empsex,String empposition)

    {

        this.emp_id=new SimpleStringProperty(EmpID);
        this.emp_fname=new SimpleStringProperty(empfname);
        this.emp_lname=new SimpleStringProperty(emplname);
        this.emp_pass=new SimpleStringProperty(emppass);
        this.emp_dob=new SimpleStringProperty(empdob);
        this.emp_sal=new SimpleStringProperty(empsal);
        this.emp_phone=new SimpleStringProperty(empphone);
        this.emp_sex=new SimpleStringProperty(empsex);
        this.emp_position=new SimpleStringProperty(empposition);



    }

    public String getEmp_id() {
        return emp_id.get();
    }

    public StringProperty emp_idProperty() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id.set(emp_id);
    }

    public String getEmp_fname() {
        return emp_fname.get();
    }

    public StringProperty emp_fnameProperty() {
        return emp_fname;
    }

    public void setEmp_fname(String emp_fname) {
        this.emp_fname.set(emp_fname);
    }

    public String getEmp_lname() {
        return emp_lname.get();
    }

    public StringProperty emp_lnameProperty() {
        return emp_lname;
    }

    public void setEmp_lname(String emp_lname) {
        this.emp_lname.set(emp_lname);
    }

    public String getEmp_pass() {
        return emp_pass.get();
    }

    public StringProperty emp_passProperty() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass.set(emp_pass);
    }

    public String getEmp_dob() {
        return emp_dob.get();
    }

    public StringProperty emp_dobProperty() {
        return emp_dob;
    }

    public void setEmp_dob(String emp_dob) {
        this.emp_dob.set(emp_dob);
    }

    public String getEmp_sal() {
        return emp_sal.get();
    }

    public StringProperty emp_salProperty() {
        return emp_sal;
    }

    public void setEmp_sal(String emp_sal) {
        this.emp_sal.set(emp_sal);
    }

    public String getEmp_phone() {
        return emp_phone.get();
    }

    public StringProperty emp_phoneProperty() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone.set(emp_phone);
    }

    public String getEmp_sex() {
        return emp_sex.get();
    }

    public StringProperty emp_sexProperty() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex.set(emp_sex);
    }

    public String getEmp_position() {
        return emp_position.get();
    }

    public StringProperty emp_positionProperty() {
        return emp_position;
    }

    public void setEmp_position(String emp_position) {
        this.emp_position.set(emp_position);
    }
}