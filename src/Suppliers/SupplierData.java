package Suppliers;

public class SupplierData {


    private int sup_id;
    private String sup_name;
    private String sup_address;
    private int sup_phone;



    public SupplierData(int supID,String supName,String supAddress,int supPhone)
    {
        this.sup_id=supID;
        this.sup_name=supName;
        this.sup_address=supAddress;
        this.sup_phone=supPhone;
    }

    public int getSup_id() {
        return sup_id;
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_address() {
        return sup_address;
    }

    public void setSup_address(String sup_address) {
        this.sup_address = sup_address;
    }

    public int getSup_phone() {
        return sup_phone;
    }

    public void setSup_phone(int sup_phone) {
        this.sup_phone = sup_phone;
    }
}
