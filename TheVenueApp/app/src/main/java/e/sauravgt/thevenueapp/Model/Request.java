package e.sauravgt.thevenueapp.Model;

import java.util.List;

public class Request {
    private String status;

    private String phone;
    private String name;
    private String  date;
    private String total;
    private List<Order> foods; // list of food order

    public Request() {

    }

    public Request(String phone, String name, String date, String total, List<Order> foods) {
        this.phone = phone;
        this.name = name;
        this.date = date;
        this.total = total;
        this.foods = foods;
        this.status ="0"; // default is 0, 0:booked, 1: shipping, 2 shipped
    }
     public String getStatus () {
        return status;
     }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
