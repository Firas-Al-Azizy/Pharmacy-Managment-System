package Drugs;

public class FormData {


    private int for_id;
    private String for_name;



    public FormData(int forID,String forName)
    {
        this.for_id=forID;
        this.for_name=forName;
    }

    public int getFor_id() {
        return for_id;
    }

    public void setFor_id(int for_id) {
        this.for_id = for_id;
    }

    public String getFor_name() {
        return for_name;
    }

    public void setFor_name(String for_name) {
        this.for_name = for_name;
    }
}
