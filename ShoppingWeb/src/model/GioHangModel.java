package model;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Items;
import entities.SanPham;

public class GioHangModel {
	HashMap<String, Items> gioHang;
	
	public GioHangModel() {
		this.gioHang = new HashMap<String, Items>();
	}
	
	public GioHangModel(HashMap<String, Items> gioHang) {
		this.gioHang = gioHang;
	}

	public HashMap<String, Items> getGioHang() {
		return gioHang;
	}

	public void setGioHang(HashMap<String, Items> gioHang) {
		this.gioHang = gioHang;
	}
	
	public String addItems(String masp) {
		String result = "Add Item That Bai";
		if (gioHang.containsKey(masp)) {
			Items item = gioHang.get(masp);
			int count = item.getSoLuong() + 1;
			item.setSoLuong(count);
			result = "Add Item Thanh Cong";
		} else {
			SanPham sanPham = new SanPhamModel().getSanPham(masp);
			Items item = new Items(sanPham, 1);
			gioHang.put(masp, item);
			result = "Add Item Thanh Cong";
		}
		return result;
	}
	
	public void removeItems(String masp) {
		gioHang.remove(masp);
	}
	
	public void removeAll() {
		gioHang.clear();
	}
	
	public int totalPrice() {
		int price = 0;
		for (Items item : gioHang.values()) {
			price += item.getSoLuong() * item.getSanPham().getGia();
		}
		return price;
	}
	
	public ArrayList<Items> getListItems() {
		ArrayList<Items> list = new ArrayList<Items>();
		for (Items item : gioHang.values()) {
			list.add(item);
		}
		return list;
	}
	
	public static void main(String[] args) {
		GioHangModel gioHangModel = new GioHangModel();
		gioHangModel.addItems("APL01");
		gioHangModel.addItems("APL02");
		gioHangModel.addItems("APL03");
		gioHangModel.addItems("AS01");
		gioHangModel.addItems("RZ01");
		gioHangModel.addItems("NB01");
		ArrayList<Items> list = gioHangModel.getListItems();
		for(Items item: list) {
			System.out.println(item);
		}
	}
}
