package Employee;

public enum option {

    Admin,Manager,User;

    private option(){}

    public String value(){
        return name();
    }

    public static option fromvalue(String v)
    {
        return valueOf(v);
    }

}
