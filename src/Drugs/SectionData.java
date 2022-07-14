package Drugs;

public class SectionData {

    private int sec_id;
    private String sec_name;



    public SectionData(int secID,String secName)
    {
        this.sec_id=secID;
        this.sec_name=secName;
    }

    public int getSec_id() {
        return sec_id;
    }

    public void setSec_id(int sec_id) {
        this.sec_id = sec_id;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }
}
