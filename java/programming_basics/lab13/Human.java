public class Human {
    private String name;
    private final int year;
    private String tel;
    public Human(String fio, int year, String phone_number) {
        this.name = fio;
        this.year = year;
        this.tel = phone_number;
    }
    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public String getTel() {
        return tel;
    }

}
