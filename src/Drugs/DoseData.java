package Drugs;

public class DoseData {


    private int dos_id;
    private String dos_quantity;



    public DoseData(int dosid,String dosquantity)
    {
        this.dos_id=dosid;
        this.dos_quantity=dosquantity;
    }

    public int getDos_id() {
        return dos_id;
    }

    public void setDos_id(int dos_id) {
        this.dos_id = dos_id;
    }

    public String getDos_quantity() {
        return dos_quantity;
    }

    public void setDos_quantity(String dos_quantity) {
        this.dos_quantity = dos_quantity;
    }
}
