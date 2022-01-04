package com.nhannc2008110306.kiemtracuoiky;

import java.util.ArrayList;
import java.util.Scanner;

public class HangHoaList {
    static Scanner input = new Scanner(System.in);
    //private HangHoa hh_canT = new HangHoa();//them mot dt can sua
    ArrayList<HangHoa> hh_list;
    //cons
    public HangHoaList(){
        this.hh_list = new ArrayList<>();
    }

    public HangHoaList(ArrayList<HangHoa> hh_list) {
        this.hh_list = hh_list;
    }

    //Method
    //them
    public void them(HangHoa hh){
        this.hh_list.add(hh);
    }
    //xoa    
    public void xoa(String id) {         
        hh_list.remove(hienThiEitherMang(hh_list, id));
        hienThi();
    }
    //sua
    public void sua(HangHoa hh, String id){
        for (int i =0; i < hh_list.size(); i++){
            if(hh_list.get(i).getId().equals(id)){
                System.out.print("Nhap Ten Hang Hoa           : "); 
                String name = input.next();
                System.out.print("Nhap Nhap Gia               : "); 
                int price = input.nextInt();
                System.out.print("Nhap So Luong Ton Kho       : "); 
                int storage= input.nextInt();
                System.out.print("Nhap Ngay                   : "); 
                int date = input.nextInt();
                HangHoa hh_E = new HangHoa( null, id, name, price, storage, date);
                if(hh_E.getDate() >0 && hh_E.getDate() <=31 && hh_E.getPrice() >=0 && hh_E.getStorage() >= 0){                    
                    hh_list.get(i).setName(name);
                    hh_list.get(i).setPrice(price);
                    hh_list.get(i).setStorage(storage);
                    hh_list.get(i).setDate(date);
                }else{
                    System.out.println("Loi!");
                }                
            }            
        }
    }
    //timkiem 
    public void timKiemLoai(String type){
        for (HangHoa hangHoa : hh_list) {
            if (hangHoa.getType().equals(type)){
                System.out.println(hangHoa);                                                      
            }
        }
    }
    public void timKiemGia(int s, int e) {
        //s start, e end
        if (e < s) {
            System.out.println("Gia khong hop le.");
            return;
        }else{            
            // sapXepGia(true);            // 
            // int l = 0;
            // int r = hh_list.size() - 1;
            // while ( l<= r){
            //     int m = (l+ r)/2; 
            //     for (HangHoa hangHoa : hh_list) {
            //         if (hangHoa.getPrice() <=s && hangHoa.getPrice() <=e ){                        
            //             System.out.println(hangHoa.getPrice() == m+1);
            //         }else if (hangHoa.getPrice() >=m && hangHoa.getPrice() >=e){                        
            //             System.out.println(hangHoa.getPrice() == m-1);
            //         }else{
            //             System.out.println(hangHoa.getPrice() == m);
            //         }
            //     }            
            // }               
            ArrayList<HangHoa> listSrc = new ArrayList<>();
            for (HangHoa hh : hh_list) {
                if (hh.getPrice() >= s && hh.getPrice() <= e) {
                    listSrc.add(hh);
                }
            }
            if (listSrc.size() > 0)
                hienThiDanhSachMoi(listSrc);
        }
    }
    public void timKiemNgay(int s, int e) {
        //s start, e end
        if (e < s) {
            System.out.println("Gia khong hop le.");
            return;
        }else{     
            ArrayList<HangHoa> listSrc = new ArrayList<>();
            for (HangHoa hh : hh_list) {
                if (hh.getDate() >= s && hh.getDate() <= e) {
                    listSrc.add(hh);
                }
            }
            if (listSrc.size() > 0)
                hienThiDanhSachMoi(listSrc);
        }
    }
    //sap xep
    public void sapXepGia(boolean pt) {
        if (pt) {
            HangHoa hh = new HangHoa();
            for (int i = 0; i < hh_list.size() - 1; i++) {
                for (int j = 0; j < hh_list.size() - 1 - i; j++) {
                    if (hh_list.get(j).getPrice() > hh_list.get(j + 1).getPrice()) {

                        hh = hh_list.get(j);
                        hh_list.set(j, hh_list.get(j + 1));
                        hh_list.set(j + 1, hh);

                    }
                }
            }
            hienThiDanhSachMoi(hh_list);
        }
        if (!pt) {
            HangHoa hh = new HangHoa();
            for (int i = 0; i < hh_list.size() - 1; i++) {
                for (int j = 0; j < hh_list.size() - 1 - i; j++) {
                    if (hh_list.get(j).getPrice() < hh_list.get(j + 1).getPrice()) {

                        hh = hh_list.get(j);
                        hh_list.set(j, hh_list.get(j + 1));
                        hh_list.set(j + 1, hh);

                    }
                }
            }
            hienThiDanhSachMoi(hh_list);
        }
    }
    public void sapXepNgay(boolean pt) {
        if (pt) {
            HangHoa hh = new HangHoa();
            for (int i = 0; i < hh_list.size() - 1; i++) {
                for (int j = 0; j < hh_list.size() - 1 - i; j++) {
                    if (hh_list.get(j).getDate() > hh_list.get(j + 1).getDate()) {

                        hh = hh_list.get(j);
                        hh_list.set(j, hh_list.get(j + 1));
                        hh_list.set(j + 1, hh);

                    }
                }
            }
            hienThiDanhSachMoi(hh_list);
        }
        if (!pt) {
            HangHoa hh = new HangHoa();
            for (int i = 0; i < hh_list.size() - 1; i++) {
                for (int j = 0; j < hh_list.size() - 1 - i; j++) {
                    if (hh_list.get(j).getDate() < hh_list.get(j + 1).getDate()) {

                        hh = hh_list.get(j);
                        hh_list.set(j, hh_list.get(j + 1));
                        hh_list.set(j + 1, hh);

                    }
                }
            }
            hienThiDanhSachMoi(hh_list);
        }
    }
    //thong ke
    public void tkeTongSoLuongHangHoa() {
        int tong = 0;
        for (HangHoa hangHoa : hh_list) {
            tong = tong + hangHoa.getStorage();
        }
        System.out.println("Tong: " +tong + " cai");
    }
    public void tkeTongGiatriNhapKho() {
        int tong = 0;
        for (HangHoa hangHoa : hh_list) {
            tong = tong + hangHoa.getPrice();
        }
        System.out.println("Tong: "+ tong +"$");
    }
    public void tkeSoLuongTungHangHoa() {
        int tongSoLuongTP = 0;
        int tongSoLuongSS = 0;
        int tongSoLuongDM = 0;        
        for (HangHoa hh : hh_list) {
            if (hh.getType().equals("ThucPham")) {
                tongSoLuongTP = tongSoLuongTP + hh.getStorage();
            }
        }
        System.out.println("So Luong Thuc Pham: " + tongSoLuongTP + " cai");
        for (HangHoa hh : hh_list) {
            if (hh.getType().equals("SanhSu")) {
                tongSoLuongSS = tongSoLuongSS + hh.getStorage();
            }
        }
        System.out.println("So Luong Sanh Su: " + tongSoLuongSS + " cai");
        for (HangHoa hh : hh_list) {
            if (hh.getType().equals("DienMay")) {
                tongSoLuongDM = tongSoLuongDM + hh.getStorage();
            }
        }
        System.out.println("So Luong Dien May: " + tongSoLuongDM + " cai");
    }
    //Other - Testing
    //========================================    
    //Show Model
    public void hienThiDoiTuong(HangHoa hh){        
            System.out.println(hh.toString());        
    }
    //Show Eech Data
    public void name() {
        
    }
    //Show Each Array
    public int hienThiEitherMang(ArrayList<HangHoa> hh_sea, String id){
        for (int i = 0; i < hh_sea.size(); i++) {
            if (hh_sea.get(i).getId().equals(id))
                return i;
        }
        return 0;
    }
    //Show
    public void hienThi() {
        for (int i = 0; i < hh_list.size(); i++) {
            System.out.println(hh_list.get(i).toString());            
        }
    }
    //Show New Arraylist
    public void hienThiDanhSachMoi(ArrayList<HangHoa> hh_list_new) {
        for (int i = 0; i < hh_list_new.size(); i++) {
            System.out.println(hh_list_new.get(i).toString());
        }
    }
    //toString
    public void xuat(){
        for (HangHoa hangHoa : hh_list) {
            System.out.println(hangHoa);
        }
    }
}
