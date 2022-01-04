package com.nhannc2008110306.kiemtracuoiky;

import java.util.Scanner;

public class QuanLyHangHoaTestDrive {
    static Scanner input = new Scanner(System.in);    
    public static void main(String[] args) { 
        
        //list
        //ArrayList<HangHoa> hh_list = new ArrayList<>();
        HangHoaList hh_list = new HangHoaList();
        //thucpham
        // hh_list.them(new ThucPham("ThucPham", "TP001", "Test", 0, 0, 1));
        // hh_list.them(new SanhSu("SanhSu", "SS002", "Test", 0, 0, 1));
        // hh_list.them(new DienMay("DienMay", "DM003", "Test", 0, 0, 1));

        hh_list.them(new ThucPham("ThucPham", "TP984", "DuiGa", 45000, 65, 12));
        hh_list.them(new ThucPham("ThucPham", "TP147", "Thit", 37000, 134, 24));
        hh_list.them(new ThucPham("ThucPham", "TP147", "Quyt", 12000, 692, 13));
        hh_list.them(new ThucPham("ThucPham", "TP147", "ThitHeo", 97500, 563, 18));

        hh_list.them(new SanhSu("SanhSu", "SS002", "Binh Gom", 153000, 9, 11));
        hh_list.them(new SanhSu("SanhSu", "SS002", "Chen", 30100, 345, 27));
        hh_list.them(new SanhSu("SanhSu", "SS002", "Dia", 46000, 120, 21));
        hh_list.them(new SanhSu("SanhSu", "SS002", "LySu", 26000, 544, 18));
        
        
        hh_list.them(new DienMay("DienMay", "SS120", "Tivi", 22700000, 8, 31));
        hh_list.them(new DienMay("DienMay", "SS120", "MayTinh", 15350999, 6, 20));
        hh_list.them(new DienMay("DienMay", "SS120", "TuLanh", 15370000, 8, 1));
        hh_list.them(new DienMay("DienMay", "SS120", "MayGiat", 13550000, 10, 6));
        
        int chon = -1;        
        do {
            //Danh Sach
            System.out.println("\n\n=====\nXuat Danh Sach.\n=====");
            hh_list.xuat();
            //Thiet Ke Menu Dau Vao
            //====================================================================================================================             
            System.out.println("=====");
            System.out.println("Menu Chinh");
            System.out.println("=====");            
            System.out.println("* Khong Chon Cac Chuc Nang Duoc Liet Ke Ben Duoi De Xuat Danh Sach");                        
            System.out.println("0. Thoat");
            System.out.println("1. Them Hang Hoa Vao Danh Sach");
            System.out.println("2. Xoa Hang Hoa Khoi Danh Sach");
            System.out.println("3. Sua Hang Hoa Trong Danh Sach");
            System.out.println("4. Tim Kiem Hang Hoa Trong Danh Sach");
            System.out.println("5. Sap Xep Hang Hoa Trong Danh Sach");
            System.out.println("6. Thong Ke Hang Hoa Trong Danh Sach");
            //====================================================================================================================
            System.out.print("\nMoi Ban Chon Chuc Nang:");
            chon = input.nextInt();
            //====================================================================================================================                           
            switch (chon) {
                //====================================================
                case 0: System.out.println("=====\nThoat\n=====\n");break;
                //====================================================
                case 1:
                    System.out.print("Moi Ban Nhap So Luong Can Them: ");
                    int c1 = input.nextInt();
                    for (int i =0; i < c1 ; i++){
                        System.out.println("\n=====\nYeu Cau (Neu Khong Dung Thi Khong Hop Le)\n=====\n+ Ma Hang Hoa Luon Bat Dau Tu \"TP\" chi Thuc Pham \"SS\" chi Sanh Su \"DM\" chi Dien May\n+ Khong Nhan Space Khi Nhap Ten Hang\n+ So Luong Va Gia Luon Lon Hon Hoac Bang 0\n+ Ngay > 0 Hoac <= 31");                        
                        System.out.print("Nhap Ma Hang Hoa            : "); 
                        String id = input.next();
                        System.out.print("Nhap Ten Hang Hoa           : "); 
                        String name = input.next();
                        System.out.print("Nhap Nhap Gia               : ");
                        int price = input.nextInt();
                        System.out.print("Nhap So Luong Ton Kho       : "); 
                        int storage= input.nextInt();
                        System.out.print("Nhap Ngay                   : "); 
                        int date = input.nextInt();
                        HangHoa hh = new HangHoa(null, id, name, price, storage, date);
                        if(hh.getDate() >0 && hh.getDate() <=31 && hh.getPrice() >=0 && hh.getStorage() >= 0){
                            if(hh.getId().startsWith("TP")){
                                hh.setType("ThucPham");
                                hh_list.them(hh);
                            }
                            if(hh.getId().startsWith("SS")){
                                hh.setType("SanhSu");
                                hh_list.them(hh);
                            }
                            if(hh.getId().startsWith("DM")){
                                hh.setType("DienMay");
                                hh_list.them(hh);
                            }
                            else{
                                System.out.println("Ma Hop Khong Hop Le Hoac Khong Tim Thay Trong Loai Hang Ton Tai.");
                            }
                        }else{
                            System.out.println("Khong Hop Le. Vui Long Nhap Ngay, SL, Gia Chinh Xac (SL Hoac Gia bat buoc > hoac bang 0)");
                        }                    
                    }
                    break;
                //====================================================
                case 2:
                    System.out.print("Moi Ban Nhap So Luong Can Xoa: ");
                    int c2 = input.nextInt();
                    for (int i =0; i < c2 ; i++){
                        System.out.print("Nhap Ma Hang Hoa            : "); 
                        String id = input.next();
                        // HangHoa hh = new HangHoa(null, id, null, 0, 0, 0);                        
                        hh_list.xoa(id);                     
                    }
                    break;
                //====================================================
                case 3:
                    System.out.print("Moi Ban Nhap So Luong Can Sua: ");
                    int c3 = input.nextInt();
                    for (int i =0; i < c3 ; i++){
                        System.out.print("Nhap Ma Hang Hoa            : "); 
                        String id = input.next();
                        HangHoa hh = new HangHoa(null, id, null, 0, 0, 0);                        
                        hh_list.sua(hh, id);                     
                }
                    break;
                //==================================================== 
                case 4:
                    int tk_type= -1;
                    do {
                        // System.out.print("Moi Ban Nhap So Luong Can Tim: ");
                        // int c4 = input.nextInt();
                        System.out.println("Chon Loai Tim Kiem");
                        System.out.println("1. Tim Kiem Theo Loai");
                        System.out.println("2. Tim Kiem Theo Gia");
                        System.out.println("3. Tim Kiem Theo Ngay");
                        System.out.print("Moi Ban Nhap: ");
                        tk_type = input.nextInt();
                        switch (tk_type) {
                            case 0:System.out.println("\nThoat Tim Kiem\n");break;
                            case 1:                                
                                System.out.println("Cac Loai Hang: ThucPham, SanhSu, DienMay");                                    
                                System.out.print("\nNhap Loai Hang    : "); 
                                String type = input.next();
                                hh_list.timKiemLoai(type);
                                break;
                            case 2:
                                System.out.print("\nTim Kiem Theo Khoang Gia\nMoi Bang Gia Bat Dau Tim: ");
                                int s_price = input.nextInt();
                                System.out.print("Moi Bang Gia Ket Thuc Tim: ");
                                int e_price = input.nextInt();
                                hh_list.timKiemGia(s_price, e_price);
                                break;
                            case 3:
                                System.out.print("\nTim Kiem Theo Khoang Ngay\nMoi Bang Ngay Bat Dau Tim: ");
                                int s_date = input.nextInt();
                                System.out.print("Moi Bang Ngay Ket Thuc Tim: ");
                                int e_date = input.nextInt();                                
                                if (s_date > 0 && s_date <= 31 && e_date > 0 && e_date <= 31){
                                    hh_list.timKiemGia(s_date, e_date);
                                }else{
                                    System.out.println("Khong The Tim Thay Do Sai Ngay");
                                }
                                break;
                            default:
                                break;
                        }
                        
                    } while (tk_type != 0);                    
                    break;
                //====================================================
                case 5:
                int sx_type= -1;
                do {
                    // System.out.print("Moi Ban Nhap So Luong Can Tim: ");
                    // int c4 = input.nextInt();
                    System.out.println("Chon Loai Sap Xep");                    
                    System.out.println("1. Sap Xep Theo Gia");
                    System.out.println("2. Sao Xep Theo Ngay");
                    System.out.print("Moi Ban Nhap:");
                    sx_type = input.nextInt();
                    switch (sx_type) {
                        case 0:System.out.println("\nThoat Tim Kiem\n");break;
                        case 1:                                
                            System.out.println("1. Tang Dan\n2. Giam Dan");
                            System.out.print("Moi Ban Nhap: "); 
                            int index1 = input.nextInt();
                            if (index1 == 1) {
                                hh_list.sapXepGia(true);
                            } else if (index1 == 2) {
                                hh_list.sapXepGia(false);
                            }else{
                                System.out.println("Ko Hop Le");
                            }                            
                            break;
                        case 2:
                            System.out.println("1. Tang Dan\n2. Giam Dan");
                            System.out.print("Moi Ban Nhap: "); 
                            int index2 = input.nextInt();
                            if (index2 == 1) {
                                hh_list.sapXepNgay(true);
                            } else if (index2 == 2) {
                                hh_list.sapXepNgay(false);
                            }else{
                            System.out.println("Ko Hop Le");
                            }      
                            break;                        
                        default:
                            System.out.println("==========\nKhong Tim Thay Chuc Nang Yeu Cau.\n==========\n");
                            break;
                    }                    
                } while (sx_type != 0);
                    break;
                //====================================================
                case 6:
                int statistic_type= -1;
                do {
                    // System.out.print("Moi Ban Nhap So Luong Can Tim: ");
                    // int c4 = input.nextInt();
                    System.out.println("\nChon Loai Thong Ke");                    
                    System.out.println("1. Tong So Luong Hang Hoa");
                    System.out.println("2. Tong Gia Tri Nhap Kho");
                    System.out.println("3. So Luong Tung Loai Hang");
                    System.out.print("Moi Ban Nhap:");
                    statistic_type = input.nextInt();
                    switch (statistic_type) {
                        case 0:System.out.println("\nThoat Tim Kiem\n");break;
                        case 1:                                
                            hh_list.tkeTongSoLuongHangHoa();                   
                            break;
                        case 2:
                            hh_list.tkeTongGiatriNhapKho();
                            break;
                        case 3:                            
                            hh_list.tkeSoLuongTungHangHoa();
                            break;                      
                        default:
                            System.out.println("==========\nKhong Tim Thay Chuc Nang Yeu Cau.\n==========\n");
                            break;
                    }                    
                } while (statistic_type != 0);
                    break;
                //====================================================
                default:
                    //vi khong chon dung nen se xuat danh sach
                    System.out.println("==========\nKhong Tim Thay Chuc Nang Yeu Cau.\n==========\n");                    
                    break;
            }
        } while (chon != 0);
    }
}
     
