package com.nhannc2008110306.kiemtracuoiky;

import java.util.Scanner;

public class HangHoa implements Comparable<HangHoa>{
    static Scanner input = new Scanner(System.in);
    private String type;
    //Loai
    //1. Thuc Pham    //2. Sanh Su    //3. Dien May
    private String id = "";       
    //+ khong sua, cung khong the thieu       
    private String name;// ten hang (khong quan trong)
    private int price;// gia nhap vao
    private int storage;// so luong ton kho
    private int date;
    //Khong Xai thu vien java.util.Date vi em khong biet xai

    //cons
    public HangHoa(){

    }
    
    public HangHoa(String type, String id, String name, int price, int storage, int date) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.price = price;
        this.storage = storage;
        this.date = date;
    }
    
    //get - set
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
   

    @Override
    public String toString() {
        return "[Loai Hang: " + this.type +"\t|Ma Hang: " + this.id + " |Ten Hang Hoa: " + 
        this.name + "\t|Gia: " + this.price+" dong" + "\t |SLG Trong Kho: " + this.storage + "\t\t |Ngay: " + this.date + "]";
    }

    @Override
    public int compareTo(HangHoa o) {
        return this.id.compareTo(o.id);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + date;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + price;
        result = prime * result + storage;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HangHoa other = (HangHoa) obj;
        if (date != other.date)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price != other.price)
            return false;
        if (storage != other.storage)
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    

    
    
    
}
