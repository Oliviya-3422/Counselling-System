class Student {
    
    private String name;
    private String rollNo;
    private int Total;
    private float cutOff;

    public Student(String rollNo, String name, int total, float cutOff) {
        this.rollNo = rollNo;
        this.name = name;
        this.Total = total;
        this.cutOff = cutOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }
    
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public float getCutOff() {
        return cutOff;
    }

    public void setCutOff(float cutOff) {
        this.cutOff = cutOff;
    }

    public void printStudent() {
    }
}
